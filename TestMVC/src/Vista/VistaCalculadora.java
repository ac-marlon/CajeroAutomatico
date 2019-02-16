package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author marlon
 */
public class VistaCalculadora extends JFrame {

    public JButton sumar, restar, multiplicar, dividir;
    public JTextField operandoUno, operandoDos, resultado;
    private final JPanel panelOperandos, panelOperaciones, panelResultado;

    public VistaCalculadora() {
        getContentPane().setLayout(new BorderLayout());

        panelOperandos = new JPanel();
        panelOperandos.setLayout(new FlowLayout());

        panelOperaciones = new JPanel();
        panelOperaciones.setLayout(new FlowLayout());

        panelResultado = new JPanel();
        panelResultado.setLayout(new FlowLayout());

        sumar = new JButton("+");
        restar = new JButton("-");
        multiplicar = new JButton("x");
        dividir = new JButton("/");

        resultado = new JTextField(20);
        operandoUno = new JTextField(20);
        operandoDos = new JTextField(20);

        panelOperandos.add(operandoUno);
        panelOperandos.add(operandoDos);
        panelOperaciones.add(sumar);
        panelOperaciones.add(restar);
        panelOperaciones.add(multiplicar);
        panelOperaciones.add(dividir);
        panelResultado.add(resultado);

        add(panelOperandos, BorderLayout.NORTH);
        add(panelOperaciones, BorderLayout.CENTER);
        add(panelResultado, BorderLayout.SOUTH);

        resultado.setEditable(false);
        setResizable(false);

    }

}
