package cl.infoclub.fsj.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "SQ_CLIENTE", initialValue = 1, allocationSize = 1)
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CLIENTE")
	private Integer id;
	private String nombre;
}