package cl.infoclub.fsj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

import cl.infoclub.fsj.modelo.Arriendo;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArriendoDTO extends GenericDTO {
	private List<Arriendo> arriendos;

	public ArriendoDTO(List<Arriendo> arriendos, String mensaje, String codigo) {
		super(mensaje, codigo);
		this.arriendos = arriendos;
	}
}
