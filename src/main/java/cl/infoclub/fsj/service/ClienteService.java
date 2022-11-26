package cl.infoclub.fsj.service;

import cl.infoclub.fsj.dto.ClienteDTO;
import cl.infoclub.fsj.modelo.Cliente;

public interface ClienteService {
	ClienteDTO findAll();
	ClienteDTO add(Cliente cliente);
}
