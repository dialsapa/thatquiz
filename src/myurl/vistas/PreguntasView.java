package myurl.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import myurl.controlador.PreguntasFactory;
import myurl.modelo.PreguntaFracciones;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class PreguntasView extends JFrame {
	private PreguntasFactory preguntasfactory = new PreguntasFactory();
	private List<PreguntaFracciones> lstPreguntas = new ArrayList<PreguntaFracciones>();
	private int indexPregunta = 0;

	private PreguntaFracciones preguntaActual = null;

	private Timer timer;
	private int segundos = 00;
	private int minutos;
	private int acertadas = 0;
	private int erradas = 0;

	private JPanel contentPane;
	private JTextField txtFNumRes;
	private JTextField txtFDenRes;
	private JLabel lblNum1;
	private JLabel lblDen1;
	private JLabel lblNum2;
	private JLabel lblDen2;
	private JLabel lblOper;
	private JLabel lblMensaje;
	private JLabel lblTiempo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreguntasView frame = new PreguntasView(1, 20, 15, 15);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PreguntasView(int rangoIni, int rangoFin, int cantidadPreguntas, int minutosTiempo) {
		this.minutos = minutosTiempo;
		lstPreguntas = preguntasfactory.generarListaPreguntasFraccionesRmd(rangoIni, rangoFin, cantidadPreguntas);
		preguntaActual = lstPreguntas.get(indexPregunta);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		lblNum1 = new JLabel("n1");
		lblNum1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNum1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum1.setBounds(22, 120, 27, 14);
		panel.add(lblNum1);

		lblDen1 = new JLabel("d1");
		lblDen1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDen1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDen1.setBounds(22, 159, 27, 14);
		panel.add(lblDen1);

		lblNum2 = new JLabel("n2");
		lblNum2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNum2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum2.setBounds(120, 120, 27, 14);
		panel.add(lblNum2);

		lblDen2 = new JLabel("d2");
		lblDen2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDen2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDen2.setBounds(120, 159, 27, 14);
		panel.add(lblDen2);

		JLabel lblNewLabel = new JLabel("=");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(168, 133, 27, 14);
		panel.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(108, 143, 50, 5);
		panel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(10, 143, 50, 5);
		panel.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(191, 137, 70, 5);
		panel.add(separator_2);

		lblOper = new JLabel("+");
		lblOper.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOper.setBounds(79, 138, 19, 14);
		panel.add(lblOper);

		txtFNumRes = new JTextField();
		txtFNumRes.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtFNumRes.setHorizontalAlignment(SwingConstants.CENTER);
		txtFNumRes.setBounds(205, 102, 43, 20);
		panel.add(txtFNumRes);
		txtFNumRes.setColumns(10);

		txtFDenRes = new JTextField();
		txtFDenRes.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtFDenRes.setHorizontalAlignment(SwingConstants.CENTER);
		txtFDenRes.setBounds(205, 153, 43, 20);
		panel.add(txtFDenRes);
		txtFDenRes.setColumns(10);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirmarRespuesta();
			}

		});
		btnOk.setBounds(271, 132, 50, 23);
		panel.add(btnOk);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iniciarTest();
			}
		});
		panel_1.add(btnIniciar);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		panel_1.add(panel_2);

		lblMensaje = new JLabel("Cuando estes listo oprime el bot\u00F3n Iniciar");
		lblMensaje.setForeground(Color.BLUE);
		panel_2.add(lblMensaje);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Tiempo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblTiempo = new JLabel();
		mostrarTiempo();
		lblTiempo.setFont(new Font("Tahoma", Font.BOLD, 19));
		panel_3.add(lblTiempo);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Avance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_4, BorderLayout.EAST);
		panel_4.setLayout(new GridLayout(6, 1, 0, 0));
		
		JLabel lblHasRespondido = new JLabel("Has respondido:");
		panel_4.add(lblHasRespondido);
		
		JLabel lblDe = new JLabel("2 de 20");
		lblDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblDe.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_4.add(lblDe);
		
		JLabel lblAcertadas = new JLabel("Acertadas:");
		panel_4.add(lblAcertadas);
		
		JLabel label = new JLabel("5");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_4.add(label);
		
		JLabel lblErradas = new JLabel("Erradas:");
		panel_4.add(lblErradas);
		
		JLabel label_1 = new JLabel("5");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_4.add(label_1);

		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (segundos == 0 && minutos == 0) {
					timer.stop();
				} else if (segundos > 0) {
					segundos--;

				} else if (minutos > 0) {
					minutos--;
					segundos = 59;
				}

				mostrarTiempo();
			}
		});

	}

	protected void mostrarTiempo() {
		// TODO Auto-generated method stub
		String segu;
		String minu;
		if (segundos < 10) {
			segu = "0" + segundos;
		} else {
			segu = segundos + "";
		}

		if (minutos < 10) {
			minu = "0" + minutos;
		} else {
			minu = minutos + "";
		}

		lblTiempo.setText(minu + " : " + segu);
	}

	/**
	 * 
	 */
	protected void confirmarRespuesta() {
		if (esCorrecta()) {
			acertadas++;
			lblMensaje.setForeground(Color.BLUE);
			lblMensaje.setText("Muy Bien. Respuesta Correcta");
		} else {
			erradas++;
			lblMensaje.setForeground(Color.RED);
			lblMensaje.setText("ERROR. Respuesta No es Correcta");
		}
		txtFNumRes.setText("");
		txtFDenRes.setText("");

		indexPregunta++;
		preguntaActual = lstPreguntas.get(indexPregunta);
		iniciarTest();
	}

	/**
	 * 
	 */
	protected void iniciarTest() {
		lblNum1.setText(String.valueOf(preguntaActual.getFraccion1().getNumerador()));
		lblDen1.setText(String.valueOf(preguntaActual.getFraccion1().getDenominador()));
		lblNum2.setText(String.valueOf(preguntaActual.getFraccion2().getNumerador()));
		lblDen2.setText(String.valueOf(preguntaActual.getFraccion2().getDenominador()));
		lblOper.setText(String.valueOf(preguntaActual.getOperacion().getSimbolo()));
		timer.start();

	}

	/**
	 * 
	 * @return
	 */
	protected boolean esCorrecta() {
		Long numRes = Long.valueOf(txtFNumRes.getText());
		Long denRes = Long.valueOf(txtFDenRes.getText());
		if (numRes == preguntaActual.getRespuesta().getNumerador()
				&& denRes == preguntaActual.getRespuesta().getDenominador()) {
			return true;

		} else
			return false;

	}
}
