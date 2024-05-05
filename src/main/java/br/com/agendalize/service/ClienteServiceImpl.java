package br.com.agendalize.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agendalize.entity.ClienteEntity;
import br.com.agendalize.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	private String mensagem;

	@Override
	public List<ClienteEntity> findAll() {
		
		return clienteRepository.findAll();
	}

	@Override
	public ClienteEntity getOneByIdCliente(String idCliente) {
		
		return clienteRepository.getOneByIdCliente(idCliente);
	}

	@Override
	public String save(ClienteEntity clienteEntity) throws Exception {
		clienteRepository.saveAndFlush(clienteEntity);
		this.mensagem = "Cliente cadastrado com sucesso.";
		
		return mensagem;
	}

	@Override
	public String deleteById(String idCliente) throws Exception {
		try 
		{
			clienteRepository.deleteById(idCliente);
			this.mensagem = "Cliente excluído com sucesso.";
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return mensagem;
	}

}
