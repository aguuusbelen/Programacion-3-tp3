package Aplicacion;

import controladores.AlbumControlador;
import modelos.TipoSimulacion;

public class Aplicacion {

	int cantidadFiguritasPorAlbum;
	int cantidadFiguritasPorPaquete;
	int cantidadSimulaciones;
	TipoSimulacion tipoSimulacion;
	int cantidadUsuarios;
	double paquetesPromedio;

	public Aplicacion(int cantidadFiguritasPorAlbum, int cantidadFiguritasPorPaquete, int cantidadSimulaciones,
			TipoSimulacion tipoSimulacion, int cantidadUsuarios) {
		this.cantidadFiguritasPorAlbum = cantidadFiguritasPorAlbum;
		this.cantidadFiguritasPorPaquete = cantidadFiguritasPorPaquete;
		this.cantidadSimulaciones = cantidadSimulaciones;
		this.tipoSimulacion = tipoSimulacion;
		this.cantidadUsuarios = cantidadUsuarios;
		this.paquetesPromedio = 0;
	}

	public double iniciarSimulacion(int cantidadSimulaciones) {
		int cont = 0;
		int paquetes = 0;
		while (cont < cantidadSimulaciones) {
			AlbumControlador albumControlador = new AlbumControlador(cantidadUsuarios, cantidadFiguritasPorAlbum,
					cantidadFiguritasPorPaquete, tipoSimulacion);
			albumControlador.completarAlbumes();
			for (int i = 0; i < albumControlador.getAlbumes().length; i++) {
				paquetes += albumControlador.getAlbumes()[i].getCantidadPaquetesFiguritasNecesarias();

			}
			cont++;
		}
		paquetesPromedio = Math.ceil(paquetes / cantidadSimulaciones);

		return paquetesPromedio;

	}

}
