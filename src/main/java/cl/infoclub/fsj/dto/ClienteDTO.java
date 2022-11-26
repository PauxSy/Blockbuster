package cl.infoclub.fsj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

import cl.infoclub.fsj.modelo.Cliente;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ClienteDTO extends GenericDTO {
	private List<Cliente> clientes;

	public ClienteDTO(List<Cliente> clientes, String mensaje, String codigo) {
		super(mensaje, codigo);
		this.clientes = clientes;
	}
}
