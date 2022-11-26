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
	@Autowired																//Inyeccion del servicios Cliente
	private ClienteService clienteService;

	@GetMapping																//Metodo get
	public ModelAndView clientes() {										//Representa un modelo y una vista devueltos por un controlador, para ser resueltos por un DispatcherServlet.
		ModelAndView modelAndView = new ModelAndView("clientes");			//Crea un objeto de tipo ModelAndView de nombre clientes
		modelAndView.addObject("cliente", new Cliente());					// y le añade un objeto de tipo Cliente con el nombre "cliente"	
		return modelAndView;
	}

	@PostMapping("/agregar")												//Agrega el metodo Post en la página agregar de ClienteController
	public RedirectView agregar(@ModelAttribute Cliente cliente) {
		ClienteDTO respuestaServicio = clienteService.add(cliente);			//Agrega un cliente a traves del servicio al DTO de la respuesta del cliente
		if (respuestaServicio.getCodigo().equals("0")) {					//Si la respuesta del servicio es distinta de 0 retorna una vista que recarga la URL de clientes, en caso contrario devuelve la URL de "Home" 			
			return new RedirectView("/home");
		} else {
			return new RedirectView("/clientes");
		}
	}
}