package vistas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author marlon
 */
public class OpRetirarDinero extends JFrame {

    public JButton cincuenta, cien, doscientos, quinientos, retirar;
    public JLabel titulo, ingMonto, titulo2, fondo;
    public JTextField montoManual;

    public OpRetirarDinero() {
        initComponents();
    }

    private void initComponents() {

        doscientos = new javax.swing.JButton();
        cien = new javax.swing.JButton();
        quinientos = new javax.swing.JButton();
        cincuenta = new javax.swing.JButton();
        ingMonto = new javax.swing.JLabel();
        titulo2 = new javax.swing.JLabel();
        montoManual = new javax.swing.JTextField();
        retirar = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(null);

        doscientos.setText("$200.000");
        getContentPane().add(doscientos);
        doscientos.setBounds(130, 220, 130, 50);

        cien.setText("$100.000");
        getContentPane().add(cien);
        cien.setBounds(310, 150, 130, 50);

        quinientos.setText("$500.000");
        getContentPane().add(quinientos);
        quinientos.setBounds(310, 220, 130, 50);

        cincuenta.setText("$50.000");
        getContentPane().add(cincuenta);
        cincuenta.setBounds(130, 150, 130, 50);

        ingMonto.setFont(new java.awt.Font("Monospaced", 1, 24));
        ingMonto.setForeground(new java.awt.Color(0, 0, 0));
        ingMonto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ingMonto.setText("Digite un monto");
        getContentPane().add(ingMonto);
        ingMonto.setBounds(20, 290, 230, 40);

        titulo2.setFont(new java.awt.Font("Monospaced", 1, 24));
        titulo2.setForeground(new java.awt.Color(0, 0, 0));
        titulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo2.setText("Retire dinero en efectivo aquí");
        titulo2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        getContentPane().add(titulo2);
        titulo2.setBounds(10, 90, 570, 40);
        getContentPane().add(montoManual);
        montoManual.setBounds(250, 300, 160, 30);

        retirar.setText("Retirar");
        getContentPane().add(retirar);
        retirar.setBounds(440, 290, 130, 50);

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
