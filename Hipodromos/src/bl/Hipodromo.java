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
    public ArrayList<Jornada> getJornadas(){
        return jornadas;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Hipodromo() {
        jornadas = new ArrayList<>();
    }

    public Hipodromo(String nombre, String direccion) {
        this();
        if (this.validarIngreso(nombre, direccion)) {
            this.nombre = nombre;
            this.direccion = direccion;
        }
    }
    //</editor-fold>

    public boolean validar() {
        return nombre != null && !nombre.isEmpty()
                && direccion != null && !direccion.isEmpty()
                && jornadas != null;

    }

    public boolean validarIngreso(String nombre, String direccion) {
        return nombre != null && !nombre.isEmpty()
                && direccion != null && !direccion.isEmpty();
    }
    public boolean validarDatosCarrera(Carrera c){
        boolean ret =true;
        for(Jornada j : Fachada.getInstancia().getHipodromoActual().jornadas){
            for (Carrera carrera : j.getCarreras()){
               if( carrera.getNombre().equals(c.getNombre()) && carrera.getFecha().equals(c.getFecha())  ){                
                    ret = false;
                }
            }
        }
    
        return ret;
    }
    public int validarCampos(String pNombre, String pDireccion) {
        int retorno = 1;
        return retorno;
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
        Jornada j;
        if (buscarJornada(c.getFecha()) != null) {
            j = buscarJornada(c.getFecha());
        } else {
            j = new Jornada(c.getFecha());
            agregarJornada(j);
        }
        return j.agregarCarrera(c);
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
        //TODO: Validar esta lógica.
        if (jornadas.size() > 0) {
            Collections.sort(jornadas);
            for (Jornada j : jornadas) {
                Carrera c = j.getSiguienteCarrera();
                if (c != null) {
                    return c;
                }
            }
        }
        return null;
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

    //@Override
    /*public boolean equals(Object o) {
     Hipodromo h = (Hipodromo) o;
     return nombre.equals(h.getNombre())
     && direccion.equals(h.getDireccion());
     }*/
    @Override
    public String toString() {
        return getNombre();
    }
}
