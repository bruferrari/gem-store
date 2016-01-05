<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gem Store ADM - Login</title>
</head>
<body>

<div class="alert alert-danger" ng-show="error">
	There was a problem logging in. Please try again.
</div>

	<div class="row" style="margin-bottom: 20px">
		<div class="col-md-6">
			<form role="form" ng-submit="login()">
				<div class="form-group">
					<label>Email</label> <input type="text" class="form-control" ng-model="credentials.email">
				</div>
	
				<div class="form-group">
					<label>Password</label> <input type="password" class="form-control" ng-model="credentials.password">
				</div>
	
				<button type="submit" class="btn btn-primary">Login</button>
			</form>
		</div>


	</div>

</body>
</html>