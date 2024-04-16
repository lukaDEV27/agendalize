package br.com.agendalize.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresa", schema = "agendalize")
public class EmpresaEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cnpj_empresa")
	private Long cnpjEmpresa;
	
	@Column(name = "nome_empresa")
	private String nomeEmpresa;
	
	@Column(name = "email_contato_empresa")
	private String emailContatoEmpresa;
	
	@Column(name = "descricao")
	private String descricaoEmpresa;
	
	@OneToOne()
    @JoinColumn(name = "telefone_empresa_id", referencedColumnName = "id_telefone")
    private TelefoneEntity telefone;
	
	@OneToOne()
    @JoinColumn(name = "endereco_empresa_id", referencedColumnName = "id_endereco")
    private EnderecoEntity endereco;
	
	@OneToOne()
    @JoinColumn(name = "usuario_empresa_id", referencedColumnName = "id_usuario")
    private UsuarioEntity usuarioLogin;
	

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

	public EnderecoEntity getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoEntity endereco) {
		this.endereco = endereco;
	}

	public Long getCnpjEmpresa() {
		return cnpjEmpresa;
	}

	public void setCnpjEmpresa(Long cnpjEmpresa) {
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

}
