package bl;

import util.ICrearApuesta;

public class SimpleFactory implements ICrearApuesta {

    public SimpleFactory() {
    }

    @Override
    public TipoApuesta crearTipoApuesta() {
        return new ApuestaSimple();
    }
}
