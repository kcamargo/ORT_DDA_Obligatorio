package bl.persistencia;

import bl.CaballoEnCarrera;
import dal.Persistente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PCaballoEnCarrera implements Persistente {

    private CaballoEnCarrera caballo;

    public PCaballoEnCarrera(CaballoEnCarrera caballo) {
        this.caballo = caballo;
    }

    PCaballoEnCarrera() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getInsertSQL() {
        //TODO:
        ArrayList<String> ret = new ArrayList<>();
        String sql = "INSERT INTO caballoscarrera VALUES (";
        sql += getOid() + ", ";
        sql += caballo.getCaballo().getOid() + ", ";
        //Resolver como obtener el oid de la carrera...
        sql += caballo.getNumero() + ", ";
        sql += caballo.getDividendo() + ", ";
        sql += caballo.getTipoApuesta();
        sql += ");";
        ret.add(sql);
        return ret;
    }

    @Override
    public ArrayList<String> getUpdateSQL() {
        //TODO:
        ArrayList<String> ret = new ArrayList<>();
        String sql = "UPDATE caballoscarrera SET ";
        sql += "oid = '" + caballo.getOid() + "', ";
        sql += "oidCaballo = '" + caballo.getCaballo().getOid() + "', ";
        //sql += "oidCarrera = '" + ????? + "', ";
        sql += "numero = '" + caballo.getNumero() + "', ";
        sql += "dividendo = '" + caballo.getDividendo() + "', ";
        sql += "tipoApuesta = '" + caballo.getTipoApuesta() + "', ";
        sql += "WHERE oid = " + getOid();
        ret.add(sql);
        return ret;
    }

    @Override
    public ArrayList<String> getDeleteSQL() {
        ArrayList<String> ret = new ArrayList<>();
        ret.add("DELETE FROM caballoscarrera WHERE oid = " + getOid());
        return ret;
    }

    @Override
    public String getSelectSQL() {
        String sql = "SELECT * FROM caballoscarrera";
        if (caballo != null && getOid() != 0) {
            sql += " WHERE oid = " + getOid();
        }
        return sql;
    }

    @Override
    public Persistente getNuevo() {
        return new PCaballoEnCarrera(new CaballoEnCarrera());
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
        //TODO:
        try {
            caballo.setOid(rs.getInt("oid"));
            //caballo.set(rs.getInt("oidCaballo"));
            //caballo.set(rs.getInt("oidCarrera"));
            caballo.setNumero(rs.getInt("numero"));
            caballo.setDividendo(rs.getDouble("dividendo"));
            //caballo.setTipoApuesta(rs.getInt("tipoApuesta"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
