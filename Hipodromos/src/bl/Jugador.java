package bl;

public class Jugador extends Usuario{
    private double saldo;

    public Jugador(double saldo, String username, String password) {
        super(username, password);
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void sumarSaldo(double cant) {
        saldo += cant;
    }
    
    public void descontarSaldo(double cant) {
        saldo -= cant;
    }
}
