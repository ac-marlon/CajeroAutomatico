package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author marlon
 */
public class SQLiteJDBCDriverConnection {

    Connection conn = null;
    Statement stmt = null;
    String url = "jdbc:sqlite:/home/marlon/NetBeansProjects/CajeroAutomatico/baseDatosBancaria.db";

    public void obtenerDatosTarDebCuenta(TarjetaDebito tarjetaDeb, int idTarjeta, Cuenta cuenta) {

        try {
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
            stmt = conn.createStatement();

            try (ResultSet rs = stmt.executeQuery("select * from TarjetaDebito where idTarjeta = " + idTarjeta + ";")) {
                while (rs.next()) {
                    tarjetaDeb.setIdTarjeta(rs.getInt("idTarjeta"));
                    tarjetaDeb.setFechaVencimiento(rs.getString("fechaVencimiento"));
                    tarjetaDeb.setClave(rs.getInt("clave"));
                    tarjetaDeb.getClienteAsociado().setIdUsuario(rs.getInt("idTitularAsociado"));
                    tarjetaDeb.setEstado(rs.getBoolean("estado"));

                    System.out.println("---InfoTarjeta---");
                    System.out.println(rs.getInt("idTarjeta"));
                    System.out.println(rs.getString("fechaVencimiento"));
                    System.out.println(rs.getInt("clave"));
                    System.out.println(rs.getInt("idTitularAsociado"));
                    System.out.println(rs.getBoolean("estado"));

                }
                rs.close();
            }

            try (ResultSet rs = stmt.executeQuery("select * from Cuenta where idTarjetaAsociada = " + idTarjeta + ";")) {
                while (rs.next()) {
                    cuenta.setIdCuenta(rs.getInt("idCuenta"));
                    cuenta.setIntentosAcceso(rs.getInt("intentosAcceso"));
                    cuenta.setSaldoActual(rs.getInt("saldoActual"));
                    cuenta.setProductosServAdquiridos(rs.getString("productosServiciosAd"));

                    System.out.println("---InfoCuenta---");
                    System.out.println(rs.getInt("idCuenta"));
                    System.out.println(rs.getInt("intentosAcceso"));
                    System.out.println(rs.getInt("saldoActual"));
                    System.out.println(rs.getString("productosServiciosAd"));
                }
                rs.close();
            }
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void obtenerDatosCliente(Cliente cliente, int idUsuario) {

        try {
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
            stmt = conn.createStatement();

            try (ResultSet rs = stmt.executeQuery("select * from Cliente where idUsuario = " + idUsuario + ";")) {
                while (rs.next()) {
                    cliente.setNombreUsuario(rs.getString("nombreUsuario"));
                    cliente.setApellidoUsuario(rs.getString("apellidoUsuario"));

                    System.out.println("---InfoCliente---");
                    System.out.println(rs.getString("nombreUsuario"));
                    System.out.println(rs.getString("apellidoUsuario"));
                }
                rs.close();
            }
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int obtenerClaveTarDeb(TarjetaDebito tarjetaDeb) {

        int claveOriginal = 0;
        try {

            int idTarjetaDeb = tarjetaDeb.getIdTarjeta();
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
            stmt = conn.createStatement();

            try (ResultSet rs = stmt.executeQuery("select clave from TarjetaDebito where idTarjeta = " + idTarjetaDeb + ";")) {
                while (rs.next()) {
                    claveOriginal = rs.getInt("clave");
                    System.out.println("---ClaveOriginal---");
                    System.out.println(rs.getInt("clave"));
                }
                rs.close();
            }
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return claveOriginal;
    }

    public void actualizarEstadoTarDeb(TarjetaDebito tarjetaDeb) {

        try {
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
            stmt = conn.createStatement();

            String sqlActEstasdo = "update TarjetaDebito set estado = " + tarjetaDeb.isEstado() + " where idTarjeta = " + tarjetaDeb.getIdTarjeta() + ";";
            System.out.println(sqlActEstasdo);
            stmt.executeUpdate(sqlActEstasdo);

            conn.commit();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void actualizarTodosDatos(Cliente cliente, TarjetaDebito tarjetaDeb, Cuenta cuenta) {
        try {
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
            stmt = conn.createStatement();

            String sqlActTarDeb = "update TarjetaDebito set clave = " + tarjetaDeb.getClave() + ", estado = " + tarjetaDeb.isEstado() + " where idTarjeta = " + tarjetaDeb.getIdTarjeta() + ";";
            String sqlActCuenta = "update Cuenta set intentosAcceso = " + cuenta.getIntentosAcceso() + ", saldoActual = " + cuenta.getSaldoActual() + ", productosServiciosAd = '" + cuenta.getProductosServAdquiridos() + "' where idCuenta = " + cuenta.getIdCuenta() + ";";
            System.out.println(sqlActTarDeb);
            System.out.println(sqlActCuenta);
            stmt.executeUpdate(sqlActTarDeb);
            stmt.executeUpdate(sqlActCuenta);

            conn.commit();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
