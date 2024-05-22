package br.com.agendalize.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig {

	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(auth -> auth
				// Qualquer tipo de permissão consegue acessar esse @controller
				.requestMatchers("/").permitAll()
				.requestMatchers("/principal").permitAll()
				.requestMatchers("/cadastroUsuario").permitAll()
				.requestMatchers("/sobreNos").permitAll()
				.requestMatchers("/login").permitAll()
				.requestMatchers("/empresa").hasAnyAuthority("admin", "empresa")
				
				
				// Quem possuir algum dos dois perfis pode acessar o @controller
				// Qualquer requisição ao @controller o usuário precisa estar autenticado
				.anyRequest().authenticated())

				
				
				.formLogin(formLogin -> formLogin
				// Direciona para esse @controller quando o login está correto
				.defaultSuccessUrl("/principal", true).permitAll()
				.loginPage("/login"))
				
				//.rememberMe(rememberMe -> rememberMe.key("AbcdEfghIjkl..."))
				.logout(logout -> logout.logoutUrl("/sair").permitAll());
		return http.build();

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// Serve d exemplo para gerar uma senha criptografada
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		System.out.println(b.encode("admin"));
		// Criptografa a sebhga oara salvar no banco de dados
		auth.userDetailsService(userDetailServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
	}

}
