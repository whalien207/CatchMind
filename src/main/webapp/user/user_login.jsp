<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/header.jsp" %>

    <section>
    	<div align = "center">
    		<form action="loginForm.user" method="post">
    			<h3>Please sign in</h3>
    			

    			<input type="text" name="id" placeholder="ID" required style="heigth:30px; width:320px"><br>
    			<input type="password" name="pw" placeholder="Password" required style="heigth:30px; width:320px"><br>
    			<span style="color: red;">${msg }</span><br>
    		
    			<button class="custom-btn btn-12"><span>GO!</span><span>Login</span></button>
    			
    		</form>
    	</div>
    </section>

<%@ include file="../include/footer.jsp" %>