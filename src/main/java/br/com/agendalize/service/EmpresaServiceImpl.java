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
	
	private String mensagem;

	@Override
	public List<EmpresaEntity> findAll() {
		
		return empresaRepository.findAll();
	}

	@Override
	public EmpresaEntity getOneByIdEmpresa(Long idEmpresa) {
		
		return empresaRepository.getOneByIdEmpresa(idEmpresa);
	}

	@Override
	public String save(EmpresaEntity empresaEntity) throws Exception {
		empresaRepository.saveAndFlush(empresaEntity);
		this.mensagem = "Empresa cadastrada com sucesso.";
		
		return mensagem;
	}

	@Override
	public String deleteById(Long idEmpresa) throws Exception {
		try 
		{
			empresaRepository.deleteById(idEmpresa);
			this.mensagem = "Empresa excluída com sucesso.";
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return mensagem;
	}

}
