package br.com.agendalize.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "status_agendamento", schema = "agendalize")
public class StatusAgendamentoEntity implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_status_agendamento")
	private Long idStatusAgendamento;
	
	@Column(name = "descricao_status_agendamento")
	private String descricao;

	public Long getIdStatusAgendamento() {
		return idStatusAgendamento;
	}

	public void setIdStatusAgendamento(Long idStatusAgendamento) {
		this.idStatusAgendamento = idStatusAgendamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
