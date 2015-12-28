angular.module('appService', ['ngResource'])
	.factory('productsResource', function($resource) {
		
		return $resource('products/:id', null, {
			update : {
				method: 'PUT'
			},
			get : {
				method: 'GET',
				isArray: false
			}
		});
		
	}).factory('productRegister', function(productsResource, $q, $rootScope) {
		var service = {};
		var prod = 'addedProduct';
		
		service.register = function(product) {
			
			return $q(function(resolve, reject) {
				
				if(product.id) {
					
					productsResource.update({id : product.id}, product, function() {
						
						$rootScope.$broadcast(prod);
						
						resolve({
							message: 'Product ' + product.prodName + ' has been updated with success!',
							include: false
							});
						
						}, function(error) {
							console.log(error);
							
							reject({
								message: 'Errors occurred'
							});
						});
					
				} else {
					productsResource.save(product, function() {
						$rootScope.$broadcast(product);
						resolve({
							message: 'Product ' + product.prodName + 'has been saved with success!',
							include: true
						});
					}, function(error) {
						console.log(error);
						reject({
							message: 'Errors occurred'
						});
					});
				}
		});
		
	};
	return service;
	
}).factory('cartResource', function($resource) {
	return $resource('cart/:id', null, {
		get : {
			method: "GET",
			isArray: false
		}
	})
}).factory('cartRegister', function(cartResource, $q, $rootScope, $resource) {
	
	var service = {};

	service.add = function(product) {
		return $q(function(resolve, reject){
			
			cartResource.save(product, function() {
				$rootScope.$broadcast(product);
				
				resolve({
					message: 'product with code ' + product.id + ' has been added to cart.',
					include: true
				});
			}, function(error) {
				console.log(error);
				
				reject({
					message: 'Error occurred!'
				});
			});
		});
			
		};
		
		return service;
	
	
});
			







