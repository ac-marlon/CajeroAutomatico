package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.CajeroAutomatico;
import vistas.ConfigAdministrador;

/**
 *
 * @author marlon
 */
public class ContrConfigAdmin implements ActionListener {

    ConfigAdministrador vistaConfAdmin;
    CajeroAutomatico modeloCajeroAuto;

    public ContrConfigAdmin(ConfigAdministrador vistaConfAdmin, CajeroAutomatico modeloCajeroAuto) {
        this.vistaConfAdmin = vistaConfAdmin;
        this.modeloCajeroAuto = modeloCajeroAuto;
    }

    void iniciarVista() {
        vistaConfAdmin.efectDinero.addActionListener(this);
        vistaConfAdmin.efecMax.addActionListener(this);
        vistaConfAdmin.setTitle("Panel de Administración");
        vistaConfAdmin.pack();
        vistaConfAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vistaConfAdmin.setLocationRelativeTo(null);
        vistaConfAdmin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (vistaConfAdmin.efectDinero == evento.getSource()) {
            try {
                System.out.println("AntesDin: " + modeloCajeroAuto.getDineroDisponibleActual());
                int dineroEnCajero = modeloCajeroAuto.getDineroDisponibleActual();
                int introDeposito = Integer.parseInt(vistaConfAdmin.dinero.getText());
                
                modeloCajeroAuto.setDineroDisponibleActual(introDeposito + dineroEnCajero);
                vistaConfAdmin.setVisible(false);
                
                JOptionPane.showMessageDialog(null, "Deposito Exitoso", "CONTINUAR", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("DespuesDin: " + modeloCajeroAuto.getDineroDisponibleActual());
                vistaConfAdmin.dinero.setText("");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada Inválida. Solo Números", "DENEGADO", JOptionPane.ERROR_MESSAGE);
            }
        } else if (vistaConfAdmin.efecMax == evento.getSource()) {
            try {
                System.out.println("AntesMax: " + modeloCajeroAuto.getMaximoRetiroPermitido());
                int introMax = Integer.parseInt(vistaConfAdmin.maximo.getText());
                
                modeloCajeroAuto.setMaximoRetiroPermitido(introMax);
                vistaConfAdmin.setVisible(false);
                
                JOptionPane.showMessageDialog(null, "Asignación Máxima Exitosa", "CONTINUAR", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("DespuesMax: " + modeloCajeroAuto.getMaximoRetiroPermitido());
                vistaConfAdmin.maximo.setText("");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada Inválida. Solo Números", "DENEGADO", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
}
