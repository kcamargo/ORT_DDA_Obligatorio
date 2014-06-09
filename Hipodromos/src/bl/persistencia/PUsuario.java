package bl.persistencia;

import bl.Usuario;
import dal.Persistente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PUsuario implements Persistente {

    private Usuario usuario;

    public PUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public ArrayList<String> getInsertSQL() {
        ArrayList<String> ret = new ArrayList<>();
        String sql = "INSERT INTO usuarios VALUES (";
        sql += getOid() + "', ";
        sql += "'" + usuario.getNombre() + "', ";
        sql += "'" + usuario.getApellido() + "', ";
        sql += "'" + usuario.getUsername() + "', ";
        sql += "'" + usuario.getPassword() + "'";
        sql += ");";
        ret.add(sql);
        return ret;
    }

    @Override
    public ArrayList<String> getUpdateSQL() {
        ArrayList<String> ret = new ArrayList<>();
        String sql = "UPDATE usuarios SET ";
        sql += "nombre = '" + usuario.getNombre() + "', ";
        sql += "apellido = '" + usuario.getApellido() + "', ";
        sql += "username = '" + usuario.getUsername() + "', ";
        sql += "password = '" + usuario.getPassword() + "'";
        sql += "WHERE oid = " + getOid();
        ret.add(sql);
        return ret;
    }

    @Override
    public ArrayList<String> getDeleteSQL() {
        ArrayList<String> ret = new ArrayList<>();
        ret.add("DELETE FROM usuarios WHERE oid = " + getOid());
        return ret;
    }

    @Override
    public String getSelectSQL() {
        String sql = "SELECT * FROM usuarios";
        if (usuario != null && getOid() != 0) {
            sql += " WHERE oid = " + getOid();
        }
        return sql;
    }

    @Override
    public Persistente getNuevo() {
        return new PUsuario(new Usuario());
    }

    @Override
    public Object getObjeto() {
        return usuario;
    }

    @Override
    public int getOid() {
        return usuario.getOid();
    }

    @Override
    public void setOid(int oid) {
        usuario.setOid(oid);
    }

    @Override
    public void leerDesdeResultSet(ResultSet rs) {
        try {
            usuario.setOid(rs.getInt("oid"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setApellido(rs.getString("apellido"));
            usuario.setUsername(rs.getString("username"));
            usuario.setPassword(rs.getString("password"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
