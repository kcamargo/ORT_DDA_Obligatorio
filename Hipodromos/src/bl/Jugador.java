package bl;

import java.util.ArrayList;

public class Jugador extends Usuario {

    private double saldo;
    private ArrayList<Apuesta> apuestas;

    public Jugador(double saldo, String username, String password) {
        super(username, password);
        this.saldo = saldo;
        this.apuestas = new ArrayList<>();
    }

    //<editor-fold defaultstate="collapsed" desc="Get/Set">
    public double getSaldo() {
        return saldo;
    }

    public ArrayList<Apuesta> getApuestas() {
        return apuestas;
    }
    //</editor-fold>

    public void sumarSaldo(double cant) {
        saldo += cant;
    }

    public void descontarSaldo(double cant) {
        saldo -= cant;
    }

    public boolean agregarApuesta(Apuesta a) {
        return apuestas.add(a);
    }
    
    public Apuesta getUltimaApuesta() {
        if (apuestas.size() >= 1) {
            return apuestas.get(apuestas.size() - 1);
        }
        return null;
    }
}
