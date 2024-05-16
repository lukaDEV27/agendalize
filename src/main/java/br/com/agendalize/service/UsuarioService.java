package br.com.agendalize.service;

import java.util.List;

import br.com.agendalize.entity.UsuarioEntity;

public interface UsuarioService {
	
	UsuarioEntity getOneByIdEmpresa(String idUsuario);
	String save(UsuarioEntity usuarioEntity) throws Exception;
	List<UsuarioEntity> findAll();
	String deleteById(String idUsuario) throws Exception;

	
}
