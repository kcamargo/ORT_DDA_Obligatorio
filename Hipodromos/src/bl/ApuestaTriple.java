package bl;

public class ApuestaTriple extends TipoApuesta {

    public ApuestaTriple() {
        super();
    }

    @Override
    public double getValorMultiplicador(double dividendo, double montoApostado) {
        System.out.println("TRIPLE");
        if (montoApostado < 100.000) {
            return 3 * dividendo;
        } else {
            return 2 * dividendo;
        }
    }

    @Override
    public int getCodigo() {
        return 3;
    }
}
