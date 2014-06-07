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
public abstract class TipoApuesta {

   public TipoApuesta(){
       super();
   }
    
    public abstract double getValorMultiplicador( double dividendo, double montoApostado);
    
    public void pagar(ArrayList<Apuesta> apuesta, double dividendo, double montoApostado){
        
        double multiplicador = getValorMultiplicador(dividendo, montoApostado);
        
        for(Apuesta a : apuesta) {
            Jugador j = a.getJugador();
            double ganancia = a.getMonto() * multiplicador;
            System.out.println(ganancia);

            j.sumarSaldo(ganancia);
            a.setGanado(ganancia);
        }
    }
    
    
}
