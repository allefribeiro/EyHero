package br.com.hero.controller;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.IOException;

public class TokenFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, java.io.IOException
	{
		HttpServletRequest req = (HttpServletRequest) request;
		
		String header = req.getHeader("Authorization");
		
		if( header == null || !header.startsWith("Beare "))
		{
			throw new ServletException("Token inexistente ou invalido");
		}
		
		String token = header.substring(7);
		
		try
		{
			Jwts.parserBuilder().build().parseClaimsJws(token).getBody();
		}
		catch( JwtException e)
		{
			throw new ServletException("Token invalido!");
		}
		
		chain.doFilter(request, response);
	}
}
