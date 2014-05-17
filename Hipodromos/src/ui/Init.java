/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import bl.Administrador;
import bl.Caballo;
import bl.Fachada;
import bl.Hipodromo;
import bl.Jugador;
/**
 *
 * @author Fossemale
 */
public class Init {
     
     public static void main(String[] args) {
        // TODO code application logic here
     
        Fachada fac = Fachada.getInstancia();
        fac.agregarAdministrador(new Administrador("Admin", "111"));
        fac.agregarAdministrador(new Administrador("aaa", "111"));
        
        fac.agregarJugador(new Jugador(0 ,"Pedro", "222"));
        fac.agregarJugador(new Jugador(10 ,"Juan", "333"));
        fac.agregarJugador(new Jugador(20 ,"Ana", "444"));
        fac.agregarJugador(new Jugador(30 ,"Jose", "555"));
        fac.agregarJugador(new Jugador(40 ,"Maria", "666"));
        
        fac.agregarCaballo(new Caballo("Chispazo","Adrian"));
        fac.agregarCaballo(new Caballo("Alegre","Adrian"));
        fac.agregarCaballo(new Caballo("Retonto","Adrian"));
        fac.agregarCaballo(new Caballo("El Manco","Jorge"));
        fac.agregarCaballo(new Caballo("Negro","Jorge"));
        fac.agregarCaballo(new Caballo("Diente","Jorge"));
        fac.agregarCaballo(new Caballo("El Corto","Esteban"));
        fac.agregarCaballo(new Caballo("Revelde","Esteban"));
        fac.agregarCaballo(new Caballo("Tornado","Esteban"));
        fac.agregarCaballo(new Caballo("El Rayo","Esteban"));
        
        fac.agregarHipodromo(new Hipodromo("Maroñas","General Flores"));
        fac.agregarHipodromo(new Hipodromo("Colonia","Calle 1243"));
        fac.agregarHipodromo(new Hipodromo("Paysandu","Ruta 15 "));
        fac.agregarHipodromo(new Hipodromo("Artigas","Av Brasil"));
      
        FrmLogin log = new FrmLogin();//.setVisible(true);}
        log.setVisible(true);                               

    }
  
    
}
