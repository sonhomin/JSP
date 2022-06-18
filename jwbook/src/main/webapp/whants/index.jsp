<%@page import="java.util.Iterator"%>
<%@page import="whants.Contents"%>
<%@page import="java.util.List"%>
<%@page import="whants.ContentsDAO"%>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!Doctype html>

	  <head>		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <title>whants  </title>
    <style type="text/css">
   		body { background: rgba(24, 24, 24, 1) !important; } /* Adding !important forces the browser to overwrite the default style applied by Bootstrap */
	</style>

    </head>

    <body>
    <link rel="stylesheet" href="./css/style.css">
	<%@ include file="./header.jsp" %>
	
	<%
		ContentsDAO dao = new ContentsDAO();
		List<Contents> contentList = dao.getAll();
		request.setAttribute("contentList", contentList);
		/*
		Iterator<Contents> iter = contentList.iterator();
		
		while(iter.hasNext()){
			Contents c = iter.next();			
			String Link = c.getImg();
			
			PrintWriter script = response.getWriter();
			script.println("<div class=\"card\" >");
			script.println(" <img class=\"card-img-top\" src=\""+Link+"\" alt=\"Card image cap\"> ");
			script.println(" <div class=\"card-body\"> ");
			script.println(" <a target=\"_blank\" href=\"#\" class=\"card-title\">"+c.getTitle()+"</a> \" ");
			script.println(" </div>");
			script.println(" </div>");
			
		}*/
	%>
    	<div class ="row">
        <c:forEach var="Contents" items="${contentList}" varStatus="status">
			<div class="col-lg-3"> <div class="card">
				
				<input type="hidden" name="Contents" value="${Contents}">
                <a type="submit" target=_blank> <img class="card-img-top"  src="${Contents.img}" alt="Card image cap"> </a>
                
                <div class="card-body">                	
                	<form action="./addCart.jsp">
                	<input type="hidden" name="UID" value="${Contents.getContentID()}">
                	<input type="hidden" name="CID" value="<%=ID %>">
                	
                	<table border="0" width=100%>
                		<tr>
                			<td><div align="left"><a target="_blank" class="card-title"  > ${Contents.getTitle()} </a> </div></td>
                			<td><div align="right"><button type="submit" >ADD CART</button></div></td>
                		</tr>
                	</table>   		
                		
                	</form>
            	</div>
        	</div></div>
		</c:forEach>
		</div>
		
		
		
    </body>

</html>
