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
package uniandes.cupi2.listaContactos.test;

import java.util.ArrayList;
import static org.junit.Assert.*;

import org.junit.Test;
import uniandes.cupi2.listaContactos.mundo.Contacto;

/**
 * Clase de prueba del contacto
 */
public class ContactoTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Contacto para realizar pruebas
     */
    private Contacto contacto;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa los elementos necesarios para realizar las pruebas
     */
    private void setUpEscenario1( )
    {
        contacto = new Contacto( "Carolina", "Rodríguez", "Trv 25 No. 43 - 45", "crodriguez@uniandes.edu.co" );
        contacto.agregarTelefono( "6556850" );
        contacto.agregarTelefono( "4859527" );
        contacto.agregarPalabra( "Amigos" );
        contacto.agregarPalabra( "Fiesta" );

    }

    /**
     * Prueba el cambio de atributos del contacto exceptuando las listas
     */
    @Test
    public void testCambiarDatos( )
    {
        setUpEscenario1( );

        // Prueba que se el usuario se cree correctamente
        String nombre = contacto.darNombre( );
        String apellido = contacto.darApellido( );
        String direccion = contacto.darDireccion( );
        String correo = contacto.darCorreo( );
        assertTrue( "El nombre no es el correcto", nombre.equals( "Carolina" ) );
        assertTrue( "El apellido no es el correcto", apellido.equals( "Rodríguez" ) );
        assertTrue( "La dirección no es la correcta", direccion.equals( "Trv 25 No. 43 - 45" ) );
        assertTrue( "El correo no es el correcto", correo.equals( "crodriguez@uniandes.edu.co" ) );

        // prueba para verificar que los cambios se hacen correctamente
        contacto.cambiarDireccion( "Cll 45 a No 45 - 23" );
        contacto.cambiarCorreo( "carito2005@hotmail.com" );

        nombre = contacto.darNombre( );
        apellido = contacto.darApellido( );
        direccion = contacto.darDireccion( );
        correo = contacto.darCorreo( );
        assertTrue( "El nombre no es el correcto", nombre.equals( "Carolina" ) );
        assertTrue( "El apellido no es el correcto", apellido.equals( "Rodríguez" ) );
        assertTrue( "La dirección no es la correcta", direccion.equals( "Cll 45 a No 45 - 23" ) );
        assertTrue( "El correo no es el correcto", correo.equals( "carito2005@hotmail.com" ) );
    }

    /**
     * Prueba que se agregue correctamente un teléfono a la lista
     */
    @Test
    public void testAgregarTelefono( )
    {
        setUpEscenario1( );
        contacto.agregarTelefono( "22140732" );
        ArrayList<String> telefonos = contacto.darTelefonos( );
        String tel1 = ( String )telefonos.get( 0 );
        String tel2 = ( String )telefonos.get( 1 );
        String tel3 = ( String )telefonos.get( 2 );
        assertTrue( "No se agregó correctamente el teléfono", tel1.equals( "6556850" ) && tel2.equals( "4859527" ) && tel3.equals( "22140732" ) );

    }

    /**
     * Prueba que se agregue correctamente una palabra a la lista
     */
    @Test
    public void testAgregarPalabra( )
    {
        setUpEscenario1( );
        contacto.agregarPalabra( "Carito" );
        ArrayList<String> palabras = contacto.darPalabras( );
        String pal1 = ( String )palabras.get( 0 );
        String pal2 = ( String )palabras.get( 1 );
        String pal3 = ( String )palabras.get( 2 );
        assertTrue( "No se agregó correctamente la palabra", pal1.equals( "Amigos" ) && pal2.equals( "Fiesta" ) && pal3.equals( "Carito" ) );
    }

    /**
     * Prueba que se elimine correctamente un elemento de la lista
     */
    @Test
    public void testElimiinarTelefono( )
    {
        setUpEscenario1( );
        contacto.eliminarTelefono( "6556850" );
        ArrayList<String> telefonos = contacto.darTelefonos( );
        String tel1 = ( String )telefonos.get( 0 );
        assertTrue( "No se eliminó correctamente el teléfono", tel1.equals( "4859527" ) && telefonos.size( ) == 1 );

    }

    /**
     * Prueba que se elimine correctamente una palabra de la lista
     */
    @Test
    public void testEliminarPalabra( )
    {
        setUpEscenario1( );
        contacto.eliminarPalabra( "Fiesta" );
        ArrayList<String> palabras = contacto.darPalabras( );
        String pal1 = ( String )palabras.get( 0 );
        assertTrue( "No se eliminó correctamente la palabra", pal1.equals( "Amigos" ) && palabras.size( ) == 1 );

    }

    /**
     * Prueba que verifique que una palabra clave se encuentre registrada para el contacto
     */
    @Test
    public void testVerificarPalabra( )
    {
        setUpEscenario1( );
        assertTrue( contacto.contienePalabraClave( "Fiesta" ) );
        assertFalse( contacto.contienePalabraClave( "Fiestica" ) );
    }

}
