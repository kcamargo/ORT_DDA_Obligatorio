package bl.persistencia;

import bl.CaballoEnCarrera;
import bl.Carrera;
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
        //TODO:
        try {
            carrera.setOid(rs.getInt("oid"));
            carrera.setNombre(rs.getString("nombre"));
            carrera.setNumero(rs.getInt("numero"));
            carrera.setFecha(rs.getDate("fecha"));
            carrera.setEstado(Carrera.getEstado(rs.getInt("estado")));
            //Setear el ganador
            //Setear el hipodromo
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
