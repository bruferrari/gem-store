angular.module('gemStore').controller('ProductController', function($scope, $routeParams, productRegister, productsResource) {
	$scope.product = {};
	$scope.message = '';
	
	if($routeParams.id) {
		productsResource.get({id : $routeParams.id}, function(product) {
			$scope.product = product;
		}, function(error) {
			console.log(error);
			$scope.message = 'An error ocurred.'
		});
	}
	
	$scope.submit = function() {
		if($scope.form.$valid) {
			productRegister.register($scope.product)
			.then(function(data) {
				$scope.message = data.message;
				if(data.include) $scope.product = {};
			}).catch(function(data) {
				$scope.message = data.message;
			});
		}
	}
});