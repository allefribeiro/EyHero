package br.com.hero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import br.com.hero.controller.TokenFilter;

@SpringBootApplication
public class HeroProjectApplication {

	@Bean
	public FilterRegistrationBean filtroJwt()
	{
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new TokenFilter());
		frb.addUrlPatterns("/ey/*");
		
		return frb;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HeroProjectApplication.class, args);
	}

}
