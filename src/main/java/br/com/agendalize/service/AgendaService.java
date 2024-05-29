package br.com.agendalize.service;

import java.util.List;

import br.com.agendalize.entity.AgendaEntity;
import br.com.agendalize.entity.EmpresaEntity;

public interface AgendaService {
	
	AgendaEntity getOneByIdAgenda(Long idAgenda);
	String save(AgendaEntity agendaEntity) throws Exception;
	List<AgendaEntity> findAll();
	String deleteById(Long idAgenda) throws Exception;
	List<AgendaEntity> findAllByEmpresa( EmpresaEntity Empresa);
}
