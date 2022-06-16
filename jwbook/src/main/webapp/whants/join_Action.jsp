<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="whants.MemberDAO" %>
<%@ page import="whants.Member" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>

<html lang="ko">
    <head>
        <meta charset="UTF-8">
        
        <title>
            whatns
        </title>
    </head>
    
    <body>
        <%
        String userID		= request.getParameter("userID");
        String userPassword = request.getParameter("userPassword");
        String userName		= request.getParameter("userName");
        
     	// -1: 서버 오류 / 0: 이미존재하는 아이디 / 1: 성공
        if(userID == null || userPassword == null || userName == null) {
        	PrintWriter script = response.getWriter();
        	script.println("<script>");
        	script.println("alert('빈칸을 확인해 주세요')");
        	script.println("history.back()");
        	script.println("</script>");
        } else {
        	MemberDAO memberDAO = new MemberDAO();
        	
        	Member newMember = new Member(userID,userPassword,userName);
        	
            int result = memberDAO.addMember(newMember);
            	
            if(result == -1) {
            	PrintWriter script = response.getWriter();
            	script.println("<script>");
            	script.println("alert('서버오류')");
            	script.println("history.back()");
            	script.println("</script>");
            } else if(result == 0) {
            	PrintWriter script = response.getWriter();
            	script.println("<script>");
            	script.println("alert('이미 아이디가 존재합니다.')");
            	script.println("history.back()");
            	script.println("</script>");
            } else {
            	PrintWriter script = response.getWriter();
            	script.println("<script>");
            	script.println("alert('회원가입을 축하드립니다.')");      
            	script.println("window.close();");     
            	script.println("</script>");
            }
        }
        %>
    </body>
    
</html>