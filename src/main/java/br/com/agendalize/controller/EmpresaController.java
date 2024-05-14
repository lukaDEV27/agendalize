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
import br.com.agendalize.entity.EmpresaEntity;
import br.com.agendalize.service.AgendaService;
import br.com.agendalize.service.EmpresaService;

@Controller
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private AgendaService agendaService;
	
	@GetMapping("/empresa") //nome que eu quiser colocar
	public String empresa(ModelMap model)
	{
		
		return "empresa"; //caminho real do arquivo
	}
	
	@PostMapping("/salvar_empresa")
	public ModelAndView save(
			ModelMap model,
			@ModelAttribute("empresaEntity") EmpresaEntity empresaEntity,
			RedirectAttributes attibutes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/principal");
		attibutes.addFlashAttribute("mensagem", empresaService.save(empresaEntity));
		return mv;
	}
	
	@GetMapping("/alterar_empresa/{idEmpresa}")
	public ModelAndView update(ModelMap model,@PathVariable("idEmpresa") String idEmpresa) throws Exception 
	{
		
		ModelAndView mv = new ModelAndView("alterar_empresa");
		model.addAttribute("idEmpresa", idEmpresa);
		model.addAttribute("empresa", empresaService.getOneByIdEmpresa(idEmpresa));
		
		return mv;
	}
	
	@PostMapping("/alterar_empresa")
	public ModelAndView update(
			ModelMap model,
			@ModelAttribute("empresaEntity") EmpresaEntity empresaEntity,
			RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/empresa");
		atributes.addFlashAttribute("mensagem", empresaService.save(empresaEntity));
		
		return mv;
	}
	
	@GetMapping("/excluir_empresa/{idEmpresa}")
	public ModelAndView delete(ModelMap model, @PathVariable("idEmpresa") String idEmpresa, RedirectAttributes atributes) throws Exception 
	{
		ModelAndView mv = new ModelAndView("redirect:/empresa");
		model.addAttribute("mensagem", empresaService.deleteById(idEmpresa));
		//após a exclusão de um docente eu preciso atualizar a listagem na página
		//por isso realizo uma nova consulta findall
		//model.addAttribute("empresas", empresaService.findAll());
		//Comentei a parte da listagem pois as empresas não serão listadas após a exclusão de uma empresa.
		return mv;
		//termina a exclusão
	}
	
	@GetMapping("/agenda") //nome que eu quiser colocar
	public String agenda(ModelMap model)
	{
		model.addAttribute("agendas", agendaService.findAll());
		return "empresa"; //caminho real do arquivo
	}
	
	@PostMapping("/salvar_agenda")
	public ModelAndView save(
			ModelMap model,
			@ModelAttribute("agendaEntity") AgendaEntity agendaEntity,
			RedirectAttributes attibutes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/agenda");
		attibutes.addFlashAttribute("mensagem", agendaService.save(agendaEntity));
		return mv;
	}
	
	@GetMapping("/alterar_agenda/{idAgenda}")
	public ModelAndView updateAgenda(ModelMap model,@PathVariable("idAgenda") Long idAgenda) throws Exception 
	{
		
		ModelAndView mv = new ModelAndView("alterar_agenda");
		model.addAttribute("idAgenda", idAgenda);
		model.addAttribute("agenda", agendaService.getOneByIdAgenda(idAgenda));
		
		return mv;
	}
	
	@PostMapping("/alterar_agenda")
	public ModelAndView updateAgenda(
			ModelMap model,
			@ModelAttribute("agendaEntity") AgendaEntity agendaEntity,
			RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/agenda");
		atributes.addFlashAttribute("mensagem", agendaService.save(agendaEntity));
		
		return mv;
	}
	
	@GetMapping("/excluir_agenda/{idAgenda}")
	public ModelAndView deleteAgenda(ModelMap model, @PathVariable("idAgenda") Long idAgenda, RedirectAttributes atributes) throws Exception 
	{
		ModelAndView mv = new ModelAndView("redirect:/agenda");
		model.addAttribute("mensagem", agendaService.deleteById(idAgenda));
		//após a exclusão de um docente eu preciso atualizar a listagem na página
		//por isso realizo uma nova consulta findall
		model.addAttribute("agendas", agendaService.findAll());
	
		return mv;
		//termina a exclusão
	}

}
