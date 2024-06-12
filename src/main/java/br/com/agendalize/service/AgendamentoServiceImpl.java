package br.com.agendalize.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agendalize.entity.AgendaEntity;
import br.com.agendalize.entity.AgendamentoEntity;
import br.com.agendalize.entity.DataIndisponivelEntity;
import br.com.agendalize.repository.AgendaRepository;
import br.com.agendalize.repository.AgendamentoRepository;

@Service
public class AgendamentoServiceImpl implements AgendamentoService{

	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Autowired
	private AgendaRepository agendaRepository;
	
	@Autowired
	private AgendaService agendaService;
	
	private String mensagem;
	
	@Override
	public AgendamentoEntity getOneByIdAgendamento(Long idAgendamento) {
		// TODO Auto-generated method stub
		return agendamentoRepository.getOneByIdAgendamento(idAgendamento);
	}

	@Override
	public String save(AgendamentoEntity agendamentoEntity) throws Exception {
	   
		
		AgendaEntity ag = new AgendaEntity();
		ag = agendaRepository.getOneByIdAgenda(agendamentoEntity.getAgenda().getIdAgenda());
		
		for (int i = 0; i < ag.getDatasIndisponiveis().size(); i++) {
			
			if (ag.getDatasIndisponiveis().get(i).getData().equals(agendamentoEntity.getDataAgendamento())) {
				this.mensagem = "data igual.";
				System.out.println(ag.getDatasIndisponiveis().get(i).getData() + "data igual." + agendamentoEntity.getDataAgendamento());
				
			}
			else
			{
				this.mensagem = "data diferente.";
				System.out.println(ag.getDatasIndisponiveis().get(i).getData() + "data diferente." + agendamentoEntity.getDataAgendamento());
			}
		}
		
	   /* if (agendaRepository.existsByIdAgendaAndDatasIndisponiveis(agendamentoEntity.getAgenda().getIdAgenda(), null)) {
	    	
			this.mensagem = "teste validacao.";
		
		} 
	    else
	    {
	    	agendamentoRepository.saveAndFlush(agendamentoEntity);
			this.mensagem = "Agendamento cadastrado com sucesso.";
	    }*/
	    	
		
		
	
		
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
