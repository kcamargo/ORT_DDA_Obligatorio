package bl;

import bl.persistencia.PAdministrador;
import bl.persistencia.PJugador;
import dal.ManejadorBD;
import java.util.ArrayList;

public class SSUsuarios {

    private ArrayList<Administrador> admins;
    private ArrayList<Jugador> jugadores;

    public SSUsuarios() {
        admins = new ArrayList<>();
        jugadores = new ArrayList<>();
    }

    public Administrador login(Administrador admin) {
        for (Administrador a : admins) {
            if (a.equals(admin)) {
                return a;
            }
        }
        return null;
    }

    public Jugador login(Jugador jugador) {
        for (Jugador j : jugadores) {
            if (j.equals(jugador)) {
                return j;
            }
        }
        return null;
    }

    public boolean agregarAdministrador(Administrador a) {
        if (!admins.contains(a)) {
            ManejadorBD.getInstancia().agregar(new PAdministrador(a));
            return admins.add(a);
        }
        return false;
    }

    public boolean agregarJugador(Jugador j) {
        if (!jugadores.contains(j)) {
            ManejadorBD.getInstancia().agregar(new PJugador(j));
            return jugadores.add(j);
        }
        return false;
    }
}
