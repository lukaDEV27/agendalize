package br.com.agendalize.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.agendalize.entity.UsuarioEntity;
import jakarta.transaction.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

	boolean existsByEmailUsuario(String emailUsuario);
	UsuarioEntity getOneByEmailUsuario(String emailUsuario);
	
	@Modifying
	@Query(value = "update agendalize.usuario"
			+ " set senha_usuario = ?1 where "
			+ "email_usuario = ?2", nativeQuery = true)
	
	@Transactional
	void alterarSenha(String novaSenha, String emailUsuario);
	
}
