package br.com.hero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hero.models.Heroi;
import br.com.hero.models.Poder;

@Repository
public interface PoderRepository extends JpaRepository<Heroi, Long> {

	// Para Jpa repository o nome do metodo indica como montar a query que vai executar no banco.
	// Como na entdade Heroi nao tem a propriedade evento estava dando erro
	Iterable<Poder> findByNome( Poder poder);
}
