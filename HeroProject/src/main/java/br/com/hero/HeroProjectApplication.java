package br.com.hero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import br.com.hero.controller.TokenFilter;

@SpringBootApplication
// Anotacao utilziada par ahabilitar caching
@EnableCaching
public class HeroProjectApplication {

	@Bean
	public FilterRegistrationBean<TokenFilter> filtroJwt()
	{
		// A classe FilterRegistrationBean utiliza Generics e para remover o warning e possiveis erros futuros o tipo do filtro foi definido.
		FilterRegistrationBean<TokenFilter> frb = new FilterRegistrationBean<>();
		frb.setFilter(new TokenFilter());
		frb.addUrlPatterns("/ey/*");
		
		return frb;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HeroProjectApplication.class, args);
	}

}
