package bl;

import java.util.ArrayList;
import java.util.Date;
import util.Fecha;

public class Hipodromo {

    private String nombre;
    private String direccion;
    private ArrayList<Jornada> jornadas;
    private Carrera siguienteCarrera;
    private Carrera carreraAbierta;
    private Carrera carreraCerrada;

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

    public ArrayList<Jornada> getJornadas() {
        return jornadas;
    }

    public Carrera getSiguienteCarrera() {
        if (siguienteCarrera == null) {
            if (jornadas.size() > 0) {
                Jornada j = buscarJornada(Fecha.fechaActual());
                if (j != null) {
                    siguienteCarrera = j.getSiguienteCarrera();
                }
            }
        }
        return siguienteCarrera;
    }

    public Carrera getCarreraAbierta() {
        if (carreraAbierta == null) {
            if (jornadas.size() > 0) {
                Jornada j = buscarJornada(Fecha.fechaActual());
                if (j != null) {
                    carreraAbierta = j.getCarreraAbierta();
                }
            }
        }
        return carreraAbierta;
    }

    public Carrera getCarreraCerrada() {
        if (carreraCerrada == null) {
            if (jornadas.size() > 0) {
                Jornada j = buscarJornada(Fecha.fechaActual());
                if (j != null) {
                    carreraCerrada = j.getCarreraCerrada();
                }
            }
        }
        return carreraCerrada;
    }

    public void setSiguienteCarrera(Carrera c) {
        this.siguienteCarrera = c;
    }

    public void setCarreraAbierta(Carrera c) {
        this.carreraAbierta = c;
    }

    public void setCarreraCerrada(Carrera c) {
        this.carreraCerrada = c;
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

    //<editor-fold defaultstate="collapsed" desc="Validaciones">
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Carreras">
    public boolean agregarCarrera(Carrera c) {
        Jornada j = buscarJornada(c.getFecha());
        if (j == null) {
            j = new Jornada(c.getFecha());
            agregarJornada(j);
        }
        return j.agregarCarrera(c);
    }
    
    public void borrarCarrera(Carrera c){
        Jornada j = buscarJornada(c.getFecha());
        if( j!=null ){
            j.eliminarCarrera(c);
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

    public boolean abrirCarrera(Carrera c) {
        Jornada j = buscarJornada(c.getFecha());
        if (j != null) {
            if (j.abrirCarrera(c)) {
                setSiguienteCarrera(null);
                setSiguienteCarrera(getSiguienteCarrera());
                setCarreraAbierta(c);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean cerrarCarrera(Carrera c) {
        Jornada j = buscarJornada(c.getFecha());
        if (j != null) {
            if (j.cerrarCarrera(c)) {
                setCarreraAbierta(null);
                setCarreraCerrada(c);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean asignarGanador(Carrera c, CaballoEnCarrera caballo) {
        Jornada j = buscarJornada(c.getFecha());
        if (j != null) {
            if (j.asignarGanador(c, caballo)) {
                setCarreraCerrada(null);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Jornadas">
    private Jornada buscarJornada(Date fecha) {
        for (Jornada j : jornadas) {
            //TODO: Validar lógica
            if (Fecha.formatearFecha(fecha).equals(Fecha.formatearFecha(j.getFecha()))) {
                return j;
            }
        }
        return null;
    }

    private boolean agregarJornada(Jornada j) {
        return jornadas.add(j);
    }
    //</editor-fold>

    public boolean estaDisponible(Caballo caballo, Date fecha) {
        boolean disponible = false;
        Jornada j = buscarJornada(fecha);
        if (j != null) {
            disponible = j.estaDisponible(caballo);
        }
        return disponible;
    }

    @Override
    public boolean equals(Object o) {
        Hipodromo h = (Hipodromo) o;
        return nombre.equals(h.getNombre());
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
