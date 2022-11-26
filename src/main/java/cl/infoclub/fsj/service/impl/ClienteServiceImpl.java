package cl.infoclub.fsj.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.infoclub.fsj.dto.ClienteDTO;
import cl.infoclub.fsj.modelo.Cliente;
import cl.infoclub.fsj.repositorio.ClienteRepository;
import cl.infoclub.fsj.service.ClienteService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
	private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);
	@Autowired
	private ClienteRepository dao;
	private ClienteDTO respuesta;

	@Override
	@Transactional(readOnly = true)
	public ClienteDTO findAll() {
		respuesta = new ClienteDTO(new ArrayList<Cliente>(), "Ha ocurrido un error", "102");
		try {
			respuesta.setClientes((List<Cliente>) dao.findAll());
			respuesta.setMensaje(String.format("Se ha/n encontrado %d registro/s", respuesta.getClientes().size()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Cliente Service: Error en findAll", e);
		}
		return respuesta;
	}

	@Override
	@Transactional
	public ClienteDTO add(Cliente cliente) {
		respuesta = new ClienteDTO(new ArrayList<Cliente>(), "Ha ocurrido un error", "104");
		try {
			dao.save(cliente);
			respuesta.setMensaje(String.format("Se ha guardado correctamente el cliente %s", cliente.getNombre()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Cliente Service: Error en add", e);
		}
		return respuesta;
	}

}