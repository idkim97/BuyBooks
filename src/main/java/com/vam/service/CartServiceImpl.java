package com.vam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vam.mapper.AttachMapper;
import com.vam.mapper.CartMapper;
import com.vam.model.AttachImageVO;
import com.vam.model.CartDTO;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartMapper cartMapper;
	
	@Autowired
	private AttachMapper attachMapper;

	
	// 장바구니 추가
	@Override
	public int addCart(CartDTO cart) {
		
		// 장바구니 데이터 체크
		CartDTO checkCart = cartMapper.checkCart(cart);
		
		if(checkCart!=null) {
			return 2;
		}
		
		try {
			return cartMapper.addCart(cart);
		} catch (Exception e) {
			return 0;
		}
	}

	// 장바구니 리스트 가져오기
	@Override
	public List<CartDTO> getCartList(String memberId) {

		List<CartDTO> cart = cartMapper.getCart(memberId);
		
		for(CartDTO dto : cart) {
			dto.initSaleTotal();
			
			// 이미지 정보 얻기
			int bookId = dto.getBookId();
			List<AttachImageVO> imageList = attachMapper.getAttachList(bookId);
			dto.setImageList(imageList);
		}
		return cart;
	}
	
	// 장바구니 수량 수정
	@Override
	public int modifyCount(CartDTO cart) {
		
		return cartMapper.modifyCount(cart);
	}
	
	// 장바구니 삭제
	@Override
	public int deleteCart(int cartId) {

		return cartMapper.deleteCart(cartId);
	}
	

}
