angular.module('microservices')
	.controller('ClientesCtrl', function($scope, $http, $routeParams) {
		$http({
			method : 'GET',
			url : '/clientes/lojas/' + $routeParams.id
		}).then(function(response) {
			$scope.clientes = response.data;
		}, function(response) {
			console.error('Erro requisitando clientes.')
		});
	});
