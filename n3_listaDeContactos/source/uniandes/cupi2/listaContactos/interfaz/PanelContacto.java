/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_listaDeContactos
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.listaContactos.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.listaContactos.mundo.Contacto;

/**
 * Panel para visualizar los datos de un contacto seleccionado.
 */
@SuppressWarnings("serial")
public class PanelContacto extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante usada para indicar que se quiere limpiar la pantalla.
     */
    private final static String LIMPIAR = "LIMPIAR";

    /**
     * Constante usada para indicar que se quiere agregar el contacto.
     */
    private final static String AGREGAR = "AGREGAR";

    /**
     * Constante usada para indicar que se quiere modificar el contacto.
     */
    private final static String MODIFICAR = "MODIFICAR";

    /**
     * Constante usada para indicar que se quiere agregar un teléfono a la lista.
     */
    private final static String AGREGAR_TELEFONO = "AGREGAR_TELEFONO";

    /**
     * Constante usada para indicar que se quiere eliminar un teléfono de la lista.
     */
    private final static String ELIMINAR_TELEFONO = "ELIMINAR_TELEFONO";

    /**
     * Constante usada para indicar que se quiere agregar una palabra a la lista.
     */
    private final static String AGREGAR_PALABRA = "AGREGAR_PALABRA";

    /**
     * Constante usada para indicar que se quiere eliminar una palabra de la lista.
     */
    private final static String ELIMINAR_PALABRA = "ELIMINAR_PALABRA";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * La ventana principal de la aplicación.
     */
    private InterfazListaDeContactos principal;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblDireccion;
    private JLabel lblCorreo;

    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDireccion;
    private JTextField txtCorreo;

    private JList<String> listaTelefonos;
    private JList<String> listaPalabras;

    private JButton btnLimpiar;
    private JButton btnAgregar;
    private JButton btnModificar;

    private JButton btnAgregaPalabra;
    private JButton btnEliminaPalabra;
    private JButton btnAgregaTelefono;
    private JButton btnEliminaTelefono;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel para visualizar, modificar y crear contactos nuevos.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelContacto( InterfazListaDeContactos pPrincipal )
    {
        principal = pPrincipal;
        setLayout( new BorderLayout( ) );
        setBorder( new TitledBorder( "Datos Personales del Contacto" ) );

        // Inicializa y organiza los elementos de datos principales del contacto
        organizarDatos( );

        // Inicializa y organiza los elementos de los botones del panel
        organizarBotones( );

        // Organiza e inicializa las listas de teléfonos y palabras clave del
        // contacto
        organizarListas( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa y organiza los elementos de los botones del panel.
     */
    private void organizarBotones( )
    {
        JPanel panelBotones = new JPanel( );

        btnAgregar = new JButton( );
        btnAgregar.setText( "Agregar Contacto" );
        btnAgregar.setActionCommand( AGREGAR );
        btnAgregar.addActionListener( this );

        btnModificar = new JButton( );
        btnModificar.setText( "Modificar Contacto" );
        btnModificar.setActionCommand( MODIFICAR );
        btnModificar.addActionListener( this );

        btnLimpiar = new JButton( );
        btnLimpiar.setText( "Limpiar" );
        btnLimpiar.setActionCommand( LIMPIAR );
        btnLimpiar.addActionListener( this );

        panelBotones.add( btnAgregar );

        // Agregar espacios vacios entre los botones
        panelBotones.add( btnModificar );
        panelBotones.add( btnLimpiar );

        add( panelBotones, BorderLayout.SOUTH );
    }

    /**
     * Inicializa y organiza los elementos de los datos principales del contacto.
     */
    private void organizarDatos( )
    {
        JPanel panelDatos = new JPanel( );
        panelDatos.setBorder( BorderFactory.createEmptyBorder( 20, 5, 20, 5 ) );
        panelDatos.setLayout( new GridLayout( 4, 2, 1, 10 ) );

        lblNombre = new JLabel( "Nombre" );
        lblApellido = new JLabel( "Apellido" );
        lblDireccion = new JLabel( "Dirección" );
        lblCorreo = new JLabel( "Correo Electrónico" );

        txtNombre = new JTextField( 10 );
        txtApellido = new JTextField( 10 );
        txtDireccion = new JTextField( 10 );
        txtCorreo = new JTextField( 10 );

        panelDatos.add( lblNombre );
        panelDatos.add( txtNombre );
        panelDatos.add( lblApellido );
        panelDatos.add( txtApellido );
        panelDatos.add( lblDireccion );
        panelDatos.add( txtDireccion );
        panelDatos.add( lblCorreo );
        panelDatos.add( txtCorreo );

        add( panelDatos, BorderLayout.CENTER );
    }

    /**
     * Organiza e inicializa la lista de teléfonos del contacto.
     */
    private void organizarListas( )
    {
        // Lista de teléfonos

        JPanel panelTelefonos = new JPanel( );
        panelTelefonos.setLayout( new BorderLayout( ) );
        panelTelefonos.setBorder( new TitledBorder( "Teléfonos" ) );

        JScrollPane deslizableTelefonos = new JScrollPane( );
        listaTelefonos = new JList<String>( );
        deslizableTelefonos.setPreferredSize( new Dimension( 150, 0 ) );
        deslizableTelefonos.setViewportView( listaTelefonos );
        deslizableTelefonos.setVerticalScrollBarPolicy( javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        deslizableTelefonos.setHorizontalScrollBarPolicy( javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        listaTelefonos.setModel( new DefaultListModel<String>( ) );

        btnAgregaTelefono = new JButton( "Agregar" );
        btnAgregaTelefono.setActionCommand( AGREGAR_TELEFONO );
        btnAgregaTelefono.addActionListener( this );

        btnEliminaTelefono = new JButton( "Eliminar" );
        btnEliminaTelefono.setActionCommand( ELIMINAR_TELEFONO );
        btnEliminaTelefono.addActionListener( this );

        JPanel panBotTelefonos = new JPanel( new GridLayout( 3, 1 ) );
        panBotTelefonos.add( btnAgregaTelefono );
        panBotTelefonos.add( new JLabel( ) );
        panBotTelefonos.add( btnEliminaTelefono );

        panelTelefonos.add( deslizableTelefonos, BorderLayout.CENTER );
        panelTelefonos.add( panBotTelefonos, BorderLayout.EAST );

        // Lista de palabras

        JPanel panelPalabras = new JPanel( );
        panelPalabras.setLayout( new BorderLayout( ) );
        panelPalabras.setBorder( new TitledBorder( "Palabras Clave" ) );

        JScrollPane deslizablePalabras = new JScrollPane( );
        listaPalabras = new JList<String>( );
        deslizablePalabras.setPreferredSize( new Dimension( 150, 0 ) );
        deslizablePalabras.setViewportView( listaPalabras );
        deslizablePalabras.setVerticalScrollBarPolicy( javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        deslizablePalabras.setHorizontalScrollBarPolicy( javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        listaPalabras.setModel( new DefaultListModel<String>( ) );

        btnAgregaPalabra = new JButton( "Agregar" );
        btnAgregaPalabra.setActionCommand( AGREGAR_PALABRA );
        btnAgregaPalabra.addActionListener( this );

        btnEliminaPalabra = new JButton( "Eliminar" );
        btnEliminaPalabra.setActionCommand( ELIMINAR_PALABRA );
        btnEliminaPalabra.addActionListener( this );

        JPanel panBotPalabras = new JPanel( new GridLayout( 3, 1 ) );
        panBotPalabras.add( btnAgregaPalabra );
        panBotPalabras.add( new JLabel( ) );
        panBotPalabras.add( btnEliminaPalabra );

        panelPalabras.add( deslizablePalabras, BorderLayout.CENTER );
        panelPalabras.add( panBotPalabras, BorderLayout.EAST );

        JPanel panelListas = new JPanel( new GridLayout( 2, 1 ) );
        panelListas.add( panelTelefonos );
        panelListas.add( panelPalabras );

        add( panelListas, BorderLayout.EAST );
    }

    /**
     * Retorna el nombre del formulario.
     * @return Nombre.
     */
    public String darNombre( )
    {
        return txtNombre.getText( ).trim( );
    }
    /**
     * Retorna el apellido del formulario.
     * @return Apellido.
     */
    public String darApellido( )
    {
        return txtApellido.getText( ).trim( );
    }
    /**
     * Retorna la dirección del formulario.
     * @return Dirección.
     */
    public String darDirección( )
    {
        return txtDireccion.getText( ).trim( );
    }
    /**
     * Retorna el correo del formulario.
     * @return Correo.
     */
    public String darCorreo( )
    {
        return txtCorreo.getText( ).trim( );
    }
    /**
     * Retorna la lista de palabras del contacto.
     * @return La lista de palabras.
     */
    public ArrayList<String> darPalabras( )
    {
        int contador = 0;
        ArrayList<String> palabras = new ArrayList<String>( );
        while( contador < listaPalabras.getModel( ).getSize( ) )
        {
            palabras.add( listaPalabras.getModel( ).getElementAt( contador ) );
            contador++;
        }
        return palabras;
    }

    /**
     * Retorna la lista de teléfonos del contacto.
     * @return La lista de teléfonos.
     */
    public ArrayList<String> darTelefonos( )
    {
        int contador = 0;
        ArrayList<String> telfs = new ArrayList<String>( );
        while( contador < listaTelefonos.getModel( ).getSize( ) )
        {
            telfs.add( listaTelefonos.getModel( ).getElementAt( contador ) );
            contador++;
        }
        return telfs;
    }

    /**
     * Limpia los campos del panel.
     */
    public void limpiarCampos( )
    {
        listaTelefonos.setModel( new DefaultListModel<String>( ) );
        listaPalabras.setModel( new DefaultListModel<String>( ) );
        txtNombre.setText( "" );
        txtApellido.setText( "" );
        txtDireccion.setText( "" );
        txtCorreo.setText( "" );
    }

    /**
     * Agrega un teléfono a la lista.
     */
    private void agregarTelefono( )
    {
        String telefono = JOptionPane.showInputDialog( this, "Escriba el nuevo teléfono", "Nuevo Teléfono", JOptionPane.PLAIN_MESSAGE );

        DefaultListModel<String> dlf = new DefaultListModel<String>( );
        int contador = 0;
        while( contador < listaTelefonos.getModel( ).getSize( ) )
        {
            dlf.addElement( listaTelefonos.getModel( ).getElementAt( contador ) );
            contador++;
        }
        dlf.addElement( telefono );
        listaTelefonos.setModel( dlf );

    }

    /**
     * Agrega una nueva palabra a la lista.
     */
    private void agregarPalabra( )
    {
        String palabra = JOptionPane.showInputDialog( this, "Escriba la nueva palabra clave", "Nueva Palabra", JOptionPane.PLAIN_MESSAGE );
        DefaultListModel<String> dlf = new DefaultListModel<String>( );
        int contador = 0;
        while( contador < listaPalabras.getModel( ).getSize( ) )
        {
            dlf.addElement( listaPalabras.getModel( ).getElementAt( contador ) );
            contador++;
        }
        dlf.addElement( palabra );
        listaPalabras.setModel( dlf );
    }

    /**
     * Elimina un teléfono de la lista.
     */
    private void eliminarTelefono( )
    {
        String telefono = ( String )listaTelefonos.getSelectedValue( );
        if( telefono == null )
        {
            JOptionPane.showMessageDialog( this, "Debe seleccionar un teléfono", "Lista de Contactos", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            DefaultListModel<String> dlf = new DefaultListModel<String>( );
            int contador = 0;
            while( contador < listaTelefonos.getModel( ).getSize( ) )
            {
                String elemento = ( String )listaTelefonos.getModel( ).getElementAt( contador );
                if( !elemento.equals( telefono ) )
                {
                    dlf.addElement( listaTelefonos.getModel( ).getElementAt( contador ) );
                }
                contador++;
            }
            listaTelefonos.setModel( dlf );
        }
    }

    /**
     * Elimina una palabra de la lista.
     */
    private void eliminarPalabra( )
    {
        String palabra = ( String )listaPalabras.getSelectedValue( );
        if( palabra == null )
        {
            JOptionPane.showMessageDialog( this, "Debe seleccionar una palabra", "Lista de Contactos", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            DefaultListModel<String> dlf = new DefaultListModel<String>( );
            int contador = 0;
            while( contador < listaPalabras.getModel( ).getSize( ) )
            {
                String elemento = ( String )listaPalabras.getModel( ).getElementAt( contador );
                if( !elemento.equals( palabra ) )
                {
                    dlf.addElement( listaPalabras.getModel( ).getElementAt( contador ) );
                }
                contador++;
            }
            listaPalabras.setModel( dlf );
        }
    }

    /**
     * Actualiza la lista de teléfonos con los elementos del arrayList.
     * @param lista La nueva lista de teléfonos para mostrar.
     */
    private void actualizarListaTelefonos( ArrayList<String> pLista )
    {
        DefaultListModel<String> dlf = new DefaultListModel<String>( );

        int contador = 0;
        while( contador < pLista.size( ) )
        {
            String tel = ( String )pLista.get( contador );
            dlf.addElement( tel );
            contador++;
        }

        listaTelefonos.setModel( dlf );

    }

    /**
     * Actualiza la lista de palabras con los elementos del arrayList.
     * @param lista La nueva lista de palabras para mostrar.
     */
    private void actualizarListaPalabras( ArrayList<String> pLista )
    {
        DefaultListModel<String> dlf = new DefaultListModel<String>( );

        int contador = 0;
        while( contador < pLista.size( ) )
        {
            dlf.addElement( pLista.get( contador ) );
            contador++;
        }

        listaPalabras.setModel( dlf );
    }

    /**
     * Muestra la información del contacto dado.
     * @param pContacto Contacto a mostrar.
     */
    public void mostrarContacto( Contacto pContacto )
    {
        txtNombre.setText( pContacto.darNombre( ) );
        txtApellido.setText( pContacto.darApellido( ) );
        txtDireccion.setText( pContacto.darDireccion( ) );
        txtCorreo.setText( pContacto.darCorreo( ) );
        actualizarListaPalabras( pContacto.darPalabras( ) );
        actualizarListaTelefonos( pContacto.darTelefonos( ) );
    }

    /**
     * Recibe los eventos realizados en los elementos de la interfaz y realiza acciones.
     * @param pEvento El evento realizado por el usuario. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( AGREGAR ) )
        {
            principal.agregarContacto( );
        }
        else if( comando.equals( MODIFICAR ) )
        {
            principal.modificarContacto( );
        }
        else if( comando.equals( LIMPIAR ) )
        {
            limpiarCampos( );
        }
        else if( comando.equals( AGREGAR_TELEFONO ) )
        {
            agregarTelefono( );
        }
        else if( comando.equals( AGREGAR_PALABRA ) )
        {
            agregarPalabra( );
        }
        else if( comando.equals( ELIMINAR_TELEFONO ) )
        {
            eliminarTelefono( );
        }
        else if( comando.equals( ELIMINAR_PALABRA ) )
        {
            eliminarPalabra( );
        }
    }
}
