package cl.infoclub.fsj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.infoclub.fsj.service.ArriendoService;

@Controller
public class HomeController {
	@Autowired
	private ArriendoService arriendoService;

	@GetMapping({ "/", "home" })															//Metodo get que abarca tanto la entrada nula como la entrada "home"
	public ModelAndView clientes() {														//Representa un modelo y una vista devueltos por un controlador, para ser resueltos por un DispatcherServlet.
		ModelAndView modelAndView = new ModelAndView("home");								//Crea un objeto de tipo ModelAndView de nombre "home"
		modelAndView.addObject("arriendos", arriendoService.findAll().getArriendos());		// y le añade todos los registros de tipo arriendo, con el nombre "arriendos"
		return modelAndView;
	}
}