<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../include/header.jsp" %>

<div align="center" class="div_center">
	<h3>Catch Mind 등록</h3>
	<hr>
	
	<form action="writeContent.board" method="post" enctype="multipart/form-data">
		<table border="1" width="500">
			<tr>
				<td>작성자</td>
				<td>
					<input type="text" name="writer" size="10" value="${sessionScope.id }" required readonly>
				</td>
			</tr>
			<tr>
				<td>글 제목</td>
				<td>
					<input type="text" name="title" required>
				</td>
			</tr>
			<tr>
				<td>정답</td>
				<td>
					<input type="text" name="answer" required>
				</td>
			</tr>
			<tr>
				<td>힌트</td>
				<td>
					<input type="text" name="hint" required>
				</td>
			</tr>
			<tr>
				<td>파일</td>
				<td>
					<input type="file" name="imgFile" required>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="작성 완료">
					<input type="button" value="목록" onclick="location.href='board_list.board' ">         
				</td>
			</tr>
			
		</table>
	</form>
</div>


<%@ include file = "../include/footer.jsp" %>