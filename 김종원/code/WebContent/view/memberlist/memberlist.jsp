<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/VIEW/memberlist/css/memberlist.css">
<meta charset="UTF-8">
<title>동아리 관리 프로그램</title>
</head>
<body>
	<!-- ---------------------------------header---------------------------------------- -->
	<div class="header">
		<jsp:include page="/VIEW/memberlist/memberlistHeader.jsp"></jsp:include>
	</div>
	<!-- ---------------------------------main------------------------------------------ -->
	<form action="/VIEW/memberlist/memberlist" method="get">
		<div class="row">
			<div class="col-md-8 mb-3">
				<select class="custom-select d-block w-100" name="search">
					<option ${(param.search == "name")?"selected":""} value="name">이름</option>
					<option ${(param.search == "studentID")?"selected":""}
						value="studentID">학번</option>
					<option ${(param.search == "department")?"selected":""}
						value="department">학과</option>
				</select> <input type="text" class="form-control" name="word" placeholder=""
					value="${param.word}" required> <input type="submit"
					value="검색">
			</div>
		</div>
	</form>
	<table class="type08">
		<thead>
			<tr>
				<th scope="cols">이름</th>
				<th scope="cols">학번</th>
				<th scope="cols">학과</th>
				<th scope="cols">선택</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="n" items="${list}">
				<tr>
					<td>${n.name }</td>
					<td>${n.studentID }</td>
					<td>${n.department }</td>
					<td><input type="checkbox" name="check"></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<c:set var="page" value="${(param.p == null)?1:param.p}" />
	<c:set var="startNum" value="${page-(page-1)%5}" />
	<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/10), '.')}" />

	<div class="indexer margin-top align-right">
		<h3 class="hidden">현재 페이지</h3>
		<div>
			<span class="text-orange text-strong">${(param.p==null)?1:param.p}/ ${lastNum} </span> pages
		</div>
	</div>

	<div class="margin-top align-center pager">

		<div>
			<c:if test="${startNum>1}">
				<a href="?p=${startNum-1}&search=${param.search}&word=${param.word}">이전</a>
			</c:if>
			<c:if test="${startNum<=1}">
				<span onclick="alert('이전 페이지가 없습니다.');">이전</span>
			</c:if>

		</div>

		<ul>
			<c:forEach var="i" begin="0" end="4">
				<c:if test="${(startNum+i) <= lastNum }">
					<li><a
						href="?p=${startNum+i}&search=${param.search}&word=${param.word}">${startNum+i}</a></li>
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
		<button class="btn btn-danger btn-lg btn-block" style="float: right;"
			type="submit">삭제</button>
	</div>
</body>
</html>