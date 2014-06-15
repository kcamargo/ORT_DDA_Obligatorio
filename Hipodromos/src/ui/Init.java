package ui;

import bl.Administrador;
import bl.Caballo;
import bl.CaballoEnCarrera;
import bl.Carrera;
import bl.Fachada;
import bl.Hipodromo;
import bl.Jugador;
import bl.persistencia.PAdministrador;
import bl.persistencia.PCaballo;
import bl.persistencia.PCaballoEnCarrera;
import bl.persistencia.PCarrera;
import bl.persistencia.PHipodromo;
import bl.persistencia.PJugador;
import dal.ManejadorBD;
import java.util.ArrayList;
import util.Fecha;

public class Init {

    private static ManejadorBD bd = ManejadorBD.getInstancia();

    public static void main(String[] args) {
        //datosPrueba();
        cargaInicial();
        FrmLogin frm = new FrmLogin();
        frm.setVisible(true);
    }

    //<editor-fold defaultstate="collapsed" desc="Datos de Prueba">
    private static void cargaInicial() {
        cargarHipodromos();
        cargarUsuarios();
        cargarCaballos();
        cargarCarreras();
        cargarCaballosCarrera();
    }
    
    private static void cargarUsuarios() {
        ArrayList<Jugador> jugadores = bd.obtener(new PJugador(null));
        for (Jugador j : jugadores) {
            Fachada.getInstancia().agregarJugador(j);
        }
        
        ArrayList<Administrador> admins = bd.obtener(new PAdministrador(null));
        for (Administrador a : admins) {
            Fachada.getInstancia().agregarAdministrador(a);
        }
    }
    
    private static void cargarHipodromos() {
        ArrayList<Hipodromo> hipodromos = bd.obtener(new PHipodromo(null));
        for (Hipodromo h : hipodromos) {
            Fachada.getInstancia().agregarHipodromo(h);
        }
    }
    
    private static void cargarCaballos() {
        ArrayList<Caballo> caballos = bd.obtener(new PCaballo(null));
        for (Caballo h : caballos) {
            Fachada.getInstancia().agregarCaballo(h);
        }
    }
    
    private static void cargarCarreras() {
        ArrayList<Carrera> carreras = bd.obtener(new PCarrera(null));
    }
    
    private static void cargarCaballosCarrera() {
        ArrayList<CaballoEnCarrera> cecs = bd.obtener(new PCaballoEnCarrera(null));
    }
    //</editor-fold>
}