package cl.infoclub.fsj.repositorio;
import cl.infoclub.fsj.modelo.Pelicula;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PeliculaRepository extends CrudRepository<Pelicula,Integer> {
}