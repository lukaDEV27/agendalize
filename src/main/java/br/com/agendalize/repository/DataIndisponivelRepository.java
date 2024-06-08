package br.com.agendalize.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agendalize.entity.AgendaEntity;
import br.com.agendalize.entity.DataIndisponivelEntity;

@Repository
public interface DataIndisponivelRepository extends JpaRepository<DataIndisponivelEntity, Long> {
	
	DataIndisponivelEntity getOneByIdDataIndisponivel(Long idDataIndisponivel);
	boolean existsByDataAndAgenda(Date data, AgendaEntity agenda);
	
	/*@Modifying
    @Transactional
    @Query("UPDATE Evento e SET e.dataEvento = CONCAT(YEAR(CURRENT_DATE), '-', FUNCTION('MONTH', e.dataEvento), '-', FUNCTION('DAY', e.dataEvento))")
    void atualizarAnoDatas();*/

}
