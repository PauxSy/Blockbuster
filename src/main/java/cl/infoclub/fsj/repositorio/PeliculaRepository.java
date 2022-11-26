package cl.infoclub.fsj.repositorio;
import cl.infoclub.fsj.modelo.Pelicula;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PeliculaRepository extends CrudRepository<Pelicula,Integer> {		//Hereda desde el repositorio Crud a la clase Pelicula
//El modelo CRUD se utiliza para tener las funciones de Create, Read, Update y Delete; y viene del framework de spring.
}