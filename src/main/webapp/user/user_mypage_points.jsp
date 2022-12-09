<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
    
<section>
	<div align="center">
		${sessionScope.user_id}
		<b>(${sessionScope.user_name})</b>님의 포인트: ${sessionScope.user_points}
	
	</div>
</section>    
    
    
<%@ include file="../include/footer.jsp" %>
    