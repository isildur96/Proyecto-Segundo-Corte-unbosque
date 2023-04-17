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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel para los botones de extensión del ejercicio.
 */
@SuppressWarnings("serial")
public class PanelOpciones extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante OPCION_1, Usada para realizar la opción de la extensión 1.
     */
    private final static String OPCION_1 = "OPCION_1";

    /**
     * Constante OPCION_2, Usada para realizar la opción de la extensión 2.
     */
    private final static String OPCION_2 = "OPCION_2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazListaDeContactos principal;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Botón Para hacer la extensión 1.
     */
    private JButton opcion1;

    /**
     * Botón Para hacer la extensión 2.
     */
    private JButton opcion2;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo panel con los botones para realizar las extensiones.
     * @param pPrincipal La ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelOpciones( InterfazListaDeContactos pPrincipal )
    {
        principal = pPrincipal;

        setBorder( new TitledBorder( "Extensiones" ) );

        opcion1 = new JButton( );
        opcion1.setText( "Opción1" );
        opcion1.setActionCommand( OPCION_1 );
        opcion1.addActionListener( this );

        opcion2 = new JButton( );
        opcion2.setText( "Opción2" );
        opcion2.setActionCommand( OPCION_2 );
        opcion2.addActionListener( this );

        add( opcion1 );
        add( opcion2 );
    }

    /**
     * Realiza las acciones respectivas dependiendo del evento ocurrido. <br>
     * <b>post: </b> Se realiza alguno de los 2 puntos de extensión.
     * @param pEvento Evento generado. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String command = pEvento.getActionCommand( );
        if( command.equals( OPCION_1 ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( command.equals( OPCION_2 ) )
        {
            principal.reqFuncOpcion2( );
        }
    }
}
