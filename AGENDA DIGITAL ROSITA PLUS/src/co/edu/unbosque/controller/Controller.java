package co.edu.unbosque.controller;

import co.edu.unbosque.view.Interfaz;

public class Controller {

	
	 private Interfaz vista;

	    public Controller() {
	        vista = new Interfaz();
	        // Aquí deberías crear tu modelo y controlador y comunicarlos con la vista a través de interfaces
	    }

	    public void run() {
	        vista.setVisible(true);
	    }
	
	
}
