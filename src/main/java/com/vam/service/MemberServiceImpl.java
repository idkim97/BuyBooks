package com.vam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vam.mapper.MemberMapper;
import com.vam.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;

	// 회원가입
	@Override
	public void memberJoin(MemberVO member) throws Exception{
		memberMapper.memberJoin(member);
	}
	
	// 아이디 중복 검사
	@Override
	public int idCheck(String memberId) throws Exception{
		return memberMapper.idCheck(memberId);
	}
	
	
	// 로그인
	@Override
	public MemberVO memberLogin(MemberVO member) throws Exception {
		return memberMapper.memberLogin(member);
	}
	
	// 주문자 정보
	public MemberVO getMemberInfo(String memberId) {
		return memberMapper.getMemberInfo(memberId);
	}
}
