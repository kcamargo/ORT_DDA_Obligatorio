package bl;

public class ApuestaCuadruple extends TipoApuesta {

    public ApuestaCuadruple() {
        super();
    }

    @Override
    public double getValorMultiplicador(double dividendo, double montoApostado) {
        if (dividendo >= 2) {
            return 3 * dividendo;
        } else {
            return 4 * dividendo;
        }
    }
}
