package br.com.agendalize.service;

import java.util.List;

import br.com.agendalize.entity.ClienteEntity;

public interface ClienteService {
	
	ClienteEntity getOneByIdCliente(Long idCliente);
	String save(ClienteEntity clienteEntity) throws Exception;
	List<ClienteEntity> findAll();
	String deleteById(Long idCliente) throws Exception;

	
}
