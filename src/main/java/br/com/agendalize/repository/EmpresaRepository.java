package br.com.agendalize.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agendalize.entity.EmpresaEntity;
import br.com.agendalize.entity.UsuarioEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Long> {

	EmpresaEntity getOneByIdEmpresa(Long idEmpresa);

	EmpresaEntity getOneByUsuarioEmpresaLogin(UsuarioEntity usuarioEmpresaLogin);
	// @Query(value = "SELECT e.?1, COUNT(c.?2) AS total_clientes FROM empresa e
	// JOIN cliente c ON e.?1 = c.empresa_cliente_id GROUP BY e.id_empresa;",
	// nativeQuery = true)

}
