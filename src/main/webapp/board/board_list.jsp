<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../include/header.jsp"%>
<div class="container">
	<h3>캐치마인드!!</h3>

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
						<div class="col-sm-4 text-center">
							<a href=""><img class="img-responsive"
								src="../img/${vo.img }" alt="그림"></a>
							<h3>${vo.id }님이 그린 그림</h3>
						</div>
					</c:forEach>
			</div>
		</div>
	</div>

</div>


<%@ include file="../include/footer.jsp"%>