package cl.infoclub.fsj.modelo;

import lombok.AllArgsConstructor;															
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Data																						//Llama a los getter, setter, toString
@Entity																						//Señala que la clase es una entidad
@AllArgsConstructor																			//Genera el constructor con todos los parámetros
@NoArgsConstructor																			//Genera el constructor sin parámetros
@SequenceGenerator(name = "SQ_ARRIENDO", initialValue = 1, allocationSize = 1)				//Define un generador de clave principal al que se puede hacer referencia por nombre cuando se especifica un elemento generador para la notación GeneratedValue.
public class Arriendo {																		
	@Id																						//Especifica la ID primaria de la clase
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ARRIENDO")			// y como esta se genera.
	private Integer id;																		//Se declaran las variables de la clase, como la id
	private String inicio;																	//el inicio,
	private Integer duracion;																//y la duracion del arriendo
	@ManyToOne																				//Especifica que la relacion con otra entidad tiene cardinalidad de uno a muchos
	@JoinColumn(name = "pelicula_id", referencedColumnName = "id")							//Indica que la columna asociada (pelicula_id)se debe unir(SQL Join) a una entidad especificada(id)
	private Pelicula pelicula;																//Variable pelicula
	@ManyToOne																				//Especifica que la relacion con otra entidad tiene cardinalidad de uno a muchos
	@JoinColumn(name = "cliente_id", referencedColumnName = "id")							//Indica que la columna asociada (cliente_id)se debe unir(SQL Join) a una entidad especificada(id)
	private Cliente cliente;
}