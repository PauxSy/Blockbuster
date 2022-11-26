package cl.infoclub.fsj.service;

import cl.infoclub.fsj.dto.ArriendoDTO;
import cl.infoclub.fsj.modelo.Arriendo;

public interface ArriendoService {					//Interfaz del servicio de Arriendo
	ArriendoDTO findAll();							//Busca todos los arriendos
	ArriendoDTO add(Arriendo arriendo);				//Agrega arriendos
}