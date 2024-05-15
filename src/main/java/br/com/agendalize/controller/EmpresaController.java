package br.com.agendalize.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.agendalize.entity.EmpresaEntity;
import br.com.agendalize.service.EmpresaService;

@Controller
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	

	@GetMapping("/empresa") // nome que eu quiser colocar
	public String empresa(ModelMap model) {
		// model.addAttribute("empresas", empresaService.findAll());
		return "empresa"; // caminho real do arquivo
	}

	@PostMapping("/salvar_empresa")
	public ModelAndView save(ModelMap model, @ModelAttribute("empresaEntity") EmpresaEntity empresaEntity,
			RedirectAttributes atributes) throws Exception {

		ModelAndView mv = new ModelAndView("redirect:/empresa");
		atributes.addFlashAttribute("mensagem", empresaService.save(empresaEntity));
		return mv;

	}

}
