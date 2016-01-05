<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/gemStore/#/products">Gem Store</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a ng-href="#">Menu</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li>
						<!-- <shopping-cart-button ng-controller="CartController" bind="cart.itens.length"></shopping-cart-button> -->
						<a ng-href="#/cart" ng-controller="CartController" class="glyphicon glyphicon-shopping-cart btn-lg"><span class="badge" data-ng-bind="cart.itens.length"></span></a>
					</li>
					
					<li>
						<a ng-hide="authenticated" ng-href="/gemStore/login">Login</a>
					</li>
					
					<li class="dropdown"><a ng-controller="LoginController" ng-show="authenticated" href="" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">{{authentication.name}} <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a ng-href="/gemStore/#/product/add">New Product</a></li>
							<li><a ng-href="/gemStore/#/product/manage">List Products</a></li>
							<li><a ng-href="/gemStore/#/user/new">Register new user</a></li>
							<li><a ng-href="/gemStore/#/user/manage">Manage users</a></li>
							<li role="separator" class="divider"></li>
							<li><a ng-controller="LoginController" href="" ng-click="logout()">Logout</a></li>
						</ul></li>
					
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</body>
</html>