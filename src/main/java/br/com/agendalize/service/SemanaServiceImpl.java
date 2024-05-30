package br.com.agendalize.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		semanaRepository.save(semanaEntity);
		this.mensagem = "Rotina semanal cadastrada com sucesso.";
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

}
