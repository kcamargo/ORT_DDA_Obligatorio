package bl;

import bl.enums.ErroresApuesta;
import java.util.ArrayList;

public class CaballoEnCarrera {

    private int numero;
    private double dividendo;
    private boolean ganador;
    private Caballo caballo;
    private Carrera carrera;
    private ArrayList<Apuesta> apuestas;

    //<editor-fold defaultstate="collapsed" desc="Get/Set">
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDividendo(double dividendo) {
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

    public double getDividendo() {
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

    public CaballoEnCarrera(int numero, double dividendo, Caballo caballo) {
        this();
        this.numero = numero;
        this.dividendo = dividendo;
        this.ganador = false;
        this.caballo = caballo;
    }
    //</editor-fold>

    public boolean validar() {
        return numero > 0 && numero < 99999
                && dividendo > 1
                && caballo != null;
    }

    public ErroresApuesta agregarApuesta(Apuesta apuesta) {
        apuesta.setCaballo(this);
        if (apuesta.getJugador().getSaldo() >= apuesta.getMonto()) {
            apuesta.getJugador().agregarApuesta(apuesta);
            if (apuestas.add(apuesta)) {
                return ErroresApuesta.OK;
            } else {
                return ErroresApuesta.ErrorGenerico;
            }
        } else {
            return ErroresApuesta.SaldoInsuficiente;
        }
    }

    public double getMontoApostado() {
        double total = 0;
        for (Apuesta a : apuestas) {
            total += a.getMonto();
        }
        return total;
    }

    public double getMontoPagado() {
        return getMontoApostado() * dividendo;
    }

    public boolean pagar() {
        for (Apuesta a : apuestas) {
            Jugador j = a.getJugador();
            double ganancia = a.getMonto() * dividendo;

            j.sumarSaldo(ganancia);
            a.setGanado(ganancia);
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

    @Override
    public String toString() {
        String ret = "(" + numero + ") " + caballo.getNombre() + " - " + dividendo;
        if (ganador) {
            ret += " ***GANADOR***";
        }
        return ret;
    }
}