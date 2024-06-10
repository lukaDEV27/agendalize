package br.com.agendalize.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agendalize.entity.AgendamentoEntity;
import br.com.agendalize.repository.AgendamentoRepository;

@Service
public class AgendamentoServiceImpl implements AgendamentoService{

	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	private String mensagem;
	
	@Override
	public AgendamentoEntity getOneByIdAgendamento(Long idAgendamento) {
		// TODO Auto-generated method stub
		return agendamentoRepository.getOneByIdAgendamento(idAgendamento);
	}

	@Override
	public String save(AgendamentoEntity agendamentoEntity) throws Exception {
		agendamentoRepository.saveAndFlush(agendamentoEntity);
		this.mensagem = "Cliente cadastrado com sucesso.";
		
		return mensagem;
	}

	@Override
	public List<AgendamentoEntity> findAll() {
		// TODO Auto-generated method stub
		return agendamentoRepository.findAll();
	}

	@Override
	public String deleteById(Long idAgendamento) throws Exception {
		try 
		{
			agendamentoRepository.deleteById(idAgendamento);
			this.mensagem = "Agendamento excluído com sucesso.";
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return mensagem;
	}

}
