package br.com.agendalize.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContatoController {
	
	@GetMapping("/contato") //nome que eu quiser colocar
	public String contato(ModelMap model)
	{
		
		return "contato"; //caminho real do arquivo
	}

}
