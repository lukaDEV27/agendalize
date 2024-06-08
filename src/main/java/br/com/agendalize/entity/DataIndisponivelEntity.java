package br.com.agendalize.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

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
@Table(name = "data_indisponivel", schema = "agendalize")
public class DataIndisponivelEntity implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_data_indisponivel")
	private Long idDataIndisponivel;
	
	@Column(name = "data")
	private Date data;
	
	@Column(name = "descricao")
	private String descricao;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agenda_ind_id")
    private AgendaEntity agenda;

	@Override
	public int hashCode() {
		return Objects.hash(idDataIndisponivel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataIndisponivelEntity other = (DataIndisponivelEntity) obj;
		return Objects.equals(idDataIndisponivel, other.idDataIndisponivel);
	}

	public Long getIdDataIndisponivel() {
		return idDataIndisponivel;
	}

	public void setIdDataIndisponivel(Long idDataIndisponivel) {
		this.idDataIndisponivel = idDataIndisponivel;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public AgendaEntity getAgenda() {
		return agenda;
	}

	public void setAgenda(AgendaEntity agenda) {
		this.agenda = agenda;
	}

}
