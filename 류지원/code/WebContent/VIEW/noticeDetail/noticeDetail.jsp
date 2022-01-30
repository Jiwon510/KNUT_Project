<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>

<head>
    
			<!-- --------------------------- main --------------------------------------- -->
		<main>
				<h2 class="main title">공지사항</h2>
				
				<div class="margin-top first">
						<h3 class="hidden">공지사항 내용</h3>
						<table class="table">
							<tbody>
								<tr>
									<th>제목</th>
									<td class="text-align-left text-indent text-strong text-orange" colspan="3">${notice.title }</td>
								</tr>
								<tr>
									<th>작성자</th>
									<td>${notice.writer }</td>	
								</tr>
								<tr>
									<th>작성일</th>
									<td class="text-align-left text-indent" colspan="3">${notice.date }</td>
								</tr>
								<tr>
									<th>내용</th>
									<td>${notice.content }</td>
								</tr>
								<!-- 수정필요 -->
								<tr>
									<th>좋아요</th>
									<td>${notice.like_count }</td>
								</tr>
								<tr>
									<th>첨부파일</th>
									<td>
										<c:forTokens var="filename" items="${notice.file }" delims="," varStatus="st">
											<a href="${filename }">${filename }</a>
											<c:if test="${!st.last }">
												/
											</c:if>
										</c:forTokens>

									</td>
								</tr>
							</tbody>
						</table>
					</div> <br>
	</main>
					

	<table>
		<thead>
			<c:forEach var="n" items="${list}">
			<tr>
				<th scope="cols">${n.writer }</th>
				<th scope="cols">${n.content }</th>
				<th scope="cols">${n.date }</th>
			</tr>
			</c:forEach>
		</thead>
		<!-- <tbody>
				<tr>
					<td>1</td>
					<td>류지원</td>
					<td>좋아요</td>
					<td>2022-01-12</td>
				</tr>
		</tbody> -->
	</table> <br>
	
	
	<!-- <form action="/VIEW/comment/comment">
		<div class="mb-3">
			<textarea rows="5" name="content" id="content" placeholder="댓글을 입력해주세요" ></textarea>
		</div>
		<button type="submit" id="btnInsert">댓글입력</button>
	</form> -->
	


	<div class="margin-top text-align-center">
						<a class="btn btn-list" href="/VIEW/notice/notice">목록</a>
					</div>
					
					<div class="margin-top">
						<table class="table border-top-default">
							<tbody>
								
								<tr>
									<th>다음글</th>
									<td colspan="3"  class="text-align-left text-indent">다음글이 없습니다.</td>
								</tr>
								
									
								
								
								<tr>
									<th>이전글</th>
									<td colspan="3"  class="text-align-left text-indent"><a class="text-blue text-strong" >이전글이 없습니다.</a></td>
								</tr>
								
								
							</tbody>
						</table>
					</div>			
					
			</main>		

   