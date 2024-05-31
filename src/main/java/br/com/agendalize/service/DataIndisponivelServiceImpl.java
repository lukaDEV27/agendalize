package br.com.agendalize.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agendalize.entity.DataIndisponivelEntity;
import br.com.agendalize.repository.DataIndisponivelRepository;

@Service
public class DataIndisponivelServiceImpl implements DataIndisponivelService{
	
	@Autowired
	private DataIndisponivelRepository dataIndisponivelRepository;
	
	private String mensagem;

	@Override
	public DataIndisponivelEntity getOneByIdDataIndisponivel(Long idDataIndisponivel) {
		// TODO Auto-generated method stub
		return dataIndisponivelRepository.getOneByIdDataIndisponivel(idDataIndisponivel);
	}

	@Override
	public String save(DataIndisponivelEntity dataIndisponivelEntity) throws Exception {
		dataIndisponivelRepository.save(dataIndisponivelEntity);
		this.mensagem = "Data indisponivel cadastrada cadastrada com sucesso.";
		return mensagem;
	}

	@Override
	public List<DataIndisponivelEntity> findAll() {
		// TODO Auto-generated method stub
		return dataIndisponivelRepository.findAll();
	}

	@Override
	public String deleteById(Long idDataIndisponivel) throws Exception {
		try 
		{
			dataIndisponivelRepository.deleteById(idDataIndisponivel);
			this.mensagem = "Data Indisponivel excluída com sucesso.";
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return mensagem;
	}

}
