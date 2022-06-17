<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="whants.MemberDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>

<html lang="ko">
    <head>
        <meta charset="UTF-8">
        
        <title>
            whants
        </title>
    </head>
    
    <body>
        <%
        String userID		= request.getParameter("userID");
        String userPassword = request.getParameter("userPassword");
        
        MemberDAO memberDAO = new MemberDAO();
        int result = memberDAO.login(userID, userPassword);
        	
        if(result == 1 || result == 2) {
        	Cookie c = new Cookie("admin", String.valueOf(result)) ;	//1 일반 2 관리자
			c.setComment("회원정보") ;			 
			c.setMaxAge(60*60*24) ;	
			response.addCookie(c) ;
			
			Cookie n = new Cookie("userID", userID) ;
			n.setComment("회원ID") ;			 
			n.setMaxAge(60*60*24) ;	
			response.addCookie(n) ;
			
        	PrintWriter script = response.getWriter();
        	script.println("<script>");
        	script.println("alert('로그인 성공')");
        	script.println("location.href = './index.jsp'");
        	script.println("</script>");
        } else if(result == 0) {
        	PrintWriter script = response.getWriter();
        	script.println("<script>");
        	script.println("alert('비밀번호가 틀립니다.')");
        	script.println("history.back()");
        	script.println("</script>");
        } else if(result == -2) {
        	PrintWriter script = response.getWriter();
        	script.println("<script>");
        	script.println("alert('아이디를 확인해주세요.')");
        	script.println("location.href = './login.jsp'");
        	script.println("</script>");
        } else if(result == -1) {
        	PrintWriter script = response.getWriter();
        	script.println("<script>");
        	script.println("alert('서버 오류 입니다.')");
        	script.println("location.href = '../index.jsp'");
        	script.println("</script>");
        }
        %>
    </body>
    
</html>