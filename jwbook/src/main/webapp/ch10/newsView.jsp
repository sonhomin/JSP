<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>뉴스 관리 앱</title>
</head>
<body>
	<div class="container w-75 mt-5 mx-auto"> 
	<h2>${news.title}</h2> 
	<hr>
	<div class="card w-75 mx-auto">
	 	<img class="card-img-top" src="${news.img}">
	 	<div class="card-body"> 
		 	<h4 class="card-title">Date: ${news.date}</h4> 
			<p class="card-text">Content: ${news.content}</p>

		</div> 
	</div> 
	<hr> 
	<a href="javascript:history.back()" class="btn btn-primary"> << Back </a> 
 
	</div> 
</body> 
</htmi> 
