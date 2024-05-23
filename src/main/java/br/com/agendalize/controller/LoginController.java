package br.com.agendalize.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
		
		@GetMapping("/") //nome que eu quiser colocar 
		public String principal()
		{
			return "principal"; //caminho real do arquivo
		}
		@GetMapping("/principal") //nome que eu quiser colocar 
		public String home(HttpSession session)
		{
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        String login = auth.getName(); //recupera o login do usuario logado     
	        
	        session.setAttribute("loginUsuarioLogado", login); //inclui na sessção o login do usuário
	        
	        System.out.println("Usuário logado" + login);
			return "principal"; //caminho real do arquivo
		}
		
		@GetMapping("/login") //nome que eu quiser colocar 
		public String login()
		{
			return "login"; //caminho real do arquivo
		}

	}

