package com.vam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vam.mapper.MemberMapper;
import com.vam.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;

	@Override
	public void memberJoin(MemberVO member) throws Exception{
		memberMapper.memberJoin(member);
	}
	
	@Override
	public int idCheck(String memberId) throws Exception{
		return memberMapper.idCheck(memberId);
	}
}
