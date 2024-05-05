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

import br.com.agendalize.entity.ClienteEntity;
import br.com.agendalize.service.ClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	
	@GetMapping("/cliente") //nome que eu quiser colocar
	public String cliente(ModelMap model)
	{
		
		return "cliente"; //caminho real do arquivo
	}


	@PostMapping("/salvar_cliente")
	public ModelAndView save(
			ModelMap model,
			@ModelAttribute("clienteEntity") ClienteEntity clienteEntity,
			RedirectAttributes attibutes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/empresa");
		attibutes.addFlashAttribute("mensagem", clienteService.save(clienteEntity));
		return mv;
	}
	
	@GetMapping("/alterar_cliente/{idCliente}")
	public ModelAndView update(ModelMap model,@PathVariable("idCliente") String idCliente) throws Exception 
	{
		
		ModelAndView mv = new ModelAndView("alterar_cliente");
		model.addAttribute("idCliente", idCliente);
		model.addAttribute("cliente", clienteService.getOneByIdCliente(idCliente));
		
		return mv;
	}
	
	@PostMapping("/alterar_cliente")
	public ModelAndView update(
			ModelMap model,
			@ModelAttribute("clienteEntity") ClienteEntity clienteEntity,
			RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/cliente");
		atributes.addFlashAttribute("mensagem", clienteService.save(clienteEntity));
		
		return mv;
	}
	
	@GetMapping("/excluir_cliente/{idCliente}")
	public ModelAndView delete(ModelMap model, @PathVariable("idCliente") String idCliente, RedirectAttributes atributes) throws Exception 
	{
		ModelAndView mv = new ModelAndView("redirect:/cliente");
		model.addAttribute("mensagem", clienteService.deleteById(idCliente));
		//após a exclusão de um docente eu preciso atualizar a listagem na página
		//por isso realizo uma nova consulta findall
		//model.addAttribute("empresas", empresaService.findAll());
		//Comentei a parte da listagem pois os clientes não serão listadas após a exclusão dele.
		return mv;
		//termina a exclusão
	}
	
	
	
}
