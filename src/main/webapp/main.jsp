<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="include/header.jsp"%>

<li class="px-3" data-page-no="1">
	<div class="page-width-1 page-left">
		<div
			class="d-flex position-relative tm-border-top tm-border-bottom intro-container">
			<div class="intro-left tm-bg-dark">
				<h2 class="mb-4">Welcome to CatchMind</h2>
				<p class="mb-4">CatchMind 퀴즈의 기본형식은 그림 판에 그림으로 그려서 게시글에 업로드하면 회원들이 댓글로 맞추는 그림퀴즈입니다.<br> 
					퀴즈로 무한한 창의적 발상과 상상력이 발휘되는 매우 교육적인 퀴즈의 형태입니다.</p>
				<p class="mb-0">
					 Catch Mind!
				</p>
			</div>
			<div class="intro-right">
				<img src="img/main1.png" alt="Image" width="220"
					class="img-fluid intro-img-1"> <img src="img/main2.png"
					alt="Image" width="220" class="img-fluid intro-img-2">
			</div>
			<div class="circle intro-circle-1"></div>
			<div class="circle intro-circle-2"></div>
			<div class="circle intro-circle-3"></div>
			<div class="circle intro-circle-4"></div>
		</div>
		<div class="text-center">
			<a href="${pageContext.request.contextPath }/board/board_list.board" data-page-no="2"
				class="btn btn-primary tm-intro-btn tm-page-link"> QUIZ 풀러가기 </a>
		</div>
	</div>
</li>





<%@ include file="include/footer.jsp"%>