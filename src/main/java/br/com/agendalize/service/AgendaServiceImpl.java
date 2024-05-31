package br.com.agendalize.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agendalize.entity.AgendaEntity;
import br.com.agendalize.entity.EmpresaEntity;
import br.com.agendalize.repository.AgendaRepository;

@Service
public class AgendaServiceImpl implements AgendaService {
	
	@Autowired
	private AgendaRepository agendaRepository;
	
	private String mensagem;

	@Override
	public AgendaEntity getOneByIdAgenda(Long idAgenda) {
		
		return agendaRepository.getOneByIdAgenda(idAgenda);
	}

	@Override
	public String save(AgendaEntity agendaEntity) throws Exception {
		agendaRepository.save(agendaEntity);
		this.mensagem = "Agenda cadastrada com sucesso.";
		
		return mensagem;
	}

	@Override
	public List<AgendaEntity> findAll() {
		
		return agendaRepository.findAll();
	}

	@Override
	public String deleteById(Long idAgenda) throws Exception {
		try 
		{
			agendaRepository.deleteById(idAgenda);
			this.mensagem = "Agenda excluída com sucesso.";
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return mensagem;
	}

	@Override
	public List<AgendaEntity> findAllByEmpresa(EmpresaEntity Empresa) {
		// TODO Auto-generated method stub
		return agendaRepository.findAllByEmpresa(Empresa);
	}

	

}
