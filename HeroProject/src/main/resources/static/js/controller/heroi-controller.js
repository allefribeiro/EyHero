appHeroi.controller("heroiController", function($scope, $http){

	$scope.carregarHerois = function()
	{
		token = localStorage.getItem("userToken");
		//$http.defaults.headers.common.Authorization = 'Bearer ' + token;
	
		$http({method:'GET', url:'/ey/herois'})
		.then(function(response))
		{
			$scope.herois = response.data;
		}, 
		(function(response))
		{
		});
	}

	$scope.excluirHerois = function(heroi)
	{
		$http({method:'POST', url:'/ey/herois', data:$scope.heroi})
		.then(function(response))
		{
			carregarHerois();
		}, 
		(function(response))
		{
		});
	}

	carregarHerois();
});
