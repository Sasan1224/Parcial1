package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import Controlador.CPerro;
import Controlador.CPerrosOrdenados;

public class Ventana extends JFrame{
	private JPanel panel;
	private JPanel panel2;
	private JPanel panel3;
	private JLabel lblTitulo;
	private JLabel lbl1;
	private JLabel lbl2;
	private JTable tabla1;
	private JTable tabla2;
	private JButton btnAdoptar;
	private JButton btnGenerar;
	private JButton btnOrdenar;
	private JComboBox<String> opciones;
	private CPerro cp;
	private CPerrosOrdenados cpo;
	public Ventana(){
		//Tamaño
		this.setSize(720, 630);
		//Titulo
		this.setTitle("Peludos sin hogar");
		//Posicional al centro
		this.setLocationRelativeTo(null);
		//Desactivar diseño por defecto
		this.setLayout(null);
		//Cuando se cierre la venta termina de ejecutarse el programa
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cp = new CPerro();
		cpo = new CPerrosOrdenados();
		iniciarComponentes();
	}
	
	/**
	 * Metodo para inciar componentes
	 */
	private void iniciarComponentes() {
		//JPanel
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 720, 630);
		//Cambiar color
		//Agregar panel a la ventana
		this.getContentPane().add(panel);
		
		//JLabel
		lblTitulo = new JLabel("Sistema de adopción canina");
		lblTitulo.setOpaque(true);
		lblTitulo.setBounds(150, 5, 450, 50);
		lblTitulo.setFont(new Font("Rockwell", Font.PLAIN, 32));
		
		//JComboBox
		opciones = new JComboBox<String>();
		opciones.addItem("Id");
		opciones.addItem("Nombre");
		opciones.addItem("Raza");
		opciones.addItem("Fecha nacimiento");
		opciones.setBounds(500, 100, 120, 25);
		
		//JTable
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.setBounds(10, 100, 450, 150);
		tabla1 = new JTable();
		JScrollPane JS = new JScrollPane(tabla1);
		JS.setPreferredSize(new Dimension(400, 150));
		panel2.add(JS);
		
		panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		panel3.setBounds(10, 380, 450, 150);
		tabla2 = new JTable();
		JScrollPane JS2 = new JScrollPane(tabla2);
		JS2.setPreferredSize(new Dimension(400, 150));
		panel3.add(JS2);
		
		
		//JButton
		btnOrdenar = new JButton("Ordenar");
		btnOrdenar.setBounds(510, 160, 100, 30);
		
		btnAdoptar = new JButton("Adoptar");
		btnAdoptar.setBounds(200, 300, 100, 30);
		
		btnGenerar = new JButton("Generar Archivos");
		btnGenerar.setBounds(480, 400, 150, 30);
		
		//Agregar componentes al panel principal
		panel.add(lblTitulo);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(opciones);
		panel.add(btnOrdenar);
		panel.add(btnAdoptar);
		panel.add(btnGenerar);
		
		
		//EVENTOS
		
		//evento del boton ordenar
		btnOrdenar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tabla1.setModel(cp.MostrarDatos(opciones.getSelectedItem().toString()));
				}
			});
		
		//evento del boton ordenar
		btnAdoptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int fila = tabla1.getSelectedRow();
				if (fila != -1) {
					cpo.agregarPerro(tabla1.getValueAt(fila, 0).toString(), tabla1.getValueAt(fila, 1).toString(), tabla1.getValueAt(fila, 2).toString(), tabla1.getValueAt(fila, 3).toString());
					tabla2.setModel(cpo.MostrarDatos());
				}
			}
		});
		
		//evento del boton ordenar
		btnGenerar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cpo.generarArchivos();
			}
		});
		}
		
	public static void main(String[] args) {
		Ventana v = new Ventana();
		v.setVisible(true);
		
	}
}
