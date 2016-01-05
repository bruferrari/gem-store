angular.module('gemStore').controller('UsersController', function($scope, usersResource) {
	
	$scope.users = [];
	$scope.user = {};
	$scope.filter = '';
	$scope.msg = '';
	
	usersResource.query(function(users) {
		$scope.users = users;
	}, function(error) {
		console.log(error);
	});
	
	$scope.remove = function(user) {
		usersResource.delete({email : user.email}, function() {
			var userIndex = $scope.users.indexOf(user);
			$scope.users.splice(userIndex, 1);
			$scope.msg = 'User ' + user.email + ' has been deleted.';
		}, function(error) {
			console.log(error);
			$scope.msg = 'An error occurred when trying to delete user, please see console log';
		});
	}
	
});