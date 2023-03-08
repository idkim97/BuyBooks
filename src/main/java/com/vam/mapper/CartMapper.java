package com.vam.mapper;

import java.util.List;

import com.vam.model.CartDTO;

public interface CartMapper {
	
	/* 장바구니 추가 */
	public int addCart(CartDTO cart) throws Exception;
	
	/* 장바구니 삭제 */
	public int deleteCart(int cartId);
	
	/* 장바구니 수량 수정 */
	public int modifyCount(CartDTO cart);
	
	/* 장바구니 목록 */
	public List<CartDTO> getCart(String memberId);	
	
	/* 장바구니 확인 */
	public CartDTO checkCart(CartDTO cart);
	
	// 장바구니에서 주문시 제거
	public int deleteOrderCart(CartDTO dto);

}
