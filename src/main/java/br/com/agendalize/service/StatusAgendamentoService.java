package br.com.agendalize.service;

import java.util.List;

import br.com.agendalize.entity.StatusAgendamentoEntity;

public interface StatusAgendamentoService {
	
	StatusAgendamentoEntity getOneByIdStatusAgendamento(Long idStatusAgendamento);
	String save(StatusAgendamentoEntity statusAgendamentoEntity) throws Exception;
	List<StatusAgendamentoEntity> findAll();
	String deleteById(Long idStatusAgendamento) throws Exception;

}
