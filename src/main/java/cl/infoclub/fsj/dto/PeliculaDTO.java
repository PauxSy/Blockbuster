package cl.infoclub.fsj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

import cl.infoclub.fsj.modelo.Pelicula;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PeliculaDTO extends GenericDTO {
	private List<Pelicula> peliculas;

	public PeliculaDTO(List<Pelicula> peliculas, String mensaje, String codigo) {
		super(mensaje, codigo);
		this.peliculas = peliculas;
	}
}
