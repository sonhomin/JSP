 <%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>cookie check</h1>
	<%

	// 쿠키값 가져오기
	Cookie[] cookies = request.getCookies() ;
	if(cookies != null){
		
		for(int i=0; i < cookies.length; i++){
			Cookie c = cookies[i] ;
			
			// 저장된 쿠키 이름을 가져온다
			String cName = c.getName();
			
			// 쿠키값을 가져온다
			String cValue = c.getValue() ;
			
			System.out.println(c.getName()+": "+c.getValue());
			if(cName.equalsIgnoreCase("memberNo")){
				%><jsp:forward page="yesCookie.jsp"/><%
			}
		}
		%><jsp:forward page="noCookie.jsp"/><%
	}else{
		%><jsp:forward page="noCookie.jsp"/><%
	}
	%>
</body>
</html>