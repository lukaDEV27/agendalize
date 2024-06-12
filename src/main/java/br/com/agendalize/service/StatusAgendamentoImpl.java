package br.com.agendalize.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agendalize.entity.StatusAgendamentoEntity;
import br.com.agendalize.repository.StatusAgendamentoRepository;

@Service
public class StatusAgendamentoImpl implements StatusAgendamentoService {

	@Autowired
	private StatusAgendamentoRepository statusAgendamentoRepository;
	
	private String mensagem;
	
	@Override
	public StatusAgendamentoEntity getOneByIdStatusAgendamento(Long idStatusAgendamento) {
		// TODO Auto-generated method stub
		return statusAgendamentoRepository.getOneByIdStatusAgendamento(idStatusAgendamento);
	}

	@Override
	public String save(StatusAgendamentoEntity statusAgendamentoEntity) throws Exception {
		statusAgendamentoRepository.saveAndFlush(statusAgendamentoEntity);
		this.mensagem = "Status cadastrado com sucesso.";
		
		return mensagem;
	}

	@Override
	public List<StatusAgendamentoEntity> findAll() {
		// TODO Auto-generated method stub
		return statusAgendamentoRepository.findAll();
	}

	@Override
	public String deleteById(Long idStatusAgendamento) throws Exception {
		try 
		{
			statusAgendamentoRepository.deleteById(idStatusAgendamento);
			this.mensagem = "status excluído com sucesso.";
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return mensagem;
	}

}
