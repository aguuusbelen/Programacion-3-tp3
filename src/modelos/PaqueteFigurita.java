package modelos;

import java.util.ArrayList;
import java.util.List;

public class PaqueteFigurita {
	private List<Figurita> figuritas;

	public PaqueteFigurita() {
		this.figuritas = new ArrayList<>();
	}

	public void agregarFigurita(Figurita figurita) {
		this.figuritas.add(figurita);
	}

	public List<Figurita> getFiguritas() {
		return figuritas;
	}
}
