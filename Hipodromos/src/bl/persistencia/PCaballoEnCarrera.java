package bl.persistencia;

import bl.Caballo;
import bl.CaballoEnCarrera;
import bl.Carrera;
import bl.Fachada;
import dal.ManejadorBD;
import dal.Persistente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PCaballoEnCarrera implements Persistente {

    private CaballoEnCarrera caballo;
    private Carrera carrera;

    public PCaballoEnCarrera(CaballoEnCarrera caballo) {
        this.caballo = caballo;
    }

    PCaballoEnCarrera() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getInsertSQL() {
        ArrayList<String> ret = new ArrayList<>();
        String sql = "INSERT INTO caballoscarrera VALUES (";
        sql += getOid() + ", ";
        sql += caballo.getCaballo().getOid() + ", ";
        sql += carrera.getOid() + ", ";
        sql += caballo.getNumero() + ", ";
        sql += caballo.getDividendo() + ", ";
        sql += caballo.getTipoApuesta();
        sql += ");";
        ret.add(sql);
        return ret;
    }

    @Override
    public ArrayList<String> getUpdateSQL() {
        ArrayList<String> ret = new ArrayList<>();
        String sql = "UPDATE caballoscarrera SET ";
        sql += "oid = '" + caballo.getOid() + "', ";
        sql += "oidCaballo = '" + caballo.getCaballo().getOid() + "', ";
        sql += "oidCarrera = '" + carrera.getOid() + "', ";
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
        try {
            caballo.setOid(rs.getInt("oid"));
            caballo.setNumero(rs.getInt("numero"));
            caballo.setDividendo(rs.getDouble("dividendo"));

            //Busco y seteo el caballo
            PCaballo pCab = new PCaballo(new Caballo());
            pCab.setOid(rs.getInt("oidCaballo"));
            Caballo cab = (Caballo) ManejadorBD.getInstancia().obtener(pCab).get(0);

            cab = Fachada.getInstancia().buscarCaballo(cab.getNombre());
            caballo.setCaballo(cab);

            //Busco la carrera y le agrego el caballo
            Carrera car = Fachada.getInstancia().buscarCarreraPorOid(rs.getInt("oidCarrera"));;
            if (car != null) {
                car.agregarCaballo(caballo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
