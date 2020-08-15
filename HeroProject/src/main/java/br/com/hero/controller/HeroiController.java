package br.com.hero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.hero.models.Heroi;
import br.com.hero.service.HeroiService;

@RestController
@RequestMapping("/ey")
public class HeroiController {

	@Autowired
	HeroiService heroiservice;
	
	@RequestMapping(method = RequestMethod.GET, value = "/herois", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Heroi>> buscarTodosHerois()
	{
		List<Heroi> heroisBuscados = heroiservice.buscarTodos();
		return new ResponseEntity<>(heroisBuscados, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/herois", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Heroi> excluirHeroi(@PathVariable Heroi heroi)
	{
		Heroi heroiExcluido = heroiservice.alterar(heroi);
		return new ResponseEntity<>(heroiExcluido, HttpStatus.OK);
	}
}
