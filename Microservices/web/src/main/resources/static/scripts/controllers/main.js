angular.module('microservices')
	.controller('MainCtrl', function($scope, $http) {
		$http({
			method : 'GET',
			url : '/lojas'
		}).then(function(response) {
			$scope.lojas = response.data;
		}, function(response) {
			console.error('Erro requisitando lojas');
		});
	});
