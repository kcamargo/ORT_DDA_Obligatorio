package ui;

import bl.Administrador;
import bl.Caballo;
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

public class Init {

    private static ManejadorBD bd = ManejadorBD.getInstancia();

    public static void main(String[] args) {
        cargaInicial();
        FrmLogin frm = new FrmLogin();
        frm.setVisible(true);
    }

    //<editor-fold defaultstate="collapsed" desc="Datos de Prueba">
    private static void cargaInicial() {
        try {
            cargarHipodromos();
            cargarUsuarios();
            cargarCaballos();
            cargarCarreras();
            cargarCaballosCarrera();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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

    private static void cargarHipodromos() throws Exception {
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
        bd.obtener(new PCarrera(null));
    }

    private static void cargarCaballosCarrera() {
        bd.obtener(new PCaballoEnCarrera(null));
    }
    //</editor-fold>
}