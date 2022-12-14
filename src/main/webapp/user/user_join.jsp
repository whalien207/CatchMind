<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/header.jsp" %>

<section>
	<div align="center">
		<h3>Hello! Sign Up Here</h3>
		<!-- 
		태그에서 제공하는 input유효성 검사
		pattern ="js정규표현식"
		required="required"
		
		정규표현식에 일치하지 않으면 submit 불가
		공백을 허용하지 않음
		
		radio or checkbox 미리 선택
		checked ="checked"
		
		selectbox 미리 선택
		selected ="selected"
		
		인풋태그의 수정불가(읽기전용)
		readonly="readonly"
		
		인풋태그 사용안하기
		disabled = "disabled"
		 -->
		<form action="joinForm.user" method="post">
		
			<span style="color:red;">${msg }</span>
			<table>
				<tr>
					<td>ID</td>
					<td><input type="text" name = "id" placeholder="4~8글자 영문자숫자" pattern = "\w{4,8}" required="required"></td>
				
				</tr>
				<tr>
					<td>PW</td>
					<td><input type="password" name = "pw" pattern = "\w{4,8}"></td>
				
				</tr>
			
				<tr>
					<td>Name</td>
					<td><input type="text" name = "name" pattern = "[가-힣]{2,}"></td>
				
				</tr>
				<tr>
				
				</tr>
				
			
			</table>

			<button class="custom-btn btn-12"><span>COME!</span><span>Join</span></button>

			<!--
			 JS로 기능을 붙임
			 onclick = "location.href ='경로' 
			-->

			<button class="custom-btn btn-12" type="reset"><span>Clear</span><span>Reset</span></button>

		
		</form>
	</div>
</section>
 <!-- 화면에서 사용할 js -->
 <script>
 
 	var msg = '${msg}';
 	if(msg !='') {
 		alert(msg);
 	}
 	
 </script>

<%@ include file="../include/footer.jsp" %>