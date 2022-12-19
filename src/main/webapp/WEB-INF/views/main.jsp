<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/main.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
</head>
<body>

	<div class="wrapper">
		<div class="wrap">
			<div class="top_gnb_area">
				<ul class="list">
					<!-- 로그인 했을경우 보이는 네비게이션 바 -->
					<c:if test="${member == null}">
						<li><a href="/member/login">로그인</a></li>
						<li><a href="/member/join">회원가입</a></li>
						<li>고객센터</li>
					</c:if>
					
					<!-- 로그인을 하지 않았을 경우 보이는 네비게이션 바 -->
					<c:if test="${member != null}">
						<c:if test="${member.adminCk==1 }">
							<li><a href="/admin/main">관리자 페이지</a></li>
						</c:if>
						<li><a id="gnb_logout_button">로그아웃</a></li>
						<li>마이룸</li>
						<li>장바구니</li>
					</c:if>
					
				</ul>
			</div>

			<div class="top_area">
				<div class="logo_area">
					<a href="/main"><img src="resources/img/logo.png"></a>
				</div>

				<div class="search_area">
					<h1>Search area</h1>
				</div>

				<div class="login_area">
					<!-- 로그인을 하지 않은 상태 -->
					<c:if test="${member == null}">
						<div class="login_button">
							<a href="/member/login">로그인</a>
						</div>
						<span><a href="/member/join">회원가입</a></span>
					</c:if>

					<!-- 로그인을 한 상태 -->
					<c:if test="${member !=null}">
						<div class="login_success_area">
							<span>회원 : ${member.memberName}</span> 
							<span>충전금액 : <fmt:formatNumber value="${member.money }" pattern="\#,###.##"/></span> 
							<span>포인트 : <fmt:formatNumber value="${member.point }" pattern="#,###" /></span>
							<a href="/member/logout.do">로그아웃</a>
						</div>
					</c:if>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="navi_bar_area">
				<h1>navi area</h1>
			</div>
			<div class="content_area">
				<h1>content area</h1>
			</div>


			<!--  footer영역 -->
			<div class="footer_nav">
				<div class="footer_nav_container">
					<ul>
						<li>회사소개</li>
						<span class="line">|</span>
						<li>이용약관</li>
						<span class="line">|</span>
						<li>고객센터</li>
						<span class="line">|</span>
						<li>광고문의</li>
						<span class="line">|</span>
						<li>채용정보</li>
						<span class="line">|</span>
					</ul>
				</div>
			</div> <!-- class="footer_nav" -->
			

			<div class="footer">
				<div class="footer_container">

					<div class="footer_left">
						<img src="resources/img/logo.png">
					</div>
					<div class="footer_right">
						(주) BuyBook 대표이사 : 김테드 <br> 사업자등록번호 : ooo-oo-ooooo <br>
						대표전화 : oooo-oooo(발신자 부담전화) <br> <br> COPYRIGHT(C) <strong>idkim97.github.io</strong>
						ALL RIGHTS RESERVED.
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<!-- class="footer" -->


		</div> <!-- class="wrap" -->

	</div>	<!-- class="wrapper" -->
	
	<script>
	
	/*gnb_area 로그아웃 버튼 작동*/
	$("#gnb_logout_button").click(function(){
		// alert("버튼 작동");
		$.ajax({
			type:"POST",
			url : "/member/logout.do",
			success:function(data){
				alert("로그아웃 성공");
				document.location.reload(); // 현재 페이지가 새로고침 되도록 하는 코드
			}
		}) // ajax
	});
	
	</script>

</body>
</html>