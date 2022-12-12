<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
    
<section>
	<div align="center">
		<h3>${sessionScope.id}
		<b>(${sessionScope.name})</b>님 환영합니다
		</h3>
		<div>
		    <button class="w-btn w-btn-skin" type="button" onclick="location.href='user_mypage_points.user?id=${sessionScope.id}'">
        포인트 조회
    </button>
        <button class="w-btn w-btn-skin" type="button" onclick="location.href='user_content.board?id=${sessionScope.id}'">
        내가 쓴 글 조회
    </button>
        <button class="w-btn w-btn-skin" type="button" onclick="location.href='user_comments.comments?id=${sessionScope.id}'">
        내가 쓴 댓글 조회
    </button>
		</div>
	
	</div>
</section>    
    
    
<%@ include file="../include/footer.jsp" %>