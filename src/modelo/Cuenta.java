package modelo;

/**
 *
 * @author marlon
 */
public class Cuenta {

    private int idCuenta;
    private TarjetaDebito tarjetaAsociada;
    private int intentosAcceso;
    private int saldoActual;
    private String productosServAdquiridos = "";

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public TarjetaDebito getTarjetaAsociada() {
        return tarjetaAsociada;
    }

    public void setTarjetaAsociada(TarjetaDebito tarjetaAsociada) {
        this.tarjetaAsociada = tarjetaAsociada;
    }

    public int getIntentosAcceso() {
        return intentosAcceso;
    }

    public void setIntentosAcceso(int intentosAcceso) {
        this.intentosAcceso = intentosAcceso;
    }

    public int getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(int saldoActual) {
        this.saldoActual = saldoActual;
    }

    public String getProductosServAdquiridos() {
        return productosServAdquiridos;
    }

    public void setProductosServAdquiridos(String productosServAdquiridos) {
        this.productosServAdquiridos = productosServAdquiridos;
    }
}
