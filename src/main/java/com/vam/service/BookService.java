package com.vam.service;

import java.util.List;

import com.vam.model.BookVO;
import com.vam.model.CateFilterDTO;
import com.vam.model.CateVO;
import com.vam.model.Criteria;
import com.vam.model.SelectDTO;

public interface BookService {

	// 상품 검색
	public List<BookVO> getGoodsList(Criteria cri);
	
	// 상품 총 개수
	public int goodsGetTotal(Criteria cri);
	
	// 국내 카테고리 리스트
	public List<CateVO> getCateCode1();
	
	// 국외 카테고리 리스트
	public List<CateVO> getCateCode2();
	
	// 검색결과 카테고리 필터 정보
	public List<CateFilterDTO> getCateInfoList(Criteria cri);
	
	// 상품 정보
	public BookVO getGoodsInfo(int bookId);
	
	// 리뷰를 위한 상품 id 이름
	public BookVO getBookIdName(int bookId);
	
	// 평점순 상품 정보
	public List<SelectDTO> likeSelect();
}
