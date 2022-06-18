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
			<td> <div class = "headerTxt" align="left" >Whants</div> </td> 
			<td> <div class = "headerTxt" align="right"> 
				<% if(Admin.equals("2")){ %><a class = "aHeader" href="./upload.jsp" style="text-decoration:none;">컨텐츠 업로드</a> <a class = "aHeader" href="./uploadPrice.jsp" style="text-decoration:none;">가격 업로드</a> <%} %>
				
				<a class = "aHeader" href="./logout.jsp" style="text-decoration:none;">로그아웃</a> &nbsp &nbsp
				<a class = "aHeader" href="./basket.jsp" style="text-decoration:none;"> <%=ID%> </a> &nbsp &nbsp
			</div> </td>			
		</tr>
	</table>	
	<hr>
	</header>
</body>
</html>