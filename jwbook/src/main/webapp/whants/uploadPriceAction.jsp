<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="whants.ContentsDAO" %>
<%@ page import="whants.Price" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	String ID = request.getParameter("ID");
    String PL = request.getParameter("platform");
    String PR = request.getParameter("price");
    Price NP = new Price();
    NP.setContentID(Integer.parseInt(ID));
    NP.setPlatform(PL);
    NP.setPrice(PR);
    ContentsDAO dao = new ContentsDAO();
    dao.addPrice(NP);
     
    PrintWriter script = response.getWriter();
   	script.println("<script>");
 	script.println("alert('업로드 성공')");
 	script.println("location.href = './index.jsp'");
 	script.println("</script>");
    %>
</body>
</html>