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
package uniandes.cupi2.listaContactos.mundo;

import java.util.ArrayList;

/**
 * Clase que representa un contacto.
 */
public class Contacto
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del contacto.
     */
    private String nombre;

    /**
     * Apellido del contacto.
     */
    private String apellido;

    /**
     * Dirección del contacto.
     */
    private String direccion;

    /**
     * Correo electrónico del contacto.
     */
    private String correo;

    /**
     * Lista de teléfonos del contacto.
     */
    private ArrayList<String> telefonos;

    /**
     * Lista de palabras clave del contacto. Esta lista incluye el nombre y el apellido del contacto.
     */
    private ArrayList<String> palabras;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo contacto sin teléfonos ni palabras claves. <br>
     * <b>post: </b> El contacto tiene los datos dados y las listas de teléfonos y palabras claves vacías.
     * @param pNombre Nombre del nuevo contacto. pNombre != null && pNombre != "".
     * @param pApellido Apellido del nuevo contacto. pApellido != null && pApellido != "".
     * @param pDireccion Dirección del nuevo contacto. pDireccion != null && pDireccion != "".
     * @param pCorreo El correo electrónico del contacto. pCorreo != null && pCorreo != "".
     */
    public Contacto( String pNombre, String pApellido, String pDireccion, String pCorreo )
    {
        nombre = pNombre;
        apellido = pApellido;
        direccion = pDireccion;
        correo = pCorreo;
        telefonos = new ArrayList<String>( );
        palabras = new ArrayList<String>( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del contacto.
     * @return Nombre del contacto.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna el apellido del contacto.
     * @return Apellido del contacto.
     */
    public String darApellido( )
    {
        return apellido;
    }

    /**
     * Retorna la dirección del contacto.
     * @return Dirección del contacto.
     */
    public String darDireccion( )
    {
        return direccion;
    }

    /**
     * Retorna el correo electrónico del contacto.
     * @return Correo electrónico del contacto.
     */
    public String darCorreo( )
    {
        return correo;
    }

    /**
     * Retorna la lista de teléfonos del contacto.
     * @return Lista de teléfonos del contacto.
     */
    public ArrayList<String> darTelefonos( )
    {
        return telefonos;
    }

    /**
     * Retorna la lista de palabras clave del contacto.
     * @return Lista de palabras clave del contacto
     */
    public ArrayList<String> darPalabras( )
    {
        return palabras;
    }

    /**
     * Cambia la dirección del contacto.
     * @param pDireccion La nueva dirección. pDireccion != null && pDireccion != "".
     */
    public void cambiarDireccion( String pDireccion )
    {
        direccion = pDireccion;
    }

    /**
     * Cambia el correo electrónico del contacto.
     * @param pCorreo Nuevo correo electrónico. pCorreo != null && pCorreo != "".
     */
    public void cambiarCorreo( String pCorreo )
    {
        correo = pCorreo;
    }

    /**
     * Agrega un nuevo teléfono a la lista de teléfonos del contacto si no existe. <br>
     * <b>post: </b> Si el número no existía se ha agregado a la lista de teléfonos.
     * @param pTelefono Número de teléfono a agregar en la lista. pTelefono != null && pTelefono != "".
     */
    public void agregarTelefono( String pTelefono )
    {
        // Ciclo para verificar si el teléfono existe en la lista
        int contador = 0;
        boolean encontrado = false;
        while( contador < telefonos.size( ) && !encontrado )
        {
            String telefono = telefonos.get( contador );
            if( telefono.equals( pTelefono ) )
            {
                encontrado = true;
            }
            else
                contador++;
        }

        // Si no encuentra el teléfono lo agrega
        if( encontrado == false )
        {
            telefonos.add( pTelefono );
        }
    }

    /**
     * Elimina un teléfono de la lista de teléfonos del contacto. <br>
     * <b>post: </b> Si el teléfono estaba en la lista de contactos queda eliminado.
     * @param pTelefonoEliminar Número de teléfono a eliminar de la lista. pTelefonoEliminar != null.
     */
    public void eliminarTelefono( String pTelefonoEliminar )
    {
        // Ciclo para buscar el teléfono a eliminar de la lista
        int contador = 0;
        boolean encontrado = false;
        while( contador < telefonos.size( ) && !encontrado )
        {
            String telefono = telefonos.get( contador );
            if( telefono.equals( pTelefonoEliminar ) )
            {
                encontrado = true;
            }
            else
            {
                contador++;
            }
        }

        // Si el teléfono existe lo elimina
        if( encontrado )
        {
            telefonos.remove( contador );
        }
    }

    /**
     * Agrega una nueva palabra clave a la lista de palabras del contacto. <br>
     * <b>post: </b> Se agrega la nueva palabra a la lista de contactos, si la palabra no existe ya en la lista.
     * @param pPalabra La palabra a agregar en la lista. pPalabra != null && pPalabra != "".
     */
    public void agregarPalabra( String pPalabra )
    {
        // Verifica si la palabra ya existe en la lista para agregarla
        if( !contienePalabraClave( pPalabra ) )
        {
            palabras.add( pPalabra );
        }
    }

    /**
     * Elimina una palabra clave a la lista de palabras del contacto. <br>
     * <b>post: </b> Si la palabra existe en la lista de palabras, queda eliminada.
     * @param pPalabraEliminar Palabra a eliminar de la lista de palabras claves. pPalabraEliminar != null.
     */
    public void eliminarPalabra( String pPalabraEliminar )
    {
        // Verificar si la palabra ya existe en la lista para eliminarla
        if( contienePalabraClave( pPalabraEliminar ) )
        {
            palabras.remove( pPalabraEliminar );
        }
    }

    /**
     * Determina si el contacto tiene la palabra clave indicada.
     * @param pPalabra Palabra clave a buscar. pPalabra != null.
     * @return Retorna true si el contacto contiene la palabra, false en caso contrario.
     */
    public boolean contienePalabraClave( String pPalabra )
    {
        boolean encontrado = false;
        int contador = 0;
        while( contador < palabras.size( ) && !encontrado )
        {
            String palabraC = palabras.get( contador );
            if( pPalabra.equals( palabraC ) )
            {
                encontrado = true;
            }
            contador++;
        }
        return encontrado;
    }

}
