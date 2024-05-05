package br.com.agendalize.service;

import java.util.List;

import br.com.agendalize.entity.EmpresaEntity;

public interface EmpresaService {
	
	EmpresaEntity getOneByIdEmpresa(String idEmpresa);
	String save(EmpresaEntity empresaEntity) throws Exception;
	List<EmpresaEntity> findAll();
	String deleteById(String idEmpresa) throws Exception;

	
}
