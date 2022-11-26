package cl.infoclub.fsj.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Data																						//Llama a los getter, setter, toString
@Entity																						//Señala que la clase es una entidad
@AllArgsConstructor																			//Genera el constructor con todos los parámetros
@NoArgsConstructor																			//Genera el constructor sin parámetros
@SequenceGenerator(name = "SQ_CLIENTE", initialValue = 1, allocationSize = 1)				//Define un generador de clave principal al que se puede hacer referencia por nombre cuando se especifica un elemento generador para la notación GeneratedValue.
public class Cliente {
	@Id																						//Especifica la id primaria de la clase
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CLIENTE")			// y como se genera.
	private Integer id;																		//Atributos de la clase (id y nombre).
	private String nombre;
}