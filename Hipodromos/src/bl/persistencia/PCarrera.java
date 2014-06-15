package bl.persistencia;

import bl.CaballoEnCarrera;
import bl.Carrera;
import bl.Fachada;
import bl.Hipodromo;
import dal.ManejadorBD;
import dal.Persistente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PCarrera implements Persistente {

    private Carrera carrera;

    public PCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public ArrayList<String> getInsertSQL() {
        //TODO:
        ArrayList<String> ret = new ArrayList<>();
        String sql = "INSERT INTO carreras VALUES (";
        sql += getOid() + ", ";
        sql += "'" + carrera.getNombre() + "', ";
        sql += carrera.getNumero() + ", ";
        sql += "'" + carrera.getFecha() + "', ";
        sql += carrera.getEstado() + ", ";
        sql += carrera.getGanador() == null
                ? "NULL"
                : carrera.getGanador().getOid() + ", ";
        //Resolver como obtener el oid del hipodromo...
        sql += ");";
        ret.add(sql);
        return ret;
    }

    @Override
    public ArrayList<String> getUpdateSQL() {
        //TODO:
        ArrayList<String> ret = new ArrayList<>();
        String sql = "UPDATE carreras SET ";
        sql += "oid = " + carrera.getOid() + ", ";
        sql += "nombre = '" + carrera.getNombre() + "', ";
        sql += "numero = " + carrera.getNumero() + ", ";
        sql += "fecha = '" + carrera.getFecha() + "', ";
        sql += "estado = " + carrera.getEstado() + ", ";
        sql += carrera.getGanador() == null
                ? "NULL"
                : carrera.getGanador().getOid() + ", ";
        //sql += "oidHipodromo = " +  + ", ";
        sql += "WHERE oid = " + getOid();
        ret.add(sql);
        return ret;
    }

    @Override
    public ArrayList<String> getDeleteSQL() {
        ArrayList<String> ret = new ArrayList<>();

        for (CaballoEnCarrera cec : carrera.getCaballos()) {
            PCaballoEnCarrera pCec = new PCaballoEnCarrera(cec);
            ret.addAll(pCec.getDeleteSQL());
        }

        ret.add("DELETE FROM carreras WHERE oid = " + getOid());
        return ret;
    }

    @Override
    public String getSelectSQL() {
        String sql = "SELECT * FROM carreras CA INNER JOIN caballoscarrera CC, caballos C WHERE CA.oid = CC.oidCarrera AND CC.oidCaballo = C.oid";
        if (carrera != null && getOid() != 0) {
            sql += " AND oid = " + getOid();
        }
        return sql;
    }

    @Override
    public Persistente getNuevo() {
        return new PCarrera(new Carrera());
    }

    @Override
    public Object getObjeto() {
        return carrera;
    }

    @Override
    public int getOid() {
        return carrera.getOid();
    }

    @Override
    public void setOid(int oid) {
        carrera.setOid(oid);
    }

    @Override
    public void leerDesdeResultSet(ResultSet rs) {
        try {
            carrera.setOid(rs.getInt("oid"));
            carrera.setNombre(rs.getString("nombre"));
            carrera.setNumero(rs.getInt("numero"));
            carrera.setFecha(rs.getDate("fecha"));
            carrera.setEstado(Carrera.getEstado(rs.getInt("estado")));

            //Busco el hipodromo y agrego la carrera.
            PHipodromo pHip = new PHipodromo(new Hipodromo());
            pHip.setOid(rs.getInt("oidHipodromo"));
            
            Hipodromo h = (Hipodromo) ManejadorBD.getInstancia().obtener(pHip).get(0);
            h = Fachada.getInstancia().buscarHipodromo(h.getNombre());
            h.agregarCarrera(carrera);

            //Busco al caballo ganador y lo seteo.
            if (carrera.getEstado() == Carrera.EstadoCarrera.FINALIZADA) {
                PCaballoEnCarrera pCab = new PCaballoEnCarrera(new CaballoEnCarrera());
                pCab.setOid(rs.getInt("oidGanador"));
                ArrayList<CaballoEnCarrera> cabs = ManejadorBD.getInstancia().obtener(pCab);

                CaballoEnCarrera c = cabs.get(0);
                carrera.setGanadorSimple(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
