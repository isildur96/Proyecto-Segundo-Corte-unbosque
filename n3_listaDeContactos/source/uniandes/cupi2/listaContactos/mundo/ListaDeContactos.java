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
 * Clase que representa una lista de contactos personales.
 */
public class ListaDeContactos
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Lista de contactos.
     */
    private ArrayList<Contacto> contactos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva lista de contactos vacía. <br>
     * <b>post: </b> Se inicializa la lista de contactos.
     */
    public ListaDeContactos( )
    {
        contactos = new ArrayList<Contacto>( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna una lista con el nombre de los contactos. <br>
     * <b>pre: </b> La lista de contactos está inicializada.
     * @return La lista de contactos. Si no hay contactos la lista se retorna vacía.
     */
    public ArrayList<String> darTodosLosContactos( )
    {
        ArrayList<String> lista = new ArrayList<String>( );
        for( int i = 0; i < contactos.size( ); i++ )
        {
            Contacto c = contactos.get( i );
            lista.add( c.darNombre( ) + " " + c.darApellido( ) );
        }
        return lista;
    }

    /**
     * Retorna una lista con todos los contactos que tienen la palabra dada entre sus palabras claves. <br>
     * <b>pre: </b> La lista de contactos está inicializada.
     * @param pPalabra Palabra clave para buscar contactos. pPalabra != null.
     * @return La lista de contactos. Si no encuentra contactos con la palabra clave, la lista se retorna vacía.
     */
    public ArrayList<String> buscarContactosPalabraClave( String pPalabra )
    {
        ArrayList<String> nombres = new ArrayList<String>( );

        for( int i = 0; i < contactos.size( ); i++ )
        {
            // Para cada contacto verifica si tiene la palabra en su lista de
            // palabras clave para agregarlo a la lista
            Contacto c = contactos.get( i );
            if( c.contienePalabraClave( pPalabra ) )
            {
                nombres.add( c.darNombre( ) + " " + c.darApellido( ) );
            }
        }
        return nombres;
    }

    /**
     * Agrega un nuevo contacto a la lista, si todavía no hay ningún contacto con el nombre y el apellido dado. <br>
     * <b>pre: </b> La lista de contactos está inicializada. <br>
     * <b>post: </b> Se agrega un nuevo contacto a la lista si éste no exista aún en ella.
     * @param pNombre Nombre del nuevo contacto. pNombre != null.
     * @param pApellido Apellido del nuevo contacto. pApellido != null.
     * @param pDireccion Dirección del nuevo contacto. pDireccion != null.
     * @param pCorreo Correo electrónico del nuevo contacto. pCorreo != null.
     * @param pTelefonos Lista de teléfonos del nuevo contacto. pTelefonos != null.
     * @param pPalabras Lista de palabras clave del nuevo contacto. pPalabras != null.
     * @return Retorna true si se pudo agregar el contacto, false de lo contrario.
     */
    public boolean agregarContacto( String pNombre, String pApellido, String pDireccion, String pCorreo, ArrayList<String> pTelefonos, ArrayList<String> pPalabras )
    {
        Contacto con = buscarContacto( pNombre, pApellido );
        boolean exito = false;
        if( con == null ) // se puede agregar el contacto
        {
            pPalabras.add( pNombre );
            pPalabras.add( pApellido );
            Contacto nuevo = new Contacto( pNombre, pApellido, pDireccion, pCorreo );
            // Agrega los teléfonos
            for( int i = 0; i < pTelefonos.size( ); i++ )
            {
                nuevo.agregarTelefono( pTelefonos.get( i ) );
            }
            // Agrega las palabras
            for( int i = 0; i < pPalabras.size( ); i++ )
            {
                nuevo.agregarPalabra( pPalabras.get( i ) );
            }
            contactos.add( nuevo );
            exito = true;
        }

        return exito;
    }

    /**
     * Elimina un contacto dado su nombre y su apellido. <br>
     * <b>pre: </b> La lista de contactos está inicializada. <br>
     * <b>post: </b> Si el usuario existe en la lista se elimina.
     * @param pNombre Nombre del contacto a eliminar. pNombre != null.
     * @param pApellido Apellido del contacto a eliminar. pApellido != null.
     * @return Retorna true si se pudo eliminar el contacto, false de lo contrario.
     */
    public boolean eliminarContacto( String pNombre, String pApellido )
    {
        Contacto con = buscarContacto( pNombre, pApellido );
        boolean exito = false;
        if( con != null )
        {
            contactos.remove( con );
            exito = true;
        }

        return exito;

    }

    /**
     * Modifica los datos de un contacto dados su nombre y apellido. <br>
     * <b>post: </b> Si el usuario existe se modifican sus datos.
     * @param pNombre Nombre del contacto. pNombre != null.
     * @param pApellido Apellido del contacto. pApellido != null.
     * @param pDireccion Nueva dirección del contacto. pDirección != null.
     * @param pCorreo Nuevo correo electrónico del contacto. pCorreo !=null.
     * @param pTelefonos Nueva lista de teléfonos del contacto.
     * @param pPalabras Nueva lista de palabras clave del contacto.
     * @return Retorna true si se pudo modificar el contacto, false de lo contrario.
     */
    public boolean modificarContacto( String pNombre, String pApellido, String pDireccion, String pCorreo, ArrayList<String> pTelefonos, ArrayList<String> pPalabras )
    {
        // Verifica si el contacto existe
        Contacto con = buscarContacto( pNombre, pApellido );
        boolean exito = true;
        if( con == null )
        {
            exito = false;
        }
        else
        {
            // Modifica el contacto con los nuevos datos
            con.cambiarDireccion( pDireccion );
            con.cambiarCorreo( pCorreo );
            actualizarPalabras( pPalabras, con );
            actualizarTelefonos( pTelefonos, con );
        }
        return exito;
    }

    /**
     * Actualiza la lista de teléfonos del contacto dado.
     * @param pTelefonos Lista actual de teléfonos. pTelefonos != null.
     * @param pContacto Contacto al que se le modificará la lista de teléfonos.
     */
    private void actualizarTelefonos( ArrayList<String> pTelefonos, Contacto pContacto )
    {
        ArrayList<String> listaVieja = pContacto.darTelefonos( );
        ArrayList<String> eliminar = new ArrayList<String>( );

        // Elige los teléfonos para eliminar de la lista vieja que ya no están
        // en la nueva lista
        for( int i = 0; i < listaVieja.size( ); i++ )
        {
            String telefonoViejo = listaVieja.get( i );
            boolean encontrado = false;
            for( int j = 0; j < pTelefonos.size( ) && !encontrado; j++ )
            {
                String telefonoNuevo = pTelefonos.get( j );
                if( telefonoViejo.equals( telefonoNuevo ) )
                {
                    encontrado = true;
                }
            }
            if( !encontrado )
            {
                eliminar.add( telefonoViejo );
            }

        }
        // Elimina los teléfonos
        for( int i = 0; i < eliminar.size( ); i++ )
        {
            pContacto.eliminarTelefono( eliminar.get( i ) );
        }

        // Intenta agregar todos los teléfonos de la lista nueva. El método
        // controla que no estén incluidos
        for( int i = 0; i < pTelefonos.size( ); i++ )
        {
            String telefono = pTelefonos.get( i );
            pContacto.agregarTelefono( telefono );
        }
    }

    /**
     * Actualiza la lista de palabras clave del contacto. <br>
     * <b>post: </b> Las palabras que no existan en la nueva lista se eliminan y las palabras nuevas se agregan a la lista del contacto.
     * @param pPalabras Lista con las palabras finales.
     * @param pContacto Contacto a quien se le modificará la lista de palabras.
     */
    private void actualizarPalabras( ArrayList<String> pPalabras, Contacto pContacto )
    {
        ArrayList<String> listaVieja = pContacto.darPalabras( );
        ArrayList<String> eliminar = new ArrayList<String>( );

        // Elige las palabras para eliminar de la lista vieja que ya no están en
        // la nueva lista
        int tamListaVieja = listaVieja.size( );
        for( int i = 0; i < tamListaVieja; i++ )
        {
            String palabraVieja = listaVieja.get( i );
            boolean encontrado = false;
            for( int j = 0; j < pPalabras.size( ) && !encontrado; j++ )
            {
                String palabraNueva = pPalabras.get( j );
                if( palabraVieja.equals( palabraNueva ) )
                {
                    encontrado = true;
                }
            }
            if( !encontrado )
            {
                eliminar.add( palabraVieja );
            }
        }
        // Elimina las palabras
        for( int i = 0; i < eliminar.size( ); i++ )
        {
            pContacto.eliminarPalabra( eliminar.get( i ) );
        }

        // Intenta agregar todas las palabras de la lista nueva. El método
        // controla que no estén incluidas
        for( int i = 0; i < pPalabras.size( ); i++ )
        {
            String palabra = pPalabras.get( i );
            pContacto.agregarPalabra( palabra );
        }

    }

    /**
     * Busca un contacto dado su nombre y su apellido. <br>
     * <b>pre: </b> La lista de contactos está inicializada.
     * @param pNombre Nombre del contacto a buscar. pNombre != null.
     * @param pApellido Apellido del contacto a buscar. pApellido != null.
     * @return Retorna el contacto si se encuentra, null en caso contrario.
     */
    public Contacto buscarContacto( String pNombre, String pApellido )
    {
        int contador = 0;
        Contacto con = null;
        boolean encontrado = false;
        while( contador < contactos.size( ) && !encontrado )
        {
            con = contactos.get( contador );
            if( pNombre.equals( con.darNombre( ) ) && pApellido.equals( con.darApellido( ) ) )
            {
                encontrado = true;
            }
            contador++;
        }
        if( !encontrado )
        {
            con = null;
        }
        return con;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión 2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }
}
