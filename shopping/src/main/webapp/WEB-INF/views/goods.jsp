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
        margin: 0;
        padding: 0;
        }
        .add-container {
            background: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 70%;
        }
    
        label {
            display: inline-block;
            margin-bottom: 5px;
            margin-right: 30px;
        }
        .form-group {
            margin-bottom: 15px;
            display: inline-block;
            margin-right: 30px;
        }
        input[type="text"],
        input[type="number"],
        select {
            width: 100px;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
            display: inline-block;
            margin-right: 30px;
        }
        form {
            display: inline-block;
            margin: 30px;
        }
        button {
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #912568;
            color: white;
            cursor: pointer;
            margin-top: 10px;
            display: block;
            margin: auto;
        }
        .product-table {
            width: 100%;
            border-collapse: collapse;
        }
        .product-table th, .product-table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        .product-table th {
            background-color: #912568;
            color: white;
        }
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgb(0,0,0);
            background-color: rgba(0,0,0,0.4);
        }
        .modal-content {
            background-color: #fefefe;
            margin: 15% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
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
    </style>
    <title>stock</title>
</head>
<body>
    <!-- The Modal -->
    <div id="productModal" class="modal">
        <div class="modal-content">
            <span class="close">&times;</span>
            <form id="editProductForm" action="/shopping/updategoods">
                <p>Product Code: <input id="productCode" name="goodsCode" readonly></input></p>
                <label for="goodsName">Name:</label>
                <input type="text" id="productName" name="goodsName" required>
                <label for="price">Price:</label>
                <input type="number" id="productPrice" name="price" required>
                <label for="insales">Sale Status:</label>
                <select id="saleStatus" name="insales">
                    <option value="Y">On Sale</option>
                    <option value="N">Not on Sale</option>
                </select>
                <input type="submit" value="Update Product">
            </form>
            <form action="/shopping/deletegoods">
                <input type="text" id="deleteCode" name="deleteCode" style="display: none;">
                <input type="submit" value="Delete Product">
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
                    		<a class="nav-link" href="/shopping/stock">재고</a>
                    		<div class="bar"></div>
                  		</li>
                        <li class="nav-item">
                    		<a class="nav-link active" aria-current="page" href="/shopping/goods">물품 등록여부 조회</a>
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

                <h2>Product Management</h2>

                <div class="add-container" style="margin-bottom: 100px;">
                    <h3>Add Product</h3>
                    <form id="addProductForm">
                        <div class="form-group">
                            <label for="productCode">Product Code:</label>
                            <input type="text" name="productCode" required>
                        </div>
                        <div class="form-group">
                            <label for="productName">Product Name:</label>
                            <input type="text" name="productName" required>
                        </div>
                        <div class="form-group">
                            <label for="productPrice">Product Price:</label>
                            <input type="number" name="productPrice" required min="0" step="0.01">
                        </div>
                        <div class="form-group">
                            <label for="saleStatus">Sale Status:</label>
                            <select name="saleStatus" required>
                                <option value="Y">On Sale</option>
                                <option value="N">Not on Sale</option>
                            </select>
                        </div>
                        <button type="submit">Add Product</button>
                    </form>
                </div>

                <table class="product-table">
                    <tr>
                        <th>Product Code</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Sale Status</th>
                        <th>Edit</th>
                    </tr>

                    <c:forEach var="orderGoods" items="${orderGoodsList}">
                        <tr class="table-row">
                            <td class="table-code">${orderGoods.goodsCode}</td>
                            <td class="table-name">${orderGoods.goodsName}</td>
                            <td class="table-price">${orderGoods.price}</td>
                            <td class="table-sales">${orderGoods.insales}</td>
                            <td><button class="table-button">Edit</button></td>
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


        var modal = $('#productModal');
        
        // Get the <span> element that closes the modal
        var modalClose = $('.close')[0];
        
        // When the user clicks on <span> (x), close the modal
        $(modalClose).on('click', function() {
            modal.hide();
        });
        
        // When the user clicks anywhere outside of the modal, close it
        $(window).on('click', function(event) {
            if (event.target == modal[0]) {
                modal.hide();
            }
        });
        
        

        $(".table-button").click(function() {
            const parent = $(this).closest(".table-row");
            const code = parent.find(".table-code");
            const name = parent.find(".table-name");
            const price = parent.find(".table-price");
            const sales = parent.find(".table-sales")

            $('#modal-item-name').text(name.html());
            $('#modal-item-quantity').val(price.html());

            $('#productCode').val(code.html());
            $('#deleteCode').val(code.html());
            $('#productName').val(name.html());
            $('#productPrice').val(price.html());
            
            if(sales.text()=="On Sale") {
                $('#saleStatus').val("Y");
            } else if(sales.text()=="Not on Sale") {
                $('#saleStatus').val("N");
            }

            modal.show();


        });

    </script>
</body>
</html>