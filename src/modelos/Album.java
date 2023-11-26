package modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Album {
	private Figurita[] figuritas;
	private HashMap<Integer, List<Figurita>> figuritasRepetidas;
	private int cantidadPaquetesFiguritasNecesarias;

	public Album(int cantidadFiguritasEnElAlbum) {
		this.figuritas = new Figurita[cantidadFiguritasEnElAlbum];
		this.figuritasRepetidas = new HashMap<>();
	}

	public void agregarPaqueteFigurita(PaqueteFigurita paqueteFigurita) {
		for (Figurita f : paqueteFigurita.getFiguritas()) {
			if (figuritas[f.getId()] == null) {
				figuritas[f.getId()] = f;
			} else {
				List<Figurita> repetidasExistentes = figuritasRepetidas.get(f.getId());
				if (repetidasExistentes == null) {
					repetidasExistentes = new ArrayList<>();
					repetidasExistentes.add(f);
				} else {
					repetidasExistentes.add(f);
				}
				figuritasRepetidas.put(f.getId(), repetidasExistentes);
			}
		}
		cantidadPaquetesFiguritasNecesarias++;
	}

	public void removerFiguritaRepetida(Integer index) {
		List<Figurita> repetidasExistentes = figuritasRepetidas.get(index);
		repetidasExistentes.remove(repetidasExistentes.size() - 1);
		if (repetidasExistentes.size() == 0) {
			figuritasRepetidas.put(index, null);
		} else {
			figuritasRepetidas.put(index, repetidasExistentes);
		}
	}

	public boolean sePuedeAgregarFigurita(Figurita figurita) {
		return figuritas[figurita.getId()] == null;
	}

	public void agregarFigurita(Figurita figurita) {
		if (sePuedeAgregarFigurita(figurita)) {
			figuritas[figurita.getId()] = figurita;
		}
	}

	public boolean elAlbumEstaCompleto() {
		for (int i = 0; i < figuritas.length; i++) {
			if (figuritas[i] == null) {
				return false;
			}
		}
		return true;
	}

	public Figurita[] getFiguritas() {
		return figuritas;
	}

	public HashMap<Integer, List<Figurita>> getFiguritasRepetidas() {
		return figuritasRepetidas;
	}

	public int getCantidadPaquetesFiguritasNecesarias() {
		return cantidadPaquetesFiguritasNecesarias;
	}

	public void setFiguritasRepetidas(HashMap<Integer, List<Figurita>> figuritasRepetidas) {
		this.figuritasRepetidas = figuritasRepetidas;
	}
}
