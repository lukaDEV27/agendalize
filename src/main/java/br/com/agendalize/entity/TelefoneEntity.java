package br.com.agendalize.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "telefone", schema = "agendalize")
public class TelefoneEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_telefone")
	private Long idTelefone;
	
	@Column(name = "opcao_1")
	private String opcao1;
	
	@Column(name = "opcao_2")
	private String opcao2;
	
	@Column(name = "opcao_3")
	private String opcao3;

}
