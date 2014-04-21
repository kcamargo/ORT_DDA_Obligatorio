package bl;

import java.util.ArrayList;

public class Hipodromo {

    private String nombre;
    private String direccion;
    private ArrayList<Carrera> carreras;

    //<editor-fold defaultstate="collapsed" desc="Get/Set">
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }
    //</editor-fold>

    public boolean validar() {
        return nombre != null && !nombre.equals("")
                && direccion != null && !direccion.equals("")
                && carreras != null;
    }
}
