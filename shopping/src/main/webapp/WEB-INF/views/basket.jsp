<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" 
    rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" 
    crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="resources/CSS/basket.css">
    <title>market</title>
</head>
<body>

    <div class="search-container d-flex justify-content-between">
        <form class="d-flex search-box">
            <input class="form-control me-2 border-0" type="search" placeholder="검색어를 입력해주세요" aria-label="Search">
            <button class="btn" type="submit"><i class="bi bi-search"></i></button>
        </form>
        <div class="recieveuserinfo d-flex flex-sm-row flex-column align-content-center">
            <div class="receivemenu d-flex align-content-center flex-wrap justify-content-center"><a href="/shopping/registerpage" id="login-register">회원가입</a></div>
            <div class="sidebar"></div>
            <div class="receivemenu d-flex align-content-center flex-wrap justify-content-center"><a href= "/shopping/loginstate" id="login-state">${headermsg}</a></div>
        </div>
    </div>
    <header>
        <nav class="navbar navbar-expand-sm">
            <div class="container-fluid">
            	<a class="navbar-brand" href="#">
                	<i class="bi bi-house h-100"></i>
              	</a>
              	<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                	<span class="navbar-toggler-icon"></span>
              	</button>
              	<div class="collapse navbar-collapse" id="navbarSupportedContent">
                	<ul class="navbar-nav me-auto mb-2 mb-lg-0 w-100 justify-content-sm-around nav_list">
                  		<li class="nav-item">
                    		<a class="nav-link " href="index.html">Home</a>
                    		<div class="bar"></div>
                  		</li>
                          <li class="nav-item">
                    		<a class="nav-link"href="/shopping/displayinsales">신상품</a>
                    		<div class="bar"></div>
                  		</li>
                        <li class="nav-item">
                    		<a class="nav-link " href="#">상품분석</a>
                    		<div class="bar"></div>
                  		</li>
                        <li class="nav-item">
                    		<a class="nav-link active" aria-current="page" href="/shopping/displaybasket">장바구니</a>
                    		<div class="bar"></div>
                  		</li>
                          <li class="nav-item">
                    		<a class="nav-link " href="#">소비분석</a>
                    		<div class="bar"></div>
                  		</li>
                  		
                	</ul>
                <!-- <form class="d-flex" role="search">
                  <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                  <button class="btn btn-outline-success" type="submit">Search</button>
                </form> -->
                	<div class="dropdown">
                    	<button class="btn" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                        	<i class="bi bi-three-dots"></i>
                    	</button>
                    	<ul class="dropdown-menu dropdown-menu-sm-end">
                      		<li><a class="dropdown-item" href="#">Action</a></li>
                      		<li><a class="dropdown-item" href="#">Another action</a></li>
                      		<li style="padding: 4px 16px 4px 16px;">
                        		<div class="form-check-reverse form-switch">
                            		<label class="form-check-label" for="flexSwitchCheckDefault" style="float: left;">테마 설정</label>
                            		<input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckDefault">
                            		<div style="clear: both;"></div>
                        		</div>
                      		</li>
                    	</ul>
                  	</div>
              	</div>
            </div>
        </nav>

		<div class="scroll-progress">
			<progress value="0" max="100" class="progress-bar" id="progress-bar"></progress>
		</div>
    </header>

    <main>
        <div class="container">
            <div class="row">

				<c:forEach var="displayBasketDto" items="${displayBasketDtoList}">
					<div class="col-12">
						<form class="basket-goods d-flex justify-content-between" action="/shopping/deletebasket" method="post">
	
							<input type="text" name="seq" class="d-none" readonly value="${displayBasketDto.seq}">
	
							<div style="display: inline-block;">
								이름 : ${displayBasketDto.goodsName}
							</div>
	
							<div style="display: inline-block;">
								개별 가격 : ${displayBasketDto.price} 원
							</div>
	
							<div style="display: inline-block;">
								수량 : ${displayBasketDto.orderQuantity} 개
							</div>
	
							<div style="display: inline-block;">
								주문 날짜 : ${displayBasketDto.orderDate}
							</div>
	
							<div style="display: inline-block;">
								가격 : <span class="total-price">${displayBasketDto.totalPrice}</span> 원
							</div>
	
							<div style="display: inline-block; width: 10%;">
							</div>
	
							<button type="submit">삭제</button>
						</form>
						
					</div>



				</c:forEach>

                

                <div class="col-12">
					<div class="d-inline-block" id="result">
						총 가격 : <span class="result-price"></span> 원
					</div>
                    <button class="send-button" type="button" onclick="location.href= '/shopping/purchasegoods' ">구매</button>
                </div>   
	            

                
                
            </div>
            
        </div>
        <hr style="margin-top: 100px; clear: both;">
    </main>
    

    <footer>
		<p>
			<i>ⓒ2023. ljuneh, All Rights Reserved</i>
		</p>
	</footer>







    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
    integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" 
    crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

    <script>
		function progressBar() {
        	var winScroll = document.body.scrollTop || document.documentElement.scrollTop;
        	var height = document.documentElement.scrollHeight - document.documentElement.clientHeight;
        	var scrolled = (winScroll / height) * 100;
        	document.getElementById("progress-bar").style.width = scrolled + "%";
    	}
		document.getElementById("progress-bar").style.width = "0%";

		window.onscroll = function () {
        	progressBar();
    	}

        function loginState() {
            const state = document.getElementById('login-state').innerHTML;
            if(state=="로그인") {

            } else {
                document.getElementById('login-register').style.display="none";
            }
            
        }

		loginState();

		let result = 0;

		$(".total-price").each(function(index, item){
			result += parseInt($(this).text())
		});

		$(".result-price").text(result);

		<c:forEach items="${msgList}" var="msg">
			alert("${msg}");	
		</c:forEach>

    </script>
</body>
</html>