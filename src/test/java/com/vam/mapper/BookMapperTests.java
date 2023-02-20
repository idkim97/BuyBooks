package com.vam.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.BookVO;
import com.vam.model.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BookMapperTests {
	
	@Autowired
	private BookMapper mapper;
	
	/*
	@Test
	public void getGoodsListTest() {
		
		Criteria cri = new Criteria();
		
		System.out.println("cri : " + cri);
		
		List<BookVO> list = mapper.getGoodsList(cri);
		System.out.println("list : " + list);
		
		System.out.println("==============");
		
		int goodsTotal = mapper.goodsGetTotal(cri);
		System.out.println("total : " + goodsTotal);
	}
	*/
	
	/*
	// 작가 id 리스트 요청 
	@Test
	public void getAuthorId() {
		
		String keyword = "김지";
		
		String[] list = mapper.getAuthorIdList(keyword);
		
		System.out.println("결과 : " + list.toString());
		
		for(String id : list) {
			System.out.println("개별 결과 : " + id);
		}
		
		
	}
	*/
	
	/*
	@Test
	public void getGoodsListTest1() {
		Criteria cri = new Criteria();
		String type = "A";
		String keyword = "김난도";
		//String keyword = "없음"
		String catecode = "";
		
		cri.setType(type);
		cri.setKeyword(keyword);
		cri.setAuthorArr(mapper.getAuthorIdList(keyword));
		cri.setCateCode(catecode);
		
		List<BookVO> list = mapper.getGoodsList(cri);
		
		System.out.println("cri : " + cri );
		System.out.println("list : " + list);
	}
	
	@Test
	public void getGoodsListTest2() {
		Criteria cri = new Criteria();
		String type = "T";
		String keyword = "테스트";
		//String keyword = "없음"
		String catecode = "";
		
		cri.setType(type);
		cri.setKeyword(keyword);
		cri.setAuthorArr(mapper.getAuthorIdList(keyword));
		cri.setCateCode(catecode);
		
		List<BookVO> list = mapper.getGoodsList(cri);
		
		System.out.println("cri : " + cri );
		System.out.println("list : " + list);
	}
	
	@Test
	public void getGoodsListTest3() {
		Criteria cri = new Criteria();
		String type = "C";
		String keyword = "테스트";
		//String keyword = "없음"
		String catecode = "103000";
		
		cri.setType(type);
		cri.setKeyword(keyword);
		cri.setAuthorArr(mapper.getAuthorIdList(keyword));
		cri.setCateCode(catecode);
		
		List<BookVO> list = mapper.getGoodsList(cri);
		
		System.out.println("cri : " + cri );
		System.out.println("list : " + list);
	}
	*/
	
	
}
