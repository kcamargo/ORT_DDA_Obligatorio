package bl.persistencia;

import bl.Jugador;
import dal.Persistente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PJugador implements Persistente {

    private Jugador jugador;

    public PJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public ArrayList<String> getInsertSQL() {
        ArrayList<String> ret = new ArrayList<>();
        String sql = "INSERT INTO jugadores VALUES (";
        sql += getOid() + ", ";
        sql += "'" + jugador.getNombre() + "', ";
        sql += "'" + jugador.getApellido() + "', ";
        sql += "'" + jugador.getUsername() + "', ";
        sql += "'" + jugador.getPassword() + "', ";
        sql += "'" + jugador.getSaldo() + "'";
        sql += ");";
        ret.add(sql);
        return ret;
    }

    @Override
    public ArrayList<String> getUpdateSQL() {
        ArrayList<String> ret = new ArrayList<>();
        String sql = "UPDATE jugadores SET ";
        sql += "nombre = '" + jugador.getNombre() + "', ";
        sql += "apellido = '" + jugador.getApellido() + "', ";
        sql += "username = '" + jugador.getUsername() + "', ";
        sql += "password = '" + jugador.getPassword() + "', ";
        sql += "saldo = '" + jugador.getSaldo() + "'";
        sql += "WHERE oid = " + getOid();
        ret.add(sql);
        return ret;
    }

    @Override
    public ArrayList<String> getDeleteSQL() {
        ArrayList<String> ret = new ArrayList<>();
        ret.add("DELETE FROM jugadores WHERE oid = " + getOid());
        return ret;
    }

    @Override
    public String getSelectSQL() {
        String sql = "SELECT * FROM jugadores";
        if (jugador != null && getOid() != 0) {
            sql += " WHERE oid = " + getOid();
        }
        return sql;
    }

    @Override
    public Persistente getNuevo() {
        return new PJugador(new Jugador());
    }

    @Override
    public Object getObjeto() {
        return jugador;
    }

    @Override
    public int getOid() {
        return jugador.getOid();
    }

    @Override
    public void setOid(int oid) {
        jugador.setOid(oid);
    }

    @Override
    public void leerDesdeResultSet(ResultSet rs) {
        try {
            jugador.setOid(rs.getInt("oid"));
            jugador.setNombre(rs.getString("nombre"));
            jugador.setApellido(rs.getString("apellido"));
            jugador.setUsername(rs.getString("username"));
            jugador.setPassword(rs.getString("password"));
            jugador.sumarSaldo(rs.getDouble("saldo"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
