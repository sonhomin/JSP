<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	for(int i=1;i<=5;i++){
%>

	<H<%=i%>>아름다운한글</H<%=i%>>
	
<%
	}
%>
<%-- jsp주석 --%>
<!--  html주석  -->
<%//자바주석%>
</body>
</html>