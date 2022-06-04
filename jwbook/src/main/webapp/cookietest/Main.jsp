<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="javascript">
	fuction makeCookie(){
		location.href="makeCookie.jsp"
	}
	
	fuction delCookie(){
		location.href="deleteCookie.jsp"
	}	
	
	fuction chekCookie(){
		location.href="checkCooke.jsp"
	}	
</script>
</head>
<body>
<FORM>
	<input type='BUTTON' value='쿠키생성' onclick='makeCookie()'>
	<input type='BUTTON' value='쿠키삭제' onclick='delCookie()'>
	<input type='BUTTON' value='쿠키확인' onclick='chekCookie()'>
</FORM>
</body>
</html>