//Criacao do modulo principal da aplicacao
var appCedula = angular.module("appCedula", [ 'ngRoute' ]);

appCedula.config(function($routeProvider, $locationProvider) {

	$routeProvider
	.when("/cedulas", {
		templateUrl : 'view/cedula.html',
		controller : 'cedulaController'
	}).otherwise({
		rediretTo : '/'
	});
	
	$locationProvider.html5Mode(true);
	
});