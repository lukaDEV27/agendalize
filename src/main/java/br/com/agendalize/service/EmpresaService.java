package br.com.agendalize.service;

import java.util.List;

import br.com.agendalize.entity.EmpresaEntity;

public interface EmpresaService {
	
	EmpresaEntity getOneByIdEmpresa(Long idEmpresa);
	String save(EmpresaEntity empresaEntity) throws Exception;
	List<EmpresaEntity> findAll();
	String deleteById(Long idEmpresa) throws Exception;

	
}
