package br.com.agendalize.service;

import java.util.List;

import br.com.agendalize.entity.ClienteEntity;

public interface ClienteService {
	
	ClienteEntity getOneByIdCliente(String idCliente);
	String save(ClienteEntity clienteEntity) throws Exception;
	List<ClienteEntity> findAll();
	String deleteById(String idCliente) throws Exception;

	
}
