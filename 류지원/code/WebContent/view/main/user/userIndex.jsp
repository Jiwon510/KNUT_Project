<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동아리 관리 프로그램</title>

<link rel="stylesheet" type="text/css" href="/css/main/index.css">
</head>
<body>
	<!-- ---------------------------------header---------------------------------------- -->
	<div class="header">
		<jsp:include page="/view/sub/header/indexHeader.jsp"></jsp:include>
	</div>
	<!-- ---------------------------------main------------------------------------------ -->
	<br >
	<div class="tab">
    <ul class="tabnav">
      <li><a href="/view/main/notice">공지사항</a></li>
      <li><a href="/view/main/comment.jsp">동아리소개</a></li>
      <li><a href="/view/main/video.jsp">대회영상</a></li>
      <li><a href="/view/main/board">자유게시판</a></li>
    </ul>
    <div class="tabcontent">
      <div id="tab01">이미지 삽입 </di v>
      <div id="tab02">글 삽입</div>
    </div>
  </div>
	<%-- <!-- ---------------------------------footer---------------------------------------- -->
	<div class="footer">
		<jsp:include page="/view/sub/footer.jsp"></jsp:include>
	</div> --%>
</body>
</html>