package br.com.agendalize.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.agendalize.entity.UsuarioEntity;
import br.com.agendalize.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
		
		
		UsuarioEntity usuario = this.usuarioRepository.getOneByCpf(cpf);
		
		
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado.");
		}
		
	
		return new User(usuario.getCpf(),usuario.getPassword(),true,true,true,true,usuario.getAuthorities());
		
		
		
	}


   

}