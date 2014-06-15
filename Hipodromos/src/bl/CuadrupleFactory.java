package bl;

import util.ICrearApuesta;

public class CuadrupleFactory implements ICrearApuesta {

    public CuadrupleFactory() {
    }

    @Override
    public TipoApuesta crearTipoApuesta() {
        return new ApuestaCuadruple();
    }
}
