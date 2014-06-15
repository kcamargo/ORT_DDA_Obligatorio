package bl;

import util.ICrearApuesta;

public class TripleFactory implements ICrearApuesta {

    public TripleFactory() {
    }

    @Override
    public TipoApuesta crearTipoApuesta() {
        return new ApuestaTriple();
    }
}
