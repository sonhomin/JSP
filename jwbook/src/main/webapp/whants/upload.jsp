<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>업로드</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="card card-body">
		<form method="post" action="/whants.nhn?action=addContents"	enctype="multipart/form-data">
			<label class="form-label">제목</label>
			<input type="text" name="title" class="form-control">
			<label class="form-label">이미지</label>
			<input type="file" name="file" class="form-control"></br>
			<label class="form-label">상세 내용</label></br>
			<textarea rows="5" cols="50" name="content" class="form-control"></textarea></br>
			<label class="form-label">시작일</label>
			<input type="date" name="startDate" class="form-control">
			<label class="form-label">종료일</label>
			<input type="date" name="endDate" class="form-control">
			<label class="form-label">감독</label>
			<input type="text" name="director" class="form-control">
			<label class="form-label">배우</label>
			<input type="text" name="actor" class="form-control">
			
			<button type="submit" class="btn btn-success mt-3">저장</button>
		</form>
	</div>
</body>
</html>