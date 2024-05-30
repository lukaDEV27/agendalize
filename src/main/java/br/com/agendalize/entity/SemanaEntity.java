package br.com.agendalize.entity;

import java.io.Serializable;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
	private Time horaInicial;
	
	@Column(name = "hora_final")
	private Time horaFinal;
	
	@OneToOne()
    @JoinColumn(name = "agenda_semana_id", referencedColumnName = "id_agenda")
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

	public Time getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(Time horaInicial) {
		this.horaInicial = horaInicial;
	}

	public Time getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Time horaFinal) {
		this.horaFinal = horaFinal;
	}

	public AgendaEntity getAgenda() {
		return agenda;
	}

	public void setAgenda(AgendaEntity agenda) {
		this.agenda = agenda;
	}
	

}
