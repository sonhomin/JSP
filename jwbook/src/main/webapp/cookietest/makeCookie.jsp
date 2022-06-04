<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		// 회원번호
		String memberNo = "58272836" ;

		// 회원번호를 쿠키에 지정한다
		Cookie c = new Cookie("memberNo", memberNo) ;
	
		// 쿠키에 설명을 추가한다
		c.setComment("회원번호") ;
	
		// 쿠키 유효기간을 설정한다. 초단위 : 60*60*24= 1일 
		c.setMaxAge(60*60*24) ;
		
		// 응답헤더에 쿠키를 추가한다.
		response.addCookie(c) ;
	%>
	<script type="text/javascript">history.back();</script>
</body>
</html>