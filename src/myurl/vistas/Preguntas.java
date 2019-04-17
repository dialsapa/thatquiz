package myurl.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
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

public class Preguntas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Preguntas frame = new Preguntas();
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
	public Preguntas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNum1 = new JLabel("n1");
		lblNum1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNum1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum1.setBounds(60, 118, 27, 14);
		panel.add(lblNum1);
		
		JLabel lblDen1 = new JLabel("d1");
		lblDen1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDen1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDen1.setBounds(60, 157, 27, 14);
		panel.add(lblDen1);
		
		JLabel lblNum2 = new JLabel("n2");
		lblNum2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNum2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum2.setBounds(158, 118, 27, 14);
		panel.add(lblNum2);
		
		JLabel lblDen2 = new JLabel("d2");
		lblDen2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDen2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDen2.setBounds(158, 157, 27, 14);
		panel.add(lblDen2);
		
		JLabel lblNewLabel = new JLabel("=");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(229, 136, 27, 14);
		panel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(146, 141, 50, 5);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(48, 141, 50, 5);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(286, 141, 70, 5);
		panel.add(separator_2);
		
		JLabel lblOper = new JLabel("+");
		lblOper.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOper.setBounds(117, 136, 19, 14);
		panel.add(lblOper);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(300, 106, 43, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(300, 157, 43, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(382, 132, 89, 23);
		panel.add(btnOk);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnIniciar = new JButton("Iniciar");
		panel_1.add(btnIniciar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		panel_1.add(panel_2);
		
		JLabel lblMensaje = new JLabel("Mensaje");
		panel_2.add(lblMensaje);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Tiempo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("00:00");
		label.setFont(new Font("Tahoma", Font.BOLD, 19));
		panel_3.add(label);
	}
}
