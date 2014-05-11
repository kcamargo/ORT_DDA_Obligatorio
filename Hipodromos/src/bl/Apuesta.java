package bl;

public class Apuesta {

    private double monto;
    private double ganado;
    private Jugador jugador;
    private CaballoEnCarrera caballo;

    //<editor-fold defaultstate="collapsed" desc="Get/Set">
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador apostador) {
        this.jugador = apostador;
    }

    public CaballoEnCarrera getCaballo() {
        return caballo;
    }

    public void setCaballo(CaballoEnCarrera caballo) {
        this.caballo = caballo;
    }

    public double getGanado() {
        return ganado;
    }

    public void setGanado(double ganado) {
        this.ganado = ganado;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Apuesta(double monto, Jugador apostador) {
        this.monto = monto;
        this.jugador = apostador;
    }
    //</editor-fold>

    public boolean validar() {
        return monto > 0 && jugador != null;
    }
}
