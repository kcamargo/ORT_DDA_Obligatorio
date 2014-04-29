package bl;

import java.util.ArrayList;

public class CaballoEnCarrera {

    private int numero;
    private float dividendo;
    private boolean ganador;
    private Caballo caballo;
    private Carrera carrera;
    private ArrayList<Apuesta> apuestas;

    //<editor-fold defaultstate="collapsed" desc="Get/Set">
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDividendo(float dividendo) {
        this.dividendo = dividendo;
    }

    public void setGanador(boolean ganador) {
        this.ganador = ganador;
    }

    public void setCaballo(Caballo caballo) {
        this.caballo = caballo;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public int getNumero() {
        return numero;
    }

    public float getDividendo() {
        return dividendo;
    }

    public boolean isGanador() {
        return ganador;
    }

    public Caballo getCaballo() {
        return caballo;
    }

    public ArrayList<Apuesta> getApuestas() {
        return apuestas;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public CaballoEnCarrera() {
        this.apuestas = new ArrayList<>();
    }

    public CaballoEnCarrera(int numero, float dividendo, Caballo caballo) {
        this();
        this.numero = numero;
        this.dividendo = dividendo;
        this.ganador = false;
        this.caballo = caballo;
    }
    //</editor-fold>

    public boolean validar() {
        return numero > 0
                && dividendo > 1
                && caballo != null;
    }

    public boolean agregarApuesta(Apuesta apuesta) {
        return apuestas.add(apuesta);
    }

    public float getMontoApostado() {
        float total = 0;
        for (Apuesta a : apuestas) {
            total += a.getMonto();
        }
        return total;
    }

    public float getMontoPagado() {
        return getMontoApostado() * dividendo;
    }

    public boolean pagar() {
        for (Apuesta a : apuestas) {
            Jugador j = a.getJugador();
            float ganancia = a.getMonto() * dividendo;

            j.sumarSaldo(ganancia);
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        CaballoEnCarrera c = (CaballoEnCarrera) obj;
        return numero == c.getNumero()
                && dividendo == c.getDividendo()
                && caballo.equals(c.getCaballo())
                && carrera.equals(c.getCarrera());
    }
}