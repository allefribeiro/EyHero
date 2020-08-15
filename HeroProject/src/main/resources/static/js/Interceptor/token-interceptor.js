appHeroi.factory("tokenInterceptor", function($q){

	return 
	{
		'request': function(config)
		{
			config.headers.Authorzation = 'Bearer ' +  localStorage.getItem("userToken");
			
			return config;
		}
	};

});