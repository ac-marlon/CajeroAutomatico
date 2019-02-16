package vistas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author marlon
 */
public class OpCambiarClave extends JFrame {

    public JButton cambiarClave;
    public JLabel cambioClave, cambiarClaveRepetir, titulo, titulo2, fondo;
    public JTextField primeraContra, segundaContra;

    public OpCambiarClave() {
        initComponents();
    }

    private void initComponents() {

        cambiarClaveRepetir = new javax.swing.JLabel();
        cambioClave = new javax.swing.JLabel();
        titulo2 = new javax.swing.JLabel();
        segundaContra = new javax.swing.JTextField();
        primeraContra = new javax.swing.JTextField();
        cambiarClave = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(null);

        cambiarClaveRepetir.setFont(new java.awt.Font("Monospaced", 1, 24));
        cambiarClaveRepetir.setForeground(new java.awt.Color(0, 0, 0));
        cambiarClaveRepetir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cambiarClaveRepetir.setText("Confirme nueva clave");
        getContentPane().add(cambiarClaveRepetir);
        cambiarClaveRepetir.setBounds(70, 220, 310, 40);

        cambioClave.setFont(new java.awt.Font("Monospaced", 1, 24));
        cambioClave.setForeground(new java.awt.Color(0, 0, 0));
        cambioClave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cambioClave.setText("Digite su nueva clave");
        getContentPane().add(cambioClave);
        cambioClave.setBounds(70, 170, 310, 40);

        titulo2.setFont(new java.awt.Font("Monospaced", 1, 24));
        titulo2.setForeground(new java.awt.Color(0, 0, 0));
        titulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo2.setText("Cambie su clave aquí");
        titulo2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        getContentPane().add(titulo2);
        titulo2.setBounds(10, 90, 570, 40);
        getContentPane().add(segundaContra);
        segundaContra.setBounds(410, 220, 160, 30);
        getContentPane().add(primeraContra);
        primeraContra.setBounds(410, 170, 160, 30);

        cambiarClave.setText("Aceptar");
        getContentPane().add(cambiarClave);
        cambiarClave.setBounds(400, 300, 170, 50);

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
