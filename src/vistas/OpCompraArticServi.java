package vistas;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author marlon
 */
public class OpCompraArticServi extends JFrame {

    public JButton efectuarPago;
    public JLabel nombre, costo, titulo, titulo2, fondo;
    public JTextField precio;
    public JComboBox eleccion;

    public OpCompraArticServi() {
        initComponents();
    }

    private void initComponents() {

        eleccion = new javax.swing.JComboBox<>();
        costo = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        titulo2 = new javax.swing.JLabel();
        precio = new javax.swing.JTextField();
        efectuarPago = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(null);

        eleccion.addItem("Recibo_Gas");
        eleccion.addItem("Ticket_Avianca");
        eleccion.addItem("Recibo_Internet");
        eleccion.addItem("Entrada_Cine");
        eleccion.addItem("Factura_DirecTV");
        eleccion.addItem("Suscripcion_Soho");
        getContentPane().add(eleccion);
        eleccion.setBounds(410, 224, 160, 30);

        costo.setFont(new java.awt.Font("Monospaced", 1, 24));
        costo.setForeground(new java.awt.Color(0, 0, 0));
        costo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        costo.setText("Digite el valor");
        getContentPane().add(costo);
        costo.setBounds(140, 160, 250, 40);

        nombre.setFont(new java.awt.Font("Monospaced", 1, 24));
        nombre.setForeground(new java.awt.Color(0, 0, 0));
        nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombre.setText("Seleccione razón de pago");
        getContentPane().add(nombre);
        nombre.setBounds(30, 220, 360, 40);

        titulo2.setFont(new java.awt.Font("Monospaced", 1, 24));
        titulo2.setForeground(new java.awt.Color(0, 0, 0));
        titulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo2.setText("Pague servicios y productos aquí");
        titulo2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        getContentPane().add(titulo2);
        titulo2.setBounds(10, 90, 570, 40);
        getContentPane().add(precio);
        precio.setBounds(410, 160, 160, 30);

        efectuarPago.setText("Aceptar");
        getContentPane().add(efectuarPago);
        efectuarPago.setBounds(50, 290, 170, 50);

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
