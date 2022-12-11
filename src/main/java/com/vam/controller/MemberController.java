package com.vam.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vam.model.MemberVO;
import com.vam.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private JavaMailSender mailSender;

	// 회원가입 페이지 이동
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void joinGET() {

		logger.info("회원가입 페이지 진입");

	}

	// 로그인 페이지 이동
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET() {

		logger.info("로그인 페이지 진입");

	}

	// 아이디 중복 검사
	@RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String memberIdChkPOST(String memberId) throws Exception {
		logger.info("memberIdChk() 진입");
		
		int result = memberService.idCheck(memberId);
		
		logger.info("결과값 = " + result);
		
		if(result !=0) {
			return "fail"; // 중복 아이디가 존재
		}
		else {
			return "success"; // 중복 아이디 X
		}

	}

	// 회원가입
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinPOST(MemberVO member) throws Exception {

		logger.info("join 진입");

		// 회원가입 서비스 실행
		memberService.memberJoin(member);

		logger.info("join Service 성공");

		return "redirect:/main";
	}
	
	
	//이메일 인증
	@RequestMapping(value="/mailCheck", method=RequestMethod.GET)
	@ResponseBody
	public String mailCheckGET(String email) throws Exception{
		logger.info("이메일 데이터 전송확인");
		logger.info("인증번호 : " + email);
		
		/* 인증번호(난수)생성*/
		Random random = new Random();
		// 111111~999999 범위의 숫자를 얻기위함
		int checkNum = random.nextInt(888888)+111111;
		logger.info("인증번호 " + checkNum);
		
		
		/* 이메일 보내기 */
		
		// root-context.xml에 삽입한 자신의 이메일 계정 주소
		String setFrom = "idkim9797@naver.com";
		// 수신받을 이메일
		String toMail = email;
		// 이메일 제목
		String title = "회원가입 인증 이메일입니다.";
		// 이메일 내용
		String content = "홈페이지를 방문해주셔서 감사합니다." + "<br><br>" + "인증 번호는 " + checkNum + "입니다." + "<br>" + "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
		
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content,true);
			mailSender.send(message);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		String num = Integer.toString(checkNum);
		
		return num;
	}
	
	/* 로그인 */
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String loginPOST(HttpServletRequest request, MemberVO member, RedirectAttributes rttr) throws Exception{
		
//		System.out.println("로그인 메소드 진입");
//		System.out.println("전달된 데이터 : " + member);
		
		HttpSession session = request.getSession();
		MemberVO lvo = memberService.memberLogin(member);
		
		if(lvo==null) {										// 일치하지 않는 아이디, 비밀번호 입력일 경우
			int result=0;
			rttr.addFlashAttribute("result",result);
			return "redirect:/member/login";
		}
		
		session.setAttribute("member", lvo);				// 일치하는 아이디, 비밀번호 일 경우 (로그인 성공)
		
		return "redirect:/main";
	}

}
