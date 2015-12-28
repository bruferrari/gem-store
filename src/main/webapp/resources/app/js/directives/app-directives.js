angular.module('appDirectives', [])
.directive('dangerButton', function() {
	
	var ddo = {};
	ddo.restrict = 'E';
	
	ddo.scope = {
		action: '&'
	};
	
	ddo.templateUrl = 'resources/app/js/directives/danger-button.html';
	
	return ddo;
})
.directive('editButton', function() {
	
	var ddo = {};
	ddo.restrict = 'E';
	
	ddo.scope = {
		url: '@'
	};
	
	ddo.templateUrl = 'resources/app/js/directives/edit-button.html';
	
	return ddo;
})
//.directive('shoppingCartButton', function() {
//	
//	var ddo = {};
//	ddo.restrict = 'AE';
//	
//	ddo.scope = {
//		bind: '&'	
//	};
//	
//	ddo.templateUrl = 'resources/app/js/directives/shopping-cart-button.html';
//	
//	return ddo;
//	
//});
