package vistas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author marlon
 */
public class IngresarClave extends JFrame {

    public JButton aceptar;
    public JLabel titulo, ingClave, fondo;
    public JTextField campoClave;

    public IngresarClave() {
        initComponents();
    }

    private void initComponents() {

        ingClave = new javax.swing.JLabel();
        campoClave = new javax.swing.JTextField();
        aceptar = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(null);

        ingClave.setFont(new java.awt.Font("Monospaced", 1, 24));
        ingClave.setForeground(new java.awt.Color(0, 0, 0));
        ingClave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ingClave.setText("Introduzca su clave");
        getContentPane().add(ingClave);
        ingClave.setBounds(60, 160, 280, 40);
        getContentPane().add(campoClave);
        campoClave.setBounds(370, 170, 160, 30);

        aceptar.setText("Continuar");
        getContentPane().add(aceptar);
        aceptar.setBounds(230, 280, 130, 50);

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
