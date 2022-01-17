<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/css/sign/login.css">
	<meta charset="UTF-8">
<title>로그인페이지</title>
</head>
<body>
	<!-- ---------------------------------main------------------------------------------ -->
	<form action="/login/login" method="post" class="loginForm">
      <div class="wrap">
        <div class="login">
            <h2>로그인</h2>
            <div class="login_sns">
            </div>
            <div class="authority">
                <input type="radio" name="authority" value="2" checked="checked" /> <span class="up">관리자</span>&nbsp;&nbsp; 
                <input type="radio" name="authority" value="1"/> <span class="up">사용자</span>
            </div>
            <div class="login_id">
                <h4>학번</h4>
                <input placeholder="학번" name=studentID>
            </div>
            <div class="login_pw">
                <h4>비밀번호</h4>
                <input placeholder="비밀번호" type="password" name=password> 
            </div>
            <div class="login_etc">
                <div class="join">
                <a href="/join/join.jsp">회원가입</a>
            </div>
            </div>
            <div class="submit">
                <input type="submit" value="로그인">
            </div>
        </div>
    </div>
    </form>
	
	<%-- <!-- ---------------------------------footer---------------------------------------- -->
	<div class="footer">
		<jsp:include page="footer.jsp"></jsp:include>
	</div> --%>

</body>
</html>