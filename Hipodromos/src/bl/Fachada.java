package bl;

import java.util.ArrayList;
import java.util.Date;

public class Fachada {

    private SSHipodromos ssHipodromos;
    private SSUsuarios ssUsuarios;
    //<editor-fold defaultstate="collapsed" desc="Singleton">
    private static Fachada Instancia;

    private Fachada() {
        ssHipodromos = new SSHipodromos();
        ssUsuarios = new SSUsuarios();
    }

    public static Fachada getInstancia() {
        if (Fachada.Instancia == null) {
            Fachada.Instancia = new Fachada();
        }
        return getInstancia();
    }
    //</editor-fold>

    public boolean agregarHipodromo(Hipodromo h) {
        return ssHipodromos.agregarHipodromo(h);
    }

    public boolean agregarCaballo(Caballo c) {
        return ssHipodromos.agregarCaballo(c);
    }

    public boolean agregarUsuario(Usuario u) {
        return ssUsuarios.agregarUsuario(u);
    }

    public boolean agregarCarrera(Hipodromo h, Carrera c) {
        return ssHipodromos.agregarCarrera(h, c);
    }

    public boolean abrirCarrera(Hipodromo h, Carrera c) {
        return ssHipodromos.abrirCarrera(h, c);
    }

    public boolean cerrarCarrera(Hipodromo h, Carrera c) {
        return ssHipodromos.cerrarCarrera(h, c);
    }

    public boolean login(Usuario u) {
        return ssUsuarios.login(u);
    }

    public ArrayList<Carrera> getCarreras(Hipodromo h, Date fecha) {
        return ssHipodromos.getCarreras(h, fecha);
    }

    public ArrayList<Carrera> getCarrerasAbiertas(Hipodromo h) {
        return ssHipodromos.getCarrerasAbiertas(h);
    }

    public Carrera getSiguienteCarrera(Hipodromo h) {
        return ssHipodromos.getSiguienteCarrera(h);
    }

    public ArrayList<Caballo> getCaballosDisponibles(Date fecha) {
        return ssHipodromos.getCaballosDisponibles(fecha);
    }
}
