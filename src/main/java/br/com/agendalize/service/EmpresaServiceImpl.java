package br.com.agendalize.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agendalize.entity.EmpresaEntity;
import br.com.agendalize.repository.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService {
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public List<EmpresaEntity> findAll() {
		
		return empresaRepository.findAll();
	}

}
