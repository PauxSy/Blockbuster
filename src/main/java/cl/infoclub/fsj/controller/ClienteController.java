package cl.infoclub.fsj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import cl.infoclub.fsj.dto.ClienteDTO;
import cl.infoclub.fsj.modelo.Cliente;
import cl.infoclub.fsj.service.ClienteService;

@Controller
@RequestMapping("clientes")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ModelAndView clientes() {
		ModelAndView modelAndView = new ModelAndView("clientes");
		modelAndView.addObject("cliente", new Cliente());
		return modelAndView;
	}

	@PostMapping("/agregar")
	public RedirectView agregar(@ModelAttribute Cliente cliente) {
		ClienteDTO respuestaServicio = clienteService.add(cliente);
		if (respuestaServicio.getCodigo().equals("0")) {
			return new RedirectView("/home");
		} else {
			return new RedirectView("/clientes");
		}
	}
}