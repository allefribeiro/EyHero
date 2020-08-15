appHeroi.factory("tokenInterceptor", function( $q){

	return 
	{
		'request': function( config)
		{
			config.headers.Authorzation = 'Bearer ' +  localStorage.getItem("userToken");
			
			return config;
		}
		'responseError': function( rejection)
		{
			if( rejection.status == 401)
			{
				$location.path("/login");
			}
			
			return $q.reject(rejection);
		}
	};

});