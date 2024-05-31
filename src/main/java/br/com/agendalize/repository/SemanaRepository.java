package br.com.agendalize.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agendalize.entity.SemanaEntity;

@Repository
public interface SemanaRepository extends JpaRepository<SemanaEntity, Long>{
	
	SemanaEntity getOneByIdSemana(Long idSemana);

}
