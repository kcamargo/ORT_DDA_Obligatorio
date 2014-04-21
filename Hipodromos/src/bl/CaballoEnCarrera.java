package bl;

public class CaballoEnCarrera {

    private int numero;
    private float dividendo;
    private boolean ganador;
    private Caballo caballo;

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
    //</editor-fold>

    public boolean validar() {
        return numero > 0
                && dividendo > 1
                && caballo != null;
    }
}
