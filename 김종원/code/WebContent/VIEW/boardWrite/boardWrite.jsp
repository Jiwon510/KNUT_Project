<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<title>동아리 관리 프로그램</title>
</head>
<body> 
	<article>
		<div class="container" role="main">
			<h2>자유게시판 글쓰기</h2>
			<form name="form" id="form" role="form" method="get" action="/view/main/boardwrite">
				<div class="mb-3">
					<label for="title">제목</label>
					<input type="text" class="form-control" name="title" id="title" placeholder="제목을 입력해 주세요">
				</div>				
				<div class="mb-3">
					<label for="reg_id">작성자</label>
					<input type="text" class="form-control" name="writer" id="writer" placeholder="이름을 입력해 주세요">
				</div>
				<div class="mb-3">
					<label for="content">내용</label>
					<textarea class="form-control" rows="5" name="content" id="content" placeholder="내용을 입력해 주세요" ></textarea>
				</div>
			<div >
				<button type="submit" class="btn float-right btn btn-sm btn-primary" id="btnSave">저장</button>
				<button type="button" class="btn float-right btn btn-sm btn-primary" onclick="location.href='/view/main/board'" id="btnList">목록</button>
			</div>
			</form>
		</div>
	</article>
</body>
</html>