package co.edu.unbosque.model;

import java.io.Serializable;

public class Contacto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String empresa;
	private String pais; 
	private String telManager;
	private String correo;
	
	
	public Contacto(String nombre, String empresa, String pais, String telManager, String correo) {
		super();
		this.nombre = nombre;
		this.empresa = empresa;
		this.pais = pais;
		this.telManager = telManager;
		this.correo = correo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public String getTelManager() {
		return telManager;
	}


	public void setTelManager(String telManager) {
		this.telManager = telManager;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	
}
