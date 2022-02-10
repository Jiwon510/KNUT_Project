<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
   <link rel="stylesheet" type="text/css" href="/VIEW/board/css/board.css">
   <meta charset="UTF-8">
<title>동아리 관리 프로그램</title>
</head>
<body>
   <!-- ---------------------------------header---------------------------------------- -->
   <div class="header">
      <jsp:include page="/VIEW/board/boardHeader.jsp"></jsp:include>
   </div>
   <!-- ---------------------------------main------------------------------------------ -->
   <form action="/VIEW/board/board" method="get" >
	   <div class="row">
	      <div class="col-md-8 mb-3">
	      <select class="custom-select d-block w-100" name="search">  
	         <option ${(param.search == "title")?"selected":""} value="title">제목</option>
	         <option ${(param.search == "writer")?"selected":""} value="writer">작성자</option>
	      </select>
	      <input type="text" class="form-control" name="word" placeholder="" value="${param.word}" required>
	      <input type="submit" value="검색">
	      </div>
	   </div>
   </form>
   
   <form action="/VIEW/board/board" method="post">
   <table class="type08">
      <thead>
         <tr>
            <th scope="cols">No.</th>
            <th scope="cols">제목</th>
            <th scope="cols">작성자</th>
            <th scope="cols">작성일자</th>
            <th scope="cols">선택</th>
            
         </tr>
      </thead>
      <tbody>
         <c:forEach var="n" items="${list}">
         <input type="hidden" name="n" value=${n.num } >
         <tr>
            <td>${n.n}</td>
            <td><a href="/VIEW/boardDetail/boardDetail?num=${n.num}">${n.title }</a><span>[${n.comment_count }]</span></td>
            <td>${n.writer }</td>
            <td>${n.date }</td>
            <td><input type="checkbox" name= "del_id" value="${n.num }"></td>
         </tr>
         </c:forEach>
      </tbody>
   </table>

	<c:set var="page" value="${(param.p == null)?1:param.p}" />
	<c:set var="startNum" value="${page-(page-1)%5}" />
	<c:set var="lastNum"
		value="${fn:substringBefore(Math.ceil(count/10), '.')}" />

	<div class="indexer margin-top align-right">
		<h3 class="hidden">현재 페이지</h3>
		<div>
			<span class="text-orange text-strong">${(param.p==null)?1:param.p}/ ${lastNum} </span> pages 
		</div>
	</div>

	<div class="margin-top align-center pager">


		<%-- <c:set var="page" value="${(param.p == null)?1:param.p}"/>
		<c:set var="startNum" value="${page-(page-1)%5}"/>
		<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/10), '.')}"/> --%>
		
		<div>
		<c:if test="${startNum>1}">
			<a href="?p=${startNum-1}&search=${param.search}&word=${param.word}">이전</a>
		</c:if>
		<c:if test="${startNum<=1}">
			<span onclick="alert('이전 페이지가 없습니다.');">이전</span>
		</c:if>
		
		</div>
		
		<ul class="list">
			<c:forEach var="i" begin="0" end="4">
			<c:if test="${(startNum+i) <= lastNum }">
				<li><a href="?p=${startNum+i}&search=${param.search}&word=${param.word}">${startNum+i}</a></li>
			</c:if>
			</c:forEach>
		</ul>
		
		<div>
			<c:if test="${startNum+4<lastNum}">
				<a href="?p=${startNum+5}&search=${param.search}&word=${param.word}">다음</a>
			</c:if>
			<c:if test="${startNum+4>=lastNum }">
				<span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">다음</span>
			</c:if>
		</div>

	</div>

	
	<div>
		<button class="btn btn-danger btn-lg btn-block" style="float: right;" type="submit">삭제</button>
	</div>
		</form>
	<div>
		<button class="btn btn-success btn-lg btn-block" onclick="location.href='/VIEW/boardWrite/boardWrite.jsp'" style="float:right;" type="submit">글쓰기</button>
	</div>
  

   
</body>
</html>