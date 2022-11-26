package cl.infoclub.fsj.service;

import cl.infoclub.fsj.dto.ClienteDTO;
import cl.infoclub.fsj.modelo.Cliente;

public interface ClienteService {						//Interfaz del Servicio de Cliente
	ClienteDTO findAll();								//Busca todos los clientes	
	ClienteDTO add(Cliente cliente);					//Agrega a un Cliente
}
