<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  

<%@ include file="../include/header.jsp" %>

<div class="container">
	<h3>내가 작성한 댓글</h3>

	<table class="table table-bordered" style= "color:white; text-align:center;">
		<thead>
			<tr>
				<th>순서</th>
				<th>작성자</th>
				<th>댓글내용</th>
				<th>날짜</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="vo" items="${list}" varStatus="num">
				<tr>
					<td>${num.count }</td>
					<td>${vo.id }</td>
					<td><a href="../board/board_content.board?bno=${vo.bno}">${vo.comments }</a></td>
					<td><fmt:formatDate value="${vo.regdate}" pattern="yyyy-MM-dd HH시mm분"/></td>
				</tr>
			</c:forEach>
		</tbody>

		
		<!-- <tbody>
			<tr>
				<td colspan="6" align="right">
					<form action="" class="form-inline">
						<div class="form-group">
							<input type="submit" value="검색"
								class="btn btn-default" style= "color:white">
						</div>
					</form>
				</td>
			</tr>
		</tbody> -->

	</table>
</div>





<%@ include file="../include/footer.jsp" %>