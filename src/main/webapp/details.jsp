<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gem Store - {{product.prodName}}</title>
</head>
<body>

		<div class="row">
			<div class="col-xs-6 col-md-3">
				<a href="#" class="thumbnail"> <img src="{{product.prodImage}}">
				</a>
			</div>

		<div class="row">
			<div class="col-md-6 col-md-6">
				<h1>{{product.prodName}}</h1>
				<p>{{product.prodDesc}}</p>
				<p>$ {{product.price | number:2}}</p>
				<p>Available: {{product.quantity}}</p>
				<p>
					<button class="btn btn-default" ng-controller="CartController" 
						ng-click="add(product)">Add to cart</button>
					<button class="btn btn-default" disabled="true">Add to Wish</button>
				</p>
			</div>
		</div>
		</div>
			
</body>
</html>