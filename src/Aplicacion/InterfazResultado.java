package Aplicacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import modelos.TipoSimulacion;

import java.awt.Font;

public class InterfazResultado {

	private JFrame frame;
	private double resultado;
	private int cantFigusAlbum;
	private int cantFigusPaquete;
	private int cantSimulaciones;
	private TipoSimulacion modeloDeSimulacion;
	private int cantUsuarios;

	/**
	 * Create the application.
	 */

	public InterfazResultado(double resultadoSimulacion, int figusAlbum, int figusPaquete, int cantidadSimulaciones,
			TipoSimulacion modelo, int cantidadUsuarios) {
		resultado = resultadoSimulacion;
		cantFigusAlbum = figusAlbum;
		cantFigusPaquete = figusPaquete;
		cantSimulaciones = cantidadSimulaciones;
		modeloDeSimulacion = modelo;
		cantUsuarios = cantidadUsuarios;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 677, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"La cantidad de paquetes que se necesitan, en promedio, para completar el album");
		lblNewLabel.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 10, 643, 43);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("con los datos ingresados es: " + resultado);
		lblNewLabel_1.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 49, 643, 35);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Datos ingresados:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(10, 93, 149, 19);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("Cantidad de figuritas por album: " + cantFigusAlbum);
		lblNewLabel_1_1.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 120, 436, 25);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Cantidad de figuritas por paquete: " + cantFigusPaquete);
		lblNewLabel_1_2.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 155, 436, 25);
		frame.getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Cantidad de simulaciones: " + cantSimulaciones);
		lblNewLabel_1_3.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(10, 190, 436, 25);
		frame.getContentPane().add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_3_1 = new JLabel("Modelo de simulacion elegido: " + modeloDeSimulacion);
		lblNewLabel_1_3_1.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		lblNewLabel_1_3_1.setBounds(10, 225, 643, 25);
		frame.getContentPane().add(lblNewLabel_1_3_1);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("Cantidad de usuarios: " + cantUsuarios);
		lblNewLabel_1_3_1_1.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		lblNewLabel_1_3_1_1.setBounds(10, 260, 436, 25);
		frame.getContentPane().add(lblNewLabel_1_3_1_1);

	}

	public JFrame getFrame() {
		return frame;
	}
}
