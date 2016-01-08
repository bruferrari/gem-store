<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gem Store - Products</title>
</head>
<body>

	<div class="row">
		<input type="search" ng-model="filter" ng-model-options="{debounce: 500}"
			 class="form-control search" placeholder="Search for products">
	</div>

	<div class="row" >
		<div class="col-sm-3" ng-repeat="product in products | filter:filter">
			<div class="thumbnail">
			<img class="img-responsive" src="{{product.prodImage}}" alt="{{product.prodName}}">
				<div class="caption">
					<h3><a ng-href="/gemStore/#/products/{{product.id}}">{{product.prodName}}</a></h3>
					<p>$ {{product.price | number:2}}</p>
				</div>
			</div>
		</div>
	</div>
	
<nav>
  <ul class="pager">
    <li><a href="#" ng-click="prods.previousPage()">Previous</a></li>
    <li><a href="#" ng-click="prods.nextPage()">Next</a></li>
  </ul>
</nav>
	
</body>
</html>