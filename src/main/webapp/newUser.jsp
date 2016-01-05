<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gem Store - New User</title>
</head>
<body>

	<p class="alert alert-info" ng-show="message.length">
		{{message}}
		<a ng-href="#/user/manager" class="btn btn-primary pull-right">Go to manager</a>
		</p>

	<div class="row">
		<div class="col-sm-6 col-md-6">


			<form novalidate name="form" ng-submit="register()" role="form">
				<div class="form-group">
					<label>User email</label> 
					<input type="text" name="email" ng-model="user.email" class="form-control" required>
					<span ng-show="form.$submitted && form.email.$error.required" 
							class="form-control alert-danger">User email is required</span>
				</div>

				<div class="form-group">
					<label>Password</label> 
					<input type="password" name="password" rows="6" ng-model="user.password" class="form-control" 
						required >
					<span ng-show="form.$submitted && form.password.$error.required" 
							class="form-control alert-danger">User password is required</span>
				</div>

				<button class="btn btn-primary" type="submit">Register User</button>
				<a ng-href="#/products" class="btn btn-danger">Cancel</a>
			</form>
		</div>
		
	</div>

</body>
</html>