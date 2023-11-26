package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controladores.AlbumControlador;
import modelos.TipoSimulacion;

class AlbumControladorTests {

	/*** CASO 1
	 * usuarios: 1
	 * cantidad de figuritas por album: 638
	 * cantidad de figuritas por paquete: 5
	 * ***/
	@Test
	void testCaso1() {
		AlbumControlador albumControlador = new AlbumControlador(1, 638, 5, TipoSimulacion.CASO_1_USUARIO);
		albumControlador.completarAlbumes();
		assertTrue(albumControlador.estanTodosLosAlbumesCompletos());
	}

	/*** CASO 2
	 * usuarios: 4
	 * cantidad de figuritas por album: 638
	 * cantidad de figuritas por paquete: 5
	 * ***/
	@Test
	void testCaso2() {
		AlbumControlador albumControlador = new AlbumControlador(4, 638, 5, TipoSimulacion.CASO_2_REGALAR_REPETIDAS);
		albumControlador.completarAlbumes();
		assertTrue(albumControlador.estanTodosLosAlbumesCompletos());
		assertTrue(albumControlador.getAlbumes()[0].elAlbumEstaCompleto());
		assertTrue(albumControlador.getAlbumes()[1].elAlbumEstaCompleto());
		assertTrue(albumControlador.getAlbumes()[2].elAlbumEstaCompleto());
		assertTrue(albumControlador.getAlbumes()[3].elAlbumEstaCompleto());
		assertTrue(albumControlador.getAlbumes()[0].getFiguritasRepetidas().isEmpty());
		assertTrue(albumControlador.getAlbumes()[1].getFiguritasRepetidas().isEmpty());
		assertTrue(albumControlador.getAlbumes()[2].getFiguritasRepetidas().isEmpty());
		assertTrue(albumControlador.getAlbumes()[3].getFiguritasRepetidas().isEmpty());
	}

	/*** CASO 3
	 * usuarios: 3
	 * cantidad de figuritas por album: 638
	 * cantidad de figuritas por paquete: 5
	 * ***/
	@Test
	void testCaso3() {
		AlbumControlador albumControlador = new AlbumControlador(3, 638, 5, TipoSimulacion.CASO_3_INTERCAMBIAR_REPETIDAS);
		albumControlador.completarAlbumes();
		assertTrue(albumControlador.estanTodosLosAlbumesCompletos());
		assertTrue(albumControlador.getAlbumes()[0].elAlbumEstaCompleto());
		assertTrue(albumControlador.getAlbumes()[1].elAlbumEstaCompleto());
		assertTrue(albumControlador.getAlbumes()[2].elAlbumEstaCompleto());
		assertFalse(albumControlador.getAlbumes()[0].getFiguritasRepetidas().isEmpty());
		assertFalse(albumControlador.getAlbumes()[1].getFiguritasRepetidas().isEmpty());
		assertFalse(albumControlador.getAlbumes()[2].getFiguritasRepetidas().isEmpty());
	}
}
