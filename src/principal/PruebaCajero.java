package principal;

import controladores.ContrVistaInicial;
import modelo.SQLiteJDBCDriverConnection;
import modelo.CajeroAutomatico;
import modelo.Cliente;
import modelo.Cuenta;
import modelo.TarjetaDebito;
import vistas.VistaInicial;

/**
 *
 * @author marlon
 */
public class PruebaCajero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SQLiteJDBCDriverConnection modeloConexion = new SQLiteJDBCDriverConnection();
        TarjetaDebito modeloTarjetaDeb = new TarjetaDebito();
        CajeroAutomatico modeloCajeroAuto = new CajeroAutomatico();
        Cliente modeloCliente = new Cliente();
        Cuenta modeloCuenta = new Cuenta();
        VistaInicial vistaInicial = new VistaInicial();
        modeloCuenta.setTarjetaAsociada(modeloTarjetaDeb);
        modeloTarjetaDeb.setClienteAsociado(modeloCliente);
        ContrVistaInicial contrVistaInicial = new ContrVistaInicial(vistaInicial, modeloConexion, modeloTarjetaDeb, modeloCajeroAuto, modeloCliente, modeloCuenta);
        contrVistaInicial.iniciarVista();
    }

}
