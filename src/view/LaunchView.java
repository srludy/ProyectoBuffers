package view;

import java.awt.Dimension;

import javax.swing.*;

public class LaunchView extends JFrame {

	private JButton comparar,buscar,copiar,libreria;
	private JTextArea textArea;
	private JTextField fichero1,fichero2,palabra,ficheroCopia,ficheroDestino;
	private JLabel label_f1,label_f2,label_pal,label_C,label_D;
	private JCheckBox primera;
	
	
	private JPanel panel;
	
	public LaunchView() {
		
		setBounds(200,200,1000,450);
		setTitle("Proyecto Buffers");	
		panel = new JPanel();
		
		comparar = new JButton("Comparar contenido");
		comparar.setPreferredSize(new Dimension(150, 26));
		buscar = new JButton("Buscar palabra");
		buscar.setPreferredSize(new Dimension(150, 26));
		copiar = new JButton("Copiar");
		libreria = new JButton("Libreria");
					
		fichero1 = new JTextField("",10);
		fichero2 = new JTextField("",10);
		palabra = new JTextField("",10);
		ficheroCopia = new JTextField("",10);
		ficheroDestino = new JTextField("",10);
		
		
		label_f1 = new JLabel("Fichero 1:");
		label_f2 = new JLabel("Fichero 2:");
		label_pal = new JLabel("Palabra:");
		label_C = new JLabel("Fichero para copiar");
		label_D = new JLabel("Fichero donde se copiara");
		
		
		
		primera = new JCheckBox("Primera aparición");

		textArea = new JTextArea(20, 80);
		textArea.setBounds(50,50,50,50);
		textArea.setEditable(false);		
		
		panel.add(comparar);
		panel.add(buscar);
		panel.add(label_f1);
		panel.add(fichero1);
		panel.add(label_f2);
		panel.add(fichero2);
		panel.add(label_pal);
		panel.add(palabra);
		panel.add(primera);
		panel.add(copiar);
		panel.add(label_C);
		panel.add(ficheroCopia);
		panel.add(label_D);
		panel.add(ficheroDestino);
		panel.add(textArea);
		panel.add(libreria);
		
        // Añadimos el JPanel al JFrame
        this.getContentPane().add(panel);		
		
	}	
	
	
	public JButton getLibreria() {
		return libreria;
	}


	public void setLibreria(JButton libreria) {
		this.libreria = libreria;
	}


	public JTextField getFicheroCopia() {
		return ficheroCopia;
	}

	public void setFicheroCopia(JTextField ficheroCopia) {
		this.ficheroCopia = ficheroCopia;
	}

	public JTextField getFicheroDestino() {
		return ficheroDestino;
	}

	public void setFicheroDestino(JTextField ficheroDestino) {
		this.ficheroDestino = ficheroDestino;
	}

	public JButton getCopiar() {
		return copiar;
	}

	public void setCopiar(JButton copiar) {
		this.copiar = copiar;
	}

	public JCheckBox getPrimera() {
		return primera;
	}

	public void setPrimera(JCheckBox primera) {
		this.primera = primera;
	}

	public JButton getComparar() {
		return comparar;
	}

	public void setComparar(JButton comparar) {
		this.comparar = comparar;
	}

	public JButton getBuscar() {
		return buscar;
	}

	public JTextField getPalabra() {
		return palabra;
	}

	public void setPalabra(JTextField palabra) {
		this.palabra = palabra;
	}

	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
			
	public JTextField getFichero1() {
		return fichero1;
	}

	public void setFichero1(JTextField fichero1) {
		this.fichero1 = fichero1;
	}

	public JTextField getFichero2() {
		return fichero2;
	}

	public void setFichero2(JTextField fichero2) {
		this.fichero2 = fichero2;
	}

	public void showError(String m){
		JOptionPane.showMessageDialog(this.panel,
			    m,
			    "Error",
			    JOptionPane.ERROR_MESSAGE);
	}


}