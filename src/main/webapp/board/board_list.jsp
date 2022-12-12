<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../include/header.jsp"%>
<div class="container">

	<button class="w-btn-outline w-btn-green2-outline" type="button" onclick="location.href='board_write.board' ">
        글 작성하기
    </button>
	

	<div class="row">
		<div class="box">
			<div class="col-lg-12">
				<hr>
				<h2 class="intro-text text-center">
					<strong>목록</strong>
				</h2>
				<hr>
			</div>
			<div class="row">
					<c:forEach var="vo" items="${list }" varStatus="num">
						<div class="col-sm-4 text-center" style="padding-bottom:40px">
							<a href="board_content.board?bno=${vo.bno }">
							<h5>[${vo.status }]</h5>
							<img class="img-responsive" src="../img/${vo.img }" alt="그림" width=250 height=250>
							<h3>${vo.id }님이 그린 그림</h3></a>
						</div>
					</c:forEach>
			</div>
		</div>
	</div>
</div>


<%@ include file="../include/footer.jsp"%>