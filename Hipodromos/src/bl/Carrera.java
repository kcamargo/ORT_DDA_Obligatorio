package bl;

import java.util.ArrayList;
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

    public void setEstado(EstadoCarrera estado) {
        this.estado = estado;
    }

    public ArrayList<CaballoEnCarrera> getCaballos() {
        return caballos;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Carrera() {
        this.caballos = new ArrayList<>();
    }

    public Carrera(String nombre, int numero) {
        this();
        this.nombre = nombre;
        this.numero = numero;
        this.fecha = new Date();
        this.estado = EstadoCarrera.DEFINIDA;
    }

    public Carrera(String nombre, int numero, Date fecha) {
        this();
        this.nombre = nombre;
        this.numero = numero;
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

    public boolean estaDisponible(Caballo caballo) {
        return buscarCaballo(caballo) == null;
    }

    public float getMontoApostado() {
        float total = 0;
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

    public void setGanador(Caballo caballo) {
        CaballoEnCarrera c = buscarCaballo(caballo);
        c.setGanador(true);
        setEstado(EstadoCarrera.FINALIZADA);
    }

    private CaballoEnCarrera buscarCaballo(Caballo caballo) {
        for (CaballoEnCarrera c : caballos) {
            if (c.getCaballo().equals(caballo)) {
                return c;
            }
        }
        return null;
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
