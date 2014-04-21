package bl;

public class Apuesta {

    private Float monto;
    private CaballoEnCarrera caballo;
    private Usuario apostador;

    //<editor-fold defaultstate="collapsed" desc="Get/Set">
    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public CaballoEnCarrera getCaballo() {
        return caballo;
    }

    public void setCaballo(CaballoEnCarrera caballo) {
        this.caballo = caballo;
    }

    public Usuario getApostador() {
        return apostador;
    }

    public void setApostador(Usuario apostador) {
        this.apostador = apostador;
    }
    //</editor-fold>

    public boolean validar() {
        return monto > 0
                && caballo != null
                && apostador != null;
    }
}
