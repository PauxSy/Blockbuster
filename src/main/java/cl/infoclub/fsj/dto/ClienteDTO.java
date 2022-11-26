package cl.infoclub.fsj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

import cl.infoclub.fsj.modelo.Arriendo;
import cl.infoclub.fsj.modelo.Cliente;

@Data																						//Llama a los getter, setter, toString.
@NoArgsConstructor																			//Genera el constructor sin parámetros.
@AllArgsConstructor																			//Genera el constructor con todos los parámetros
@EqualsAndHashCode(callSuper = true)														//Genera implementaciones para los "equals" y metodos hashCode
public class ClienteDTO extends GenericDTO {												//Se crea la clase ClienteDTO heredando desde GenericDTO
	private List<Cliente> clientes;															//Instancia de lista de "Cliente"

	public ClienteDTO(List<Cliente> clientes, String mensaje, String codigo) {				//Constructor de clase
		super(mensaje, codigo);
		this.clientes = clientes;
	}
}
