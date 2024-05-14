package br.com.agendalize.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpresaController {
	
	@GetMapping("/empresa") //nome que eu quiser colocar
	public String empresa(ModelMap model)
	{
		//model.addAttribute("empresas", empresaService.findAll());
		return "empresa"; //caminho real do arquivo
	}
	
	
	
	

}
