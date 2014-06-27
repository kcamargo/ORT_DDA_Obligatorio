package bl;

import java.util.ArrayList;
import java.util.Date;
import util.Observable;

public class Fachada extends Observable {

    private SSHipodromos ssHipodromos;
    private SSUsuarios ssUsuarios;

    public enum Evento {

        agregarHipodromo
    }
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
        return Fachada.Instancia;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="SSHipodromos">
    public Hipodromo getHipodromoActual() {
        return ssHipodromos.getHipodromoActual();
    }

    public void agregarHipodromo(Hipodromo hipodromo) throws Exception {
        ssHipodromos.agregarHipodromo(hipodromo);
    }

    public boolean guardarHipodromo(Hipodromo hipodromo) throws Exception {
        return ssHipodromos.guardarHipodromo(hipodromo);
    }
    
    public Hipodromo seleccionarHipodromo(Hipodromo hipodromo) {
        return ssHipodromos.seleccionarHipodromo(hipodromo);
    }

    public boolean agregarCaballo(Caballo caballo) {
        return ssHipodromos.agregarCaballo(caballo);
    }

    public ArrayList<Caballo> getCaballosDisponibles(Date fecha) {
        return ssHipodromos.getCaballosDisponibles(fecha);
    }

    public ArrayList<Hipodromo> getHipodromos() {
        return ssHipodromos.getHipodromos();
    }

    public Hipodromo buscarHipodromo(String nombre) {
        return ssHipodromos.buscarHipodromo(nombre);
    }

    public Caballo buscarCaballo(String nombre) {
        return ssHipodromos.buscarCaballo(nombre);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="SSUsuarios">
    public Administrador login(Administrador admin) {
        return ssUsuarios.login(admin);
    }

    public Jugador login(Jugador jugador) {
        return ssUsuarios.login(jugador);
    }

    public boolean agregarAdministrador(Administrador a) {
        return ssUsuarios.agregarAdministrador(a);
    }

    public boolean agregarJugador(Jugador j) {
        return ssUsuarios.agregarJugador(j);
    }
    //</editor-fold>
}
