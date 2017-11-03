package view;

import java.awt.Dimension;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookView extends JFrame {
	
	private	JPanel panel;
	private JTextField id;
	private JTextField titulo;
	private JTextField autor;
	private JTextField añoPubli;
	private JTextField editor;
	private JTextField nPaginas;
	private JButton nuevoLibro;
	private JTextField recLibro;
	private JButton recTodos;
	private JList list;
	JButton recLibroBtn;
	
	public BookView() {
		
		setBounds(200,200,1000,450);
		setTitle("Proyecto Buffers");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JLabel ID = new JLabel("ID");
		panel_1.add(ID);
		
		id = new JTextField();
		panel_1.add(id);
		id.setColumns(10);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_4);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo");
		panel_1.add(lblNewLabel_1);
		
		titulo = new JTextField();
		panel_1.add(titulo);
		titulo.setColumns(10);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_3);
		
		JLabel lblNewLabel_2 = new JLabel("Autor");
		panel_1.add(lblNewLabel_2);
		
		autor = new JTextField();
		panel_1.add(autor);
		autor.setColumns(10);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_2);
		
		JLabel lblNewLabel_3 = new JLabel("A\u00F1o de Publicacion");
		panel_1.add(lblNewLabel_3);
		
		añoPubli = new JTextField();
		panel_1.add(añoPubli);
		añoPubli.setColumns(10);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_1);
		
		JLabel lblNewLabel_4 = new JLabel("Editorial");
		panel_1.add(lblNewLabel_4);
		
		editor = new JTextField();
		panel_1.add(editor);
		editor.setColumns(10);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut);
		
		JLabel lblNewLabel_5 = new JLabel("N. Paginas");
		panel_1.add(lblNewLabel_5);
		
		nPaginas = new JTextField();
		panel_1.add(nPaginas);
		nPaginas.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.NORTH);
		
		nuevoLibro = new JButton("A\u00F1adir Nuevo Lbro");
		nuevoLibro.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(nuevoLibro);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(80);
		panel_2.add(horizontalStrut_3);
		
		recLibroBtn = new JButton("Recuperar Libro");
		panel_2.add(recLibroBtn);
		
		recLibro = new JTextField();
		panel_2.add(recLibro);
		recLibro.setColumns(10);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(120);
		panel_2.add(horizontalStrut_4);
		
		recTodos = new JButton("Recuperar Todos ");
		panel_2.add(recTodos);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(450);
		panel_2.add(horizontalStrut_2);
		
		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3, BorderLayout.SOUTH);
		
		JPanel panel_4 = new JPanel();
		getContentPane().add(panel_4, BorderLayout.WEST);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_4.add(horizontalStrut);
		
		JPanel panel_5 = new JPanel();
		getContentPane().add(panel_5, BorderLayout.EAST);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel = new JLabel("Libros a\u00F1adidos al Array");
		panel_5.add(lblNewLabel);
		
		list = new JList();
		panel_5.add(list);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(600);
		panel_5.add(horizontalStrut_1);
		panel = new JPanel();
		
	}
	public void Show(String texto) {
		JOptionPane.showMessageDialog(this, texto);
	}
	
	


	public JList getList() {
		return list;
	}
	public void setList(JList list) {
		this.list = list;
	}
	public JButton getRecLibroBtn() {
		return recLibroBtn;
	}
	public void setRecLibroBtn(JButton recLibroBtn) {
		this.recLibroBtn = recLibroBtn;
	}
	public JButton getRecTodos() {
		return recTodos;
	}
	public void setRecTodos(JButton recTodos) {
		this.recTodos = recTodos;
	}

	public JPanel getPanel() {
		return panel;
	}


	public void setPanel(JPanel panel) {
		this.panel = panel;
	}


	public JTextField getId() {
		return id;
	}


	public void setId(JTextField id) {
		this.id = id;
	}


	public JTextField getTitulo() {
		return titulo;
	}


	public void setTitulo(JTextField titulo) {
		this.titulo = titulo;
	}


	public JTextField getAutor() {
		return autor;
	}


	public void setAutor(JTextField autor) {
		this.autor = autor;
	}


	public JTextField getAñoPubli() {
		return añoPubli;
	}


	public void setAñoPubli(JTextField añoPubli) {
		this.añoPubli = añoPubli;
	}


	public JTextField getEditor() {
		return editor;
	}


	public void setEditor(JTextField editor) {
		this.editor = editor;
	}


	public JTextField getnPaginas() {
		return nPaginas;
	}


	public void setnPaginas(JTextField nPaginas) {
		this.nPaginas = nPaginas;
	}


	public JButton getNuevoLibro() {
		return nuevoLibro;
	}


	public void setNuevoLibro(JButton nuevoLibro) {
		this.nuevoLibro = nuevoLibro;
	}


	public JTextField getRecLibro() {
		return recLibro;
	}


	public void setRecLibro(JTextField recLibro) {
		this.recLibro = recLibro;
	}
	
	
}
