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
	Cookie[] cookies = request.getCookies() ;
	String ID = "Unknown";
	String Admin = "1";
	for(int i=0; i < cookies.length; i++){
		Cookie c = cookies[i] ;
		String cName = c.getName();
		String cValue = c.getValue() ;			
		if(cName.equalsIgnoreCase("userID")){
			ID = cValue;
		}
		if(cName.equalsIgnoreCase("admin")){
			Admin = cValue;
		}
	}	
	%>
	<header>
	<table border="0" width=100%>
		<tr>
			<td> <div align="left" >Whants</div> </td> 
			<td> <div align="right"> 
				<% if(Admin.equals("2")){ %><a href="./upload.jsp" style="text-decoration:none;">업로드</a><%} %>
				
				<a href="./logout.jsp" style="text-decoration:none;">로그아웃</a> 
				<a href="./basket.jsp" style="text-decoration:none;"> <%=ID%> </a> 
			</div> </td>			
		</tr>
	</table>	
	<hr>
	</header>
</body>
</html>