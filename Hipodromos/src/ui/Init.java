package ui;

import bl.Administrador;
import bl.Caballo;
import bl.CaballoEnCarrera;
import bl.Carrera;
import bl.Fachada;
import bl.Hipodromo;
import bl.Jugador;
import util.Fecha;

public class Init {

    public static void main(String[] args) {
        datosPrueba();
        FrmLogin frm = new FrmLogin();
        frm.setVisible(true);
    }

    private static void datosPrueba() {
        Fachada fac = Fachada.getInstancia();

        Hipodromo h1 = new Hipodromo("Maroñas", "General Flores");
        Hipodromo h2 = new Hipodromo("Colonia", "Calle 1243");
        Hipodromo h3 = new Hipodromo("Paysandu", "Ruta 15 ");
        Hipodromo h4 = new Hipodromo("Artigas", "Av Brasil");

        fac.agregarHipodromo(h1);
        fac.agregarHipodromo(h2);
        fac.agregarHipodromo(h3);
        fac.agregarHipodromo(h4);

        fac.agregarAdministrador(new Administrador("admin", "admin", "Admin", "Rodriguez"));
        fac.agregarAdministrador(new Administrador("root", "root", "Root", "Gonzalez"));

        fac.agregarJugador(new Jugador(0, "Pedro", "222", "Pedro", "Jugador1"));
        fac.agregarJugador(new Jugador(10, "Juan", "333", "Juan", "Jugador2"));
        fac.agregarJugador(new Jugador(20, "Ana", "444", "Ana", "Jugador3"));
        fac.agregarJugador(new Jugador(30, "Jose", "555", "Jose", "Jugador4"));
        fac.agregarJugador(new Jugador(40, "Maria", "666", "Maria", "Jugador5"));

        Caballo cab1 = new Caballo("Chispazo", "Adrian");
        Caballo cab2 = new Caballo("Alegre", "Adrian");
        Caballo cab3 = new Caballo("Retonto", "Adrian");
        Caballo cab4 = new Caballo("El Manco", "Jorge");
        Caballo cab5 = new Caballo("Negro", "Jorge");
        Caballo cab6 = new Caballo("Diente", "Jorge");
        Caballo cab7 = new Caballo("El Corto", "Esteban");
        Caballo cab8 = new Caballo("Revelde", "Esteban");
        Caballo cab9 = new Caballo("Tornado", "Esteban");
        Caballo cab10 = new Caballo("El Rayo", "Esteban");
        Caballo cab11 = new Caballo("Mengano", "Pedro");
        Caballo cab12 = new Caballo("Babieca", "Pedro");
        Caballo cab13 = new Caballo("Tornado", "Fulano");
        Caballo cab14 = new Caballo("Kekeke", "Fulano");

        Carrera c1 = new Carrera("Carrera 1", Fecha.fechaActual());
        Carrera c2 = new Carrera("Carrera 2", Fecha.fechaActual());
        Carrera c3 = new Carrera("Carrera 3", Fecha.fechaActual());
        Carrera c4 = new Carrera("Carrera 4", Fecha.fechaActual());

        fac.agregarCaballo(cab1);
        fac.agregarCaballo(cab2);
        fac.agregarCaballo(cab3);
        fac.agregarCaballo(cab4);
        fac.agregarCaballo(cab5);
        fac.agregarCaballo(cab6);
        fac.agregarCaballo(cab7);
        fac.agregarCaballo(cab8);
        fac.agregarCaballo(cab9);
        fac.agregarCaballo(cab10);
        fac.agregarCaballo(cab11);
        fac.agregarCaballo(cab12);
        fac.agregarCaballo(cab13);
        fac.agregarCaballo(cab14);

        CaballoEnCarrera cec1 = new CaballoEnCarrera(1, 1.10, cab1);
        CaballoEnCarrera cec2 = new CaballoEnCarrera(2, 1.20, cab2);
        CaballoEnCarrera cec3 = new CaballoEnCarrera(3, 1.30, cab3);
        CaballoEnCarrera cec4 = new CaballoEnCarrera(4, 1.40, cab4);
        
        CaballoEnCarrera cec5 = new CaballoEnCarrera(1, 1.10, cab5);
        CaballoEnCarrera cec6 = new CaballoEnCarrera(2, 1.20, cab6);
        CaballoEnCarrera cec7 = new CaballoEnCarrera(3, 1.30, cab7);
        CaballoEnCarrera cec8 = new CaballoEnCarrera(4, 1.40, cab8);
        
        CaballoEnCarrera cec9 = new CaballoEnCarrera(1, 1.10, cab9);
        CaballoEnCarrera cec10 = new CaballoEnCarrera(2, 1.20, cab10);
        CaballoEnCarrera cec11 = new CaballoEnCarrera(3, 1.40, cab11);
        
        CaballoEnCarrera cec12 = new CaballoEnCarrera(1, 1.40, cab12);
        CaballoEnCarrera cec13 = new CaballoEnCarrera(2, 1.60, cab13);
        CaballoEnCarrera cec14 = new CaballoEnCarrera(3, 2.10, cab14);
        
        try {
            c1.agregarCaballo(cec1);
            c1.agregarCaballo(cec2);
            c1.agregarCaballo(cec3);
            c1.agregarCaballo(cec4);

            c2.agregarCaballo(cec5);
            c2.agregarCaballo(cec6);
            c2.agregarCaballo(cec7);
            c2.agregarCaballo(cec8);

            c3.agregarCaballo(cec9);
            c3.agregarCaballo(cec10);
            c3.agregarCaballo(cec11);
            
            c4.agregarCaballo(cec12);
            c4.agregarCaballo(cec13);
            c4.agregarCaballo(cec14);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        h1.agregarCarrera(c1);
        h1.agregarCarrera(c2);
        h1.agregarCarrera(c3);
        h1.agregarCarrera(c4);
    }
}