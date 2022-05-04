package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entidades.Tiempo;

public class GUITiempo extends JFrame implements ActionListener {
	
	private JPanel panel;
	private JTextField campoHora;
	private JTextField campoMinutos;
	private JTextField campoSegundos;
	private JTextField campoCentesimas;
	private JLabel labelHora;
	private JLabel labelMinutos;
	private JLabel labelSegundos;
	private JLabel labelCentesimas;
	private JButton boton;
	
	public GUITiempo() {
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		
		panel = new JPanel();
		panel.setLayout(null);
		
		campoHora= new JTextField();
		campoMinutos= new JTextField();
		campoSegundos= new JTextField();
		campoCentesimas= new JTextField();
		
		labelHora = new JLabel("Horas:");
		labelMinutos = new JLabel("Minutos:");
		labelSegundos= new JLabel("Segundos:");
		labelCentesimas = new JLabel("Centesimas:");
		
		labelHora.setBounds(10, 10, 80, 30);
		labelMinutos.setBounds(10, 50, 80, 30);
		labelSegundos.setBounds(10, 90, 80, 30);
		labelCentesimas.setBounds(10, 130, 80, 30);
		
		campoHora.setBounds(100, 10, 150, 30);
		campoMinutos.setBounds(100, 50, 150, 30);
		campoSegundos.setBounds(100, 90, 150, 30);
		campoCentesimas.setBounds(100, 130, 150, 30);
		
		boton = new JButton("Guardar Tiempo");
		boton.setBounds(100, 160, 150, 30);
		
		boton.addActionListener(this);
		
		panel.add(labelHora);
		panel.add(labelMinutos);
		panel.add(labelSegundos);
		panel.add(labelCentesimas);
		
		panel.add(campoHora);
		panel.add(campoMinutos);
		panel.add(campoSegundos);
		panel.add(campoCentesimas);
		panel.add(boton);
		
		this.add(panel);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUITiempo app = new GUITiempo();
		app.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int horas,minutos,segundos,centesimas;
		
		horas = Integer.parseInt(campoHora.getText());
		minutos = Integer.parseInt(campoMinutos.getText());
		segundos = Integer.parseInt(campoSegundos.getText());
		centesimas = Integer.parseInt(campoCentesimas.getText());
		
		Tiempo tiempo = new Tiempo(horas, minutos, segundos, centesimas);
	}

}
