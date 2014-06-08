/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import util.ICrearApuesta;

/**
 *
 * @author Fossemale
 */
public class TripleFactory implements ICrearApuesta{
    
    public TripleFactory(){
    }
    @Override
    public TipoApuesta crearTipoApuesta() {
        return new ApuestaTriple();
    }
    
}
