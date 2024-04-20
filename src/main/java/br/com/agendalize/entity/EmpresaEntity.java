package br.com.agendalize.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresa", schema = "agendalize")
public class EmpresaEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cnpj_empresa")
	private Long idEmpresa;
	
	@Column(name = "nome_empresa")
	private String nomeEmpresa;
	
	@Column(name = "email_contato_empresa")
	private String emailContatoEmpresa;
	
	@Column(name = "descricao_empresa")
	private String descricaoEmpresa;
	
	@Column(name = "endreco_empresa")
	private String enderecoEmpresa;
	
	@OneToOne()
    @JoinColumn(name = "telefone_empresa_id", referencedColumnName = "id_telefone")
    private TelefoneEntity telefone;
	
	@OneToOne()
    @JoinColumn(name = "usuario_empresa_id", referencedColumnName = "id_usuario")
    private UsuarioEntity usuarioLogin;
	
	@OneToMany(mappedBy = "empresa")
    private List<AgendaEntity> agendas;
	

	public List<AgendaEntity> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<AgendaEntity> agendas) {
		this.agendas = agendas;
	}

	public UsuarioEntity getUsuarioLogin() {
		return usuarioLogin;
	}

	public void setUsuarioLogin(UsuarioEntity usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}

	public TelefoneEntity getTelefone() {
		return telefone;
	}

	public void setTelefone(TelefoneEntity telefone) {
		this.telefone = telefone;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getEmailContatoEmpresa() {
		return emailContatoEmpresa;
	}

	public void setEmailContatoEmpresa(String emailContatoEmpresa) {
		this.emailContatoEmpresa = emailContatoEmpresa;
	}

	public String getDescricaoEmpresa() {
		return descricaoEmpresa;
	}

	public void setDescricaoEmpresa(String descricaoEmpresa) {
		this.descricaoEmpresa = descricaoEmpresa;
	}

	public String getEnderecoEmpresa() {
		return enderecoEmpresa;
	}

	public void setEnderecoEmpresa(String enderecoEmpresa) {
		this.enderecoEmpresa = enderecoEmpresa;
	}



}
