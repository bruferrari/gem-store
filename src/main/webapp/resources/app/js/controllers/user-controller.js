angular.module('gemStore').controller('UserController', function($scope, $routeParams, userRegister, usersResource) {
	
	$scope.user = {};
	$scope.message = '';
	
	if($routeParams.email) {
		usersResource.get({email : $routeParams.email}, function(user) {
			$scope.user = user;
		}, function(error) {
			console.log(error);
			$scope.message = 'An error occurred';
		});
	}
	
	$scope.register = function() {
		if($scope.form.$valid) {
			userRegister.register($scope.user)
			.then(function(data) {
				$scope.message = data.message;
				if(data.include) $scope.user = {};
				
			}).catch(function(data) {
				$scope.message = data.message;
			});
		}
	}
	
	
});