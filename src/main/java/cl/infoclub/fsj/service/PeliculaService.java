package cl.infoclub.fsj.service;

import cl.infoclub.fsj.dto.PeliculaDTO;
import cl.infoclub.fsj.modelo.Pelicula;

public interface PeliculaService {
	PeliculaDTO findAll();
	PeliculaDTO add(Pelicula pelicula);
}