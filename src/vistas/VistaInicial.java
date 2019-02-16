package vistas;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author marlon
 */
public final class VistaInicial extends JFrame {

    public JButton ingresarTarjeta, ingresarClaveAdmin;
    public JTextField idTarjetaCliente, claveAdmin;
    public JLabel titulo, fondo, logoUd;

    public VistaInicial() {
        initComponents();
    }

    public void initComponents() {
        claveAdmin = new javax.swing.JTextField();
        idTarjetaCliente = new javax.swing.JTextField();
        ingresarClaveAdmin = new javax.swing.JButton();
        ingresarTarjeta = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();
        logoUd = new javax.swing.JLabel();

        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(null);

        logoUd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoUd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/escudoUD.png")));
        getContentPane().add(logoUd);
        logoUd.setBounds(20, 130, 170, 170);

        getContentPane().add(claveAdmin);
        claveAdmin.setBounds(220, 280, 140, 30);
        getContentPane().add(idTarjetaCliente);
        idTarjetaCliente.setBounds(220, 180, 160, 30);

        ingresarClaveAdmin.setText("Ingresar Clave Admin.");
        getContentPane().add(ingresarClaveAdmin);
        ingresarClaveAdmin.setBounds(380, 270, 190, 50);

        ingresarTarjeta.setText("Ingresar Tarjeta");
        getContentPane().add(ingresarTarjeta);
        ingresarTarjeta.setBounds(400, 170, 170, 50);

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
