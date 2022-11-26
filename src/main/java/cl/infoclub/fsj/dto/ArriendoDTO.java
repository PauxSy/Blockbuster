package cl.infoclub.fsj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

import cl.infoclub.fsj.modelo.Arriendo;

@Data																						//Llama a los getter, setter, toString.
@NoArgsConstructor																			//Genera el constructor sin parámetros.
@AllArgsConstructor																			//Genera el constructor con todos los parámetros
@EqualsAndHashCode(callSuper = true)														//Genera implementaciones para los "equals" y metodos hashCode 
public class ArriendoDTO extends GenericDTO {												//Se implementa la clase ArriendoDTO heredando variables, constructores y metodos desde GenericDTO 
	private List<Arriendo> arriendos;														//Se instancia la lista de tipo "Arriendo"

	public ArriendoDTO(List<Arriendo> arriendos, String mensaje, String codigo) {			//Constructor de clase
		super(mensaje, codigo);
		this.arriendos = arriendos;
	}
}
