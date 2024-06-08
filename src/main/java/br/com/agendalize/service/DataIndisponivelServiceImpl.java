package br.com.agendalize.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agendalize.entity.AgendaEntity;
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
		

		if (dataIndisponivelRepository.existsByDataAndAgenda(dataIndisponivelEntity.getData(), dataIndisponivelEntity.getAgenda()) == true) {
			
			this.mensagem = "Você ja cadastrou a rotina desse dia.";
		
		} else {
			
			dataIndisponivelRepository.save(dataIndisponivelEntity);
			this.mensagem = "Data indisponivel cadastrada cadastrada com sucesso.";
			
		}
		
		
		return mensagem;
	}

	@Override
	public List<DataIndisponivelEntity> findAll() {
		
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

	@Override
	public String update(DataIndisponivelEntity dataIndisponivelEntity) throws Exception {
		
		dataIndisponivelRepository.saveAndFlush(dataIndisponivelEntity);
		this.mensagem = "Data atualizada com sucesso.";
		
		return mensagem;
	}

	@Override
	public boolean existsByDataAndAgenda(Date data, AgendaEntity agenda) {
		
		return dataIndisponivelRepository.existsByDataAndAgenda(data, agenda);
	}
	

}
