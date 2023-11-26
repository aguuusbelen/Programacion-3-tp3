package Aplicacion;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import modelos.TipoSimulacion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Interfaz {

	private JFrame frame;
	private JTextField textFieldCantFigAlbum;
	private JTextField textFieldCantFigPaquete;
	private JTextField textFieldCantSimulaciones;
	private Aplicacion aplicacion;
	TipoSimulacion modelo;
	private JTextField textFieldCantidadUsuarios;
	private JButton btnIniciarSimulacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblCantidadFigusAlbum = new JLabel("Ingrese la cantidad de figuritas del alb\u00FAm");
		lblCantidadFigusAlbum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidadFigusAlbum.setBounds(10, 25, 262, 36);
		frame.getContentPane().add(lblCantidadFigusAlbum);

		textFieldCantFigAlbum = new JTextField();
		textFieldCantFigAlbum.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if (!((int) e.getKeyChar() > 47 && (int) e.getKeyChar() < 58)) {
					e.consume();
				}
			}
		});
		textFieldCantFigAlbum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldCantFigAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCantFigAlbum.setBounds(295, 31, 96, 30);
		frame.getContentPane().add(textFieldCantFigAlbum);
		textFieldCantFigAlbum.setColumns(10);

		JLabel lblCantidadFigusPaquete = new JLabel("Ingrese la cantidad de figuritas por paquete");
		lblCantidadFigusPaquete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidadFigusPaquete.setBounds(10, 71, 276, 36);
		frame.getContentPane().add(lblCantidadFigusPaquete);

		textFieldCantFigPaquete = new JTextField();
		textFieldCantFigPaquete.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if (!((int) e.getKeyChar() > 47 && (int) e.getKeyChar() < 58)) {
					e.consume();
				}
			}
		});
		textFieldCantFigPaquete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldCantFigPaquete.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCantFigPaquete.setColumns(10);
		textFieldCantFigPaquete.setBounds(295, 77, 96, 30);
		frame.getContentPane().add(textFieldCantFigPaquete);

		JLabel lblCantidadDeSimulaciones = new JLabel("Cantidad de simulaciones");
		lblCantidadDeSimulaciones.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidadDeSimulaciones.setBounds(10, 117, 262, 36);
		frame.getContentPane().add(lblCantidadDeSimulaciones);

		textFieldCantSimulaciones = new JTextField();
		textFieldCantSimulaciones.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if (!((int) e.getKeyChar() > 47 && (int) e.getKeyChar() < 58)) {
					e.consume();
				}
			}
		});
		textFieldCantSimulaciones.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCantSimulaciones.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldCantSimulaciones.setColumns(10);
		textFieldCantSimulaciones.setBounds(295, 123, 96, 30);
		frame.getContentPane().add(textFieldCantSimulaciones);

		JLabel lblSeleccioneUnModelo = new JLabel("Seleccione un modelo de simulaci\u00F3n");
		lblSeleccioneUnModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSeleccioneUnModelo.setBounds(10, 163, 262, 36);
		frame.getContentPane().add(lblSeleccioneUnModelo);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(295, 166, 180, 30);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Seleccione un modelo", "Unico usuario",
				"Regalar repetidas", "Intercambiar repetidas" }));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 1) {
					textFieldCantidadUsuarios.setText("1");
					textFieldCantidadUsuarios.setEditable(false);
					modelo = TipoSimulacion.CASO_1_USUARIO;
				} else {
					textFieldCantidadUsuarios.setText("");
					textFieldCantidadUsuarios.setEditable(true);
					if (comboBox.getSelectedIndex() == 2) {
						modelo = TipoSimulacion.CASO_2_REGALAR_REPETIDAS;
					} else {
						modelo = TipoSimulacion.CASO_3_INTERCAMBIAR_REPETIDAS;
					}
				}
			}
		});
		frame.getContentPane().add(comboBox);

		JLabel lblCantidadDeUsuarios = new JLabel("Cantidad de usuarios");
		lblCantidadDeUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidadDeUsuarios.setBounds(47, 209, 262, 36);
		frame.getContentPane().add(lblCantidadDeUsuarios);

		textFieldCantidadUsuarios = new JTextField();
		textFieldCantidadUsuarios.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if (!((int) e.getKeyChar() > 47 && (int) e.getKeyChar() < 58)) {
					e.consume();
				}
			}
		});
		textFieldCantidadUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCantidadUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldCantidadUsuarios.setColumns(10);
		textFieldCantidadUsuarios.setBounds(295, 215, 96, 30);
		frame.getContentPane().add(textFieldCantidadUsuarios);

		btnIniciarSimulacion = new JButton("INICIAR SIMULACI\u00D3N");
		btnIniciarSimulacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarSimulacion();
			}
		});
		btnIniciarSimulacion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnIniciarSimulacion.setBounds(185, 302, 229, 53);
		frame.getContentPane().add(btnIniciarSimulacion);

	}

	public void iniciarSimulacion() {
		if (textFieldCantFigAlbum.getText().length() > 0 && textFieldCantFigPaquete.getText().length() > 0
				&& textFieldCantSimulaciones.getText().length() > 0
				&& textFieldCantidadUsuarios.getText().length() > 0) {
			
			int cantFigusAlbum = Integer.parseInt(textFieldCantFigAlbum.getText());
			int cantFigusPaquete = Integer.parseInt(textFieldCantFigPaquete.getText());
			int cantSimulaciones = Integer.parseInt(textFieldCantSimulaciones.getText());
			int cantUsuarios = Integer.parseInt(textFieldCantidadUsuarios.getText());
			
			aplicacion = new Aplicacion(cantFigusAlbum, cantFigusPaquete, cantSimulaciones, modelo, cantUsuarios);
			double resultadoSimulacion = aplicacion.iniciarSimulacion(Integer.parseInt(textFieldCantSimulaciones.getText()));
			
			InterfazResultado resultado = new InterfazResultado(resultadoSimulacion, cantFigusAlbum, cantFigusPaquete,
					cantSimulaciones, modelo, cantUsuarios);
			resultado.getFrame().setVisible(true);
		}
	}
}
