package br.com.agendalize.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agendalize.entity.AgendaEntity;
import br.com.agendalize.entity.DataIndisponivelEntity;
import br.com.agendalize.entity.EmpresaEntity;

@Repository
public interface AgendaRepository extends JpaRepository<AgendaEntity, Long>{
	
	AgendaEntity getOneByIdAgenda(Long idAgenda);
	List<AgendaEntity> findAllByEmpresa( EmpresaEntity Empresa);
	boolean existsByIdAgendaAndDatasIndisponiveis(Long idAgenda, List<DataIndisponivelEntity> datasIndisponiveis);

}
