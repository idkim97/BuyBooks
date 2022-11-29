package com.vam.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberMapperTests {
	
	@Autowired
	private MemberMapper memberMapper;
	
	/*
	// 회원가입 쿼리 테스트
	@Test
	public void memberJoin() throws Exception{
		MemberVO member = new MemberVO();
		
		member.setMemberId("test");
		member.setMemberPw("test");
		member.setMemberName("test");
		member.setMemberMail("test");
		member.setMemberAddr1("test");
		member.setMemberAddr2("test");
		member.setMemberAddr3("test");
		
		memberMapper.memberJoin(member);
	}
	*/
	
	// 아이디 중복검사
	@Test
	public void memberIdChk() throws Exception{
		String id="admin"; 		// 존재하는 아이디
		String id2="test123"; 	// 존재하지 않는 아이디
		memberMapper.idCheck(id);
		memberMapper.idCheck(id2);

	}
}
