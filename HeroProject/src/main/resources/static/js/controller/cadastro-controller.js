appHeroi.controller("cadastroController", function($scope, $http){

	$scope.carregarUniversos = function()
	{
		$http({method:'GET', url:'/ey/universos'})
		.then(function(response))
		{
			$scope.universos = response.data;
		}, 
		(function(response))
		{
		});
	}

	$scope.carregarPoderes = function()
	{
		$http({method:'GET', url:'/ey/poderes'})
		.then(function(response))
		{
			$scope.poderes = response.data;
		}, 
		(function(response))
		{
		});
	}

	$scope.salvarHerois = function()
	{
		$http({method:'POST', url:'/ey/cadastrarHeroi', data:$scope.heroi})
		.then(function(response))
		{
			carregarPoderes();
			carregarUniversos();
		}, 
		(function(response))
		{
		});
	}

	carregarPoderes();
	carregarUniversos();
});