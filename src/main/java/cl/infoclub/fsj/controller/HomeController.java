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

	@GetMapping({ "/", "home" })
	public ModelAndView clientes() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("arriendos", arriendoService.findAll().getArriendos());
		return modelAndView;
	}
}