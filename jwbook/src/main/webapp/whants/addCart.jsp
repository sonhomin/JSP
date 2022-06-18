<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="whants.ContentsDAO" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ContentsDAO dao = new ContentsDAO();
	dao.addCart(request.getParameter("UID"),request.getParameter("CID"));
	
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("location.href = './index.jsp'");
	script.println("</script>");
%>
</body>
</html>