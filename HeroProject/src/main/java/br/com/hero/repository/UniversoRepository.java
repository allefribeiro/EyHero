package br.com.hero.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.hero.models.Heroi;
import br.com.hero.models.Universo;

@Repository
public interface UniversoRepository  extends JpaRepository<Heroi, Long> {
	
	// Para Jpa repository o nome do metodo indica como montar a query que vai executar no banco.
	// Como na entdade Heroi nao tem a propriedade evento estava dando erro
	Iterable<Universo> findByNome( Universo universo);

	// O resultado dessa consulta sera cacheado em memoria para agilizar a consulta de universos
	@Cacheable("universos")
	@Query("select u from Universo u")
	public List<Universo> listarTodos();
	
}
