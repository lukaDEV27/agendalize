package br.com.agendalize.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario", schema = "agendalize")
public class UsuarioEntity implements Serializable,UserDetails{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;

	@Column(name = "email_usuario") 
	private String emailUsuario;
	
	@Column(name = "senha_usuario") 
	private String senhaUsuario;

	@ManyToMany
	@JoinTable(name="usuario_permissao",
    joinColumns={@JoinColumn(name="usuario_id_usuario", referencedColumnName = "id_usuario")},
    inverseJoinColumns={@JoinColumn(name="permissao_id_permissao", referencedColumnName = "id_permissao")})
	private List<PermissaoEntity> permissoes;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return (Collection<? extends GrantedAuthority>) this.permissoes;
	}

	@Override
	public String getPassword() {
		
		return this.senhaUsuario;
	}

	@Override
	public String getUsername() {
		
		return this.emailUsuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}


	public List<PermissaoEntity> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<PermissaoEntity> permissoes) {
		this.permissoes = permissoes;
	}

}
