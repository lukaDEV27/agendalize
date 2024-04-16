package br.com.agendalize.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agendalize.entity.EnderecoEntity;
import br.com.agendalize.repository.EnderecoRepository;

@Service
public class EnderecoServiceImpl implements EnderecoService{

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Override
	public EnderecoEntity getOneByIdEndereco(Long idEndereco) {
		// TODO Auto-generated method stub
		return enderecoRepository.getOneByIdEndereco(idEndereco);
	}

	@Override
	public List<EnderecoEntity> findAll() {
		// TODO Auto-generated method stub
		return enderecoRepository.findAll();
	}

}
