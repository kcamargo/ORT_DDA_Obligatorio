package bl;

public class Jugador extends Usuario{
    private float saldo;

    public float getSaldo() {
        return saldo;
    }

    public void sumarSaldo(float cant) {
        saldo += cant;
    }
    
    public void descontarSaldo(float cant) {
        saldo -= cant;
    }
}
