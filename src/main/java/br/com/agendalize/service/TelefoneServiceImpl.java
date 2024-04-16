package br.com.agendalize.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agendalize.entity.TelefoneEntity;
import br.com.agendalize.repository.TelefoneRespository;

@Service
public class TelefoneServiceImpl implements TelefoneService{
	
	@Autowired
	private TelefoneRespository telefoneRepository;

	@Override
	public TelefoneEntity getOneByIdTelefone(Long idTelefone) {
		
		return telefoneRepository.getOneByIdTelefone(idTelefone);
	}

	@Override
	public List<TelefoneEntity> findAll() {
		
		return telefoneRepository.findAll();
	}
	
	

}
