package ui;

import bl.Administrador;
import bl.Caballo;
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

        fac.agregarAdministrador(new Administrador("Admin", "111"));
        fac.agregarAdministrador(new Administrador("aaa", "111"));

        fac.agregarJugador(new Jugador(0, "Pedro", "222"));
        fac.agregarJugador(new Jugador(10, "Juan", "333"));
        fac.agregarJugador(new Jugador(20, "Ana", "444"));
        fac.agregarJugador(new Jugador(30, "Jose", "555"));
        fac.agregarJugador(new Jugador(40, "Maria", "666"));

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
        Caballo cab11 = new Caballo("Sopla la Vela", "Pedro");
        Caballo cab12 = new Caballo("Mengano", "Pedro");
        Caballo cab13 = new Caballo("Babieca", "Pedro");
        Caballo cab14 = new Caballo("Tornado", "Fulano");
        Caballo cab15 = new Caballo("Kekeke", "Fulano");

        Carrera c1 = new Carrera("Carrera 1", Fecha.crearFecha(25, 4, 2014));
        Carrera c2 = new Carrera("Carrera 2", Fecha.crearFecha(25, 4, 2014));
        Carrera c3 = new Carrera("Carrera 3", Fecha.crearFecha(25, 4, 2014));
        Carrera c4 = new Carrera("Carrera 4", Fecha.crearFecha(25, 4, 2014));
        Carrera c5 = new Carrera("Carrera 5", Fecha.crearFecha(25, 4, 2014));
        Carrera c6 = new Carrera("Carrera 6", Fecha.crearFecha(25, 4, 2014));
        Carrera c7 = new Carrera("Carrera 7", Fecha.crearFecha(25, 4, 2014));

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
        fac.agregarCaballo(cab15);

        c1.agregarCaballo(cab1, 1, 1.10);
        c1.agregarCaballo(cab2, 2, 1.20);
        c1.agregarCaballo(cab3, 3, 1.30);
        c1.agregarCaballo(cab4, 4, 1.40);
        c1.setEstado(Carrera.EstadoCarrera.FINALIZADA);
        c2.agregarCaballo(cab5, 1, 1.10);
        c2.agregarCaballo(cab6, 2, 1.20);
        c2.agregarCaballo(cab7, 3, 1.30);
        c2.agregarCaballo(cab8, 4, 1.40);
        c2.setEstado(Carrera.EstadoCarrera.FINALIZADA);
        c3.agregarCaballo(cab9, 1, 1.10);
        c3.agregarCaballo(cab10, 2, 1.20);
        c3.agregarCaballo(cab11, 3, 1.30);
        c3.agregarCaballo(cab12, 4, 1.40);
        c3.abrir();
        c4.agregarCaballo(cab13, 1, 1.10);
        c4.agregarCaballo(cab14, 2, 1.20);
        c4.agregarCaballo(cab15, 3, 1.30);
        c4.agregarCaballo(cab1, 4, 1.40);

        c5.agregarCaballo(cab2, 1, 1.10);
        c5.agregarCaballo(cab3, 2, 1.20);
        c5.agregarCaballo(cab4, 3, 1.30);
        c5.agregarCaballo(cab5, 4, 1.40);

        c6.agregarCaballo(cab6, 1, 1.10);
        c6.agregarCaballo(cab7, 2, 1.20);
        c6.agregarCaballo(cab8, 3, 1.30);
        c6.agregarCaballo(cab9, 4, 1.40);

        c7.agregarCaballo(cab10, 1, 1.10);
        c7.agregarCaballo(cab11, 2, 1.20);
        c7.agregarCaballo(cab12, 3, 1.30);
        c7.agregarCaballo(cab13, 4, 1.40);

        h1.agregarCarrera(c1);
        h1.agregarCarrera(c2);
        h1.agregarCarrera(c3);
        h1.agregarCarrera(c4);
        h1.agregarCarrera(c5);
        h1.agregarCarrera(c6);
        h1.agregarCarrera(c7);
    }
}