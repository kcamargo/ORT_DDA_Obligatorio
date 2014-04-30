package util;

import java.util.ArrayList;

public class Observable {

    private final ArrayList<Observador> observadores = new ArrayList<>();

    public void agregarObservador(Observador obs) {
        if (!observadores.contains(obs)) {
            observadores.add(obs);
        }
    }

    public void quitarObservador(Observador obs) {
        observadores.remove(obs);
    }

    public void notificarObservadores(Object param) {
        for (Observador obs : observadores) {
            obs.actualizar(this, param);
        }
    }

    public void notificarObservadores() {
        notificarObservadores(null);
    }
}
