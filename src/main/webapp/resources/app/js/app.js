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
		
		$routeProvider.when('/login', {
			templateUrl: 'login.jsp',
			controller: 'LoginController'
		});
		
		$routeProvider.when('/cart', {
			templateUrl: 'cart.jsp',
			controller: 'CartController'
		});
		
		$routeProvider.when('/user/new', {
			templateUrl: 'newUser.jsp',
			controller: 'UserController'
		});
		
		$routeProvider.when('/user/manage', {
			templateUrl: 'usersManager.jsp',
			controller: 'UsersController'
		});
		
		$routeProvider.otherwise({redirectTo: '/products'});
	});