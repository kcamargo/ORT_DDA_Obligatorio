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
public class ApuestaCuadruple extends TipoApuesta {
    public ApuestaCuadruple(){
        super();
    }
    
    @Override
    public double getValorMultiplicador(double dividendo, double montoApostado) {
        if(dividendo >= 2){
          return 3 * dividendo;
        }else {
           return 4 * dividendo;
        }
    }

    

   
    
}
