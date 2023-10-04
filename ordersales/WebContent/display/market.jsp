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
    <link rel="stylesheet" href="/ordersales/display/CSS/market.css">
    <title>market</title>
</head>
<body>
    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="">
                    <div class="modal-header">
                        <div class="modal-title" id="exampleModalLabel">
                            <h5>상품명 타이틀</h5>
                            <p>??,??? 원</p>
                        </div>
                        <!-- <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button> -->
                        <div class="countbutton d-flex" id="countbutton">
                            <button type="button" id="minus" onclick="countNumber('minus')" disabled="true">-</button>
                            <input id="count" type="number" readonly min="1" value="1">
                            <button type="button" onclick="countNumber('plus')">+</button>
                        </div>
                    </div>
                    <div class="modal-body d-flex justify-content-between align-bottom">
                        <p class="d-inline-block fw-bold">합계</p>
                        <h4 class="d-inline-block modalprice fw-bolder">??,??? 원</h4>
                    </div>
                    <div class="modal-footer d-flex justify-content-around">
                        <button type="reset" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                        <button type="submit" class="btn modal-submit">장바구니에 담기</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="search-container d-flex justify-content-between">
        <form class="d-flex search-box">
            <input class="form-control me-2 border-0" type="search" placeholder="검색어를 입력해주세요" aria-label="Search">
            <button class="btn" type="submit"><i class="bi bi-search"></i></button>
        </form>
        <div class="recieveuserinfo d-flex flex-sm-row flex-column align-content-center">
            <div class="receivemenu d-flex align-content-center flex-wrap justify-content-center"><a href="#">회원가입</a></div>
            <div class="sidebar"></div>
            <div class="receivemenu d-flex align-content-center flex-wrap justify-content-center"><a href="#">로그인</a></div>
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
                    		<a class="nav-link active" aria-current="page" href="market.html">신상품</a>
                    		<div class="bar"></div>
                  		</li>
                        <li class="nav-item">
                    		<a class="nav-link " href="#">상품분석</a>
                    		<div class="bar"></div>
                  		</li>
                        <li class="nav-item">
                    		<a class="nav-link " href="#">장바구니</a>
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

                <c:forEach var="insalesgoods" items="${insalesGoodsArr}">

                    <div class="col-lg-4 col-md-6">
                        <div class="box-card">
                            <div class="box-card">
                                <a href="#">
                                    <div class="card" style="width: 100%;">
                                        <img src="/ordersales/display/images/item1.jpg" class="card-img-top" alt="...">
                                        <div class="card-body">
                                            <p class="product-subtext">새벽배송</p>
                                            <h3 class="product-title">${insalesgoods.goodsName}</h3>
                                            <h4 class="product-price">${insalesgoods.price}원</h4>
                                        </div>
                                    </div>
                                </a>
                                <button type="button" class="cart-button" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                    <i class="bi bi-cart2"></i>
                                </button>
                            </div>
                        </div>
                    </div>
	            </c:forEach>

                
                
            </div>
            
        </div>
        <hr style="margin-top: 100px;">
    </main>
    

    <footer>
		<p>
			<i>ⓒ2023. ljuneh, All Rights Reserved</i>
		</p>
	</footer>







    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
    integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" 
    crossorigin="anonymous"></script>

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

        function countNumber(type) {
            const result = document.getElementById('count');
            // onclick 이벤트 tdz
            // console.log("hi");
            let number = parseInt(result.value);
            // console.log(number);
            // console.log(typeof(number));
            if(type == 'plus') {
                number += 1;
            } else if(type == 'minus' && number > 1) {
                number -= 1;
            }
            result.value = number;
        }


        const countbutton = document.getElementById('countbutton');
        countbutton.addEventListener("click", function() {
            console.log("countbutton clicked");
            const button = document.getElementById('minus');
            const result = document.getElementById('count');
            let number = parseInt(result.value);
            console.log(number);
            if (number > 1) {
                button.disabled=false;
                console.log("button able");
            } else {
                button.disabled=true;
            }
        });

    </script>
</body>
</html>