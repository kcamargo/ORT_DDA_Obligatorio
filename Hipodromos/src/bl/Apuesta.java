package bl;

public class Apuesta {

    private double monto;
    private Jugador jugador;

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
