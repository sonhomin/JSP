<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLTm9Nao0YzztcQTwFspd3yD65VohhpuuC0mLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integerity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/t
wtIaxVXM" crossorigin="anonymous"></script>
<title>뉴스 관리 앱</title>
</head>

<body>
	<div class="container w-75 mt-5 mx-auto">
	<h2>뉴스 목록</h2>
	<hr>
	<ul class="list-group">
	<c:forEach var="news" items="${newslist}" varStatus="status"> 
	<li class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
	
	<a href="news.nhn?action=getNews&aid=${news.aid}" class="text-decoration-none">[${status.count}] ${news.title}, ${news.date}</a>
	
	<a href="news.nhn?action=deleteNews&aid=${news.aid}"><span class='badgebg-secondary"> &times;</span></a>
	</li>
	
	</c:forEach>
	</ul>

	<hr>
	<c:if test="{error != null}">
		<div class="alert alert-danger alert-dismissible fade show mt-3">
			에러발생: ${error}
	 <button type="button" class="btn-close" data-bs-dismiss="alert"X/button>
	 </div>
	</c:if>
	<button class="btn btn-outline-info mb-3" type="button" data-bs-toggle="collapse" 
	data-bs-target="#addForm" aria-expanded="false" aria-controls="addForm">뉴스등록
	</button>
	<div class="collapse" id=addForm"></div>
	<div class.-card card-body"> 
	<form method="post" action="/jwbook/news.nhn?action=addNews" enctype="multipart/form-data"> 

	<label class="form-label">제목</label> 
	<input type="text" name="title" class="form-control"> 
	<label class="form-label">이미지</label> 
	<input type="file" name="file" class="form-control">
	<label class="form-label">기사 내용</label> 
	<textarea cols="50" rows="5" name="content" class="form-control"> </textarea> 
	<button type="submit" class="btn btn-success mt-3">저장</button> 
	</form>
	</div> 
	</div>
	
	</div>
</body>
</html>
