package cl.infoclub.fsj.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.infoclub.fsj.dto.PeliculaDTO;
import cl.infoclub.fsj.modelo.Pelicula;
import cl.infoclub.fsj.repositorio.PeliculaRepository;
import cl.infoclub.fsj.service.PeliculaService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService {
	private static final Logger log = LoggerFactory.getLogger(PeliculaServiceImpl.class);
	@Autowired
	private PeliculaRepository dao;
	private PeliculaDTO respuesta;

	@Override
	@Transactional(readOnly = true)
	public PeliculaDTO findAll() {
		respuesta = new PeliculaDTO(new ArrayList<Pelicula>(), "Ha ocurrido un error", "102");
		try {
			respuesta.setPeliculas((List<Pelicula>) dao.findAll());
			respuesta.setMensaje(String.format("Se ha/n encontrado %d registro/s", respuesta.getPeliculas().size()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Pelicula Service: Error en findAll", e);
		}
		return respuesta;
	}

	@Override
	@Transactional
	public PeliculaDTO add(Pelicula pelicula) {
		respuesta = new PeliculaDTO(new ArrayList<Pelicula>(), "Ha ocurrido un error", "104");
		try {
			dao.save(pelicula);
			respuesta.setMensaje(String.format("Se ha guardado correctamente la pelicula %s", pelicula.getTitulo()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Pelicula Service: Error en add", e);
		}
		return respuesta;
	}
}
