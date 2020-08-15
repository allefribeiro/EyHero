package br.com.hero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hero.models.Heroi;

@Repository
public interface HeroiRepository extends JpaRepository<Heroi, Long> {
	
	Iterable<Heroi> findByEvento( Heroi heroi);
}
