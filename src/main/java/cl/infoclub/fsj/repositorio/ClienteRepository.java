package cl.infoclub.fsj.repositorio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.infoclub.fsj.modelo.Cliente;
@Repository
public interface ClienteRepository extends CrudRepository<Cliente,Integer> {		//Hereda desde el repositorio Crud a la clase Cliente
// El modelo CRUD se utiliza para tener las funciones de Create, Read, Update y Delete; y viene del framework de spring.
}