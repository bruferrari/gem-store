<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gem Store - New Product</title>
</head>
<body>

	<p class="alert alert-info" ng-show="message.length">
		{{message}}
		<a ng-href="#/products" class="btn btn-primary pull-right">Go to Home</a>
		</p>

	<div class="row">
		<div class="col-sm-6 col-md-6">


			<form novalidate name="form" ng-submit="submit()" role="form">
				<div class="form-group">
					<label>Product Name</label> 
					<input type="text" name="name" required ng-model="product.prodName" class="form-control" required>
					<span ng-show="form.$submitted && form.name.$error.required" 
							class="form-control alert-danger">Name is mandatory</span>
				</div>

				<div class="form-group">
					<label>Product Description</label> 
					<textarea type="text" name="description" rows="6" ng-model="product.prodDesc" class="form-control" 
						required ></textarea>
					<span ng-show="form.$submitted && form.description.$error.required" 
							class="form-control alert-danger">Description is mandatory</span>
				</div>

				<div class="form-group">
					<label>Product Price</label> 
					<input type="text" name="price" ng-model="product.price" class="form-control" required>
						<span ng-show="form.$submitted && form.price.$error.required" 
							class="form-control alert-danger">Price is mandatory</span>
				</div>
				
				<div class="form-group">
					<label>Product Qty</label> 
					<input type="number" name="qty" placeholder="0" ng-model="product.quantity" class="form-control" required >
						<span ng-show="form.$submitted && form.qty.$error.required" 
								class="form-control alert-danger">Quantity is mandatory</span>
				</div>

				<div class="form-group">
					<label>Product Image URL</label> 
					<input type="text" name="url" placeholder="http://www.example.com/image/1" ng-model="product.prodImage" 
						class="form-control" required>
					<span ng-show="form.$submitted && form.url.$error.required" 
						class="form-control alert-danger">Url image is mandatory</span>
				</div>

				<button class="btn btn-primary" type="submit">Save Product</button>
			</form>
		</div>
		
		<div class="row">

			<div class="col-sm-6 col-md-6">
				<img class="img-responsive" src="{{product.prodImage}}" alt="{{product.prodName}}">
			</div>
		</div>
		
	</div>

</body>
</html>