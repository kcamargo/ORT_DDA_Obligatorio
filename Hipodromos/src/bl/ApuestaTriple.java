/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.util.ArrayList;

/**
 *
 * @author Fossemale
 */
public class ApuestaTriple extends TipoApuesta {
    
    public ApuestaTriple(){
        super();
    }

    @Override
    public double getValorMultiplicador(double dividendo, double montoApostado) {
        System.out.println("TRIPLE");
        if(montoApostado < 100.000){
            return 3 * dividendo;
        } else {
            return 2 * dividendo;
        }
    }

   
    
}
