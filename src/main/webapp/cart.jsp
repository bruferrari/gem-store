<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gem Store - Shopping Cart</title>
</head>
<body>
		<p class="alert alert-info" ng-show="message.length">{{message}}</p>
	
		<div class="row">
			<div class="panel panel-primary">
			  <!-- Default panel contents -->
			  <div class="panel-heading">Your shopping cart</div>
			<table class="table table-bordered table-hover">
				<tr>
					<th></th>
					<th>Item</th>
					<th>Qty</th>
					<th>Total</th>
					<th>Options</th>
				</tr>
				
				<tbody>
					<tr ng-repeat="item in cart.itens">
						<td><img src="{{item.product.prodImage}}" /></td>
						<td>{{item.product.prodName}}</td>
						<td>{{item.quantity}}</td>
						<td>$ {{item.total | number:2}}</td>
						<td>
							<a ng-click="remove(item)" 
								class="glyphicon glyphicon-trash" />
						</td>
					</tr>
				</tbody>
				
			</table>
			<div class="panel-footer">
				<button class="btn btn-primary">Checkout</button>
				<p class="pull-right">Subtotal: $ {{cart.subTotal | number:2}}</p>
			</div>
		</div>
	</div>
			
</body>
</html>