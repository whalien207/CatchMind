<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Astro Motion by TemplateMo</title>
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@300;400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/slick.css" type="text/css" /> 
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/templatemo-style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nabla&family=Rampart+One&family=Rubik+Puddles&display=swap" rel="stylesheet">
<style>
@import url('https://fonts.googleapis.com/css2?family=Nabla&family=Rampart+One&family=Rubik+Puddles&display=swap');
.main-logo{
font-size: 90px;
font-family: 'Nabla', cursive;
font-family: 'Rampart One', cursive;
font-family: 'Rubik Puddles', cursive;

}

</style>

    <link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Rubik+Spray+Paint&display=swap" rel="stylesheet">
    <style> @import url('https://fonts.googleapis.com/css2?family=Rubik+Spray+Paint&display=swap'); 
	.aaa{
	font-family: 'Rubik Spray Paint', cursive;
	font-size: 40px;
	border-bottom: 2px solid white;
	color: #99FF66;
    border-bottom: 1px solid ;
	}
	.aaa:hover{
	color : #99FF66;
	}
	
	.aaa:focus{
	color : #99FF66;
	}
		
</style>
  <title>How to use and customize SweetAlert2</title>
  <!-- jQuery -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <!-- SweetAlert2 -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js"></script>
<!--
    
TemplateMo 560 Astro Motion

https://templatemo.com/tm-560-astro-motion

-->
</head>
<body>
    <video autoplay muted loop id="bg-video">
        <source src="${pageContext.request.contextPath }/video/gfp-astro-timelapse.mp4" type="video/mp4">
    </video>
    <div class="page-container">
      <div class="container-fluid">
        <div class="row">
          <div class="col-xs-12">
            <div class="cd-slider-nav">
              <nav class="navbar navbar-expand-lg" id="tm-nav">
                <a class="main-logo" href="${pageContext.request.contextPath}/main.jsp" ><strong>Catch Mind</strong></a>
                  <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbar-supported-content" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                  </button>
                  <div class="collapse navbar-collapse" id="navbar-supported-content">
                    <ul class="navbar-nav mb-2 mb-lg-0">

                      <li class="nav-item ">

                        <a class="aaa" aria-current="page" href="${pageContext.request.contextPath}/main.jsp" data-no="1">Home</a>
                        <div style="padding-top:10px">
                      	<div class="circle"></div>
                      	</div>
                      </li>
                      <li class="nav-item">
                        <a class="aaa" href="${pageContext.request.contextPath}/board/board_list.board" data-no="2">Quiz</a>
                      <div class="circle"></div>
                      </li>
                      <c:if test="${sessionScope.id == null}">
                      <li class="nav-item">
                        <a class="aaa" href="${pageContext.request.contextPath}/user/user_login.user" data-no="3">Login</a>
                      <div class="circle"></div>
                      </li>
                      <li class="nav-item">
                        <a class="aaa" href="${pageContext.request.contextPath}/user/user_join.user" data-no="4">Join</a>
                      <div class="circle"></div>
                      </li>
                      </c:if>
                      
                      <c:if test="${sessionScope.id != null }">
                      <li class="nav-item">
						<a class="aaa" href="${pageContext.request.contextPath}/user/user_logout.user" data-no="3">Logout</a>
						<div class="circle"></div>
						<li class="nav-item">
                        <a class="aaa" href="${pageContext.request.contextPath}/user/user_mypage.user" data-no="4">Mypage</a>
                   		<div class="circle"></div>
                   		</li >
                      </li>
                      
                      </c:if>
                      
                      
                    </ul>
                  </div>
              </nav>
            </div>
          </div>          
        </div>        
      </div>

