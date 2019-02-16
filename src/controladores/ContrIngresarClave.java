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
public class ContrIngresarClave implements ActionListener {

    IngresarClave vistaIngresarClave;
    SQLiteJDBCDriverConnection modeloConexion;
    TarjetaDebito modeloTarjetaDeb;
    CajeroAutomatico modeloCajeroAuto;
    Cliente modeloCliente;
    Cuenta modeloCuenta;
    ElegirOperacion vistaElegirOperacion = new ElegirOperacion();
    VistaInicial vistaInicial = new VistaInicial();

    public ContrIngresarClave(IngresarClave vistaIngresarClave, SQLiteJDBCDriverConnection modeloConexion, TarjetaDebito modeloTarjetaDeb, CajeroAutomatico modeloCajeroAuto, Cliente modeloCliente, Cuenta modeloCuenta) {
        this.vistaIngresarClave = vistaIngresarClave;
        this.modeloConexion = modeloConexion;
        this.modeloTarjetaDeb = modeloTarjetaDeb;
        this.modeloCajeroAuto = modeloCajeroAuto;
        this.modeloCliente = modeloCliente;
        this.modeloCuenta = modeloCuenta;
    }

    void iniciarVista() {
        vistaIngresarClave.aceptar.addActionListener(this);
        vistaIngresarClave.setTitle("Ingresar Clave");
        vistaIngresarClave.pack();
        vistaIngresarClave.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vistaIngresarClave.setLocationRelativeTo(null);
        vistaIngresarClave.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (vistaIngresarClave.aceptar == evento.getSource()) {
            int intentos = modeloCuenta.getIntentosAcceso();
            try {
                int claveIngresada = Integer.parseInt(vistaIngresarClave.campoClave.getText());

                if ((claveIngresada == modeloConexion.obtenerClaveTarDeb(modeloTarjetaDeb)) && intentos < 3) {
                    modeloCuenta.setIntentosAcceso(0);
                    modeloConexion.actualizarTodosDatos(modeloCliente, modeloTarjetaDeb, modeloCuenta);
                    vistaIngresarClave.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Transacción Exitosa", "CONTINUAR", JOptionPane.INFORMATION_MESSAGE);

                    int opcionUno = JOptionPane.showConfirmDialog(null, "¿Desea visualizar su recibo?", "FINAL", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (opcionUno == 0) {
                        modeloConexion.obtenerDatosTarDebCuenta(modeloTarjetaDeb, modeloTarjetaDeb.getIdTarjeta(), modeloCuenta);
                        modeloConexion.obtenerDatosCliente(modeloCliente, modeloCliente.getIdUsuario());

                        String recibo = "---Info Cliente---\n"
                                + "Apellido: " + modeloCliente.getApellidoUsuario() + "\n"
                                + "Nombre: " + modeloCliente.getNombreUsuario() + "\n"
                                + "---Info Tarjeta Debito---\n"
                                + "Fecha Vencimiento: " + modeloTarjetaDeb.getFechaVencimiento() + "\n"
                                + "---Info Cuenta---\n"
                                + "Saldo: " + modeloCuenta.getSaldoActual() + "\n"
                                + "Productos y Servicios pagados: " + modeloCuenta.getProductosServAdquiridos() + "\n"
                                + "---FIN RECIBO---";
                        JOptionPane.showMessageDialog(null, recibo, "RECIBO", JOptionPane.INFORMATION_MESSAGE);
                    }
                    int opcionDos = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra operación?", "FINAL", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (opcionDos == 0) {
                        ContrElegirOp contrElegirOp = new ContrElegirOp(vistaElegirOperacion, modeloConexion, modeloTarjetaDeb, modeloCajeroAuto, modeloCliente, modeloCuenta);
                        contrElegirOp.iniciarVista();

                        modeloConexion.obtenerDatosTarDebCuenta(modeloTarjetaDeb, modeloTarjetaDeb.getIdTarjeta(), modeloCuenta);
                        modeloConexion.obtenerDatosCliente(modeloCliente, modeloCliente.getIdUsuario());
                    } else {
                        JOptionPane.showMessageDialog(null, "Gracias por preferirnos. Vuelva pronto", "SALIR", JOptionPane.INFORMATION_MESSAGE);
                        ContrVistaInicial contrVistaInicial = new ContrVistaInicial(vistaInicial, modeloConexion, modeloTarjetaDeb, modeloCajeroAuto, modeloCliente, modeloCuenta);
                        contrVistaInicial.iniciarVista();
                    }
                } else if (!(claveIngresada == modeloConexion.obtenerClaveTarDeb(modeloTarjetaDeb)) && intentos >= 3) {
                    vistaIngresarClave.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Cuenta Bloqueada. Acudir al SC Banco", "DENEGADO", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Transacción Fallida", "CONTINUAR", JOptionPane.INFORMATION_MESSAGE);
                    ContrVistaInicial contrVistaInicial = new ContrVistaInicial(vistaInicial, modeloConexion, modeloTarjetaDeb, modeloCajeroAuto, modeloCliente, modeloCuenta);
                    contrVistaInicial.iniciarVista();

                    modeloTarjetaDeb.setEstado(false);
                    modeloConexion.actualizarEstadoTarDeb(modeloTarjetaDeb);
                } else if (!(claveIngresada == modeloConexion.obtenerClaveTarDeb(modeloTarjetaDeb))) {
                    JOptionPane.showMessageDialog(null, "Clave erronea", "DENEGADO", JOptionPane.ERROR_MESSAGE);
                    modeloCuenta.setIntentosAcceso(intentos + 1);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada Inválida. Solo Números", "DENEGADO", JOptionPane.ERROR_MESSAGE);
                modeloCuenta.setIntentosAcceso(intentos + 1);
            }
        }
    }
}
