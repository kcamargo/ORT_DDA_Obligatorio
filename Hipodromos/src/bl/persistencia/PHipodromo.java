package bl.persistencia;

import bl.Hipodromo;
import dal.Persistente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PHipodromo implements Persistente {

    private Hipodromo hipodromo;

    public PHipodromo(Hipodromo hipodromo) {
        this.hipodromo = hipodromo;
    }

    @Override
    public ArrayList<String> getInsertSQL() {
        ArrayList<String> ret = new ArrayList<>();
        String sql = "INSERT INTO hipodromos VALUES (";
        sql += getOid() + ", ";
        sql += "'" + hipodromo.getNombre() + "', ";
        sql += "'" + hipodromo.getDireccion() + "'";
        sql += ");";
        ret.add(sql);
        return ret;
    }

    @Override
    public ArrayList<String> getUpdateSQL() {
        ArrayList<String> ret = new ArrayList<>();
        String sql = "UPDATE hipodromos SET ";
        sql += "nombre = '" + hipodromo.getNombre() + "', ";
        sql += "direccion = '" + hipodromo.getDireccion() + "' ";
        sql += "WHERE oid = " + getOid();
        ret.add(sql);
        return ret;
    }

    @Override
    public ArrayList<String> getDeleteSQL() {
        ArrayList<String> ret = new ArrayList<>();
        ret.add("DELETE FROM hipodromos WHERE oid = " + getOid());
        return ret;
    }

    @Override
    public String getSelectSQL() {
        String sql = "SELECT * FROM hipodromos";
        if (hipodromo != null && getOid() != 0) {
            sql += " WHERE oid = " + getOid();
        }
        return sql;
    }

    @Override
    public Persistente getNuevo() {
        return new PHipodromo(new Hipodromo());
    }

    @Override
    public Object getObjeto() {
        return hipodromo;
    }

    @Override
    public int getOid() {
        return hipodromo.getOid();
    }

    @Override
    public void setOid(int oid) {
        hipodromo.setOid(oid);
    }

    @Override
    public void leerDesdeResultSet(ResultSet rs) {
        try {
            hipodromo.setOid(rs.getInt("oid"));
            hipodromo.setNombre(rs.getString("nombre"));
            hipodromo.setDireccion(rs.getString("direccion"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
