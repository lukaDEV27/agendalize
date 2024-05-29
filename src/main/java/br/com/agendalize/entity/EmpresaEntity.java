package br.com.agendalize.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	@Column(name = "id_empresa")
	private Long idEmpresa;
	
	@Column(name = "cnpj_empresa")
	private String cnpjEmpresa;
	
	@Column(name = "nome_empresa")
	private String nomeEmpresa;
	
	@Column(name = "email_contato_empresa")
	private String emailContatoEmpresa;
	
	@Column(name = "descricao_empresa")
	private String descricaoEmpresa;
	
	@Column(name = "endereco_empresa")
	private String enderecoEmpresa;
	
	@Column(name = "telefone_empresa")
	private String telefoneEmpresa;
	
	@Column(name = "cep_empresa")
	private String cepEmpresa;
	

	@OneToOne()
    @JoinColumn(name = "usuario_empresa_id", referencedColumnName = "id_usuario")
    private UsuarioEntity usuarioEmpresaLogin;
	
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<AgendaEntity> agendas;
	

	public String getCepEmpresa() {
		return cepEmpresa;
	}

	public void setCepEmpresa(String cepEmpresa) {
		this.cepEmpresa = cepEmpresa;
	}

	public String getTelefoneEmpresa() {
		return telefoneEmpresa;
	}

	public void setTelefoneEmpresa(String telefoneEmpresa) {
		this.telefoneEmpresa = telefoneEmpresa;
	}

	public List<AgendaEntity> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<AgendaEntity> agendas) {
		this.agendas = agendas;
	}

	public UsuarioEntity getUsuarioEmpresaLogin() {
		return usuarioEmpresaLogin;
	}

	public void setUsuarioEmpresaLogin(UsuarioEntity usuarioEmpresaLogin) {
		this.usuarioEmpresaLogin = usuarioEmpresaLogin;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getCnpjEmpresa() {
		return cnpjEmpresa;
	}

	public void setCnpjEmpresa(String cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
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
