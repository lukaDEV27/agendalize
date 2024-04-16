package br.com.agendalize.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agendalize.entity.TelefoneEntity;

@Repository
public interface TelefoneRespository extends JpaRepository<TelefoneEntity, Long>{

	TelefoneEntity getOneByIdTelefone(Long idTelefone);
	
}
