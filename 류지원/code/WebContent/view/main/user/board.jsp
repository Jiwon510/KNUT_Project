<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/main/notice.css">
<meta charset="UTF-8">
<title>동아리 관리 프로그램</title>
</head>
<body>
   <!-- ---------------------------------header---------------------------------------- -->
   <div class="header">
      <jsp:include page="/view/sub/header/user/boardHeader.jsp"></jsp:include>
   </div>
   <!-- ---------------------------------main------------------------------------------ -->
   <div class="row">
      <div class="col-md-8 mb-3">
      <select class="custom-select d-block w-100" name="search">
         <option>제목</option>
         <option>내용</option>
         <option>작성자</option>
      </select>
      <input type="text" class="form-control" name="name" placeholder="" value="" required>
      <input type="submit" value="검색">
      </div>
   </div>
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
         <tr>
            <td>${n.num}</td>
            <td>${n.title }</td>
            <td>${n.writer }</td>
            <td>${n.date }</td>
            <td><input type="checkbox" name= "check"></td>
         </tr>
         </c:forEach>
      </tbody>
   </table>
   <div>
      <button class="btn btn-danger btn-lg btn-block" style="float:right;" type="submit">삭제</button>
      <button class="btn btn-success btn-lg btn-block" onclick="location.href='/view/main/user/boardwrite.jsp'" style="float:right;" type="submit">글쓰기</button>
   </div>
</body>
</html>