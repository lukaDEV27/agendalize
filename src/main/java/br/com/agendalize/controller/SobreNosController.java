package br.com.agendalize.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SobreNosController {
	
	@GetMapping("/sobreNos") //nome que eu quiser colocar
	public String sobreNos(ModelMap model)
	{
		
		return "sobreNos"; //caminho real do arquivo
	}

}
