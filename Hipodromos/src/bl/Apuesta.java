package bl;

public class Apuesta {

    private Float monto;
    private Jugador jugador;

    //<editor-fold defaultstate="collapsed" desc="Get/Set">
    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
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
    public Apuesta(Float monto, Jugador apostador) {
        this.monto = monto;
        this.jugador = apostador;
    }
    //</editor-fold>

    public boolean validar() {
        return monto > 0 && jugador != null;
    }
}
