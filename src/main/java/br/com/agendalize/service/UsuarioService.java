package br.com.agendalize.service;

import java.util.List;

import br.com.agendalize.entity.UsuarioEntity;

public interface UsuarioService {
	
	UsuarioEntity getOneByUsername(String username);
	String save(UsuarioEntity usuarioEntity) throws Exception;
	List<UsuarioEntity> findAll();
	String deleteById(Long idUsuario) throws Exception;

	
}
