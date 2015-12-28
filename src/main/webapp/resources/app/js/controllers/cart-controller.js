angular.module('gemStore').controller('CartController', function($scope, cartResource, cartRegister, $route, $location) {
	
//	$scope.itens = [];
	$scope.item = {};
	$scope.message = '';
	$scope.cart = {};
	$scope.cartItensQty = 0;
	
	cartResource.get(function(cart) {
		$scope.cart = cart;
	}, function(error) {
		console.log(error);
	});
	
	$scope.$watch('cart.itens', function() {
		console.log('changed!');
		$scope.cartItensQty = $scope.cart.itens.length;
	});
	
//	cartResource.query(function(itens) {
//		$scope.itens = itens;
//	}, function(error) {
//		console.log(error);
//	});
	
//	$scope.add = function(id) {
//		console.log($scope.product.id);
//		$http.post('cart/add/' + $scope.product.id, null)
//		.success(function() {
//			console.log('OK!')
//		})
//		.error(function(error) {
//			console.log(error);
//		});
//	}
	
	$scope.add = function() {
		cartRegister.add($scope.product)
		.then(function(data) {
			$location.path('/cart')
			console.log(data.message);

		}).catch(function(data) {
			console.log('An error occurred ' + data.message);
		});
	}
	
	$scope.remove = function(item) {
		cartResource.delete({id : item.product.id}, function() {
			var productIndex = $scope.cart.itens.indexOf(item);
			$scope.cart.itens.splice(productIndex, 1);
			$scope.message = 'Product ' + item.product.prodName + ' was removed from your cart'
//			$route.reload();	
			console.log($scope.cart.itens.length);
			console.log($scope.cartItensQty);
		}, function(error) {
			console.log(error);
			$scope.message = 'An error occured!';
		});
	}	
	
});