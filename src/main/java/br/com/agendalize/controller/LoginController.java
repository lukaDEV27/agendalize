package br.com.agendalize.controller;

import java.time.LocalDate;
import java.util.Locale;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
		
	@GetMapping("/") //nome que eu quiser colocar 
	public ModelAndView principal(HttpSession session)
	{
		ModelAndView mv = new ModelAndView("principal");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String login = auth.getName(); //recupera o login do usuario logado     
        
        session.setAttribute("loginUsuarioLogado", login); //inclui na sessção o login do usuário
        
        System.out.println("Usuário logado" + login);
        mv.addObject("login", login);

		
		return mv;  //caminho real do arquivo
	}
		@GetMapping("/principal") //nome que eu quiser colocar 
		public ModelAndView home(HttpSession session)
		{
			ModelAndView mv = new ModelAndView("principal");
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        String login = auth.getName(); //recupera o login do usuario logado     
	        
	        session.setAttribute("loginUsuarioLogado", login); //inclui na sessção o login do usuário
	        
	        System.out.println("Usuário logado" + login);
	        mv.addObject("login", login);
	        Locale.setDefault(Locale.of("pt", "br"));
	        LocalDate day = LocalDate.parse("2024-05-29");
	        System.out.println("Dia da semana: " + day.getDayOfWeek());

			
			return mv;  //caminho real do arquivo
		}
		
		@GetMapping("/login") //nome que eu quiser colocar 
		public String login()
		{
			return "login"; //caminho real do arquivo
		}
		
		@GetMapping("/sobreNos") //nome que eu quiser colocar
		public String sobreNos(ModelMap model)
		{
			
			return "sobreNos"; //caminho real do arquivo
		}
		
		

		

	}

