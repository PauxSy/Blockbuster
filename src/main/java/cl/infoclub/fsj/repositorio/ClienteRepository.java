package cl.infoclub.fsj.repositorio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.infoclub.fsj.modelo.Cliente;
@Repository
public interface ClienteRepository extends CrudRepository<Cliente,Integer> {
}