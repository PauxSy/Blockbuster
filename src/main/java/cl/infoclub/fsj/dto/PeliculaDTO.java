package cl.infoclub.fsj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

import cl.infoclub.fsj.modelo.Cliente;
import cl.infoclub.fsj.modelo.Pelicula;

@Data																						//Llama a los getter, setter, toString.
@NoArgsConstructor																			//Genera el constructor sin parámetros.
@AllArgsConstructor																			//Genera el constructor con todos los parámetros
@EqualsAndHashCode(callSuper = true)														//Genera implementaciones para los "equals" y metodos hashCode
public class PeliculaDTO extends GenericDTO {												//Se crea la clase PeliculaDTO heredando desde GenericDTO
	private List<Pelicula> peliculas;														//Instancia de la lista de "Pelicula"

	public PeliculaDTO(List<Pelicula> peliculas, String mensaje, String codigo) {			//Constructor de la clase
		super(mensaje, codigo);
		this.peliculas = peliculas;
	}
}
