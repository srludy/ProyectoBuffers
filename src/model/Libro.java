package model;

import java.io.Serializable;

public class Libro implements Serializable{
	String titulo ;
	String identificador;
	String autor;
	String numPaginas;
	String a�oPub;
	String editorial;
	
	public Libro(String titulo, String identificador, String autor, String numPaginas, String a�oPub, String editorial) {
		super();
		this.titulo = titulo;
		this.identificador = identificador;
		this.autor = autor;
		this.numPaginas = numPaginas;
		this.a�oPub = a�oPub;
		this.editorial = editorial;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(String numPaginas) {
		this.numPaginas = numPaginas;
	}

	public String getA�oPub() {
		return a�oPub;
	}

	public void setA�oPub(String a�oPub) {
		this.a�oPub = a�oPub;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	

}
