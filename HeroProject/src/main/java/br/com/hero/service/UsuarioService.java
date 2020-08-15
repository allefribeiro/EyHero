package br.com.hero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hero.models.Usuario;
import br.com.hero.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario cadastrar(Usuario usuario)
	{
		return usuarioRepository.save(usuario);
	}
	
	public Usuario buscarPorNome( String nome)
	{
		return usuarioRepository.buscarPorNome(nome);
	}
}
