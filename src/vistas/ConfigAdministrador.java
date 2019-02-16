package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author marlon
 */
public class ConfigAdministrador extends JFrame {

    public JButton efectDinero, efecMax;
    public JLabel tituloAdmin, dineroDi, maxRet;
    public JTextField dinero, maximo;
    private JPanel titulo, dineroDisp, maxRetiro;

    public ConfigAdministrador() {
        initComponents();
    }

    private void initComponents() {
        getContentPane().setLayout(new BorderLayout());

        titulo = new JPanel();
        titulo.setLayout(new FlowLayout());

        dineroDisp = new JPanel();
        dineroDisp.setLayout(new FlowLayout());

        maxRetiro = new JPanel();
        maxRetiro.setLayout(new FlowLayout());

        dineroDi = new JLabel("Digite monto para depositar");
        maxRet = new JLabel("Introduzca valor maximo de retiro ");
        tituloAdmin = new JLabel("Panel de Configuración");

        dinero = new JTextField(20);
        maximo = new JTextField(20);

        efectDinero = new JButton("Deposito");
        efecMax = new JButton("Maximo");

        titulo.add(tituloAdmin);
        dineroDisp.add(dineroDi);
        dineroDisp.add(dinero);
        dineroDisp.add(efectDinero);
        maxRetiro.add(maxRet);
        maxRetiro.add(maximo);
        maxRetiro.add(efecMax);

        add(titulo, BorderLayout.NORTH);
        add(dineroDisp, BorderLayout.CENTER);
        add(maxRetiro, BorderLayout.SOUTH);

        setResizable(false);
    }
}
