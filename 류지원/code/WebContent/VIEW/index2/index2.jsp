<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동아리 관리 프로그램</title>

<link rel="stylesheet" type="text/css" href="/VIEW/index2/css/index2.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<!-- ---------------------------------header---------------------------------------- -->
	<div class="header">
		<jsp:include page="/VIEW/index/indexHeader.jsp"></jsp:include>
		<span>${name }</span>
		<a href="/VIEW/login/login.jsp">로그아웃</a></li>
	</div>
	<!-- ---------------------------------main------------------------------------------ -->
	<nav class="menu-1">
		<ul>
			<li>
				<a href="#">1차 메뉴 아이템 1<a/>
				<ul>
					<li><a href="#">2차 메뉴 아이템 1<a/></li>
					<li><a href="#">2차 메뉴 아이템 1<a/></li>
					<li><a href="#">2차 메뉴 아이템 3<a/></li>
					<li><a href="#">2차 메뉴 아이템 4<a/></li>
				</ul>
			</li>
			<li>
				<a href="#">1차 메뉴 아이템 2<a/>
				<ul>
					<li><a href="#">2차 메뉴 아이템 1<a/></li>
					<li><a href="#">2차 메뉴 아이템 1<a/></li>
					<li><a href="#">2차 메뉴 아이템 3<a/></li>
					<li><a href="#">2차 메뉴 아이템 4<a/></li>
				</ul>
			</li>
			<li>
				<a href="#">1차 메뉴 아이템 3<a/>
				<ul>
					<li><a href="#">2차 메뉴 아이템 1<a/></li>
					<li><a href="#">2차 메뉴 아이템 1<a/></li>
					<li><a href="#">2차 메뉴 아이템 3<a/></li>
					<li><a href="#">2차 메뉴 아이템 4<a/></li>
				</ul>
			</li>
			<li>
				<a href="#">1차 메뉴 아이템 4<a/>
				<ul>
					<li><a href="#">2차 메뉴 아이템 1<a/></li>
					<li><a href="#">2차 메뉴 아이템 1<a/></li>
					<li><a href="#">2차 메뉴 아이템 3<a/></li>
					<li><a href="#">2차 메뉴 아이템 4<a/></li>
				</ul>
			</li>
		</ul>
	</nav>
	<script type="text/javascript">
		$(document).ready(function(){
			
			$('nav a').on('click', function(){
				$(this).addClass('on');
				$(this).siblings().removeClass('on')
			});
		});
	
	</script>
</body>
</html>