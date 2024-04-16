package br.com.agendalize.service;

import java.util.List;

import br.com.agendalize.entity.EnderecoEntity;

public interface EnderecoService {
	
	EnderecoEntity getOneByIdEndereco(Long idEndereco);
	List<EnderecoEntity> findAll();

}
