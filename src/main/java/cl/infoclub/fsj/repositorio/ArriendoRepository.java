package cl.infoclub.fsj.repositorio;

import cl.infoclub.fsj.modelo.Arriendo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ArriendoRepository extends CrudRepository<Arriendo,Integer> {		//Hereda desde el repositorio Crud a la clase Arriendo
//El modelo CRUD se utiliza para tener las funciones de Create, Read, Update y Delete; y viene del framework de spring.
}
