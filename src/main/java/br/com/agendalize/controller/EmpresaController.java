package br.com.agendalize.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.agendalize.service.EmpresaService;

@Controller
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping("/empresa") //nome que eu quiser colocar
	public String empresa(ModelMap model)
	{
	//	model.addAttribute("empresas", empresaService.findAll());
		
		return "empresa"; //caminho real do arquivo
	}

}
