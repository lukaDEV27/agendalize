package br.com.agendalize.service;

import java.util.List;

import br.com.agendalize.entity.DataIndisponivelEntity;

public interface DataIndisponivelService {
	
	DataIndisponivelEntity getOneByIdDataIndisponivel(Long idDataIndisponivel);
	String save(DataIndisponivelEntity dataIndisponivelEntity) throws Exception;
	List<DataIndisponivelEntity> findAll();
	String deleteById(Long idDataIndisponivel) throws Exception;

}
