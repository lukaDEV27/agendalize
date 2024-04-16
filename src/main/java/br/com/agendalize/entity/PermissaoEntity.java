package br.com.agendalize.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "permissao" , schema = "agendalize")
public class PermissaoEntity implements Serializable,GrantedAuthority{

	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_permissao")
	private Long idPermissao;
	
	@Column(name = "descricao_permissao")
	private String descricaoPermissao;
	
	@ManyToMany(mappedBy = "permissoes")
    private List<UsuarioEntity> usuarios;
	
	public Long getIdPermissao() {
		return idPermissao;
	}

	public void setIdPermissao(Long idPermissao) {
		this.idPermissao = idPermissao;
	}

	public String getDescricaoPermissao() {
		return descricaoPermissao;
	}

	public void setDescricaoPermissao(String descricaoPermissao) {
		this.descricaoPermissao = descricaoPermissao;
	}

	public List<UsuarioEntity> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String getAuthority() {
		
		return this.descricaoPermissao;
	}

}
