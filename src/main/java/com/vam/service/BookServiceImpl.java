package com.vam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vam.mapper.BookMapper;
import com.vam.model.BookVO;
import com.vam.model.Criteria;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookMapper bookMapper;

	// 상품 검색
	@Override
	public List<BookVO> getGoodsList(Criteria cri) {

		log.info("getGoodsList()........");
		
		// 작가만 검색된 경우 (A)
		String type = cri.getType();
		String[] typeArr = type.split("");
		
		for(String t : typeArr) {
			if(t.equals("A")) {
				String[] authorArr = bookMapper.getAuthorIdList(cri.getKeyword());
				cri.setAuthorArr(authorArr);
			}
		}
		
		return bookMapper.getGoodsList(cri);
	}

	// 상품 총 개수
	@Override
	public int goodsGetTotal(Criteria cri) {

		log.info("goodsGetTotal().........");
		
		return bookMapper.goodsGetTotal(cri);
	}

}
