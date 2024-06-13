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
import br.com.agendalize.entity.StatusAgendamentoEntity;
import br.com.agendalize.entity.UsuarioEntity;
import br.com.agendalize.entity.eStatusAgendamento;
import br.com.agendalize.service.AgendamentoService;
import br.com.agendalize.service.ClienteService;
import br.com.agendalize.service.EmpresaService;
import br.com.agendalize.service.UsuarioService;
import jakarta.servlet.http.HttpSession;

@Controller
public class ClienteController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private AgendamentoService agendamentoService;
	
	private String loginUsuarioLogado;
	
	//Página onde gerencia os clientes
	@GetMapping("/cliente") // nome que eu quiser colocar
	public ModelAndView cliente(ModelMap model, HttpSession session) {

		ModelAndView mv = new ModelAndView("cliente");
		EmpresaEntity empresa = new EmpresaEntity();
		// recupera o usuario logado na sessão
		loginUsuarioLogado = (String) session.getAttribute("loginUsuarioLogado");
		UsuarioEntity usuario = new UsuarioEntity();
		usuario = usuarioService.getOneByUsername(loginUsuarioLogado);

		empresa = empresaService.getOneByUsuarioEmpresaLogin(usuario);
		System.out.println("Clientes do Usuário logado " + empresa.getClientes());

		mv.addObject("empresa", empresa);

		model.addAttribute("clientes", empresa.getClientes());
		return mv; // caminho real do arquivo
	}
	
	//CRUD - Cliente
	//Botão para cadastro de clientes
	@GetMapping("/cadastro_cliente")
	public ModelAndView cadastroCliente(ModelMap model, HttpSession session) throws Exception {

		ModelAndView mv = new ModelAndView("cadastro_cliente");
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
	
	@PostMapping("/salvar_cliente")
	public ModelAndView save(ModelMap model, 
			@ModelAttribute("clienteEntity") ClienteEntity clienteEntity,
			RedirectAttributes atributes) throws Exception {

		ModelAndView mv = new ModelAndView("redirect:/cliente");
		atributes.addFlashAttribute("mensagem", clienteService.save(clienteEntity));
		return mv;

	}
	
	@GetMapping("/alterar_cliente/{idCliente}")
	public ModelAndView updateCliente(ModelMap model, @PathVariable("idCliente") Long idCliente) throws Exception {
		ModelAndView mv = new ModelAndView("alterar_cliente");

		model.addAttribute("idCliente", idCliente);
		model.addAttribute("cliente", clienteService.getOneByIdCliente(idCliente));

		return mv;

	}

	@PostMapping("/alterar_cliente")
	public ModelAndView updateCliente(ModelMap model, @ModelAttribute("clienteEntity") ClienteEntity clienteEntity,
			RedirectAttributes atributes) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/cliente");
		atributes.addFlashAttribute("mensagem", clienteService.save(clienteEntity));

		return mv;

	}
	
	@GetMapping("/excluir_cliente/{idCliente}")
	public ModelAndView deleteCliente(ModelMap model, @PathVariable("idCliente") Long idCliente,
			RedirectAttributes atributes) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/cliente");

		model.addAttribute("mensagem", clienteService.deleteById(idCliente));
		// após a exclusão de um docente eu preciso atualizar a listagem na página
		// por isso eu realizo uma nova consulta findall

		return mv;

	}
	
	//BOTÃO DO AGENDAMENTO
	@GetMapping("/cadastro_agendamento/{idCliente}")
	public ModelAndView configurarSemana(ModelMap model, HttpSession session, @PathVariable("idCliente") Long idCliente) throws Exception {

		ModelAndView mv = new ModelAndView("cadastro_agendamento");
		
		EmpresaEntity empresa = new EmpresaEntity();
		// recupera o usuario logado na sessão
		loginUsuarioLogado = (String) session.getAttribute("loginUsuarioLogado");
		UsuarioEntity usuario = new UsuarioEntity();
		usuario = usuarioService.getOneByUsername(loginUsuarioLogado);

		empresa = empresaService.getOneByUsuarioEmpresaLogin(usuario);
		System.out.println("Agendas do Usuário logado " + empresa.getAgendas());

		mv.addObject("empresa", empresa);

		model.addAttribute("agendas", empresa.getAgendas());


		model.addAttribute("idCliente", idCliente);
		model.addAttribute("cliente", clienteService.getOneByIdCliente(idCliente));


		return mv;

	}
	
	@PostMapping("/cadastro_agendamento")
	public ModelAndView updateAgenda(ModelMap model, @ModelAttribute("agendamentoEntity") AgendamentoEntity agendamentoEntity,
			RedirectAttributes atributes) throws Exception 
	{
		StatusAgendamentoEntity status = new StatusAgendamentoEntity();
		status.setIdStatusAgendamento(eStatusAgendamento.ANDAMENTO.getValor());
		
		agendamentoEntity.setStatusAgendamento(status);
		ModelAndView mv = new ModelAndView("redirect:/cliente");
		 
		atributes.addFlashAttribute("mensagem", agendamentoService.save(agendamentoEntity));

		return mv;

	}

}
