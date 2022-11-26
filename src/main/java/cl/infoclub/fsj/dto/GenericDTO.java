package cl.infoclub.fsj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data									//Llama a los getter, setter, toString.
@NoArgsConstructor						//Genera el constructor sin parámetros.
@AllArgsConstructor						//Genera el constructor con todos los parámetros
public class GenericDTO {
	String mensaje;
	String codigo;
}
