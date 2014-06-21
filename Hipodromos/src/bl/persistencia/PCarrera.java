package bl.persistencia;

import bl.CaballoEnCarrera;
import bl.Carrera;
import bl.Fachada;
import bl.Hipodromo;
import dal.ManejadorBD;
import dal.Persistente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PCarrera implements Persistente {

    private Carrera carrera;
    private Hipodromo hipodromo;

    public PCarrera(Carrera carrera, Hipodromo hipodromo) {
        this.carrera = carrera;
        this.hipodromo = hipodromo;
    }

    public PCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public ArrayList<String> getInsertSQL() {
        ArrayList<String> ret = new ArrayList<>();

        //Inserto todos los caballos
        for (CaballoEnCarrera cec : carrera.getCaballos()) {
            PCaballoEnCarrera pCec = new PCaballoEnCarrera(cec, carrera);
            ret.addAll(pCec.getInsertSQL());
        }

        String sqlCarrera = "INSERT INTO carreras VALUES (";
        sqlCarrera += getOid() + ", ";
        sqlCarrera += "'" + carrera.getNombre() + "', ";
        sqlCarrera += carrera.getNumero() + ", ";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        sqlCarrera += "'" + sdf.format(carrera.getFecha()) + "', ";
        sqlCarrera += carrera.getEstado().ordinal() + ", ";
        sqlCarrera += carrera.getGanador() == null
                ? "0, "
                : carrera.getGanador().getOid() + ", ";
        sqlCarrera += hipodromo.getOid();
        sqlCarrera += ");";
        ret.add(sqlCarrera);
        return ret;
    }

    @Override
    public ArrayList<String> getUpdateSQL() {
        ArrayList<String> ret = new ArrayList<>();
        String oidGanador = carrera.getGanador() == null
                ? null : "'" + carrera.getGanador().getOid() + "'";

        String sql = "UPDATE carreras SET ";
        sql += "estado = " + carrera.getEstado() + ", ";
        sql += "oidGanador = " + oidGanador;
        sql += "WHERE oid = '" + getOid() + "'";
        ret.add(sql);
        return ret;
    }

    @Override
    public ArrayList<String> getDeleteSQL() {
        ArrayList<String> ret = new ArrayList<>();

        //Borro todos los caballos
        for (CaballoEnCarrera cec : carrera.getCaballos()) {
            PCaballoEnCarrera pCec = new PCaballoEnCarrera(cec);
            ret.addAll(pCec.getDeleteSQL());
        }

        ret.add("DELETE FROM carreras WHERE oid = " + getOid());
        return ret;
    }

    @Override
    public String getSelectSQL() {
        String sql = "SELECT * FROM carreras";
        if (carrera != null && getOid() != 0) {
            sql += " WHERE oid = " + getOid();
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

            //Armo la lista de caballos
            PCaballoEnCarrera pCC = new PCaballoEnCarrera(carrera);
            ArrayList<CaballoEnCarrera> caballos = ManejadorBD.getInstancia().obtener(pCC);

            for (CaballoEnCarrera c : caballos) {
                carrera.agregarCaballo(c);
                c.setCarrera(carrera);
                if (rs.getInt("oidGanador") == c.getOid()) {
                    carrera.setGanadorSimple(c);
                    c.setGanador(true);
                }
            }

            //Busco el hipodromo y agrego la carrera.
            PHipodromo pHip = new PHipodromo(new Hipodromo());
            pHip.setOid(rs.getInt("oidHipodromo"));
            Hipodromo h = (Hipodromo) ManejadorBD.getInstancia().obtener(pHip).get(0);
            h = Fachada.getInstancia().buscarHipodromo(h.getNombre());

            h.agregarCarrera(carrera);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
