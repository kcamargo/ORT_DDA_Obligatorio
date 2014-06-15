package bl.persistencia;

import bl.Caballo;
import dal.Persistente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PCaballo implements Persistente {

    private Caballo caballo;

    public PCaballo(Caballo c) {
        caballo = c;
    }

    @Override
    public ArrayList<String> getInsertSQL() {
        ArrayList<String> ret = new ArrayList<>();
        String sql = "INSERT INTO caballos VALUES (";
        sql += "'" + caballo.getNombre() + "', ";
        sql += "'" + caballo.getNombreResponsable() + "', ";
        sql += getOid();
        sql += ");";
        ret.add(sql);
        return ret;
    }

    @Override
    public ArrayList<String> getUpdateSQL() {
        ArrayList<String> ret = new ArrayList<>();
        String sql = "UPDATE caballos SET ";
        sql += "nombre = '" + caballo.getNombre() + "', ";
        sql += "responsable = '" + caballo.getNombreResponsable() + "' ";
        sql += "WHERE oid = " + getOid();
        ret.add(sql);
        return ret;
    }

    @Override
    public ArrayList<String> getDeleteSQL() {
        ArrayList<String> ret = new ArrayList<>();
        ret.add("DELETE FROM caballos WHERE oid = " + getOid());
        return ret;
    }

    @Override
    public String getSelectSQL() {
        String sql = "SELECT * FROM caballos";
        if (caballo != null && getOid() != 0) {
            sql += " WHERE oid = " + getOid();
        }
        return sql;
    }

    @Override
    public Persistente getNuevo() {
        return new PCaballo(new Caballo());
    }

    @Override
    public Object getObjeto() {
        return caballo;
    }

    @Override
    public int getOid() {
        return caballo.getOid();
    }

    @Override
    public void setOid(int oid) {
        caballo.setOid(oid);
    }

    @Override
    public void leerDesdeResultSet(ResultSet rs) {
        try {
            caballo.setOid(rs.getInt("oid"));
            caballo.setNombre(rs.getString("nombre"));
            caballo.setNombreResponsable(rs.getString("responsable"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
