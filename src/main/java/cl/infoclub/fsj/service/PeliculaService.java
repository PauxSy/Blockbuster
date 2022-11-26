package cl.infoclub.fsj.service;

import cl.infoclub.fsj.dto.PeliculaDTO;
import cl.infoclub.fsj.modelo.Pelicula;

public interface PeliculaService {						//Se instancia la interfaz del Servicio de Pelicula
	PeliculaDTO findAll();								//Se buscan todas las peliculas
	PeliculaDTO add(Pelicula pelicula);					//Agrega una Pelicula
}