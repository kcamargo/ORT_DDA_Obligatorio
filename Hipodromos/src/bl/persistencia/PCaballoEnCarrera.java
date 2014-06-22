package bl.persistencia;

import bl.ApuestaCuadruple;
import bl.ApuestaSimple;
import bl.ApuestaTriple;
import bl.Caballo;
import bl.CaballoEnCarrera;
import bl.Carrera;
import bl.TipoApuesta;
import dal.ManejadorBD;
import dal.Persistente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PCaballoEnCarrera implements Persistente {

    private CaballoEnCarrera caballo;
    private Carrera carrera;

    public PCaballoEnCarrera(CaballoEnCarrera caballo, Carrera carrera) {
        this.caballo = caballo;
        this.carrera = carrera;
    }

    public PCaballoEnCarrera(CaballoEnCarrera caballo) {
        this.caballo = caballo;
    }

    public PCaballoEnCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public PCaballoEnCarrera() {
        caballo = null;
        carrera = null;
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
        sql += caballo.getTipoApuesta().getCodigo();
        sql += ");";
        ret.add(sql);
        return ret;
    }

    @Override
    public ArrayList<String> getUpdateSQL() {
        ArrayList<String> ret = new ArrayList<>();
        String sql = "UPDATE caballoscarrera SET ";
        sql += "oid = " + caballo.getOid() + ", ";
        sql += "oidCaballo = " + caballo.getCaballo().getOid() + ", ";
        sql += "oidCarrera = " + carrera != null ? "null, " : carrera.getOid() + ", ";
        sql += "numero = " + caballo.getNumero() + ", ";
        sql += "dividendo = " + caballo.getDividendo() + ", ";
        sql += "tipoApuesta = " + caballo.getTipoApuesta().getCodigo() + ", ";
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

        if (carrera != null && carrera.getOid() != 0) {
            sql += " WHERE oidCarrera = " + carrera.getOid();
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

            TipoApuesta tipo = null;
            switch (rs.getInt("tipoApuesta")) {
                case 1:
                    tipo = new ApuestaSimple();
                    break;
                case 3:
                    tipo = new ApuestaTriple();
                    break;
                case 4:
                    tipo = new ApuestaCuadruple();
                    break;
            }

           // caballo.setTipoApuesta(tipo);
            //Busco y seteo el caballo
            PCaballo pCab = new PCaballo(new Caballo());
            pCab.setOid(rs.getInt("oidCaballo"));
            Caballo cab = (Caballo) ManejadorBD.getInstancia().obtener(pCab).get(0);
            caballo.setCaballo(cab);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
