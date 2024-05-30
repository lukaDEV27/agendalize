package br.com.agendalize.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "agenda", schema = "agendalize")
public class AgendaEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_agenda")
	private Long idAgenda;
	
	@Column(name = "nome_agenda")
	private String nomeAgenda;
	
	@Column(name = "data_disponivel_inicial")
	private Date dataDisponivelInicial;
	
	@Column(name = "data_disponivel_final")
	private Date dataDisponivelFinal;
	
	@Column(name = "descricao_agenda")
	private String descricaoAgenda;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "empresa_agenda_id")
    private EmpresaEntity empresa;
	
	@ManyToMany
	@JoinTable(name="agenda_segmento",
    joinColumns={@JoinColumn(name="agenda_id_agenda", referencedColumnName = "id_agenda")},
    inverseJoinColumns={@JoinColumn(name="segmento_id_segmento", referencedColumnName = "id_segmento")})
	private List<SegmentoEntity> segmentos;
	
	@OneToMany(mappedBy = "agenda", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<DataIndisponivelEntity> datasIndisponiveis;

	public List<DataIndisponivelEntity> getDatasIndisponiveis() {
		return datasIndisponiveis;
	}

	public void setDatasIndisponiveis(List<DataIndisponivelEntity> datasIndisponiveis) {
		this.datasIndisponiveis = datasIndisponiveis;
	}

	public Long getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(Long idAgenda) {
		this.idAgenda = idAgenda;
	}

	public String getNomeAgenda() {
		return nomeAgenda;
	}

	public void setNomeAgenda(String nomeAgenda) {
		this.nomeAgenda = nomeAgenda;
	}

	public Date getDataDisponivelInicial() {
		return dataDisponivelInicial;
	}

	public void setDataDisponivelInicial(Date dataDisponivelInicial) {
		this.dataDisponivelInicial = dataDisponivelInicial;
	}

	public Date getDataDisponivelFinal() {
		return dataDisponivelFinal;
	}

	public void setDataDisponivelFinal(Date dataDisponivelFinal) {
		this.dataDisponivelFinal = dataDisponivelFinal;
	}

	public String getDescricaoAgenda() {
		return descricaoAgenda;
	}

	public void setDescricaoAgenda(String descricaoAgenda) {
		this.descricaoAgenda = descricaoAgenda;
	}

	public EmpresaEntity getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
	}

	public List<SegmentoEntity> getSegmentos() {
		return segmentos;
	}

	public void setSegmentos(List<SegmentoEntity> segmentos) {
		this.segmentos = segmentos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAgenda);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgendaEntity other = (AgendaEntity) obj;
		return Objects.equals(idAgenda, other.idAgenda);
	}

}
