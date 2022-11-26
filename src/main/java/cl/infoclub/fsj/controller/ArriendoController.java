package cl.infoclub.fsj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cl.infoclub.fsj.dto.ArriendoDTO;
import cl.infoclub.fsj.modelo.Arriendo;
import cl.infoclub.fsj.service.ArriendoService;
import cl.infoclub.fsj.service.ClienteService;
import cl.infoclub.fsj.service.PeliculaService;

@Controller
@RequestMapping("arriendos")
public class ArriendoController {
	private static final Logger log = LoggerFactory.getLogger(ArriendoController.class);			//Obtiene el logger
	@Autowired																						//Inyeccion de los servicios del proyecto
	private ArriendoService arriendoService;
	@Autowired
	private PeliculaService peliculaService;
	@Autowired
	private ClienteService clienteService;

	@GetMapping																						//Metodo get
	public ModelAndView arriendos(Model model) {													//Representa un modelo y una vista devueltos por un controlador, para ser resueltos por un DispatcherServlet.
		ModelAndView modelAndView = new ModelAndView("arriendos");									//Crea un objeto de tipo ModelAndView de nombre arriendos
		modelAndView.addObject("arriendo", new Arriendo());											// y le añade un objeto de tipo Arriendo con el nombre arriendo	
		model.addAttribute("peliculas", peliculaService.findAll().getPeliculas());					//Se añaden todos los registros de Pelicula y Cliente al model
		model.addAttribute("clientes", clienteService.findAll().getClientes());						
		return modelAndView;																		
	}

	@PostMapping("/agregar")																		//Agrega el metodo Post en la página agregar de ArriendoController
	public RedirectView agregar(@ModelAttribute Arriendo arriendo) {								
		ArriendoDTO respuestaServicio = arriendoService.add(arriendo);
		if (respuestaServicio.getCodigo().equals("0")) {											//Si la respuesta del servicio es distinta de 0 retorna una vista que recarga la URL de arriendos, en caso contrario devuelve la URL de "Home" 			
			return new RedirectView("/home");
		} else {
			return new RedirectView("/arriendos");
		}
	}
}