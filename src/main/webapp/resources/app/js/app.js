var app = angular.module('gemStore', ['appDirectives','appService', 'ngRoute'])
	.config(function($routeProvider, $locationProvider) {
		
//		$locationProvider.html5Mode(true);
		
		$routeProvider.when('/products', {
			templateUrl: 'home.jsp',
			controller: 'ProductsController'
		});
		
		$routeProvider.when('/products/:id', {
			templateUrl: 'details.jsp',
			controller: 'ProductController'
		});
		
		$routeProvider.when('/product/add', {
			templateUrl: 'newProduct.jsp',
			controller: 'ProductController'
		});
		
		$routeProvider.when('/product/edit/:id', {
			templateUrl: 'newProduct.jsp',
			controller: 'ProductController'
		});
		
		$routeProvider.when('/product/manage', {
			templateUrl: 'productManager.jsp',
			controller: 'ProductsController'
		});
		
		$routeProvider.when('/cart', {
			templateUrl: 'cart.jsp',
			controller: 'CartController'
		});
		
		$routeProvider.otherwise({redirectTo: '/products'});
	});