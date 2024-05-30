package br.com.agendalize.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.agendalize.entity.AgendaEntity;
import br.com.agendalize.entity.EmpresaEntity;
import br.com.agendalize.entity.UsuarioEntity;
import br.com.agendalize.service.AgendaService;
import br.com.agendalize.service.EmpresaService;
import br.com.agendalize.service.UsuarioService;
import jakarta.servlet.http.HttpSession;

@Controller
public class AgendaController {

	@Autowired
	private EmpresaService empresaService;

	@Autowired
	private AgendaService agendaService;
	
	@Autowired
	private UsuarioService usuarioService;

	private String loginUsuarioLogado;

	// CRUD - Agenda
	// Direcionando para a página agenda
	@GetMapping("/agenda") // nome que eu quiser colocar
	public ModelAndView agenda(ModelMap model, HttpSession session) {
		
		
		ModelAndView mv = new ModelAndView("agenda");
		EmpresaEntity empresa = new EmpresaEntity();
		//recupera o usuario logado na sessão
        loginUsuarioLogado = (String)session.getAttribute("loginUsuarioLogado");
        UsuarioEntity usuario = new UsuarioEntity();
        usuario = usuarioService.getOneByUsername(loginUsuarioLogado);
		
         empresa = empresaService.getOneByUsuarioEmpresaLogin(usuario);
		System.out.println("Empresa do Usuário logado " + empresa.getAgendas());
		
		mv.addObject("empresa", empresa);
		
		//AgendaEntity agenda = new AgendaEntity();
		//agenda = agendaService.findAllByEmpresa(empresa);

		model.addAttribute("agendas", empresa.getAgendas());
		return mv; // caminho real do arquivo
	}

	// Direcionando para a página de cadastro de uma agenda
	@GetMapping("/cadastroAgenda") 
	public ModelAndView cadastroAgenda(ModelMap model,HttpSession session) throws Exception
	{
	
		ModelAndView mv = new ModelAndView("cadastroAgenda");
		EmpresaEntity empresa = new EmpresaEntity();
		//recupera o usuario logado na sessão
        loginUsuarioLogado = (String)session.getAttribute("loginUsuarioLogado");
        UsuarioEntity usuario = new UsuarioEntity();
        usuario = usuarioService.getOneByUsername(loginUsuarioLogado);
		
        empresa = empresaService.getOneByUsuarioEmpresaLogin(usuario);
		System.out.println("Usuário logado " + empresa.getIdEmpresa());
		
		mv.addObject("empresa", empresa);

		
		return mv; 
	}
	
	@PostMapping("/salvar_agenda")
	public ModelAndView save(ModelMap model, @ModelAttribute("agendaEntity") AgendaEntity agendaEntity,
			RedirectAttributes atributes) throws Exception {
		
		
		ModelAndView mv = new ModelAndView("redirect:/agenda");
		atributes.addFlashAttribute("mensagem", agendaService.save(agendaEntity));
		return mv;

	}

}
