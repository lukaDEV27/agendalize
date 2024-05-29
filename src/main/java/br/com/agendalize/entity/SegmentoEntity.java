package br.com.agendalize.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "segmento", schema = "agendalize")
public class SegmentoEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_segmento")
	private Long idSegmento;
	
	@Column(name = "descricao_segmento")
	private String descricaoSegmento;
	
	/*@ManyToMany(mappedBy = "segmentos")
    private List<AgendaEntity> agendas;*/

	public Long getIdSegmento() {
		return idSegmento;
	}

	public void setIdSegmento(Long idSegmento) {
		this.idSegmento = idSegmento;
	}

	public String getDescricaoSegmento() {
		return descricaoSegmento;
	}

	public void setDescricaoSegmento(String descricaoSegmento) {
		this.descricaoSegmento = descricaoSegmento;
	}

	/*public List<AgendaEntity> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<AgendaEntity> agendas) {
		this.agendas = agendas;
	}*/

}
