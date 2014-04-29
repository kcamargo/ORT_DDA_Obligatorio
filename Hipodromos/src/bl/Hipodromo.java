package bl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Hipodromo {

    private String nombre;
    private String direccion;
    private ArrayList<Jornada> jornadas;

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

    public ArrayList<Jornada> getCarreras() {
        return jornadas;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Hipodromo() {
        jornadas = new ArrayList<>();
    }

    public Hipodromo(String nombre, String direccion) {
        this();
        this.nombre = nombre;
        this.direccion = direccion;
    }
    //</editor-fold>

    public boolean validar() {
        return nombre != null && !nombre.isEmpty()
                && direccion != null && !direccion.isEmpty()
                && jornadas != null;
    }

    @Override
    public boolean equals(Object o) {
        Hipodromo h = (Hipodromo) o;
        return nombre.equals(h.getNombre())
                && direccion.equals(h.getDireccion());
    }

    public boolean estaDisponible(Caballo caballo, Date fecha) {
        boolean disponible = false;
        Jornada j = buscarJornada(fecha);
        if (j != null) {
            disponible = j.estaDisponible(caballo);
        }
        return disponible;
    }

    public boolean agregarCarrera(Carrera c) {
        if (buscarJornada(c.getFecha()) != null) {
            Jornada j = buscarJornada(c.getFecha());
            return j.agregarCarrera(c);
        } else {
            Jornada j = new Jornada(c.getFecha());
            agregarJornada(j);
            return agregarCarrera(c);
        }
    }

    public ArrayList<Carrera> getCarreras(Date fecha) {
        Jornada j = buscarJornada(fecha);
        if (j != null) {
            return j.getCarreras();
        } else {
            return null;
        }
    }

    public ArrayList<Carrera> getCarrerasAbiertas() {
        ArrayList<Carrera> retorno = new ArrayList<>();
        for (Jornada j : jornadas) {
            retorno.addAll(j.getCarrerasAbiertas());
        }
        return retorno;
    }

    public Carrera getSiguienteCarrera() {
        Collections.sort(jornadas);
        Jornada j = jornadas.get(jornadas.size() - 1);
        return j.getSiguienteCarrera();
    }

    public boolean abrirCarrera(Carrera c) {
        Jornada j = buscarJornada(c.getFecha());
        if (j != null) {
            return j.abrirCarrera(c);
        } else {
            return false;
        }
    }

    public boolean cerrarCarrera(Carrera c) {
        Jornada j = buscarJornada(c.getFecha());
        if (j != null) {
            return j.cerrarCarrera(c);
        } else {
            return false;
        }
    }

    private Jornada buscarJornada(Date fecha) {
        for (Jornada j : jornadas) {
            if (j.getFecha().equals(fecha)) {
                return j;
            }
        }
        return null;
    }

    private boolean agregarJornada(Jornada j) {
        if (!jornadas.contains(j)) {
            return jornadas.add(j);
        }
        return false;
    }
}
