package cl.infoclub.fsj.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data																						//Llama a los getter, setter, toString
@Entity																						//Señala que la clase es una entidad
@AllArgsConstructor																			//Genera el constructor con todos los parámetros
@NoArgsConstructor																			//Genera el constructor sin parámetros
@SequenceGenerator(name = "SQ_PELICULA", initialValue = 1, allocationSize = 1)				//Define un generador de clave principal al que se puede hacer referencia por nombre cuando se especifica un elemento generador para la notación GeneratedValue.
public class Pelicula {
	@Id																						//Indica la clave primaria de la clase
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PELICULA")			// y como se genera.
	private Integer id;																		//Variables de clase 
	private String titulo;
	private String descripcion;
	private Integer duracion;
}
