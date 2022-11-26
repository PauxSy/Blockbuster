package cl.infoclub.fsj.service;

import cl.infoclub.fsj.dto.ArriendoDTO;
import cl.infoclub.fsj.modelo.Arriendo;

public interface ArriendoService {
	ArriendoDTO findAll();
	ArriendoDTO add(Arriendo arriendo);
}