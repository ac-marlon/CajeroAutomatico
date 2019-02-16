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
public class ContrComprarArtServ implements ActionListener {

    OpCompraArticServi vistaComprarArtSer;
    SQLiteJDBCDriverConnection modeloConexion;
    TarjetaDebito modeloTarjetaDeb;
    CajeroAutomatico modeloCajeroAuto;
    Cliente modeloCliente;
    Cuenta modeloCuenta;
    IngresarClave vistaIngresarClave = new IngresarClave();

    public ContrComprarArtServ(OpCompraArticServi vistaComprarArtSer, SQLiteJDBCDriverConnection modeloConexion, TarjetaDebito modeloTarjetaDeb, CajeroAutomatico modeloCajeroAuto, Cliente modeloCliente, Cuenta modeloCuenta) {
        this.vistaComprarArtSer = vistaComprarArtSer;
        this.modeloConexion = modeloConexion;
        this.modeloTarjetaDeb = modeloTarjetaDeb;
        this.modeloCajeroAuto = modeloCajeroAuto;
        this.modeloCliente = modeloCliente;
        this.modeloCuenta = modeloCuenta;
    }

    void iniciarVista() {
        vistaComprarArtSer.efectuarPago.addActionListener(this);
        vistaComprarArtSer.setTitle("Pago de Artículos y Servicios");
        vistaComprarArtSer.pack();
        vistaComprarArtSer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vistaComprarArtSer.setLocationRelativeTo(null);
        vistaComprarArtSer.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (vistaComprarArtSer.efectuarPago == evento.getSource()) {
            try {
                int dineroEnCuenta = modeloCuenta.getSaldoActual();
                String nombreProSer = vistaComprarArtSer.eleccion.getSelectedItem().toString();
                String artServCuenta = modeloCuenta.getProductosServAdquiridos();

                int introMonto = Integer.parseInt(vistaComprarArtSer.precio.getText());
                if (dineroEnCuenta >= introMonto) {
                    modeloCuenta.setSaldoActual(dineroEnCuenta - introMonto);
                    modeloCuenta.setProductosServAdquiridos(artServCuenta + ", " + nombreProSer);
                    vistaComprarArtSer.setVisible(false);
                    ContrIngresarClave contrIngresarClave = new ContrIngresarClave(vistaIngresarClave, modeloConexion, modeloTarjetaDeb, modeloCajeroAuto, modeloCliente, modeloCuenta);
                    contrIngresarClave.iniciarVista();
                } else if (dineroEnCuenta < introMonto) {
                    JOptionPane.showMessageDialog(null, "Fondos Insuficientes", "DENEGADO", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada Inválida. Solo Números", "DENEGADO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
