package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.ShutdownChannelGroupException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import model.GestionDatos;
import model.Libro;
import view.BookView;
import view.LaunchView;

public class GestionEventos {

	private GestionDatos model;
	private LaunchView view;
	private ActionListener actionListener_comparar, actionListener_buscar, actionListener_copiar, actionListener_libreria;
	BookView frameLibreria;

	public GestionEventos(GestionDatos model, LaunchView view) {
		this.model = model;
		this.view = view;
	}

	public void contol() {
		actionListener_copiar = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				call_copiaFichero();
				
			}
			
		};
		view.getCopiar().addActionListener(actionListener_copiar);
		
		actionListener_comparar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_compararContenido
				call_compararContenido();
			}
		};
		view.getComparar().addActionListener(actionListener_comparar);

		actionListener_buscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_buscarPalabra
				call_buscarPalabra();
				
			}
		};
		view.getBuscar().addActionListener(actionListener_buscar);
		
		actionListener_libreria = new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				frameLibreria = new BookView();
				frameLibreria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frameLibreria.setVisible(true);
				
				ActionListener nuevoLibro = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						call_nuevoLibro();
					}
				};
				
				frameLibreria.getNuevoLibro().addActionListener(nuevoLibro);
				
				ActionListener	recuperarLibro = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						call_recuperarLibro();
					}
				};
				frameLibreria.getRecLibroBtn().addActionListener(recuperarLibro);
				
				ActionListener	recuperarTodos = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						call_recuperaTodos();
					}
				};
				frameLibreria.getRecTodos().addActionListener(recuperarTodos);
				
			}
			
		};
		view.getLibreria().addActionListener(actionListener_libreria);
		
		
	}
	
	public void call_recuperaTodos() {

			try {
				DefaultListModel<String> lleno = model.recTodo();
				if(lleno != null) {
					frameLibreria.getList().removeAll();
					frameLibreria.getList().setModel(lleno);
					frameLibreria.Show("Los Libros se han añadido.");
				}else {
					frameLibreria.Show("No hay libros en la carpeta.");
				}
				
			}catch(FileNotFoundException e) {
				view.showError("El directorio no existe");
			}catch (IOException e) {
				view.showError("Error de ejecucion, revisa tus permisos de lectura y escritura de este fichero");
			}catch (ClassNotFoundException e) {
				view.showError("Error de ejecucion, Problemas a la hora de leer el fichero serializado.");
			}
		
		
	}
	
	public void call_recuperarLibro() {
		if (frameLibreria.getRecLibro().getText().isEmpty()) {
			view.showError("Introduce el nombre del libro.");
		}else {
			try {
				DefaultListModel<String> list = model.recLibro(frameLibreria.getRecLibro().getText());
				frameLibreria.getList().removeAll();
				frameLibreria.getList().setModel(list);
				frameLibreria.Show("El Libro se ha añadido a tu base de datos..");
				
			}catch(FileNotFoundException e) {
				view.showError("El Libro no existe.");
			}catch (IOException e) {
				view.showError("Error de ejecucion, revisa tus permisos de lectura y escritura de este fichero");
			}catch (ClassNotFoundException e) {
				view.showError("Error de ejecucion, Problemas a la hora de leer el fichero serializado.");
			}
		}
	}
	
	private void call_nuevoLibro() {
		if(frameLibreria.getId().getText().isEmpty() || frameLibreria.getAutor().getText().isEmpty() || frameLibreria.getTitulo().getText().isEmpty() || frameLibreria.getnPaginas().getText().isEmpty() || frameLibreria.getAñoPubli().getText().isEmpty() || frameLibreria.getEditor().getText().isEmpty() ) {
			view.showError("Plena tots els camps del nou llibre correctament");
		}else {
			try {
				Libro libro = new Libro(frameLibreria.getTitulo().getText(), frameLibreria.getId().getText(), frameLibreria.getAutor().getText(), frameLibreria.getnPaginas().getText(), frameLibreria.getAñoPubli().getText(), frameLibreria.getEditor().getText());
				model.nuevoLibro(libro);
				frameLibreria.Show("El Libro se ha creado.");
			}catch(FileNotFoundException e) {
				view.showError("Uno o varios ficheros no existen");
			}catch (IOException e) {
				view.showError("Error de ejecucion, revisa tus permisos de lectura y escritura de este fichero");
			}
			
		}
	}

	protected void call_copiaFichero() {
		
		if(view.getFicheroCopia().getText().isEmpty() || view.getFicheroDestino().getText().isEmpty()) {
			view.showError("Plena els camps de Fichero para copiar y Fichero Destino");
		}else {
			try {
				 int numBytes = model.copiaFicheros(view.getFicheroCopia().getText(), view.getFicheroDestino().getText());
				 view.getTextArea().setText("El numero de Bytes copiados es: "+numBytes);
			}catch(FileNotFoundException e) {
				view.showError("Uno o varios ficheros no existen");
			} 
			catch (IOException e) {
				view.showError("Error de ejecucion, revisa tus permisos de lectura y escritura de este fichero");
			}
			
		}
		
	}

	private void call_compararContenido() {
		// TODO: Llamar a la función compararContenido de GestionDatos
		// TODO: Gestionar excepciones
		if(view.getFichero1().getText().isEmpty() || view.getFichero2().getText().isEmpty()) {
			view.showError("Plena els camps de ficher 1 y 2");
		}else {
			boolean sonIguals = false;
			try {
				sonIguals = model.compararContenido(view.getFichero1().getText(), view.getFichero2().getText());
				if(sonIguals){
					view.getTextArea().setText("Son iguals");
				}else {
					view.getTextArea().setText("No son iguals");
				}
			}catch (FileNotFoundException e) {
				view.showError("Uno o varios ficheros no existen");
			} catch (IOException e) {
				view.showError("Error de ejecucion, revisa tus permisos de lectura y escritura de los ficheros");
			}
		}
	
	}

	private void call_buscarPalabra() {
		// TODO: Llamar a la función buscarPalabra de GestionDatos
		if(view.getFichero1().getText().isEmpty() || view.getPalabra().getText().isEmpty()){
			view.showError("Rellena el campo de fichero1 y palabra");
		}else {
			try {	
				
				int fila = model.buscarPalabra(view.getFichero1().getText(),view.getPalabra().getText(), view.getPrimera().isSelected());
				String filaS = String.valueOf(fila);
				if(fila > 0) {
					view.getTextArea().setText("La paraula que busques apareix en la fila:"+filaS);
				}else{
					view.showError("No sha trovat la paraula");
				}
			} catch (FileNotFoundException e) {
				view.showError("Uno o varios ficheros no existen");
			} catch (IOException e) {
				view.showError("Error de ejecucion, revisa tus permisso de lectura y escritura del fichero");
			}
	
		}
	
	}
}
