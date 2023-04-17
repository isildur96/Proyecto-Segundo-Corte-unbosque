package co.edu.unbosque.model;

import java.io.Serializable;

public class Amigo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String pais;
	private String telefono;
	private String email;
	
	
	public Amigo(String nombre, String pais, String telefono, String email) {
		super();
		this.nombre = nombre;
		this.pais = pais;
		this.telefono = telefono;
		this.email = email;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
