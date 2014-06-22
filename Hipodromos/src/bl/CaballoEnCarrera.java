package bl;

import bl.enums.ErroresApuesta;
import bl.enums.TiposApuestas;
import java.util.ArrayList;

public class CaballoEnCarrera {

    private int oid;
    private int numero;
    private double dividendo;
    private boolean ganador;
    private Caballo caballo;
    private Carrera carrera;
    private ArrayList<Apuesta> apuestas;
    private TipoApuesta tipoApuesta = new ApuestaCuadruple();

    //<editor-fold defaultstate="collapsed" desc="Get/Set">
    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDividendo(double dividendo) {
        this.dividendo = dividendo;
    }

    public void setGanador(boolean ganador) {
        this.ganador = ganador;
    }

    public void setCaballo(Caballo caballo) {
        this.caballo = caballo;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public int getNumero() {
        return numero;
    }

    public double getDividendo() {
        return dividendo;
    }

    public boolean isGanador() {
        return ganador;
    }

    public Caballo getCaballo() {
        return caballo;
    }
    public TipoApuesta getTipoApuesta() {
        return tipoApuesta;
    }

    public void setTipoApuesta(TiposApuestas tipoApuesta){
       this.tipoApuesta = cambiarTipoApuesta(tipoApuesta);
    }

    public ArrayList<Apuesta> getApuestas() {
        return apuestas;
    }

    //</editor-fold>
    

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public CaballoEnCarrera() {
        this.apuestas = new ArrayList<>();
    }

    public CaballoEnCarrera(int numero, double dividendo, Caballo caballo) {
        this();
        this.numero = numero;
        this.dividendo = dividendo;
        this.ganador = false;
        this.caballo = caballo;
    }
    //</editor-fold>

    public boolean validar() throws Exception {
        if (numero > 0 && numero < 99999) {
            if (dividendo > 1) {
                if (caballo != null) {
                    return true;
                } else {
                    throw new Exception("Debe asignarse un caballo");
                }
            } else {
                throw new Exception("Dividendo debe ser mayor a 1");
            }
        } else {
            throw new Exception("Número debe estar entre 0 y 99999");
        }
    }

    public ErroresApuesta agregarApuesta(Apuesta apuesta) {
        apuesta.setCaballo(this);
        if (apuesta.getJugador().getSaldo() >= apuesta.getMonto()) {
            apuesta.getJugador().agregarApuesta(apuesta);
            if (apuestas.add(apuesta)) {
                return ErroresApuesta.OK;
            } else {
                return ErroresApuesta.ErrorGenerico;
            }
        } else {
            return ErroresApuesta.SaldoInsuficiente;
        }
    }

    public double getMontoApostado() {
        double total = 0;
        for (Apuesta a : apuestas) {
            total += a.getMonto();
        }
        return total;
    }

    public double getMontoPagado() {
        return getMontoApostado() * dividendo;
    }

    public boolean pagar() {
        tipoApuesta.pagar(apuestas, dividendo, getMontoApostado());
        return true;
    }
    public boolean getCaballoSinApuesta(){
        if(apuestas.size() > 0){
            return false;
        }
        return true;
    }
    @Override
    public boolean equals(Object obj) {
        CaballoEnCarrera c = (CaballoEnCarrera) obj;
        return numero == c.getNumero()
                && dividendo == c.getDividendo()
                && caballo.equals(c.getCaballo())
                && carrera.equals(c.getCarrera());
    }

    @Override
    public String toString() {
        String ret = "(" + numero + ") " + caballo.getNombre() + " - " + dividendo;
        if (ganador) {
            ret += " ***GANADOR***";
        }
        return ret;
    }

    public TipoApuesta cambiarTipoApuesta(TiposApuestas tipo)  {
        switch (tipo) {
            case Simple : return new SimpleFactory().crearTipoApuesta();
                
            case Triple : return new TripleFactory().crearTipoApuesta();
                
            case Cuadruple : return new CuadrupleFactory().crearTipoApuesta();

        }
        return null;
    }
}