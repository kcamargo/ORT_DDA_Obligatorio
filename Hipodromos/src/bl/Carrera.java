package bl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Carrera implements Comparable<Carrera> {

    public enum EstadoCarrera {

        DEFINIDA,
        ABIERTA,
        CERRADA,
        FINALIZADA
    }
    private String nombre;
    private int numero;
    private Date fecha;
    private EstadoCarrera estado;
    private ArrayList<CaballoEnCarrera> caballos;
    private CaballoEnCarrera ganador;

    //<editor-fold defaultstate="collapsed" desc="Get/Set">
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public EstadoCarrera getEstado() {
        return estado;
    }

    public String getEstadoString() {
        String ret = null;

        switch (estado) {
            case DEFINIDA:
                ret = "DEFINIDA";
                break;
            case ABIERTA:
                ret = "ABIERTA";
                break;
            case CERRADA:
                ret = "CERRADA";
                break;
            case FINALIZADA:
                ret = "FINALIZADA";
                break;
            default:
                return null;
        }
        return ret;
    }

    public void setEstado(EstadoCarrera estado) {
        this.estado = estado;
    }

    public ArrayList<CaballoEnCarrera> getCaballos() {
        return caballos;
    }

    public CaballoEnCarrera getGanador() {
        return ganador;
    }

    public void setGanador(CaballoEnCarrera caballo) {
        caballo.setGanador(true);
        this.ganador = caballo;
        caballo.pagar();
        setEstado(EstadoCarrera.FINALIZADA);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Carrera() {
        this.caballos = new ArrayList<>();
    }

    public Carrera(String nombre) {
        this();
        this.nombre = nombre;
        this.fecha = new Date();
        this.estado = EstadoCarrera.DEFINIDA;
    }

    public Carrera(String nombre, Date fecha) {
        this();
        this.nombre = nombre;
        this.fecha = fecha;
        this.estado = EstadoCarrera.DEFINIDA;
    }
    //</editor-fold>

    public boolean validar() {
        return nombre != null && !nombre.isEmpty()
                && numero > 1
                && fecha != null
                && estado != null;
    }
    public boolean validarFecha (int year, int month, int day){
    boolean ret;
    
    Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DATE, day);
        Date fch = cal.getTime();
        Date now = new Date();
        System.out.println(fch);
        if (now.after(fch)){
            ret = false;
        } else {
            ret = true;
        }        
    return ret;
    }
    public boolean estaDisponible(Caballo caballo) {
        return buscarCaballo(caballo) == null;
    }

    public double getMontoApostado() {
        double total = 0;
        for (CaballoEnCarrera c : caballos) {
            total += c.getMontoApostado();
        }
        return total;
    }

    public boolean abrir() {
        if (estado == EstadoCarrera.DEFINIDA) {
            setEstado(EstadoCarrera.ABIERTA);
            return true;
        }
        return false;
    }

    public boolean cerrar() {
        if (estado == EstadoCarrera.ABIERTA) {
            setEstado(EstadoCarrera.CERRADA);
            return true;
        }
        return false;
    }

    private CaballoEnCarrera buscarCaballo(Caballo caballo) {
        for (CaballoEnCarrera c : caballos) {
            if (c.getCaballo().equals(caballo)) {
                return c;
            }
        }
        return null;
    }

    public CaballoEnCarrera agregarCaballo(Caballo c, int numero, double dividendo) {
        CaballoEnCarrera caballo = new CaballoEnCarrera(numero, dividendo, c);
        caballo.setCarrera(this);

        if (caballos.add(caballo)) {
            return caballo;
        }
        return null;
    }

    public boolean quitarCaballo(Caballo c) {
        CaballoEnCarrera caballo = buscarCaballo(c);
        if (caballo != null) {
            return caballos.remove(caballo);
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        Carrera c = (Carrera) o;
        return nombre.equals(c.getNombre())
                && numero == c.getNumero()
                && fecha.equals(c.getFecha())
                && estado == c.getEstado();
    }

    @Override
    public int compareTo(Carrera c) {
        return getNumero() - c.getNumero();
    }
}
