package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.plaf.synth.SynthSpinnerUI;

public class GestionDatos {

		ArrayList <Libro> libreria = new ArrayList <Libro>();
		
	public GestionDatos() {

	}

	//TODO: Implementa una función para abrir ficheros
	public Object abrirFichero(String fichero, String opcion) throws FileNotFoundException {
			File file = new File(fichero);
		if (opcion.equals("f")) {
			return file;
		}
		if(opcion.equals("fr")) {
			FileReader fR = new FileReader(file);
			return fR;
		}
		if(opcion.equals("fi")){
			FileInputStream fI = new FileInputStream(fichero);	
			return fI;
		}
		if(opcion.equals("fo")) {
			FileOutputStream fO = new FileOutputStream(fichero);
			return fO;
		}
		return null;
	}
	//TODO: Implementa una función para cerrar ficheros
	public void cerrarFichero(Object fichero, String opcion) throws IOException {
		if(opcion.equals("fr")) {
				FileReader ficherof = (FileReader) fichero;
				ficherof.close();
		}else {
				if(fichero.getClass().getName().equals("java.io.FileInputStream")) {
					FileInputStream ficheroI = (FileInputStream) fichero;
					ficheroI.close();
				}else {
					FileOutputStream ficheroO = (FileOutputStream) fichero;
					ficheroO.close();
				}
		}
	}
	
	public ArrayList sacaArrayFichero(FileReader fR) throws IOException {
		ArrayList <String> arrayFichero = new ArrayList();
		BufferedReader bR = new BufferedReader(fR);		
		String linea;
			while((linea = bR.readLine())!= null) {
				arrayFichero.add(linea);
			}
		return arrayFichero;
	} 
	
	public boolean compararContenido (String fichero1, String fichero2) throws FileNotFoundException, IOException{
		ArrayList<String> a1;
		ArrayList<String> a2;
		
		FileReader fR1 = (FileReader) abrirFichero(fichero1, "fr");
		FileReader fR2 = (FileReader) abrirFichero(fichero2, "fr");
		a1 = sacaArrayFichero(fR1);
		a2 = sacaArrayFichero(fR2);	
		cerrarFichero(fR1, "fr");
		cerrarFichero(fR2, "fr");
		
		if (a1.size() == a2.size()) {
			System.out.println(a1.size());
			System.out.println(a2.size());
			System.out.println(a1.get(0));
			System.out.println(a2.get(0));
			for(int i = 0 ; i < a1.size(); i++) {
				String linea1 = a1.get(i);
				String linea2 = a2.get(i);
				if(linea1.equals(linea2)){
	
				}else {
					i = a1.size()+1;
					return false;
				}
			}
			
		}else {
			return false;
		}
		return true;
	}
	
	public int buscarPalabra (String fichero1, String palabra, boolean primera_aparicion) throws FileNotFoundException, IOException{
		//TODO: Implementa la función
		ArrayList <String> a1;
		FileReader fR1 = (FileReader) abrirFichero(fichero1, "fr");
		a1 = sacaArrayFichero(fR1);
		cerrarFichero(fR1, "fr");
		int fila = 0;
		if (primera_aparicion){
			for (int i = 0 ; i < a1.size(); i++ ){
				if(a1.get(i).equals(palabra)){
					fila  = i+1;
					break;
				}	
			}
		}else{
			for (int i = 0 ; i < a1.size(); i++ ) {
				if(a1.get(i).equals(palabra)) {
					fila = i+1;
				}
			}
			
		}
		return fila;
	}	
	
	public int copiaFicheros (String ficheroC, String ficheroD) throws FileNotFoundException, IOException {	
		int numBytes = 0;
		File file = new File(ficheroC);
		
		FileInputStream fI = (FileInputStream) abrirFichero(ficheroC,"fi");
		FileOutputStream fO = (FileOutputStream) abrirFichero(ficheroD, "fo");
		
		//byte[] buffer = new byte[(int) file.length()];
		int b;
		int cont=0;
		
		while((b= fI.read())!=-1) {
			fO.write(b);
			cont++;
		}
		//fI.read(buffer);
		//fO.write(buffer);
		
		
		cerrarFichero(fI, "fi");
		cerrarFichero(fO, "fo");
		return cont;
		
	}
	public void nuevoLibro(Libro libro) throws FileNotFoundException, IOException {
		FileOutputStream fO = (FileOutputStream) abrirFichero(".\\Libreria\\"+libro.getTitulo()+".dat", "fo");
		ObjectOutputStream oB = new ObjectOutputStream(fO);
		oB.writeObject(libro);
		cerrarFichero(fO, "fo");
	}
	
	public DefaultListModel<String> recLibro(String nomFichero)	throws FileNotFoundException, IOException, ClassNotFoundException {
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		FileInputStream fI = (FileInputStream) abrirFichero(".\\Libreria\\"+nomFichero+".dat", "fi");
		ObjectInputStream oI = new ObjectInputStream(fI);
		Libro libro = (Libro) oI.readObject();
		libreria.add(libro);
		listModel.addElement(libro.getTitulo());
		
		cerrarFichero(fI, "fi");
		return listModel;
	}
	
	public DefaultListModel<String> recTodo() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		File file = (File) abrirFichero(".\\Libreria\\", "f");
	
		if(file.list().length <= 0) {
			return null;
			
		}else {
			
			String[] libros = file.list();
			DefaultListModel<String> listModel = new DefaultListModel();
			FileInputStream fI = null;
			
			for (int i = 0 ; i < libros.length; i ++) {
				Libro libro;
				fI = (FileInputStream) abrirFichero(".\\Libreria\\"+libros[i], "fi");
				ObjectInputStream oI = new ObjectInputStream(fI);
				libro = (Libro) oI.readObject();
				libreria.add(libro);
				listModel.addElement(libro.getTitulo());
			}
				cerrarFichero(fI, "fi");
			
		return listModel;
		}
	}
	
	

}
