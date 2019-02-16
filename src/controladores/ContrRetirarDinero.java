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
public class ContrRetirarDinero implements ActionListener {

    OpRetirarDinero vistaRetirarDinero;
    SQLiteJDBCDriverConnection modeloConexion;
    TarjetaDebito modeloTarjetaDeb;
    CajeroAutomatico modeloCajeroAuto;
    Cliente modeloCliente;
    Cuenta modeloCuenta;
    IngresarClave vistaIngresarClave = new IngresarClave();

    public ContrRetirarDinero(OpRetirarDinero vistaRetirarDinero, SQLiteJDBCDriverConnection modeloConexion, TarjetaDebito modeloTarjetaDeb, CajeroAutomatico modeloCajeroAuto, Cliente modeloCliente, Cuenta modeloCuenta) {
        this.vistaRetirarDinero = vistaRetirarDinero;
        this.modeloConexion = modeloConexion;
        this.modeloTarjetaDeb = modeloTarjetaDeb;
        this.modeloCajeroAuto = modeloCajeroAuto;
        this.modeloCliente = modeloCliente;
        this.modeloCuenta = modeloCuenta;
    }

    void iniciarVista() {
        vistaRetirarDinero.cincuenta.addActionListener(this);
        vistaRetirarDinero.cien.addActionListener(this);
        vistaRetirarDinero.doscientos.addActionListener(this);
        vistaRetirarDinero.quinientos.addActionListener(this);
        vistaRetirarDinero.retirar.addActionListener(this);
        vistaRetirarDinero.setTitle("Retiro en Efectivo");
        vistaRetirarDinero.pack();
        vistaRetirarDinero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vistaRetirarDinero.setLocationRelativeTo(null);
        vistaRetirarDinero.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        int dineroEnCuenta = modeloCuenta.getSaldoActual();
        int dineroEnCajero = modeloCajeroAuto.getDineroDisponibleActual();

        if (vistaRetirarDinero.cincuenta == evento.getSource()) {
            if ((dineroEnCuenta >= 50000) && (dineroEnCajero >= 50000)) {
                modeloCuenta.setSaldoActual(dineroEnCuenta - 50000);
                vistaRetirarDinero.setVisible(false);

                ContrIngresarClave contrIngresarClave = new ContrIngresarClave(vistaIngresarClave, modeloConexion, modeloTarjetaDeb, modeloCajeroAuto, modeloCliente, modeloCuenta);
                contrIngresarClave.iniciarVista();
            } else if (dineroEnCuenta < 50000) {
                JOptionPane.showMessageDialog(null, "Fondos Insuficientes", "DENEGADO", JOptionPane.ERROR_MESSAGE);
            } else if (dineroEnCajero < 50000) {
                JOptionPane.showMessageDialog(null, "Cajero Sin Reservas", "DENEGADO", JOptionPane.ERROR_MESSAGE);
            }
        } else if (vistaRetirarDinero.cien == evento.getSource()) {
            if ((dineroEnCuenta >= 100000) && (dineroEnCajero >= 100000)) {
                modeloCuenta.setSaldoActual(dineroEnCuenta - 100000);
                vistaRetirarDinero.setVisible(false);

                ContrIngresarClave contrIngresarClave = new ContrIngresarClave(vistaIngresarClave, modeloConexion, modeloTarjetaDeb, modeloCajeroAuto, modeloCliente, modeloCuenta);
                contrIngresarClave.iniciarVista();
            } else if (dineroEnCuenta < 100000) {
                JOptionPane.showMessageDialog(null, "Fondos Insuficientes", "DENEGADO", JOptionPane.ERROR_MESSAGE);
            } else if (dineroEnCajero < 100000) {
                JOptionPane.showMessageDialog(null, "Cajero Sin Reservas", "DENEGADO", JOptionPane.ERROR_MESSAGE);
            }
        } else if (vistaRetirarDinero.doscientos == evento.getSource()) {
            if ((dineroEnCuenta >= 200000) && (dineroEnCajero >= 200000)) {
                modeloCuenta.setSaldoActual(dineroEnCuenta - 200000);
                vistaRetirarDinero.setVisible(false);

                ContrIngresarClave contrIngresarClave = new ContrIngresarClave(vistaIngresarClave, modeloConexion, modeloTarjetaDeb, modeloCajeroAuto, modeloCliente, modeloCuenta);
                contrIngresarClave.iniciarVista();
            } else if (dineroEnCuenta < 200000) {
                JOptionPane.showMessageDialog(null, "Fondos Insuficientes", "DENEGADO", JOptionPane.ERROR_MESSAGE);
            } else if (dineroEnCajero < 200000) {
                JOptionPane.showMessageDialog(null, "Cajero Sin Reservas", "DENEGADO", JOptionPane.ERROR_MESSAGE);
            }
        } else if (vistaRetirarDinero.quinientos == evento.getSource()) {
            if ((dineroEnCuenta >= 500000) && (dineroEnCajero >= 500000)) {
                modeloCuenta.setSaldoActual(dineroEnCuenta - 500000);
                vistaRetirarDinero.setVisible(false);
                ContrIngresarClave contrIngresarClave = new ContrIngresarClave(vistaIngresarClave, modeloConexion, modeloTarjetaDeb, modeloCajeroAuto, modeloCliente, modeloCuenta);
                contrIngresarClave.iniciarVista();
            } else if (dineroEnCuenta < 500000) {
                JOptionPane.showMessageDialog(null, "Fondos Insuficientes", "DENEGADO", JOptionPane.ERROR_MESSAGE);
            } else if (dineroEnCajero < 500000) {
                JOptionPane.showMessageDialog(null, "Cajero Sin Reservas", "DENEGADO", JOptionPane.ERROR_MESSAGE);
            }
        } else if (vistaRetirarDinero.retirar == evento.getSource()) {
            try {
                int introMonto = Integer.parseInt(vistaRetirarDinero.montoManual.getText());
                if ((dineroEnCuenta >= introMonto) && (dineroEnCajero >= introMonto)) {
                    modeloCuenta.setSaldoActual(dineroEnCuenta - introMonto);
                    vistaRetirarDinero.setVisible(false);

                    ContrIngresarClave contrIngresarClave = new ContrIngresarClave(vistaIngresarClave, modeloConexion, modeloTarjetaDeb, modeloCajeroAuto, modeloCliente, modeloCuenta);
                    contrIngresarClave.iniciarVista();
                } else if (dineroEnCuenta < introMonto) {
                    JOptionPane.showMessageDialog(null, "Fondos Insuficientes", "DENEGADO", JOptionPane.ERROR_MESSAGE);
                } else if (dineroEnCajero < introMonto) {
                    JOptionPane.showMessageDialog(null, "Cajero Sin Reservas", "DENEGADO", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada Inválida. Solo Números", "DENEGADO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
