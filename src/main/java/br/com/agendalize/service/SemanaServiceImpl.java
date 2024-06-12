package br.com.agendalize.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agendalize.entity.AgendaEntity;
import br.com.agendalize.entity.SemanaEntity;
import br.com.agendalize.repository.SemanaRepository;

@Service
public class SemanaServiceImpl implements SemanaService{
	
	@Autowired
	private SemanaRepository semanaRepository;
	
	private String mensagem;

	@Override
	public SemanaEntity getOneByIdSemana(Long idSemana) {
		// TODO Auto-generated method stub
		return semanaRepository.getOneByIdSemana(idSemana);
	}

	@Override
	public String save(SemanaEntity semanaEntity) throws Exception {
		
		
		
		if (semanaRepository.existsByNomeDiaAndAgenda(semanaEntity.getNomeDia(), semanaEntity.getAgenda()) == true) {
			
			this.mensagem = "Você ja cadastrou a rotina desse dia.";
		
		} 
		else {
			
			semanaRepository.saveAndFlush(semanaEntity);
			this.mensagem = "Rotina do dia cadastrada com sucesso.";
			
		}
		
		return mensagem;
	}

	@Override
	public List<SemanaEntity> findAll() {
		// TODO Auto-generated method stub
		return semanaRepository.findAll();
	}

	@Override
	public String deleteById(Long idSemana) throws Exception {
		try 
		{
			semanaRepository.deleteById(idSemana);
			this.mensagem = "Rotina semanal excluída com sucesso.";
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return mensagem;
	}

	@Override
	public boolean existsByNomeDiaAndAgenda(String nomeDia, AgendaEntity agenda) {
		
		return semanaRepository.existsByNomeDiaAndAgenda(nomeDia, agenda);
	}

	@Override
	public String update(SemanaEntity semanaEntity) throws Exception {
		
		semanaRepository.saveAndFlush(semanaEntity);
		this.mensagem = "Dia atualizado com sucesso.";
		
		return mensagem;
	}

}
