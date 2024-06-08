package br.com.agendalize.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "semana", schema = "agendalize")
public class SemanaEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_semana")
	private Long idSemana;
	
	@Column(name = "nome_dia")
	private String nomeDia;
	
	@Column(name = "hora_inicial")
	private String horaInicial;
	
	@Column(name = "hora_final")
	private String horaFinal;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agenda_semana_id")
    private AgendaEntity agenda;

	public Long getIdSemana() {
		return idSemana;
	}

	public void setIdSemana(Long idSemana) {
		this.idSemana = idSemana;
	}

	public String getNomeDia() {
		return nomeDia;
	}

	public void setNomeDia(String nomeDia) {
		this.nomeDia = nomeDia;
	}

	public String getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	public AgendaEntity getAgenda() {
		return agenda;
	}

	public void setAgenda(AgendaEntity agenda) {
		this.agenda = agenda;
	}
	

}
