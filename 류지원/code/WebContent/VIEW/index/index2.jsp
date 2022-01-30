<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동아리 관리 프로그램</title>

<link rel="stylesheet" type="text/css" href="VIEW/index/css/index.css">
</head>
<body>
	<!-- ---------------------------------header---------------------------------------- -->
	<div class="header">
		<jsp:include page="/VIEW/index/indexHeader.jsp"></jsp:include>
		<span>${studentID }</span>
		<a href="/VIEW/login/login.jsp">로그아웃</a></li>
	</div>
	<!-- ---------------------------------main------------------------------------------ -->
	<br >
	<div class="tab">
    <ul class="tabnav">
      <li><a href="/VIEW/notice/notice">공지사항</a></li>
      <li><a href="/VIEW/comment/comment.jsp">동아리소개</a></li>
      <li><a href="/VIEW/video/video.jsp">대회영상</a></li>
      <li><a href="/VIEW/board/board">자유게시판</a></li>
      <c:if test="${authority eq '2'}">
      	<li><a href="/VIEW/memberlist/memberlist">회원목록</a></li>
      	<li><a href="/VIEW/non_memberlist/non_memberlist">승인목록</a></li>
      </c:if>
    </ul>
    <div class="tabcontent">
      <div id="tab01">이미지 삽입	 </div>
      <div id="tab02">글 삽입</div>
    </div>
  </div>
	<%-- <!-- ---------------------------------footer---------------------------------------- -->
	<div class="footer">
		<jsp:include page="/view/sub/footer.jsp"></jsp:include>
	</div> --%>
</body>
</html>