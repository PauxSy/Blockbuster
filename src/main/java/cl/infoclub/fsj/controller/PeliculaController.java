package cl.infoclub.fsj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import cl.infoclub.fsj.dto.PeliculaDTO;
import cl.infoclub.fsj.modelo.Pelicula;
import cl.infoclub.fsj.service.PeliculaService;

@Controller
@RequestMapping("peliculas")
public class PeliculaController {
	@Autowired																		//Inyeccion del servicio Pelicula
	private PeliculaService peliculaService;

	@GetMapping																		//Metodo get
	public ModelAndView peliculas() {												//Representa un modelo y una vista devueltos por un controlador, para ser resueltos por un DispatcherServlet.
		ModelAndView modelAndView = new ModelAndView("peliculas");					//Crea un objeto de tipo ModelAndView de nombre "peliculas"
		modelAndView.addObject("pelicula", new Pelicula());							// y le añade un objeto de tipo Pelicula con el nombre "pelicula"
		return modelAndView;
	}

	@PostMapping("/agregar")														//Agrega el metodo Post en la página agregar de PeliculaController
	public RedirectView agregar(@ModelAttribute Pelicula pelicula) {
		PeliculaDTO respuestaServicio = peliculaService.add(pelicula);				//Agrega una pelicula a traves del servicio al DTO de la respuesta de la pelicula
		if (respuestaServicio.getCodigo().equals("0")) {							//Si la respuesta del servicio es distinta de 0 retorna una vista que recarga la URL de peliculas, en caso contrario devuelve la URL de "Home"
			return new RedirectView("/home");
		} else {
			return new RedirectView("/peliculas");
		}
	}
}
