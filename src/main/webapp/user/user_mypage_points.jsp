<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../include/header.jsp" %>
    
<section>
	<div align="center">
		${sessionScope.id}
		<b>(${sessionScope.name})</b>님의 포인트: ${p_vo.point}
	</div>
</section>    
    
    
<%@ include file="../include/footer.jsp" %>
    