angular.module('gemStore').controller('ProductsController', function($scope, productsResource) {
	$scope.products = [];
	$scope.product = {};
	$scope.filter = '';
	$scope.msg = '';
	
	productsResource.query(function(products) {
		$scope.products = products;
	}, function(error) {
		console.log(error);
	});
	
	$scope.remove = function(product) {
		productsResource.delete({id : product.id}, function() {
			var productIndex = $scope.products.indexOf(product);
			$scope.products.splice(productIndex, 1);
			$scope.msg = 'Product ' + product.prodName + 'removed with success!';
		}, function(error) {
			console.log(error);
			$scope.msg = 'An error occurred when trying to delete product ' + product.prodName; 
		});
	}
	
});