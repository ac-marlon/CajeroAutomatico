package Principal;

import Controlador.ControladorCalculadora;
import Modelo.ModeloCalculadora;
import Vista.VistaCalculadora;

/**
 *
 * @author marlon
 */
public class PruebaCalculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ModeloCalculadora modelo = new ModeloCalculadora();
        VistaCalculadora vista = new VistaCalculadora();
        ControladorCalculadora controlador = new ControladorCalculadora(modelo, vista);
        controlador.iniciarVista();
    }

}
