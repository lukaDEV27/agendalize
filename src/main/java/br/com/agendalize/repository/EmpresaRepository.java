package br.com.agendalize.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agendalize.entity.EmpresaEntity;
import br.com.agendalize.entity.UsuarioEntity;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Long> {

	EmpresaEntity getOneByIdEmpresa(Long idEmpresa);

	EmpresaEntity getOneByUsuarioEmpresaLogin(UsuarioEntity usuarioEmpresaLogin);
	

}
