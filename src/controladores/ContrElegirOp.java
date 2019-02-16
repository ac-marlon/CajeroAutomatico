package controladores;

import modelo.*;
import vistas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author marlon
 */
public class ContrElegirOp implements ActionListener {

    ElegirOperacion vistaElegirOperacion;
    SQLiteJDBCDriverConnection modeloConexion;
    TarjetaDebito modeloTarjetaDeb;
    CajeroAutomatico modeloCajeroAuto;
    Cliente modeloCliente;
    Cuenta modeloCuenta;
    OpCambiarClave vistaCambiarClave = new OpCambiarClave();
    IngresarClave vistaIngresarClave = new IngresarClave();
    OpCompraArticServi vistaComprarArticServ = new OpCompraArticServi();
    OpRetirarDinero vistaRetirarDinero = new OpRetirarDinero();

    public ContrElegirOp(ElegirOperacion vistaElegirOperacion, SQLiteJDBCDriverConnection modeloConexion, TarjetaDebito modeloTarjetaDeb, CajeroAutomatico modeloCajeroAuto, Cliente modeloCliente, Cuenta modeloCuenta) {
        this.vistaElegirOperacion = vistaElegirOperacion;
        this.modeloConexion = modeloConexion;
        this.modeloTarjetaDeb = modeloTarjetaDeb;
        this.modeloCajeroAuto = modeloCajeroAuto;
        this.modeloCliente = modeloCliente;
        this.modeloCuenta = modeloCuenta;
    }

    public void iniciarVista() {
        vistaElegirOperacion.cambiarClave.addActionListener(this);
        vistaElegirOperacion.consultarSaldo.addActionListener(this);
        vistaElegirOperacion.comprarArticServ.addActionListener(this);
        vistaElegirOperacion.retirarDinero.addActionListener(this);
        vistaElegirOperacion.setTitle("Selección de Opciones");
        vistaElegirOperacion.pack();
        vistaElegirOperacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vistaElegirOperacion.setLocationRelativeTo(null);
        vistaElegirOperacion.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (vistaElegirOperacion.cambiarClave == evento.getSource()) {
            ContrCambiarClave contrCambiarClave = new ContrCambiarClave(vistaCambiarClave, modeloConexion, modeloTarjetaDeb, modeloCajeroAuto, modeloCliente, modeloCuenta);
            contrCambiarClave.iniciarVista();

            vistaElegirOperacion.setVisible(false);
        } else if (vistaElegirOperacion.consultarSaldo == evento.getSource()) {
            ContrIngresarClave contrIngresarClave = new ContrIngresarClave(vistaIngresarClave, modeloConexion, modeloTarjetaDeb, modeloCajeroAuto, modeloCliente, modeloCuenta);
            contrIngresarClave.iniciarVista();

            vistaElegirOperacion.setVisible(false);
        } else if (vistaElegirOperacion.comprarArticServ == evento.getSource()) {
            ContrComprarArtServ contrComprarArtServ = new ContrComprarArtServ(vistaComprarArticServ, modeloConexion, modeloTarjetaDeb, modeloCajeroAuto, modeloCliente, modeloCuenta);
            contrComprarArtServ.iniciarVista();

            vistaElegirOperacion.setVisible(false);
        } else if (vistaElegirOperacion.retirarDinero == evento.getSource()) {
            ContrRetirarDinero contrRetirarDinero = new ContrRetirarDinero(vistaRetirarDinero, modeloConexion, modeloTarjetaDeb, modeloCajeroAuto, modeloCliente, modeloCuenta);
            contrRetirarDinero.iniciarVista();
            vistaElegirOperacion.setVisible(false);
        }
    }
}
