package Controlador;

import Modelo.ModeloCalculadora;
import Vista.VistaCalculadora;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author marlon
 */
public class ControladorCalculadora implements ActionListener {

    ModeloCalculadora modelo;
    VistaCalculadora vista;

    public ControladorCalculadora(ModeloCalculadora modelo, VistaCalculadora vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciarVista() {
        vista.sumar.addActionListener(this);
        vista.restar.addActionListener(this);
        vista.multiplicar.addActionListener(this);
        vista.dividir.addActionListener(this);

        vista.setTitle("Calculadora");
        vista.pack();
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (vista.sumar == evento.getSource()) {
            try {
                modelo.setOperandoUno(Double.parseDouble(vista.operandoUno.getText()));
                modelo.setOperandoDos(Double.parseDouble(vista.operandoDos.getText()));
                modelo.suma();
                vista.resultado.setText(modelo.getResultado().toString());
            } catch (NumberFormatException e) {
                vista.resultado.setText("Introduzca una cantidad valida...");
            }
        } else if (vista.restar == evento.getSource()) {
            try {
                modelo.setOperandoUno(Double.parseDouble(vista.operandoUno.getText()));
                modelo.setOperandoDos(Double.parseDouble(vista.operandoDos.getText()));
                modelo.resta();
                vista.resultado.setText(modelo.getResultado().toString());
            } catch (NumberFormatException e) {
                vista.resultado.setText("Introduzca una cantidad valida...");
            }
        } else if (vista.multiplicar == evento.getSource()) {
            try {
                modelo.setOperandoUno(Double.parseDouble(vista.operandoUno.getText()));
                modelo.setOperandoDos(Double.parseDouble(vista.operandoDos.getText()));
                modelo.multiplicacion();
                vista.resultado.setText(modelo.getResultado().toString());
            } catch (NumberFormatException e) {
                vista.resultado.setText("Introduzca una cantidad valida...");
            }
        } else if (vista.dividir == evento.getSource()) {
            try {
                modelo.setOperandoUno(Double.parseDouble(vista.operandoUno.getText()));
                modelo.setOperandoDos(Double.parseDouble(vista.operandoDos.getText()));
                modelo.division();
                vista.resultado.setText(modelo.getResultado().toString());
            } catch (NumberFormatException e) {
                vista.resultado.setText("Introduzca una cantidad valida...");
            }
        }
    }

}
