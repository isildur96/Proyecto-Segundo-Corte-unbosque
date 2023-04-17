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
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import uniandes.cupi2.listaContactos.mundo.Contacto;
import uniandes.cupi2.listaContactos.mundo.ListaDeContactos;

/**
 * Ventana principal de la lista de contactos.
 */
@SuppressWarnings("serial")
public class InterfazListaDeContactos extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Lista de contactos.
     */
    private ListaDeContactos lista;

    /**
     * Panel que contiene el banner de la aplicación.
     */
    private PanelBanner panelBanner;

    /**
     * Panel para desplegar la lista de contactos.
     */
    private PanelLista panelLista;

    /**
     * Panel para mostrar la información del contacto.
     */
    private PanelContacto panelContacto;

    /**
     * Panel de opciones.
     */
    private PanelOpciones panelOpciones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la ventana principal de la aplicación.
     */
    public InterfazListaDeContactos( )
    {
        setTitle( "Lista de Contactos" );
        setSize( 550, 700 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        lista = new ListaDeContactos( );

        setLayout( new BorderLayout( ) );

        panelBanner = new PanelBanner( );
        panelLista = new PanelLista( this );
        panelContacto = new PanelContacto( this );
        panelOpciones = new PanelOpciones( this );

        JPanel centro = new JPanel( );
        centro.setLayout( new BorderLayout( ) );

        add( panelBanner, BorderLayout.NORTH );
        add( centro, BorderLayout.CENTER );
        centro.add( panelLista, BorderLayout.NORTH );
        centro.add( panelContacto, BorderLayout.CENTER );
        add( panelOpciones, BorderLayout.SOUTH );

        setLocationRelativeTo( null );
        setResizable( false );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna la lista de los nombres de todos los contactos.
     * @return Lista con nombres y apellidos de todos los contactos.
     */
    public ArrayList<String> darContactos( )
    {
        return lista.darTodosLosContactos( );
    }

    /**
     * Muestra la información del contacto seleccionado.
     */
    public void visualizarContacto( )
    {
        String nombre = panelLista.darNombreSeleccionado( );
        String apellido = panelLista.darApellidoSeleccionado( );
        if( nombre == null )
        {
            JOptionPane.showMessageDialog( this, "No ha seleccionado ningún contacto", "Lista de Contactos", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            Contacto c = lista.buscarContacto( nombre, apellido );
            if( c != null )
            {
                panelContacto.mostrarContacto( c );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "El contacto no existe", "Lista de Contactos", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    /**
     * Elimina el contacto seleccionado. <br>
     * <b>post: </b> Si el contacto existe, se elimina el contacto de la lista.
     */
    public void eliminarContacto( )
    {
        String nombre = panelLista.darNombreSeleccionado( );
        String apellido = panelLista.darApellidoSeleccionado( );
        if( nombre == null )
        {
            JOptionPane.showMessageDialog( this, "No ha seleccionado ningún contacto", "Lista de Contactos", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            boolean accion = lista.eliminarContacto( nombre, apellido );

            if( accion )
            {
                panelLista.actualizarLista( lista.darTodosLosContactos( ) );
                panelContacto.limpiarCampos( );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "No se puede eliminar el contacto", "Lista de Contactos", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    /**
     * Busca y despliega todos los contactos encontrados por una palabra clave.
     */
    public void buscarContactosPalabra( )
    {
        String palabra = JOptionPane.showInputDialog( this, "Escriba la palabra clave a buscar", "Lista de Contactos", JOptionPane.PLAIN_MESSAGE );
        if( palabra != null )
        {
            if( palabra.equals( "" ) )
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar una palabra clave", "Lista de Contactos", JOptionPane.INFORMATION_MESSAGE );
            }
            else
            {
                ArrayList<String> listaC = lista.buscarContactosPalabraClave( palabra );
                if( listaC.size( ) == 0 )
                {
                    JOptionPane.showMessageDialog( this, "No se encontraron contactos con esa palabra clave", "Lista de Contactos", JOptionPane.INFORMATION_MESSAGE );
                }
                else
                {
                    panelLista.actualizarLista( listaC );
                }
            }
        }
    }

    /**
     * Agrega un nuevo contacto a la lista, si no existe otro contacto con los mismos nombres y apellidos. <br>
     * <b>post: </b> Se agrega un nuevo contacto a la lista en caso de que éste no exista aún en ella.
     */
    public void agregarContacto( )
    {
        String nombre = panelContacto.darNombre( );
        String apellido = panelContacto.darApellido( );
        if( nombre.equals( "" ) || apellido.equals( "" ) )
        {
            JOptionPane.showMessageDialog( this, "El nombre y el apellido del contacto son requeridos", "Lista de Contactos", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            String direccion = panelContacto.darDirección( );
            String correo = panelContacto.darCorreo( );
            ArrayList<String> palabras = panelContacto.darPalabras( );
            ArrayList<String> telefonos = panelContacto.darTelefonos( );

            boolean accion = lista.agregarContacto( nombre, apellido, direccion, correo, telefonos, palabras );
            if( !accion )
            {
                JOptionPane.showMessageDialog( this, "Ya existe un contacto con el mismo nombre y apellido", "Lista de Contactos", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                panelLista.actualizarLista( lista.darTodosLosContactos( ) );
                panelContacto.limpiarCampos( );
            }
        }

    }

    /**
     * Modifica los datos de un contacto a la lista, excepto el nombre y el apellido. <br>
     * <b>post: </b> Se actualizan los datos del contacto si existe.
     */
    public void modificarContacto( )
    {
        String nombre = panelContacto.darNombre( );
        String apellido = panelContacto.darApellido( );
        if( nombre.equals( "" ) || apellido.equals( "" ) )
        {
            JOptionPane.showMessageDialog( this, "El nombre y el apellido del contacto son requeridos", "Lista de Contactos", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            String direccion = panelContacto.darDirección( );
            String correo = panelContacto.darCorreo( );
            ArrayList<String> palabras = panelContacto.darPalabras( );
            ArrayList<String> telefonos = panelContacto.darTelefonos( );

            boolean accion = lista.modificarContacto( nombre, apellido, direccion, correo, telefonos, palabras );
            if( !accion )
            {
                JOptionPane.showMessageDialog( this, "El contacto no existe. Verifique el nombre y apellido", "Lista de Contactos", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                panelLista.actualizarLista( lista.darTodosLosContactos( ) );
                panelContacto.limpiarCampos( );
            }
        }

    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Llamado al metodo1 del mundo para realizar la extensión 1. <br>
     * <b>post: </b> Se retorna el valor de la operación 1 y se muestra en pantalla.
     */
    public void reqFuncOpcion1( )
    {
        String respuesta = lista.metodo1( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Llamado al metodo2 del mundo para realizar la extensión 2. <br>
     * <b>post: </b> Se retorna el valor de la operación 2 y se muestra en pantalla.
     */
    public void reqFuncOpcion2( )
    {
        String respuesta = lista.metodo2( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Ejecuta la aplicación.
     * @param pArgs Parámetros de la ejecución. No son necesarios.
     */
    public static void main( String[] pArgs )
    {
        try
        {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

            InterfazListaDeContactos interfaz = new InterfazListaDeContactos( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}
