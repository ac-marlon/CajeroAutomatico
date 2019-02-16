package modelo;

/**
 *
 * @author marlon
 */
public class CajeroAutomatico {

    private int claveCajero = 1234;
    private int dineroDisponibleActual = 40000000;
    private int maximoRetiroPermitido = 2400000;

//__________________________Operaciones Administrador______________________//
    public int getClaveCajero() {
        return claveCajero;
    }

    public void setClaveCajero(int claveCajero) {
        this.claveCajero = claveCajero;
    }

    public int getDineroDisponibleActual() {
        return dineroDisponibleActual;
    }

    public void setDineroDisponibleActual(int dineroDisponibleActual) {
        this.dineroDisponibleActual = dineroDisponibleActual;
    }

    public int getMaximoRetiroPermitido() {
        return maximoRetiroPermitido;
    }

    public void setMaximoRetiroPermitido(int maximoRetiroPermitido) {
        this.maximoRetiroPermitido = maximoRetiroPermitido;
    }
}
