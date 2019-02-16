package controladores;

import modelo.*;
import vistas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author marlon
 */
public class ContrVistaInicial implements ActionListener {

    VistaInicial vistaInicial;
    SQLiteJDBCDriverConnection modeloConexion;
    TarjetaDebito modeloTarjetaDeb;
    CajeroAutomatico modeloCajeroAuto;
    Cliente modeloCliente;
    Cuenta modeloCuenta;
    ElegirOperacion vistaElegirOperacion = new ElegirOperacion();
    ConfigAdministrador vistaConfAdmin = new ConfigAdministrador();

    public ContrVistaInicial(VistaInicial vistaInicial, SQLiteJDBCDriverConnection modeloConexion, TarjetaDebito modeloTarjetaDeb, CajeroAutomatico modeloCajeroAuto, Cliente modeloCliente, Cuenta modeloCuenta) {
        this.vistaInicial = vistaInicial;
        this.modeloConexion = modeloConexion;
        this.modeloTarjetaDeb = modeloTarjetaDeb;
        this.modeloCajeroAuto = modeloCajeroAuto;
        this.modeloCliente = modeloCliente;
        this.modeloCuenta = modeloCuenta;
    }

    public void iniciarVista() {
        vistaInicial.ingresarTarjeta.addActionListener(this);
        vistaInicial.ingresarClaveAdmin.addActionListener(this);
        vistaInicial.setTitle("Interfaz Inicial");
        vistaInicial.pack();
        vistaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vistaInicial.setLocationRelativeTo(null);
        vistaInicial.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (vistaInicial.ingresarTarjeta == evento.getSource()) {
            try {
                int idTarjeta = Integer.parseInt(vistaInicial.idTarjetaCliente.getText());
                modeloConexion.obtenerDatosTarDebCuenta(modeloTarjetaDeb, idTarjeta, modeloCuenta);

                if ((modeloTarjetaDeb.getIdTarjeta() == idTarjeta) && modeloTarjetaDeb.isEstado()) {
                    JOptionPane.showMessageDialog(null, "Tarjeta Identificada. Proceda elegir opción", "CONTINUAR", JOptionPane.INFORMATION_MESSAGE);
                    modeloConexion.obtenerDatosCliente(modeloCliente, modeloCliente.getIdUsuario());
                    vistaInicial.setVisible(false);

                    ContrElegirOp contrElegirOp = new ContrElegirOp(vistaElegirOperacion, modeloConexion, modeloTarjetaDeb, modeloCajeroAuto, modeloCliente, modeloCuenta);
                    contrElegirOp.iniciarVista();
                } else if (modeloTarjetaDeb.getIdTarjeta() != idTarjeta) {
                    JOptionPane.showMessageDialog(null, "Tarjeta Inválida. Intente de nuevo", "DENEGADO", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Tarjeta Bloqueada. Acudir al SC del Banco", "DENEGADO", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada Inválida. Solo números", "DENEGADO", JOptionPane.ERROR_MESSAGE);
            }
        } else if (vistaInicial.ingresarClaveAdmin == evento.getSource()) {
            try {
                if (modeloCajeroAuto.getClaveCajero() == Integer.parseInt(vistaInicial.claveAdmin.getText())) {
                    JOptionPane.showMessageDialog(null, "Clave Aceptada. Bienvenido", "CONTINUAR", JOptionPane.INFORMATION_MESSAGE);

                    ContrConfigAdmin contrConfAdmin = new ContrConfigAdmin(vistaConfAdmin, modeloCajeroAuto);
                    contrConfAdmin.iniciarVista();
                } else {
                    JOptionPane.showMessageDialog(null, "Clave Inválida.", "DENEGADO", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada Inválida. Solo Números", "DENEGADO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
