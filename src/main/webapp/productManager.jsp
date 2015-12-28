<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gem Store - Products Manager</title>
</head>
<body>

	<div class="row">
		<table class="table table-hover">
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Product Price</th>
				<th>Quantity Available</th>
				<th></th>
			</tr>
			
			<tr ng-repeat="product in products">
				<td>{{product.id}}</td>
				<td>{{product.prodName}}</td>
				<td>$ {{product.price}}</td>
				<td>{{product.quantity}}</td>
				<td>
					<edit-button url="#/product/edit/{{product.id}}" />
				</td>
				<td><danger-button action="remove(product)" /></td>
			</tr>
		</table>
	</div>
</body>
</html>