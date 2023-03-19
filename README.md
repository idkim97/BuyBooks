
# 📕 BuyBooks 

> **Spring 기반 온라인 책 쇼핑몰 웹 페이지 입니다.**
> 
> **MVC 패턴, HTTP 프로토콜 등 Backend 로직을 중점으로 설계한 프로젝트 입니다.** 

<br><br>

<p align="center">
<img src="https://github.com/idkim97/idkim97.github.io/blob/master/img/bb1.png?raw=true" align="left" width="40%" height="50%" >
<img src="https://github.com/idkim97/idkim97.github.io/blob/master/img/bb2.png?raw=true" align="center" width="40%" height="50%">
<figcaption align="center"></figcaption>
</p>

<p align="center">
<img src="https://github.com/idkim97/idkim97.github.io/blob/master/img/bb13.png?raw=true" align="left" width="40%" height="50%" >
<img src="https://github.com/idkim97/idkim97.github.io/blob/master/img/bb14.png?raw=true" align="center" width="40%" height="50%">
<figcaption align="center"></figcaption>
</p>
<br>

## 💻 개요

- **개발기간 : 22.12~22.02**

- **개발 환경**
	- JAVA 11
	- STS 3.9.9
	- Apache Tomcat 8.5
	- MySQL
	- MyBatis

- **주요기능**
	- 회원가입 및 로그인&로그아웃
	- Ajax 활용 회원가입 유효성 검사
	- SMTP 기반 이메일 인증번호 전송
	- kakao 제공 주소록 API 활용
	- BCryptPasswordEncoder 활용 비밀번호 인코딩
	- 관리자 전용 페이지 인터셉터 적용
	- 관리자 전용 상품등록&관리, 작가 등록&관리, 주문 현황 파악 페이지
	- 위지윅 에디터, 캘린더 위젯 적용, 메인페이지 slick 적용
	- 카테고리 리스트 구현
	- 상품 이미지 및 썸네일 저장&삭제
	- 상품 검색
	- 장바구니 기능
	- 상품 주문
	- 상품 리뷰
	- DB Batch Program 적용

## 📜 프로젝트 구성도
📦src  
 ┣ 📂main  
 ┃ ┣ 📂java  
 ┃ ┃ ┗ 📂com  
 ┃ ┃ ┃ ┗ 📂vam  
 ┃ ┃ ┃ ┃ ┣ 📂controller  				// 컨트롤러  
 ┃ ┃ ┃ ┃ ┣ 📂interceptor  			// 인터셉터  
 ┃ ┃ ┃ ┃ ┣ 📂mapper  					// Mapper 인터페이스  
 ┃ ┃ ┃ ┃ ┣ 📂model  						// VO,DTO 클래스  
 ┃ ┃ ┃ ┃ ┣ 📂service  					// Service 인터페이스, 클래스  
 ┃ ┃ ┃ ┃ ┗ 📂task  						// Batch Program  
 ┃ ┣ 📂resources  
 ┃ ┃ ┣ 📂com  
 ┃ ┃ ┃ ┗ 📂vam  
 ┃ ┃ ┃ ┃ ┗ 📂mapper  					// Mapper xml ( 쿼리문 )  
 ┃ ┃ ┣ 📂META-INF  
 ┃ ┗ 📂webapp  
 ┃ ┃ ┣ 📂resources  
 ┃ ┃ ┃ ┣ 📂css  
 ┃ ┃ ┃ ┃ ┣ 📂admin  						// 관리자 페이지 css  
 ┃ ┃ ┃ ┃ ┣ 📂member  					// 로그인, 회원가입 css  
 ┃ ┃ ┃ ┃ ┣ 📜cart.css  					// 장바구니 css  
 ┃ ┃ ┃ ┃ ┣ 📜goodsDetail.css  	// 상품 상세 페이지 css  
 ┃ ┃ ┃ ┃ ┣ 📜main.css  					// 메인화면 css  
 ┃ ┃ ┃ ┃ ┣ 📜order.css  				// 주문화면 css  
 ┃ ┃ ┃ ┃ ┗ 📜search.css  				// 상품검색 css  
 ┃ ┃ ┃ ┗ 📂img  								// 이미지 파일 모아놓기  
 ┃ ┃ ┗ 📂WEB-INF  
 ┃ ┃ ┃ ┣ 📂classes  
 ┃ ┃ ┃ ┣ 📂spring  
 ┃ ┃ ┃ ┃ ┣ 📂appServlet  
 ┃ ┃ ┃ ┃ ┗ 📜root-context.xml  
 ┃ ┃ ┃ ┣ 📂views  
 ┃ ┃ ┃ ┃ ┣ 📂admin  
 ┃ ┃ ┃ ┃ ┣ 📂includes  
 ┃ ┃ ┃ ┃ ┃ ┗ 📂admin  				// 관리자 페이지 JSP  
 ┃ ┃ ┃ ┃ ┣ 📂member  					// 로그인, 회원가입 JSP  
 ┃ ┃ ┃ ┃ ┣ 📜cart.jsp  					// 장바구니 JSP  
 ┃ ┃ ┃ ┃ ┣ 📜goodsDetail.jsp  		// 상품 상세 페이지 JSP  
 ┃ ┃ ┃ ┃ ┣ 📜home.jsp  				// 기본 JSP  
 ┃ ┃ ┃ ┃ ┣ 📜main.jsp  					// 메인화면 JSP  
 ┃ ┃ ┃ ┃ ┣ 📜order.jsp  				// 주문화면 JSP  
 ┃ ┃ ┃ ┃ ┣ 📜replyEnroll.jsp  		// 댓글등록 JSP  
 ┃ ┃ ┃ ┃ ┣ 📜replyUpdate.jsp  	// 댓글갱신 JSP  
 ┃ ┃ ┃ ┃ ┗ 📜search.jsp  				// 상품검색 JSP  
 ┃ ┃ ┃ ┗ 📜web.xml  
 ┗ 📂test  
 ┃ ┣ 📂java  
 ┃ ┃ ┗ 📂com  
 ┃ ┃ ┃ ┗ 📂vam  
 ┃ ┃ ┃ ┃ ┣ 📂mapper  					// Mapper 테스트  
 ┃ ┃ ┃ ┃ ┣ 📂persistence  			// DB연동 테스트  
 ┃ ┃ ┃ ┃ ┣ 📂service  					// Service 테스트  
 ┃ ┃ ┃ ┃ ┗ 📂task  						// Batch Program 테스트  
 ┃ ┗ 📂resources  
 ┃ ┃ ┗ 📜log4j.xml  

## 📜 DB 구조도
<p align="left">
<img src="https://github.com/idkim97/idkim97.github.io/blob/master/img/BuyBooks_DB.png?raw=true">
</p>

- vam_book : 책 정보 테이블
- vam_imgage : 책 이미지 테이블
- vam_bcate : 책 카테고리 테이블
- vam_author : 작가 정보 테이블
- vam_nation : 작가 소속 국가 테이블
- vam_orderItem : 책 주문시 책 정보 테이블 ( 수량, 가격, 할인율 등 )
- vam_order : 책 주문시 주문자 정보 테이블 ( 주소, 아이디, 배달비 등 )
- vam_cart : 장바구니 정보 테이블
- book_member : 회원 정보 테이블
- vam_reply : 댓글 정보 테이블


## 📜 API ( GitBook 활용 )

**📄 API 문서 주소** : [BuyBooks API](https://kims-organization-2.gitbook.io/buybooks-api/)

<br>

<p align="center">
<img src="https://github.com/idkim97/idkim97.github.io/blob/master/img/bbapi4.png?raw=true" align="left" width="40%" height="50%" >
<img src="https://github.com/idkim97/idkim97.github.io/blob/master/img/bbapi2.png?raw=true" align="center" width="40%" height="320">
<figcaption align="center"></figcaption>
</p>
<br>
<p align="center">
<img src="https://github.com/idkim97/idkim97.github.io/blob/master/img/bbapi3.png?raw=true" align="left" width="40%" height="50%" >
<img src="https://github.com/idkim97/idkim97.github.io/blob/master/img/bbapi1.png?raw=true" align="center" width="40%" height="50%">
<figcaption align="center"></figcaption>
</p>
<br>
