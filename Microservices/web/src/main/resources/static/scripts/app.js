angular.module('microservices', ['ngRoute'])
	.config(function($routeProvider) {
		$routeProvider.when('/lojas', {
			templateUrl : 'views/main.html',
			controller : 'MainCtrl'
		}).when('/lojas/:id/clientes', {
			templateUrl : 'views/clientes.html',
			controller : 'ClientesCtrl'
		}).otherwise({
			redirectTo : '/lojas'
		});
	});
