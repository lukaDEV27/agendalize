package br.com.agendalize.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agendalize.entity.AgendaEntity;

@Repository
public interface AgendaRepository extends JpaRepository<AgendaEntity, Long>{
	
	AgendaEntity getOneByIdAgenda(Long idAgenda);

}
