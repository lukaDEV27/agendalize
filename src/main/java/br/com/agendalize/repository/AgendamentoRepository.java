package br.com.agendalize.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agendalize.entity.AgendamentoEntity;

@Repository
public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity, Long> {

	AgendamentoEntity getOneByIdAgendamento(Long idAgendamento);
	
}
