angular.module('gemStore').controller('LoginController', function($rootScope, $scope, $http, $location, auth) {
	
	$scope.authentication = auth;
	
	var authenticate = function(credentials, callback) {
		var headers = credentials ? {authorization : "Basic "
			+ btoa(credentials.username + ":" + credentials.password)
		} : {};
		
		$http.get('api/user', {headers : headers}).success(function(data) {
			if(data.name) {
				$rootScope.authenticated = true;
			} else {
				$rootScope.authenticated = false;
			}
			callback && callback();
		}).error(function() {
			$rootScope.authenticated = false;
			callback && callback();
		});
		
	}
	
	authenticate();
	$scope.credentials = {};
	$scope.login = function(data) {
		authenticate($scope.credentials, function() {
			if($rootScope.authenticated) {
				$location.path("/");
				$scope.error = false;
			} else {
				$location.path("/login");
				$scope.error = true;
			}
		});
	};
	
	$scope.logout = function() {
		$http.post("logout", {}).success(function() {
			$rootScope.authenticated = false;
			$location.path("/");
		}).error(function(data) {
			$rootScope.authenticated = false;
		});
	}
	
});