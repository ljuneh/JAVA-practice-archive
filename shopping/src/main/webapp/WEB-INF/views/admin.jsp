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
    <link rel="stylesheet" href="resources/CSS/stock.css">
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            width: 60%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #912568;
            color: white;
        }
        .modal {
            display: none;
            position: fixed;
            z-index: 1000;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0,0,0,0.4);
            padding-top: 60px;
        }
        .modal-content {
            background-color: #fefefe;
            margin: 5% auto;
            position: fixed; /* Stay in place */
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            padding: 20px;
            border: 1px solid #888;
            width: 300px;
        }
        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }
        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
        .inventory-details {
            margin-bottom: 20px;
        }
        .quantity-adjust {
            display: inline-block;
            width: 50px;
        }
    </style>
    <title>stock</title>
</head>
<body>
    <!-- The Modal -->
    <div id="myModal" class="modal">
        <!-- Modal content -->
        <div class="modal-content">
            <span class="close">&times;</span>
            <form action="/shopping/updatestock">
                <div class="inventory-details">
                    <p>Item Code: <input id="modal-item-code" name="goodsCode" readonly></input></p>
                    <p>Item Name: <span id="modal-item-name"></span></p>
                    <p>Current Quantity: <input id="modal-item-quantity" name="goodsQuantity" type="number"></input></p>
                </div>
                <button type="button" class="quantity-adjust" onclick="changeQuantity(-1)" style="margin-left: 0px;">-</button>
                <button type="button" class="quantity-adjust" onclick="changeQuantity(1)" style="margin-right: 0px;">+</button>
                <button type="submit" onclick="submitUpdate()">Submit</button>
            </form>
        </div>
    </div>

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
                    		<a class="nav-link active" aria-current="page" href="/shopping/stock">재고</a>
                    		<div class="bar"></div>
                  		</li>
                        <li class="nav-item">
                    		<a class="nav-link " href="/shopping/goods">물품 등록여부 조회</a>
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

                <div class="col-12">
                    <button class="send-button" type="button" onclick="location.href= '/shopping/initstock' ">재고 초기화</button>
                </div> 

                <h1>전체 재고</h1>

                <table id="inventoryTable">
                    <tr>
                        <th>Item Code</th>
                        <th>Item Name</th>
                        <th>Quantity</th>
                        <th>Action</th>
                    </tr>
                    
                    <c:forEach var="stockInfoDto" items="${stockInfoDtoList}">
                        <tr class="table-row">
                            <td class="table-code">${stockInfoDto.goodsCode}</td>
                            <td class="table-name">${stockInfoDto.goodsName}</td>
                            <td class="table-quantity">${stockInfoDto.goodsQuantity}</td>
                            <td><button class="table-button">Update Quantity</button></td>
                        </tr>
                    </c:forEach>
                    
                </table>
                
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


        var modal = $('#myModal');
        var span = $('.close')[0];

        $(span).on('click', function() {
            modal.hide();
        });

        $(window).on('click', function(event) {
            if (event.target == modal[0]) {
                modal.hide();
            }
        });

        function changeQuantity(change) {
            var quantityElement = $('#modal-item-quantity');
            var currentQuantity = parseInt(quantityElement.val());
            var newQuantity = currentQuantity + change;
            if (newQuantity >= 0) {
                quantityElement.val(newQuantity);
            }
        }

        window.changeQuantity = changeQuantity;

        function submitUpdate() {
            modal.hide();
            console.log('Inventory updated!');
        }

        window.submitUpdate = submitUpdate;



        $(".table-button").click(function() {

            const parent = $(this).closest(".table-row");
            const code = parent.find(".table-code");
            const name = parent.find(".table-name");
            const quantity = parent.find(".table-quantity");

            $('#modal-item-code').val(code.html());
            $('#modal-item-name').text(name.html());
            $('#modal-item-quantity').val(quantity.html());

            modal.show();
        });

    </script>
</body>
</html>