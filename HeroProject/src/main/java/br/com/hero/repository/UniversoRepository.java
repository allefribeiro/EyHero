package br.com.hero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hero.models.Heroi;
import br.com.hero.models.Universo;

@Repository
public interface UniversoRepository  extends JpaRepository<Heroi, Long> {
	
	Iterable<Universo> findByEvento( Heroi heroi);
}
