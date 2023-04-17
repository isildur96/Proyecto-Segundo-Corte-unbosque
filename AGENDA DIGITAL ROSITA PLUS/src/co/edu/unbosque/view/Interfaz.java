package co.edu.unbosque.view;


	
	import javax.swing.*;
	import java.awt.*;

	public class Interfaz extends JFrame {

	    private JTextArea textoIzquierdo;
	    private JTextArea textoDerecho;

	    public Interfaz() {
	        // Configuración de la ventana principal
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setTitle("Ejemplo MVC");
	        setSize(500, 300);
	        setLayout(new BorderLayout());

	        // Creación de los paneles
	        JPanel panelIzquierdo = new JPanel(new GridLayout(3, 1));
	        JPanel panelDerecho = new JPanel(new GridLayout(3, 1));
	        JPanel panelCentral = new JPanel(new GridLayout(1, 2));

	        // Creación de los botones del lado izquierdo
	        JButton botonIzquierdo1 = new JButton("Botón 1");
	        JButton botonIzquierdo2 = new JButton("Botón 2");
	        JButton botonIzquierdo3 = new JButton("Botón 3");

	        // Agregar los botones al panel izquierdo
	        panelIzquierdo.add(botonIzquierdo1);
	        panelIzquierdo.add(botonIzquierdo2);
	        panelIzquierdo.add(botonIzquierdo3);

	        // Creación de los botones del lado derecho
	        JButton botonDerecho1 = new JButton("Botón 1");
	        JButton botonDerecho2 = new JButton("Botón 2");
	        JButton botonDerecho3 = new JButton("Botón 3");

	        // Agregar los botones al panel derecho
	        panelDerecho.add(botonDerecho1);
	        panelDerecho.add(botonDerecho2);
	        panelDerecho.add(botonDerecho3);

	        // Creación de las áreas de texto
	        textoIzquierdo = new JTextArea();
	        textoDerecho = new JTextArea();

	        // Agregar las áreas de texto al panel central
	        panelCentral.add(textoIzquierdo);
	        panelCentral.add(textoDerecho);

	        // Agregar los paneles a la ventana principal
	        add(panelIzquierdo, BorderLayout.WEST);
	        add(panelCentral, BorderLayout.CENTER);
	        add(panelDerecho, BorderLayout.EAST);

	        setVisible(true);
	    }

	    // Getters para los componentes de la vista
	    public JTextArea getTextoIzquierdo() {
	        return textoIzquierdo;
	    }

	    public JTextArea getTextoDerecho() {
	        return textoDerecho;
	    }
	}

	

