package br.com.agendalize.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresa", schema = "agendai")
public class EmpresaEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cnpj")
	private Long cnpjEmpresa;
	
	@Column(name = "nome_empresa")
	private String nomeEmpresa;
	
	@Column(name = "email_contato_empresa")
	private String emailContatoEmpresa;
	
	@Column(name = "telefone_empresa")
	private String telefoneEmpresa;
	
	@Column(name = "endereco_empresa")
	private String enderecoEmpresa;
	
	@Column(name = "cep_empresa")
	private String cepEmpresa;
	
	@Column(name = "descricao")
	private String descricaoEmpresa;

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

	public String getTelefoneEmpresa() {
		return telefoneEmpresa;
	}

	public void setTelefoneEmpresa(String telefoneEmpresa) {
		this.telefoneEmpresa = telefoneEmpresa;
	}

	public String getEnderecoEmpresa() {
		return enderecoEmpresa;
	}

	public void setEnderecoEmpresa(String enderecoEmpresa) {
		this.enderecoEmpresa = enderecoEmpresa;
	}

	public String getCepEmpresa() {
		return cepEmpresa;
	}

	public void setCepEmpresa(String cepEmpresa) {
		this.cepEmpresa = cepEmpresa;
	}

	public String getDescricaoEmpresa() {
		return descricaoEmpresa;
	}

	public void setDescricaoEmpresa(String descricaoEmpresa) {
		this.descricaoEmpresa = descricaoEmpresa;
	}

}
