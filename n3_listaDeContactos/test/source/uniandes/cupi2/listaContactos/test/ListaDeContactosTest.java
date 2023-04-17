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
import uniandes.cupi2.listaContactos.mundo.ListaDeContactos;

/**
 * Clase de prueba de la lista de contactos
 */
public class ListaDeContactosTest
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Contacto1 para realizar pruebas
     */
    private Contacto contacto1;

    /**
     * Contacto2 para realizar pruebas
     */
    private Contacto contacto2;

    /**
     * Contacto3 para realizar pruebas
     */
    private Contacto contacto3;

    /**
     * Lista de contactos para realizar pruebas
     */
    private ListaDeContactos lista;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa los elementos para las pruebas
     */
    public void setUpEscenario1( )
    {
        contacto1 = new Contacto( "Carolina", "Rodríguez", "Trv 25 No. 43 - 45", "crodriguez@uniandes.edu.co" );
        contacto1.agregarTelefono( "6556850" );
        contacto1.agregarTelefono( "4859527" );
        contacto1.agregarPalabra( "Amigos" );
        contacto1.agregarPalabra( "Fiesta" );

        contacto2 = new Contacto( "Camila", "Borrero", "Cll 56 No. 67 - 76", "cborrero@uniandes.edu.co" );
        contacto2.agregarTelefono( "6456787" );
        contacto2.agregarTelefono( "5678765" );
        contacto2.agregarPalabra( "Amigas" );
        contacto2.agregarPalabra( "Fiesta" );

        contacto3 = new Contacto( "Mauricio", "Sánchez", "Av 24 No. 6 - 32", "msanchez@msanchez.com" );
        contacto3.agregarTelefono( "6785465" );
        contacto3.agregarPalabra( "Papa" );
        contacto3.agregarPalabra( "Familia" );

        lista = new ListaDeContactos( );
        lista.agregarContacto( contacto1.darNombre( ), contacto1.darApellido( ), contacto1.darDireccion( ), contacto1.darCorreo( ), contacto1.darTelefonos( ), contacto1.darPalabras( ) );
        lista.agregarContacto( contacto2.darNombre( ), contacto2.darApellido( ), contacto2.darDireccion( ), contacto2.darCorreo( ), contacto2.darTelefonos( ), contacto2.darPalabras( ) );
        lista.agregarContacto( contacto3.darNombre( ), contacto3.darApellido( ), contacto3.darDireccion( ), contacto3.darCorreo( ), contacto3.darTelefonos( ), contacto3.darPalabras( ) );
    }

    /**
     * Prueba el obtener todos los elementos
     */
    @Test
    public void testDarTodosLosContactos( )
    {
        setUpEscenario1( );
        ArrayList<String> contactos = lista.darTodosLosContactos( );
        String strCon1 = ( String )contactos.get( 0 );
        String strCon2 = ( String )contactos.get( 1 );
        String strCon3 = ( String )contactos.get( 2 );

        assertTrue( "La lista no se armó correctamente", strCon1.equals( "Carolina Rodríguez" ) && strCon2.equals( "Camila Borrero" ) && strCon3.equals( "Mauricio Sánchez" ) );

    }

    /**
     * Prueba la búsqueda de elementos por palabra
     */
    @Test
    public void testDarContactosPalabra( )
    {
        setUpEscenario1( );

        // búsqueda de más de 1 elemento
        ArrayList<String> contactos = lista.buscarContactosPalabraClave( "Fiesta" );
        String strCon1 = ( String )contactos.get( 0 );
        String strCon2 = ( String )contactos.get( 1 );

        assertTrue( "La lista no está armada correctamente", strCon1.equals( "Carolina Rodríguez" ) && strCon2.equals( "Camila Borrero" ) && contactos.size( ) == 2 );

        // búsqueda de un elemento
        contactos = lista.buscarContactosPalabraClave( "Familia" );
        strCon1 = ( String )contactos.get( 0 );

        assertTrue( "La lista no está armada correctamente", strCon1.equals( "Mauricio Sánchez" ) && contactos.size( ) == 1 );

        // búsqueda por nombre
        contactos = lista.buscarContactosPalabraClave( "Camila" );
        strCon1 = ( String )contactos.get( 0 );

        assertTrue( "La lista no está armada correctamente", strCon1.equals( "Camila Borrero" ) && contactos.size( ) == 1 );
    }

    /**
     * Prueba que los contactos se recuperen correctamente
     */
    @Test
    public void testBuscarContactoExistente( )
    {
        setUpEscenario1( );
        Contacto c = lista.buscarContacto( "Camila", "Borrero" );
        assertNotNull( c );
        assertEquals( "Camila", c.darNombre( ) );
        assertEquals( "Borrero", c.darApellido( ) );
        ArrayList<String> telefonos = c.darTelefonos( );
        assertEquals( 2, telefonos.size( ) );
        ArrayList<String> palabras = c.darPalabras( );
        assertEquals( 4, palabras.size( ) );
        assertEquals( "6456787", ( String )telefonos.get( 0 ) );
        assertEquals( "5678765", ( String )telefonos.get( 1 ) );
        assertEquals( "Amigas", ( String )palabras.get( 0 ) );
        assertEquals( "Fiesta", ( String )palabras.get( 1 ) );
    }

    /**
     * Prueba que que la búsqueda de un contacto que no existe retorne null
     */
    @Test
    public void testBuscarContactoInexistente( )
    {
        setUpEscenario1( );
        Contacto c = lista.buscarContacto( "Pedro", "Pérez" );
        assertNull( c );
    }

    /**
     * Prueba que no se agregue un usuario cuyo nombre y apellido ya existen en la lista
     */
    @Test
    public void testAgregarContacto( )
    {
        setUpEscenario1( );

        contacto1 = new Contacto( "Mauricio", "Sánchez", "Av 24 No. 6 - 34", "msanchez1@msanchez.com" );
        boolean accion = lista.agregarContacto( contacto1.darNombre( ), contacto1.darApellido( ), contacto1.darDireccion( ), contacto1.darCorreo( ), contacto1.darTelefonos( ), contacto1.darPalabras( ) );
        assertFalse( "No se puede agregar un contacto con el nombre y apellidos de uno ya existente", accion );

    }

    /**
     * Prueba la eliminación de contactos
     */
    @Test
    public void testEliminarContacto( )
    {
        setUpEscenario1( );

        // prueba la eliminación de un contacto no existente
        boolean accion = lista.eliminarContacto( "Diana", "Puentes" );
        assertTrue( "No se puede eliminar un contacto no existente", accion == false );

        // prueba la eliminación de un contacto existente
        lista.eliminarContacto( "Mauricio", "Sánchez" );
        ArrayList<String> conts = lista.buscarContactosPalabraClave( "Familia" );
        assertTrue( "No se elimino correctamente el contacto", conts.size( ) == 0 );

    }

    /**
     * Prueba la modificación de elementos
     */
    @Test
    public void testModificarContacto( )
    {
        setUpEscenario1( );

        // Modificación de un elemento no existente
        contacto1 = new Contacto( "Pedro", "Sánchez", "Av 24 No. 6 - 34", "msanchez1@msanchez.com" );

        boolean accion = lista.modificarContacto( contacto1.darNombre( ), contacto1.darApellido( ), contacto1.darDireccion( ), contacto1.darCorreo( ), contacto1.darTelefonos( ), contacto1.darPalabras( ) );
        assertFalse( "No se puede modificar un contacto no existente", accion );

        // Modificación de un elemento existente
        ArrayList<String> telefonos1 = new ArrayList<String>( );
        ArrayList<String> palabras1 = new ArrayList<String>( );

        lista.modificarContacto( "Mauricio", "Sánchez", "Av 24 No. 6 - 44", "msanchez1@msanchez.com", telefonos1, palabras1 );

        Contacto c = lista.buscarContacto( "Mauricio", "Sánchez" );
        assertEquals( "Av 24 No. 6 - 44", c.darDireccion( ) );
        assertEquals( "No se modifico el contacto correctamente (Las palabras clave no cambiaron)", 0, c.darPalabras( ).size( ) );
        assertEquals( "No se modifico el contacto correctamente (Las palabras clave no cambiaron)", 0, c.darTelefonos( ).size( ) );

    }

}
