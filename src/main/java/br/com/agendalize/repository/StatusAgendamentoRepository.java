package br.com.agendalize.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agendalize.entity.StatusAgendamentoEntity;

@Repository
public interface StatusAgendamentoRepository extends JpaRepository<StatusAgendamentoEntity, Long> {

	StatusAgendamentoEntity getOneByIdStatusAgendamento(Long idStatusAgendamento);
	
}
