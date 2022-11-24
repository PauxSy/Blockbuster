package cl.infoclub.fsj.repositorio;

import cl.infoclub.fsj.modelo.Arriendo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ArriendoRepository extends CrudRepository<Arriendo,Integer> {
}
