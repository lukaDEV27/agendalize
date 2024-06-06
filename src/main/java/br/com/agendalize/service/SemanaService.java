package br.com.agendalize.service;

import java.util.List;

import br.com.agendalize.entity.AgendaEntity;
import br.com.agendalize.entity.SemanaEntity;

public interface SemanaService {
	
	SemanaEntity getOneByIdSemana(Long idSemana);
	String save(SemanaEntity semanaEntity) throws Exception;
	String update(SemanaEntity semanaEntity) throws Exception;
	List<SemanaEntity> findAll();
	String deleteById(Long idSemana) throws Exception;
	boolean existsByNomeDiaAndAgenda(String nomeDia, AgendaEntity agenda);

}
