<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
    
<section>
	<div align="center">
		${sessionScope.id}
		<b>(${sessionScope.name})</b>님 환영합니다

		<div>
		<input type="button" value="포인트 조회"
				onclick="location.href='user_mypage_points.user?id=${sessionScope.id}'">
		<input type="button" value="내가 쓴 글 조회"
				onclick="location.href='user_content.board?id=${sessionScope.id}'">
		<input type="button" value="내가 쓴 댓글 조회"
				onclick="location.href='user_comments.comments?id=${sessionScope.id}'">
		</div>
	
	</div>
</section>    
    
    
<%@ include file="../include/footer.jsp" %>