package Modelo;

/**
 *
 * @author marlon
 */
public class ModeloCalculadora {

    private Double operandoUno;
    private Double operandoDos;
    private Double resultado;

    public void setOperandoUno(Double operandoUno) {
        this.operandoUno = operandoUno;
    }

    public void setOperandoDos(Double operandoDos) {
        this.operandoDos = operandoDos;
    }

    public Double getResultado() {
        return resultado;
    }

    public void suma() {
        resultado = operandoUno + operandoDos;
    }

    public void resta() {
        resultado = operandoUno - operandoDos;
    }

    public void multiplicacion() {
        resultado = operandoUno * operandoDos;
    }

    public void division() {
        resultado = operandoUno / operandoDos;
    }
}
