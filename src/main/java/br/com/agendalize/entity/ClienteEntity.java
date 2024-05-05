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
@Table(name = "cliente", schema = "agendalize")
public class ClienteEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cpf_cliente")
	private String idCliente;
	
	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEmailContatoCliente() {
		return emailContatoCliente;
	}

	public void setEmailContatoCliente(String emailContatoCliente) {
		this.emailContatoCliente = emailContatoCliente;
	}

	public String getSobrenomeCliente() {
		return sobrenomeCliente;
	}

	public void setSobrenomeCliente(String sobrenomeCliente) {
		this.sobrenomeCliente = sobrenomeCliente;
	}

	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public String getCepCliente() {
		return cepCliente;
	}

	public void setCepCliente(String cepCliente) {
		this.cepCliente = cepCliente;
	}

	public TelefoneEntity getTelefone() {
		return telefone;
	}

	public void setTelefone(TelefoneEntity telefone) {
		this.telefone = telefone;
	}

	public UsuarioEntity getUsuarioLogin() {
		return usuarioLogin;
	}

	public void setUsuarioLogin(UsuarioEntity usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}

	@Column(name = "nome_cliente")
	private String nomeCliente;
	
	@Column(name = "email_contato_cliente")
	private String emailContatoCliente;
	
	@Column(name = "sobrenome_cliente")
	private String sobrenomeCliente;
	
	@Column(name = "endereco_cliente")
	private String enderecoCliente;
	
	@Column(name = "cep_cliente")
	private String cepCliente;
	
	@OneToOne()
    @JoinColumn(name = "telefone_cliente_id", referencedColumnName = "id_telefone")
    private TelefoneEntity telefone;
	
	@OneToOne()
    @JoinColumn(name = "usuario_cliente_id", referencedColumnName = "id_usuario")
    private UsuarioEntity usuarioLogin;
	
}