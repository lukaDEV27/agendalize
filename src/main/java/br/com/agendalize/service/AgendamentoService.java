package br.com.agendalize.service;

import java.util.List;

import br.com.agendalize.entity.AgendamentoEntity;

public interface AgendamentoService {
	
	AgendamentoEntity getOneByIdAgendamento(Long idAgendamento);
	String save(AgendamentoEntity agendamentoEntity) throws Exception;
	List<AgendamentoEntity> findAll();
	String deleteById(Long idAgendamento) throws Exception;


}
