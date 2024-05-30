package br.com.agendalize.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agendalize.entity.DataIndisponivelEntity;

@Repository
public interface DataIndisponivelRepository extends JpaRepository<DataIndisponivelEntity, Long> {
	
	DataIndisponivelEntity getOneByIdDataIndisponivel(Long idDataIndisponivel);

}
