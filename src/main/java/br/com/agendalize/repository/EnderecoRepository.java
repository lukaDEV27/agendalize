package br.com.agendalize.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agendalize.entity.EnderecoEntity;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {

	EnderecoEntity getOneByIdEndereco(Long idEndereco);
	
}
