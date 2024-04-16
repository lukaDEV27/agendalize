package br.com.agendalize.service;

import java.util.List;

import br.com.agendalize.entity.TelefoneEntity;

public interface TelefoneService {

	TelefoneEntity getOneByIdTelefone(Long idTelefone);
	List<TelefoneEntity> findAll();
	
}
