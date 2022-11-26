package cl.infoclub.fsj.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.infoclub.fsj.dto.ArriendoDTO;
import cl.infoclub.fsj.modelo.Arriendo;
import cl.infoclub.fsj.repositorio.ArriendoRepository;
import cl.infoclub.fsj.service.ArriendoService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArriendoServiceImpl implements ArriendoService {
	private static final Logger log = LoggerFactory.getLogger(ArriendoServiceImpl.class);    								//Obtiene el logger de la clase ArriendoServicio que es el puente de comunicacion entre el programa y el usuario
	@Autowired																												//Inyeccion de los servicios del proyecto																												
	private ArriendoRepository dao;
	private ArriendoDTO respuesta;

	@Override
	@Transactional(readOnly = true)
	public ArriendoDTO findAll() {
		respuesta = new ArriendoDTO(new ArrayList<Arriendo>(), "Ha ocurrido un error", "102");
		try {
			respuesta.setArriendos((List<Arriendo>) dao.findAll());
			respuesta.setMensaje(String.format("Se ha/n encontrado %d registro/s", respuesta.getArriendos().size()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Arriendo Service: Error en findAll", e);
		}
		return respuesta;
	} 

	@Override
	@Transactional
	public ArriendoDTO add(Arriendo arriendo) {
		respuesta = new ArriendoDTO(new ArrayList<Arriendo>(), "Ha ocurrido un error", "104");
		try {
			dao.save(arriendo);
			respuesta.setMensaje(String.format("Se ha guardado correctamente el arriendo de la pelicula %s",arriendo.getPelicula().getTitulo()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Arriendo Service: Error en add", e);
		}
		return respuesta;
	}
}