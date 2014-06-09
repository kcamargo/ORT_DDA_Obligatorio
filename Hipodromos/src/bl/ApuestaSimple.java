package bl;

public class ApuestaSimple extends TipoApuesta {

    public ApuestaSimple() {
        super();
    }

    @Override
    public double getValorMultiplicador(double dividendo, double montoApostado) {
        System.out.println("SIMPLE");
        return dividendo;
    }
}
