package br.com.hero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hero.models.Heroi;
import br.com.hero.models.Poder;

@Repository
public interface PoderRepository extends JpaRepository<Heroi, Long> {

	Iterable<Poder> findByEvento( Heroi heroi);
}
