package cl.infoclub.fsj.modelo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "SQ_ARRIENDO", initialValue = 1, allocationSize = 1)
public class Arriendo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ARRIENDO")
	private Integer id;
	private String inicio;
	private Integer duracion;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pelicula_id", referencedColumnName = "id")
	private Pelicula pelicula;
}
