var appHeroi = angular.module("appHeroi", ['ngRoute']);

appHeroi.config(function($routeProvider, $locationProvider){

	$routeProvider
	.when("/herois", {templateUrl:'view/heroi.html', controller:'heroiController'})
	.when("/cadastro", {templateUrl:'view/cadastro.html', controller:'cadastroController'})
	.when("/login", {templateUrl:'view/login.html', controller:'loginController'})
	.otherwise({redirectTo:'/'});
	
	$locationProvider.html5Mode(true);
	
	appHeroi.config (function($httpProvider)
	{
		$httpProvider.interceptions.push("tokenInterceptor");
	});
});