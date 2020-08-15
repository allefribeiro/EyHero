package br.com.hero.controller;

import java.security.Key;
import java.sql.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.hero.models.Usuario;
import br.com.hero.service.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@RestController
public class LoginController {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="/autenticar", consumes=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.POST)
	public LoginResponse autenticar(@RequestBody Usuario usuario) throws ServletException
	{
		if( usuario.getNome() == null || usuario.getNome() == null)
		{
			throw new ServletException("Nome e senha obrigatori.");
		}

		Usuario usuarioAutenticado = usuarioService.buscarPorNome(usuario.getNome());
		
		if( usuarioAutenticado == null)
		{
			throw new ServletException("Usuario nao encontrado.");
		}
		
		if( usuarioAutenticado.getSenha() != usuario.getSenha())
		{
			throw new ServletException("Usuario ou senha invalido.");
		}

		Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		String token = Jwts.builder().setSubject(usuarioAutenticado.getNome()).signWith(key).setExpiration(new Date(System.currentTimeMillis() + 10* 60 * 1000)).compact();

		return new LoginResponse(token);
	}
	
	
	private class LoginResponse	{

		public String token;
		
		public LoginResponse( String token)
		{
			this.token = token;
		}
	}
}
