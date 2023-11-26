package controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import modelos.Album;
import modelos.Figurita;
import modelos.PaqueteFigurita;
import modelos.TipoSimulacion;

public class AlbumControlador {
	private Album[] albumes;
	private TipoSimulacion tipoSimulacion;
	private int cantidadFiguritasPorAlbum;
	private int cantidadFiguritasPorPaquete;

	public AlbumControlador(int cantidadUsuarios, int cantidadFiguritasPorAlbum, int cantidadFiguritasPorPaquete,
			TipoSimulacion tipoSimulacion) {
		this.albumes = new Album[cantidadUsuarios];
		this.tipoSimulacion = tipoSimulacion;
		this.cantidadFiguritasPorAlbum = cantidadFiguritasPorAlbum;
		this.cantidadFiguritasPorPaquete = cantidadFiguritasPorPaquete;
		this.crearAlbumes(cantidadUsuarios);
	}

	public void completarAlbumes() {
		if (tipoSimulacion == TipoSimulacion.CASO_1_USUARIO) {
			completarAlbumCaso1();
		} else if (tipoSimulacion == TipoSimulacion.CASO_2_REGALAR_REPETIDAS) {
			completarAlbumesCaso2();
		} else {
			completarAlbumesCaso3();
		}
	}

	
	public void completarAlbumCaso1() {
		while (!this.albumes[0].elAlbumEstaCompleto()) {
			PaqueteFigurita paqueteFigurita = crearPaqueteFigurita();
			this.albumes[0].agregarPaqueteFigurita(paqueteFigurita);

		}
	}

	
	public void completarAlbumesCaso2() {
		HashMap<Integer, List<Figurita>> figuritasRepetidas = new HashMap<>();
		while (!estanTodosLosAlbumesCompletos()) {
			for (int i = 0; i < albumes.length; i++) {
				agregarFiguritasRepetidasEnAlbum(figuritasRepetidas, albumes[i]);
				if (!albumes[i].elAlbumEstaCompleto()) {
					PaqueteFigurita paqueteFigurita = crearPaqueteFigurita();
					albumes[i].agregarPaqueteFigurita(paqueteFigurita);
					HashMap<Integer, List<Figurita>> figuritasRepetidasActual = albumes[i].getFiguritasRepetidas();
					albumes[i].setFiguritasRepetidas(new HashMap<>());
					for (Integer index : figuritasRepetidasActual.keySet()) {
						if (figuritasRepetidasActual.get(index) != null) {
							List<Figurita> repetidasExistentes = figuritasRepetidas.get(index);
							if (repetidasExistentes == null) {
								repetidasExistentes = new ArrayList<>();
								repetidasExistentes.addAll(figuritasRepetidasActual.get(index));
							} else {
								repetidasExistentes.addAll(figuritasRepetidasActual.get(index));
							}
						}
					}
				}
			}
		}
	}

	public void completarAlbumesCaso3() {
		while (!estanTodosLosAlbumesCompletos()) {
			for (int i = 0; i < albumes.length; i++) {
				for (int j = 0; j < albumes.length; j++) {
					if (i != j && !albumes[j].elAlbumEstaCompleto() && !albumes[i].elAlbumEstaCompleto()) {
						HashMap<Integer, List<Figurita>> figuritasRepetidasAlbum1 = albumes[i].getFiguritasRepetidas();
						for (Integer index : figuritasRepetidasAlbum1.keySet()) {
							if (figuritasRepetidasAlbum1.get(index) != null
									&& !figuritasRepetidasAlbum1.get(index).isEmpty()
									&& figuritasRepetidasAlbum1.get(index).get(0) != null
									&& albumes[j].sePuedeAgregarFigurita(figuritasRepetidasAlbum1.get(index).get(0))) {
								HashMap<Integer, List<Figurita>> figuritasRepetidasAlbum2 = albumes[j]
										.getFiguritasRepetidas();
								for (Integer indexAlbum2 : figuritasRepetidasAlbum2.keySet()) {
									if (figuritasRepetidasAlbum2.get(indexAlbum2) != null
											&& !figuritasRepetidasAlbum2.get(indexAlbum2).isEmpty()
											&& figuritasRepetidasAlbum2.get(indexAlbum2).get(0) != null
											&& albumes[i].sePuedeAgregarFigurita(
													figuritasRepetidasAlbum2.get(indexAlbum2).get(0))) {
										albumes[j].agregarFigurita(figuritasRepetidasAlbum1.get(index).get(0));
										albumes[i].agregarFigurita(figuritasRepetidasAlbum2.get(indexAlbum2).get(0));
										albumes[i].removerFiguritaRepetida(index);
										albumes[j].removerFiguritaRepetida(indexAlbum2);
										break;
									}
								}
							}
						}
					}
				}

				if (!albumes[i].elAlbumEstaCompleto()) {
					PaqueteFigurita paqueteFigurita = crearPaqueteFigurita();
					albumes[i].agregarPaqueteFigurita(paqueteFigurita);
				}
			}
		}
	}

	private void agregarFiguritasRepetidasEnAlbum(HashMap<Integer, List<Figurita>> figuritasRepetidas, Album album) {
		for (Integer index : figuritasRepetidas.keySet()) {
			if (figuritasRepetidas.get(index) != null
					&& album.sePuedeAgregarFigurita(figuritasRepetidas.get(index).get(0))) {
				album.agregarFigurita(figuritasRepetidas.get(index).get(0));
				figuritasRepetidas.get(index).remove(0);
			}
		}
	}

	public boolean estanTodosLosAlbumesCompletos() {
		for (Album album : albumes) {
			if (!album.elAlbumEstaCompleto()) {
				return false;
			}
		}
		return true;
	}

	private void crearAlbumes(int cantidadAlbumes) {
		for (int i = 0; i < cantidadAlbumes; i++) {
			albumes[i] = new Album(cantidadFiguritasPorAlbum);
		}
	}

	private PaqueteFigurita crearPaqueteFigurita() {
		PaqueteFigurita paqueteFigurita = new PaqueteFigurita();
		Random random = new Random();
		for (int i = 0; i <= cantidadFiguritasPorPaquete; i++) {
			paqueteFigurita.agregarFigurita(new Figurita(random.nextInt(0, cantidadFiguritasPorAlbum)));
		}
		return paqueteFigurita;
	}

	public Album[] getAlbumes() {
		return albumes;
	}
}
