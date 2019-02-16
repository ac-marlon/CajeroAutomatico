package vistas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author marlon
 */
public class ElegirOperacion extends JFrame {

    public JButton cambiarClave, consultarSaldo, comprarArticServ, retirarDinero;
    public JLabel titulo, titulo2, fondo;

    public ElegirOperacion() {
        initComponents();
    }

    private void initComponents() {

        comprarArticServ = new javax.swing.JButton();
        cambiarClave = new javax.swing.JButton();
        titulo2 = new javax.swing.JLabel();
        retirarDinero = new javax.swing.JButton();
        consultarSaldo = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(null);

        comprarArticServ.setText("Pagar Productos & Servicios");
        getContentPane().add(comprarArticServ);
        comprarArticServ.setBounds(30, 270, 240, 50);

        cambiarClave.setText("Cambiar Clave");
        getContentPane().add(cambiarClave);
        cambiarClave.setBounds(30, 170, 240, 50);

        titulo2.setBackground(new java.awt.Color(255, 255, 255));
        titulo2.setFont(new java.awt.Font("Monospaced", 1, 24));
        titulo2.setForeground(new java.awt.Color(0, 0, 0));
        titulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo2.setText("Seleccione una operación");
        titulo2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        getContentPane().add(titulo2);
        titulo2.setBounds(10, 90, 570, 40);

        retirarDinero.setText("Retirar Dinero");
        getContentPane().add(retirarDinero);
        retirarDinero.setBounds(380, 270, 190, 50);

        consultarSaldo.setText("Consultar Saldo");
        getContentPane().add(consultarSaldo);
        consultarSaldo.setBounds(380, 170, 190, 50);

        titulo.setFont(new java.awt.Font("Monospaced", 1, 24));
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Bienvenido A Su Cajero De Confianza");
        titulo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        getContentPane().add(titulo);
        titulo.setBounds(10, 40, 570, 40);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/fondo.jpg")));
        getContentPane().add(fondo);
        fondo.setBounds(0, 0, 600, 400);
    }
}
