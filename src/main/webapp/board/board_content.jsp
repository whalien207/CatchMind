<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../include/header.jsp"%>

<div class="cd-hero-slider mb-0 py-5">
	<!-- 이미지 출력 -->
	<div align="center" style="padding-bottom: 15px">
		<img src="../img/${vo.img }" width=512 height=384></img>

	</div>
	<div align="center" style="padding-bottom: 5px">
		[5 Point 사용하여 힌트보기]
	 <button class="w-btn w-btn-gra3 w-btn-gra-anim" type="button" id="question" value ="${vo.hint }">Hint!</button>
	</div>

	<!-- 글에 작성된 댓글 리스트 보기 -->
	<c:forEach var="vo" items="${list }">
		<div class="container">
			<div class="row">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<tr style="color: white;">
						<td align="left">${vo.id }</td>
						<td colspan="2"></td>
						<td align="right"><fmt:formatDate value="${vo.regdate }"
								pattern="yyyy-MM-dd HH:mm" /></td>
					</tr>

					<tr style="color: white;">

						<td colspan="5" align="left">${vo.comments }</td>
					</tr>
				</table>
			</div>
		</div>
	</c:forEach>

	<!-- 댓글작성 폼 -->
	<!-- status가 완료됨인 경우 댓글을 작성못하도록 c태그로 처리.. -->
	<c:if test="${vo.status != '완료됨' }">
		<div class="container">
			<div class="form-group"
				style="display: table-cell; width: 50%; vertical-align: middle;">
				<form action="writeComment.board" method="post">
					<!-- 히든 타입으로 bno정보를 writeComment.board로 넘겨주기 위한 작업 -->
					<input type="hidden" name="bno" value="${bno }">

					<table class="table table-striped"
						style="text-align: center; border: 1px solid #dddddd">
						<tr>
							<!--  <td style="border-bottom:none;" valign="middle">${sessionScope.user_id }</td> -->
							<td style="border-bottom: none;" valign="middle"><input
								type="text" name="id" value="${sessionScope.id }" required
								readonly
								style="text-align: center; display: block; margin: 0 auto;">
							</td>
							<td style="border-bottom: none;" valign="middle"><input
								type="text" name="comment" placeholder="댓글 작성 ^*^ 정답을 맞춰주세요~"
								class="form-control"
								style="text-align: center; display: block; margin: 0 auto;">
							</td>
							<td style="border-bottom: none;" valign="middle">
								<button class="w-btn-outline w-btn-blue-outline" type="submit">
									댓글 작성</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</c:if>

	<button class="w-btn-outline w-btn-gray-outline" style="float: right"
		type="button"
		onclick="location.href='board_delete.board?bno=${bno}&writer=${vo.id }'">
		글 삭제하기</button>
	<button class="w-btn-outline w-btn-gray-outline" style="float: right"
		type="button" onclick="location.href='board_list.board'">글 목록
	</button>

</div>

<%@ include file="../include/footer.jsp"%>