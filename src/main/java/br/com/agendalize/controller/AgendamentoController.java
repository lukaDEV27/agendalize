package br.com.agendalize.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.agendalize.entity.AgendamentoEntity;
import br.com.agendalize.entity.ClienteEntity;
import br.com.agendalize.entity.EmpresaEntity;
import br.com.agendalize.entity.SemanaEntity;
import br.com.agendalize.entity.StatusAgendamentoEntity;
import br.com.agendalize.entity.UsuarioEntity;
import br.com.agendalize.service.AgendaService;
import br.com.agendalize.service.AgendamentoService;
import br.com.agendalize.service.ClienteService;
import br.com.agendalize.service.EmpresaService;
import br.com.agendalize.service.StatusAgendamentoService;
import br.com.agendalize.service.UsuarioService;
import jakarta.servlet.http.HttpSession;

@Controller
public class AgendamentoController {
	
	@Autowired
	private EmpresaService empresaService;

	@Autowired
	private AgendaService agendaService;

	@Autowired
	private UsuarioService usuarioService;

	private String loginUsuarioLogado;
	
	@Autowired
	private AgendamentoService agendamentoService;
	
	@Autowired
	private StatusAgendamentoService statusAgendamentoService;
	
	@Autowired
	private ClienteService clienteService;
	
	// CRUD - Agendamento
		// Direcionando para a página agendamento
		@GetMapping("/agendamento") // nome que eu quiser colocar
		public ModelAndView agendamento(ModelMap model, HttpSession session) {

			ModelAndView mv = new ModelAndView("agendamento");
			EmpresaEntity empresa = new EmpresaEntity();
			// recupera o usuario logado na sessão
			loginUsuarioLogado = (String) session.getAttribute("loginUsuarioLogado");
			UsuarioEntity usuario = new UsuarioEntity();
			usuario = usuarioService.getOneByUsername(loginUsuarioLogado);

			empresa = empresaService.getOneByUsuarioEmpresaLogin(usuario);

			mv.addObject("empresa", empresa);

			model.addAttribute("agendas", empresa.getAgendas());
	
			return mv; // caminho real do arquivo
		}
		
		/*// Direcionando para a página de cadastro de uma agenda
		@GetMapping("/cadastro_agendamento/{idAgenda}")
		public ModelAndView cadastroAgendamento(ModelMap model, @PathVariable("idAgenda") Long idAgenda) throws Exception {

			ModelAndView mv = new ModelAndView("cadastro_agendamento");

			// AgendaEntity agenda = new AgendaEntity();
			
			

			model.addAttribute("idAgenda", idAgenda);
			model.addAttribute("agendas", agendaService.getOneByIdAgenda(idAgenda));

			// agenda = agendaService.getOneByIdAgenda(idAgenda);
			// model.addAttribute(agenda.getDiasDaSemana());

			return mv;

		}

		@PostMapping("/configurar_semana")
		public ModelAndView save(ModelMap model, @ModelAttribute("semanaEntity") SemanaEntity semanaEntity,
				@ModelAttribute("idAgenda") Long idAgenda, RedirectAttributes atributes) throws Exception {

			semanaEntity.setAgenda(agendaService.getOneByIdAgenda(idAgenda));

			model.addAttribute("agenda", agendaService.getOneByIdAgenda(idAgenda));

			ModelAndView mv = new ModelAndView("redirect:/configurar_semana/" + idAgenda);

			atributes.addFlashAttribute("mensagem", semanaService.save(semanaEntity));
			return mv;

		}*/

}
