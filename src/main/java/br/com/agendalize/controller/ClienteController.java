package br.com.agendalize.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {
	
	@GetMapping("/cliente") //nome que eu quiser colocar
	public String cliente(ModelMap model)
	{
		
		return "cliente"; //caminho real do arquivo
	}

}
