package br.com.agendalize.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "agendamento", schema = "agendalize")
public class AgendamentoEntity implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_agendamento")
	private Long idAgendamento;
	
	@Column(name = "data_agendamento")
	private Date dataAgendamento;
	
	@Column(name = "hora_inicio_agendamento")
	private String horaInicioAgendamento;
	
	@Column(name = "hora_final_agendamento")
	private String horaFinalAgendamento;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agenda_agendamento_id")
    private AgendaEntity agenda;
	
	@OneToOne()
    @JoinColumn(name = "cliente_id", referencedColumnName = "id_cliente")
    private ClienteEntity cliente;
	
	@OneToOne()
    @JoinColumn(name = "status_agendamento_id", referencedColumnName = "id_status_agendamento")
    private StatusAgendamentoEntity statusAgendamento;

	public Long getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(Long idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public String getHoraInicioAgendamento() {
		return horaInicioAgendamento;
	}

	public void setHoraInicioAgendamento(String horaInicioAgendamento) {
		this.horaInicioAgendamento = horaInicioAgendamento;
	}

	public String getHoraFinalAgendamento() {
		return horaFinalAgendamento;
	}

	public void setHoraFinalAgendamento(String horaFinalAgendamento) {
		this.horaFinalAgendamento = horaFinalAgendamento;
	}

	public AgendaEntity getAgenda() {
		return agenda;
	}

	public void setAgenda(AgendaEntity agenda) {
		this.agenda = agenda;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public StatusAgendamentoEntity getStatusAgendamento() {
		return statusAgendamento;
	}

	public void setStatusAgendamento(StatusAgendamentoEntity statusAgendamento) {
		this.statusAgendamento = statusAgendamento;
	}

}
