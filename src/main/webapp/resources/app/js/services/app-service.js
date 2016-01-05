angular.module('appService', ['ngResource'])
	.factory('productsResource', function($resource) {
		
		return $resource('api/products/:id', null, {
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
	return $resource('api/cart/:id', null, {
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
	
	
}).factory('auth',function($resource) {
	
	var resource = $resource('api/user', {}, {
		get: {
			method: "GET",
			cache: true,
			isArray: false
		}
	});
	
	return resource.get();
	
}).factory('usersResource', function($resource) {
	
	return $resource('api/users/:email', null, {
		update: {
			method: 'PUT'
		},
		
		get: {
			method: 'GET',
			isArray: false
		}
	});
	
}).factory('userRegister', function($q, $rootScope, usersResource) {
	var service = {};
	var u = 'addedUser';
	
	service.register = function(user) {
		return $q(function(resolve, reject) {
//			if(user.email) {
//				usersResource.update({email : user.email}, user, function() {
//					
//					$rootScope.$broadcast(u);
//					resolve({
//						message: 'User ' + user.email + ' has been updated with success!',
//						include: false
//						});
//					
//					}, function(error) {
//						console.log(error);
//						
//						reject({
//							message: 'Errors occurred'
//						});
//					});
//				
//			} else {
				usersResource.save(user, function() {
					$rootScope.$broadcast(user);
					resolve({
						message: 'User ' + user.email + 'has been saved with success!',
						include: true
					});
				}, function(error) {
					console.log(error);
					reject({
						message: 'Errors occurred'
					});
				});
			});
	
	};
	
	return service;
});

			







