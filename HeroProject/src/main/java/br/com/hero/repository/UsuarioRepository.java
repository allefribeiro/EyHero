package br.com.hero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.hero.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query(value="SELECT u FROM Usuario u WHERE u.nome=:pnome")
	public Usuario buscarPorNome(@Param("pnome") String nome);
}
