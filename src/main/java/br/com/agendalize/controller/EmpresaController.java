package br.com.agendalize.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.agendalize.entity.EmpresaEntity;
import br.com.agendalize.entity.PermissaoEntity;
import br.com.agendalize.entity.UsuarioEntity;
import br.com.agendalize.entity.ePermissao;
import br.com.agendalize.service.EmpresaService;
import br.com.agendalize.service.UsuarioService;

@Controller
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private UsuarioService usuarioService;
	

	@GetMapping("/empresa") // nome que eu quiser colocar
	public String empresa(ModelMap model) {
		
		return "empresa"; // caminho real do arquivo
	}
//CADASTRO EMPRESA
	
	@GetMapping("/cadastroEmpresa") // nome que eu quiser colocar
	public String cadastroEmpresa(ModelMap model) {
		
		return "cadastroEmpresa"; // caminho real do arquivo
	}
	
	@PostMapping("/salvar_empresa")
	public ModelAndView save(ModelMap model, @ModelAttribute("empresaEntity") EmpresaEntity empresaEntity,
			RedirectAttributes atributes) throws Exception {
		
		
		ModelAndView mv = new ModelAndView("redirect:/empresa");
		atributes.addFlashAttribute("mensagem", empresaService.save(empresaEntity));
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
		BCryptPasswordEncoder cript = new BCryptPasswordEncoder();
		usuarioEntity.setSenhaUsuario(cript.encode(usuarioEntity.getSenhaUsuario()));
		atributes.addFlashAttribute("mensagem", usuarioService.save(usuarioEntity));
		
		
		
		return mv;

	}

}
