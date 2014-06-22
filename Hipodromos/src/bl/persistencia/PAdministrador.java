package bl.persistencia;

import bl.Administrador;
import dal.Persistente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PAdministrador implements Persistente {

    private Administrador administrador;

    public PAdministrador(Administrador admin) {
        this.administrador = admin;
    }

    @Override
    public ArrayList<String> getInsertSQL() {
        ArrayList<String> ret = new ArrayList<>();
        String sql = "INSERT INTO administradores VALUES (";
        sql += getOid() + ", ";
        sql += "'" + administrador.getNombre() + "', ";
        sql += "'" + administrador.getApellido() + "', ";
        sql += "'" + administrador.getUsername() + "', ";
        sql += "'" + administrador.getPassword() + "'";
        sql += ");";
        ret.add(sql);
        return ret;
    }

    @Override
    public ArrayList<String> getUpdateSQL() {
        ArrayList<String> ret = new ArrayList<>();
        String sql = "UPDATE administradores SET ";
        sql += "nombre = '" + administrador.getNombre() + "', ";
        sql += "apellido = '" + administrador.getApellido() + "', ";
        sql += "username = '" + administrador.getUsername() + "', ";
        sql += "password = '" + administrador.getPassword() + "'";
        sql += "WHERE oid = " + getOid();
        ret.add(sql);
        return ret;
    }

    @Override
    public ArrayList<String> getDeleteSQL() {
        ArrayList<String> ret = new ArrayList<>();
        ret.add("DELETE FROM administradores WHERE oid = " + getOid());
        return ret;
    }

    @Override
    public String getSelectSQL() {
        String sql = "SELECT * FROM administradores";
        if (administrador != null && getOid() != 0) {
            sql += " WHERE oid = " + getOid();
        }
        return sql;
    }

    @Override
    public Persistente getNuevo() {
        return new PAdministrador(new Administrador());
    }

    @Override
    public Object getObjeto() {
        return administrador;
    }

    @Override
    public int getOid() {
        return administrador.getOid();
    }

    @Override
    public void setOid(int oid) {
        administrador.setOid(oid);
    }

    @Override
    public void leerDesdeResultSet(ResultSet rs) {
        try {
            administrador.setOid(rs.getInt("oid"));
            administrador.setNombre(rs.getString("nombre"));
            administrador.setApellido(rs.getString("apellido"));
            administrador.setUsername(rs.getString("username"));
            administrador.setPassword(rs.getString("password"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
