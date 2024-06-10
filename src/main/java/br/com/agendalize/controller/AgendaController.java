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

import br.com.agendalize.entity.AgendaEntity;
import br.com.agendalize.entity.DataIndisponivelEntity;
import br.com.agendalize.entity.EmpresaEntity;
import br.com.agendalize.entity.SemanaEntity;
import br.com.agendalize.entity.UsuarioEntity;
import br.com.agendalize.service.AgendaService;
import br.com.agendalize.service.DataIndisponivelService;
import br.com.agendalize.service.EmpresaService;
import br.com.agendalize.service.SemanaService;
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

	@Autowired
	private DataIndisponivelService dataIndisponivelService;

	@Autowired
	private SemanaService semanaService;

	private String loginUsuarioLogado;

	// CRUD - Agenda
	// Direcionando para a página agenda
	@GetMapping("/agenda") // nome que eu quiser colocar
	public ModelAndView agenda(ModelMap model, HttpSession session) {

		ModelAndView mv = new ModelAndView("agenda");
		EmpresaEntity empresa = new EmpresaEntity();
		// recupera o usuario logado na sessão
		loginUsuarioLogado = (String) session.getAttribute("loginUsuarioLogado");
		UsuarioEntity usuario = new UsuarioEntity();
		usuario = usuarioService.getOneByUsername(loginUsuarioLogado);

		empresa = empresaService.getOneByUsuarioEmpresaLogin(usuario);
		System.out.println("Agendas do Usuário logado " + empresa.getAgendas());

		mv.addObject("empresa", empresa);

		//
		// agenda = agendaService.findAllByEmpresa(empresa);

		model.addAttribute("agendas", empresa.getAgendas());
		return mv; // caminho real do arquivo
	}

	// Direcionando para a página de cadastro de uma agenda
	@GetMapping("/cadastroAgenda")
	public ModelAndView cadastroAgenda(ModelMap model, HttpSession session) throws Exception {

		ModelAndView mv = new ModelAndView("cadastroAgenda");
		EmpresaEntity empresa = new EmpresaEntity();
		// recupera o usuario logado na sessão
		loginUsuarioLogado = (String) session.getAttribute("loginUsuarioLogado");
		UsuarioEntity usuario = new UsuarioEntity();
		usuario = usuarioService.getOneByUsername(loginUsuarioLogado);

		empresa = empresaService.getOneByUsuarioEmpresaLogin(usuario);
		System.out.println("Empresa do Usuario Logado " + empresa.getIdEmpresa());

		mv.addObject("empresa", empresa);

		return mv;
	}

	// Salvando uma agenda no BD
	@PostMapping("/salvar_agenda")
	public ModelAndView save(ModelMap model, @ModelAttribute("agendaEntity") AgendaEntity agendaEntity,
			RedirectAttributes atributes) throws Exception {

		ModelAndView mv = new ModelAndView("redirect:/agenda");
		atributes.addFlashAttribute("mensagem", agendaService.save(agendaEntity));
		return mv;

	}

	@GetMapping("/alterar_agenda/{idAgenda}")
	public ModelAndView updateAgenda(ModelMap model, @PathVariable("idAgenda") Long idAgenda) throws Exception {
		ModelAndView mv = new ModelAndView("alterar_agenda");

		model.addAttribute("idAgenda", idAgenda);
		model.addAttribute("agenda", agendaService.getOneByIdAgenda(idAgenda));

		return mv;

	}

	@PostMapping("/alterar_agenda")
	public ModelAndView updateAgenda(ModelMap model, @ModelAttribute("agendaEntity") AgendaEntity agendaEntity,
			RedirectAttributes atributes) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/agenda");
		atributes.addFlashAttribute("mensagem", agendaService.save(agendaEntity));

		return mv;

	}

	// Começa Exclusão
	@GetMapping("/excluir_agenda/{idAgenda}")
	public ModelAndView deleteAgenda(ModelMap model, @PathVariable("idAgenda") Long idAgenda,
			RedirectAttributes atributes) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/agenda");

		model.addAttribute("mensagem", agendaService.deleteById(idAgenda));
		// após a exclusão de um docente eu preciso atualizar a listagem na página
		// por isso eu realizo uma nova consulta findall

		return mv;

	}
	// Termina Exclusão

	// Configurar a rotina semanal
	@GetMapping("/configurar_semana/{idAgenda}")
	public ModelAndView configurarSemana(ModelMap model, @PathVariable("idAgenda") Long idAgenda) throws Exception {

		ModelAndView mv = new ModelAndView("configurar_semana");

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

	}

	@GetMapping("/alterar_dia_da_semana/{idSemana}")
	public ModelAndView update(ModelMap model, @PathVariable("idSemana") Long idSemana) throws Exception {
		ModelAndView mv = new ModelAndView("alterar_dia_da_semana");

		model.addAttribute("idSemana", idSemana);
		model.addAttribute("semana", semanaService.getOneByIdSemana(idSemana));

		return mv;

	}

	@PostMapping("/alterar_dia_da_semana")
	public ModelAndView update(ModelMap model, @ModelAttribute("semanaEntity") SemanaEntity semanaEntity,
			@ModelAttribute("idAgenda") Long idAgenda, RedirectAttributes atributes) throws Exception {

		semanaEntity.setAgenda(agendaService.getOneByIdAgenda(idAgenda));

		model.addAttribute("agenda", agendaService.getOneByIdAgenda(idAgenda));

		ModelAndView mv = new ModelAndView("redirect:/configurar_semana/" + idAgenda);
		atributes.addFlashAttribute("mensagem", semanaService.update(semanaEntity));

		return mv;

	}

	@GetMapping("/excluir_dia_da_semana/{idSemana}")
	public ModelAndView delete(ModelMap model, @PathVariable("idSemana") Long idSemana, RedirectAttributes atributes)
			throws Exception {

		ModelAndView mv = new ModelAndView("redirect:/agenda");

		model.addAttribute("idSemana", idSemana);
		model.addAttribute("semana", semanaService.getOneByIdSemana(idSemana));

		atributes.addFlashAttribute("mensagem", semanaService.deleteById(idSemana));

		return mv;

	}

	// Configurar a Datas indisponíveis
	@GetMapping("/configurar_data_indisponivel/{idAgenda}")
	public ModelAndView configurarDataIndisponivel(ModelMap model, @PathVariable("idAgenda") Long idAgenda)
			throws Exception {

		ModelAndView mv = new ModelAndView("configurar_data_indisponivel");

		// AgendaEntity agenda = new AgendaEntity();

		model.addAttribute("idAgenda", idAgenda);
		model.addAttribute("agendas", agendaService.getOneByIdAgenda(idAgenda));

		// agenda = agendaService.getOneByIdAgenda(idAgenda);
		// model.addAttribute(agenda.getDiasDaSemana());

		return mv;
	}

	@PostMapping("/configurar_data_indisponivel")
	public ModelAndView save(ModelMap model,
			@ModelAttribute("dataIndisponivelEntity") DataIndisponivelEntity dataIndisponivelEntity,
			@ModelAttribute("idAgenda") Long idAgenda, RedirectAttributes atributes) throws Exception {

		dataIndisponivelEntity.setAgenda(agendaService.getOneByIdAgenda(idAgenda));

		model.addAttribute("agenda", agendaService.getOneByIdAgenda(idAgenda));

		ModelAndView mv = new ModelAndView("redirect:/configurar_data_indisponivel/" + idAgenda);

		atributes.addFlashAttribute("mensagem", dataIndisponivelService.save(dataIndisponivelEntity));
		return mv;
	}

	@GetMapping("/alterar_data_indisponivel/{idDataIndisponivel}")
	public ModelAndView updateDataIndisponivel(ModelMap model,
			@PathVariable("idDataIndisponivel") Long idDataIndisponivel) throws Exception {

		ModelAndView mv = new ModelAndView("alterar_data_indisponivel");

		model.addAttribute("idDataIndisponivel", idDataIndisponivel);
		model.addAttribute("dataIndisponivel", dataIndisponivelService.getOneByIdDataIndisponivel(idDataIndisponivel));

		return mv;

	}

	@PostMapping("/alterar_data_indisponivel")
	public ModelAndView updateDataIndisponivel(ModelMap model,
			@ModelAttribute("dataIndisponivelEntity") DataIndisponivelEntity dataIndisponivelEntity,
			@ModelAttribute("idAgenda") Long idAgenda, RedirectAttributes atributes) throws Exception {

		dataIndisponivelEntity.setAgenda(agendaService.getOneByIdAgenda(idAgenda));

		model.addAttribute("agenda", agendaService.getOneByIdAgenda(idAgenda));

		ModelAndView mv = new ModelAndView("redirect:/configurar_data_indisponivel/" + idAgenda);
		atributes.addFlashAttribute("mensagem", dataIndisponivelService.update(dataIndisponivelEntity));

		return mv;

	}

	@GetMapping("/excluir_data_indisponivel/{idDataInsiponivel}")
	public ModelAndView deleteDataIndisponivel(ModelMap model,
			@PathVariable("idDataInsiponivel") Long idDataInsiponivel, RedirectAttributes atributes) throws Exception {

		ModelAndView mv = new ModelAndView("redirect:/agenda");

		model.addAttribute("idDataInsiponivel", idDataInsiponivel);
		model.addAttribute("dataIndisponivel", dataIndisponivelService.getOneByIdDataIndisponivel(idDataInsiponivel));

		atributes.addFlashAttribute("mensagem", dataIndisponivelService.deleteById(idDataInsiponivel));

		return mv;

	}

}
