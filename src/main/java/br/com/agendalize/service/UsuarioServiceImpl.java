package br.com.agendalize.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agendalize.entity.UsuarioEntity;
import br.com.agendalize.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private String mensagem;

	@Override
	public UsuarioEntity getOneByUsername(String username) {
		
		return usuarioRepository.getOneByUsername(username);
	}

	@Override
	public String save(UsuarioEntity usuarioEntity) throws Exception {
		usuarioRepository.saveAndFlush(usuarioEntity);
		this.mensagem = "Usuario cadastrada com sucesso.";
		
		return mensagem;
	}

	@Override
	public List<UsuarioEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteById(String idUsuario) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
