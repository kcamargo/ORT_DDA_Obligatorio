package dal;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface Persistente {

    //<editor-fold defaultstate="collapsed" desc="SQLs">
    public abstract ArrayList<String> getInsertSQL();

    public abstract ArrayList<String> getUpdateSQL();

    public abstract ArrayList<String> getDeleteSQL();

    public abstract String getSelectSQL();
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Get/Set">
    public abstract Persistente getNuevo();

    public abstract Object getObjeto();

    public abstract int getOid();

    public abstract void setOid(int oid);
    //</editor-fold>

    public abstract void leerDesdeResultSet(ResultSet rs);
}
