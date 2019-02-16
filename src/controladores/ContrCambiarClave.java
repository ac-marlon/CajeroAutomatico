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
public class ContrCambiarClave implements ActionListener {

    OpCambiarClave vistaCambiarClave;
    SQLiteJDBCDriverConnection modeloConexion;
    TarjetaDebito modeloTarjetaDeb;
    CajeroAutomatico modeloCajeroAuto;
    Cliente modeloCliente;
    Cuenta modeloCuenta;
    IngresarClave vistaIngresarClave = new IngresarClave();

    public ContrCambiarClave(OpCambiarClave vistaCambiarClave, SQLiteJDBCDriverConnection modeloConexion, TarjetaDebito modeloTarjetaDeb, CajeroAutomatico modeloCajeroAuto, Cliente modeloCliente, Cuenta modeloCuenta) {
        this.vistaCambiarClave = vistaCambiarClave;
        this.modeloConexion = modeloConexion;
        this.modeloTarjetaDeb = modeloTarjetaDeb;
        this.modeloCajeroAuto = modeloCajeroAuto;
        this.modeloCliente = modeloCliente;
        this.modeloCuenta = modeloCuenta;
    }

    void iniciarVista() {
        vistaCambiarClave.cambiarClave.addActionListener(this);
        vistaCambiarClave.setTitle("Cambiar Clave");
        vistaCambiarClave.pack();
        vistaCambiarClave.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vistaCambiarClave.setLocationRelativeTo(null);
        vistaCambiarClave.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (vistaCambiarClave.cambiarClave == evento.getSource()) {
            try {
                int claveUno = Integer.parseInt(vistaCambiarClave.primeraContra.getText());
                int claveDos = Integer.parseInt(vistaCambiarClave.segundaContra.getText());
                if ((claveUno == claveDos) && (Integer.toString(claveUno).length() == 4)) {
                    JOptionPane.showMessageDialog(null, "Clave Aceptada", "CONTINUAR", JOptionPane.INFORMATION_MESSAGE);
                    modeloTarjetaDeb.setClave(claveUno);
                    vistaCambiarClave.setVisible(false);

                    ContrIngresarClave contrIngresarClave = new ContrIngresarClave(vistaIngresarClave, modeloConexion, modeloTarjetaDeb, modeloCajeroAuto, modeloCliente, modeloCuenta);
                    contrIngresarClave.iniciarVista();
                } else {
                    JOptionPane.showMessageDialog(null, "Claves NO coinciden o longitud diferente de cuatro. Intente de nuevo", "DENEGADO", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada Inválida. Solo Números", "DENEGADO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
