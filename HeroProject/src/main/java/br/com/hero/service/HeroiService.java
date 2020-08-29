package br.com.hero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.hero.models.Heroi;
import br.com.hero.repository.HeroiRepository;

@Service
public class HeroiService {

	@Autowired
	HeroiRepository heroiRepository;
	
	public Heroi cadastrar(Heroi heroi) 
	{
		return heroiRepository.save(heroi);
	}
	
	public List<Heroi> buscarTodos()
	{
		return heroiRepository.findAll();
	}
	
	public Heroi alterar( Heroi heroi) 
	{
		return heroiRepository.save(heroi);
	}
}
