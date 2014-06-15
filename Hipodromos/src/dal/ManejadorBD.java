package dal;

import java.sql.*;
import java.util.ArrayList;

public class ManejadorBD {

    private Connection conexion;
    private static ManejadorBD instancia;

    private ManejadorBD() {
        conectar("jdbc:mysql://localhost:3306/obligatorio", "root", "root");
    }

    public static ManejadorBD getInstancia() {
        if (instancia == null) {
            instancia = new ManejadorBD();
        }
        return instancia;
    }

    public void conectar(String url, String user, String pass) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            System.out.println("Error de driver.");
        } catch (SQLException e1) {
            System.out.println("Error de conexion.");
        }
    }

    public void desconectar() {
        try {
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexi�n.");
        }
    }

    private void ejecutar(String sql) {
        try {
            Statement st = conexion.createStatement();
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al ejecutar sql.\n" + e.getMessage());
        }
    }

    private ResultSet consultar(String sql) {
        ResultSet rs = null;
        try {
            Statement st = conexion.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Error al ejecutar sql.\n" + e.getMessage());
        }
        return rs;
    }

    public int proximoOid() {
        int oid = -1;
        try {
            String sql = "SELECT value FROM config WHERE key='oid'";
            ResultSet rs = this.consultar(sql);
            while (rs.next()) {
                oid = Integer.parseInt(rs.getString("value"));
            }
            rs.close();
            oid++;
            this.ejecutar("UPDATE config set value=" + oid + " WHERE key='oid'");
        } catch (SQLException e) {
            System.out.println("Error al obtener el proximo oid." + e.getMessage());
        }
        return oid;
    }

    //<editor-fold defaultstate="collapsed" desc="Operaciones con Persistente">
    public ArrayList obtener(Persistente b) {
        ArrayList ret = new ArrayList();
        try {
            ResultSet rs = this.consultar(b.getSelectSQL());
            while (rs.next()) {
                Persistente aux = b.getNuevo();
                aux.leerDesdeResultSet(rs);
                ret.add(aux.getObjeto());
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener objetos.\n" + e.getMessage());
        }
        return ret;
    }

    public void agregar(Persistente b) {
        int oid = this.proximoOid();
        b.setOid(oid);
        for (String s : b.getInsertSQL()) {
            this.ejecutar(s);
        }
    }

    public void modificar(Persistente b) {
        for (String s : b.getUpdateSQL()) {
            this.ejecutar(s);
        }
    }

    public void eliminar(Persistente b) {
        for (String s : b.getDeleteSQL()) {
            this.ejecutar(s);
        }
        b.setOid(0);
    }

    public void actualizar(Persistente b) {
        try {
            ResultSet rs = this.consultar(b.getSelectSQL());
            while (rs.next()) {
                b.leerDesdeResultSet(rs);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer objeto.\n" + e.getMessage());
        }
    }
    //</editor-fold>
}
