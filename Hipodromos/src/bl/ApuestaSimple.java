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
public class ApuestaSimple extends TipoApuesta {

   public ApuestaSimple(){
       super();
   }

 
    @Override
    public double getValorMultiplicador(double dividendo, double montoApostado) {
        System.out.println("SIMPLE");
        return  dividendo;
    }
    
}
