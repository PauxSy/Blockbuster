package cl.infoclub.fsj;

import cl.infoclub.fsj.modelo.Arriendo;
import cl.infoclub.fsj.modelo.Cliente;
import cl.infoclub.fsj.modelo.Pelicula;
import cl.infoclub.fsj.repositorio.ArriendoRepository;
import cl.infoclub.fsj.repositorio.ClienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlockbusterApplicationTests {
	@Autowired
	private ArriendoRepository arriendoRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	@Test
	public void validandoDatos() {
// Instanciamos las tres clases.
		Pelicula pelicula = new Pelicula();
		Cliente cliente = new Cliente();
		Arriendo arriendo = new Arriendo();
// Guardamos al cliente en base de datos para generar su ID.
		cliente.setNombre("Juan");
		cliente = clienteRepository.save(cliente);
// Asignamos un estado a la pelicula
		pelicula.setDescripcion("Buena pelicula");
		pelicula.setDuracion(160);
		pelicula.setTitulo("El cuadro");
// Asignamos un estado al arriendo
		arriendo.setDuracion(10);
		arriendo.setInicio("11/12/2019");
		arriendo.setPelicula(pelicula);
//Le asignamos al cliente previamente creado.
		arriendo.setCliente(cliente);
//Guardamos la pelicula y el arriendo
		arriendo = arriendoRepository.save(arriendo);
//Guardamos al cliente en base de datos
		cliente = clienteRepository.save(cliente);
//afirmaciones
		Assertions.assertNotNull(arriendoRepository.findAll());
		Assertions.assertNotNull(clienteRepository.findAll());
	}
}
