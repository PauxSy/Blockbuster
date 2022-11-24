package cl.infoclub.fsj;

import cl.infoclub.fsj.modelo.Arriendo;
import cl.infoclub.fsj.modelo.Pelicula;
import cl.infoclub.fsj.repositorio.ArriendoRepository;
import cl.infoclub.fsj.repositorio.PeliculaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlockbusterApplicationTests {
	@Autowired
	private ArriendoRepository arriendoRepository;
	@Autowired
	PeliculaRepository peliculaRepository;
	@Test
	private void validaRepositoriosCreandoPeliculaYArriendo() {
		
	//nueva pelicula
	Pelicula spaceOdyssey = new Pelicula(1,"2001: A Space Odyssey","After discovering a mysterious artifact buried beneath the Lunar surface, mankind sets off on a quest to find its origins with help from intelligent supercomputer H.A.L. 9000. ",149);
	//	Pelicula spaceOdyssey = new Pelicula();
	//nuevo arriendo
	Arriendo arriendo = new Arriendo(null, "11/20/2019", 7,spaceOdyssey);
	//guardar arriendo
	arriendoRepository.save(arriendo);
	//buscar arriendo
	Arriendo arriendoOd = arriendoRepository.findById(1).get();
	//valida que exista
	Assertions.assertNotNull(arriendoOd);
	}
}
