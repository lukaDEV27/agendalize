package br.com.agendalize.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.agendalize.entity.AgendaEntity;
import br.com.agendalize.entity.AgendamentoEntity;
import br.com.agendalize.entity.EmpresaEntity;
import br.com.agendalize.entity.PermissaoEntity;
import br.com.agendalize.entity.UsuarioEntity;
import br.com.agendalize.entity.ePermissao;
import br.com.agendalize.service.EmpresaService;
import br.com.agendalize.service.UsuarioService;
import jakarta.servlet.http.HttpSession;

@Controller
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private UsuarioService usuarioService;

	private String loginUsuarioLogado;
	
	//PÁGINA PRINCIPAL DE EMPRESA
	@GetMapping("/empresa") 
	public ModelAndView empresa(ModelMap model,HttpSession session) throws Exception
	{
	
		ModelAndView mv = new ModelAndView("empresa");
		EmpresaEntity empresa = new EmpresaEntity();
		//recupera o usuario logado na sessão
        loginUsuarioLogado = (String)session.getAttribute("loginUsuarioLogado");
        UsuarioEntity usuario = new UsuarioEntity();
        usuario = usuarioService.getOneByUsername(loginUsuarioLogado);
		//empresa = empresaService.getOneByIdEmpresa(1L);
		empresa = empresaService.getOneByUsuarioEmpresaLogin(usuario);
		//System.out.println("Usuário logado " + empresa.getIdEmpresa());
		mv.addObject("empresa", empresa);
		
		
		model.addAttribute("agendas", empresa.getAgendas());

		
		return mv; 
	}
//CADASTRO EMPRESA
	
	@GetMapping("/cadastroEmpresa") 
	public ModelAndView cadastroEmpresa(ModelMap model,HttpSession session) throws Exception
	{
	
		ModelAndView mv = new ModelAndView("cadastroEmpresa");
		EmpresaEntity empresa = new EmpresaEntity();
		//recupera o usuario logado na sessão
        loginUsuarioLogado = (String)session.getAttribute("loginUsuarioLogado");
        UsuarioEntity usuario = new UsuarioEntity();
        usuario = usuarioService.getOneByUsername(loginUsuarioLogado);
		
		empresa.setUsuarioEmpresaLogin(usuario);
		System.out.println("Usuário logado" + empresa.getUsuarioEmpresaLogin().getIdUsuario());
		
		mv.addObject("empresa", empresa);

		
		return mv; 
	}
	
	@PostMapping("/salvar_empresa")
	public ModelAndView save(ModelMap model, @ModelAttribute("empresaEntity") EmpresaEntity empresaEntity,
			RedirectAttributes atributes) throws Exception {
		
		
		ModelAndView mv = new ModelAndView("redirect:/empresa");
		atributes.addFlashAttribute("mensagem", empresaService.save(empresaEntity));
		return mv;

	}
	
	//PÁGINA DE CONFIGURAÇÕES DA EMPRESA
	@GetMapping("/configuracoes") 
	public ModelAndView configuracoes(ModelMap model,HttpSession session) throws Exception
	{
	
		ModelAndView mv = new ModelAndView("empresa");
		EmpresaEntity empresa = new EmpresaEntity();
		//recupera o usuario logado na sessão
        loginUsuarioLogado = (String)session.getAttribute("loginUsuarioLogado");
        UsuarioEntity usuario = new UsuarioEntity();
        usuario = usuarioService.getOneByUsername(loginUsuarioLogado);
		//empresa = empresaService.getOneByIdEmpresa(1L);
		empresa = empresaService.getOneByUsuarioEmpresaLogin(usuario);
		//System.out.println("Usuário logado " + empresa.getIdEmpresa());
		mv.addObject("empresa", empresa);

		
		return mv; 
	}
	
	
	//ALTERAR EMPRESA
	
	@GetMapping("/alterar_empresa") // nome que eu quiser colocar
	public ModelAndView agenda(ModelMap model, HttpSession session) {

		ModelAndView mv = new ModelAndView("alterar_empresa");
		EmpresaEntity empresa = new EmpresaEntity();
		// recupera o usuario logado na sessão
		loginUsuarioLogado = (String) session.getAttribute("loginUsuarioLogado");
		UsuarioEntity usuario = new UsuarioEntity();
		usuario = usuarioService.getOneByUsername(loginUsuarioLogado);

		empresa = empresaService.getOneByUsuarioEmpresaLogin(usuario);

		mv.addObject("empresa", empresa);

		return mv; // caminho real do arquivo
	}
	
	@PostMapping("/alterar_empresa")
	public ModelAndView update(ModelMap model, @ModelAttribute("empresaEntity") EmpresaEntity empresaEntity,
			RedirectAttributes atributes) throws Exception {

		ModelAndView mv = new ModelAndView("redirect:/configuracoes");
		atributes.addFlashAttribute("mensagem", empresaService.save(empresaEntity));
		return mv;

	}
	
	//EXCLUIR CONTA
	
	@GetMapping("/excluir_usuario")
	public ModelAndView deleteUsuario(ModelMap model, HttpSession session) throws Exception {
		
		ModelAndView mv = new ModelAndView("redirect:/principal");
		EmpresaEntity empresa = new EmpresaEntity();
		// recupera o usuario logado na sessão
		loginUsuarioLogado = (String) session.getAttribute("loginUsuarioLogado");
		UsuarioEntity usuario = new UsuarioEntity();
		usuario = usuarioService.getOneByUsername(loginUsuarioLogado);
		
		model.addAttribute("mensagem", usuarioService.deleteById(usuario.getIdUsuario()));
		// após a exclusão de um docente eu preciso atualizar a listagem na página
		// por isso eu realizo uma nova consulta findall

		return mv;

	}
	
	
//CADASTRO USUARIO
	
	@GetMapping("/cadastroUsuario") // nome que eu quiser colocar
	public String cadastroUsuario(ModelMap model) {
		
		return "cadastroUsuario"; // caminho real do arquivo
	}
	
	@PostMapping("/salvar_usuario")
	public ModelAndView save (ModelMap model, @ModelAttribute("usuarioEntity") UsuarioEntity usuarioEntity,
			RedirectAttributes atributes) throws Exception {
		
		
		PermissaoEntity permissao = new PermissaoEntity();
		permissao.setIdPermissao(ePermissao.EMPRESA.getValor());
		
		List<PermissaoEntity> permissoes = new ArrayList<>();
		permissoes.add(permissao);
		
		usuarioEntity.setPermissoes(permissoes);
		ModelAndView mv = new ModelAndView("redirect:/login");
		System.out.println("Entrei");
		BCryptPasswordEncoder cript = new BCryptPasswordEncoder();
		usuarioEntity.setPassword(cript.encode(usuarioEntity.getPassword()));
		atributes.addFlashAttribute("mensagem", usuarioService.save(usuarioEntity));
		
		
		
		return mv;

	}
	
	
	
	
	

}
