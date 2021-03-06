package bl;

import bl.enums.CambiosCarrera;
import java.util.ArrayList;
import java.util.Date;
import util.Fecha;

public class Carrera {

    public enum EstadoCarrera {
        DEFINIDA,
        ABIERTA,
        CERRADA,
        FINALIZADA
    }

    public static EstadoCarrera getEstado(int i) {
        EstadoCarrera ret = null;
        switch (i) {
            case 0:
                ret = EstadoCarrera.DEFINIDA;
                break;
            case 1:
                ret = EstadoCarrera.ABIERTA;
                break;
            case 2:
                ret = EstadoCarrera.CERRADA;
                break;
            case 3:
                ret = EstadoCarrera.FINALIZADA;
                break;
        }
        return ret;
    }
    private int oid;
    private String nombre;
    private int numero;
    private Date fecha;
    private EstadoCarrera estado;
    private ArrayList<CaballoEnCarrera> caballos;
    private CaballoEnCarrera ganador;

    //<editor-fold defaultstate="collapsed" desc="Get/Set">
    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

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
        Fachada.getInstancia().notificarObservadores(CambiosCarrera.CambioEstado);
    }

    public ArrayList<CaballoEnCarrera> getCaballos() {
        return caballos;
    }

    public CaballoEnCarrera getGanador() {
        return ganador;
    }

    public void setGanadorSimple(CaballoEnCarrera caballo) {
        this.ganador = caballo;
    }

    public void setGanador(CaballoEnCarrera caballo) {
        if (this.estado == EstadoCarrera.CERRADA) {
            caballo.setGanador(true);
            this.ganador = caballo;
            caballo.pagar();
            setEstado(EstadoCarrera.FINALIZADA);
            Fachada.getInstancia().notificarObservadores(CambiosCarrera.CarreraFinalizada);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Carrera() {
        this.caballos = new ArrayList<>();
    }

    public Carrera(String nombre) {
        this();
        this.nombre = nombre;
        this.fecha = Fecha.fechaActual();
        this.estado = EstadoCarrera.DEFINIDA;
        this.caballos = new ArrayList<>();
    }

    public Carrera(String nombre, Date fecha) {
        this();
        this.nombre = nombre;
        this.fecha = fecha;
        this.estado = EstadoCarrera.DEFINIDA;
        this.caballos = new ArrayList<>();
    }
    //</editor-fold>

    public boolean validar() throws Exception {
        if (nombre != null && !nombre.isEmpty()) {
            if (numero >= 1) {
                if (validarFecha()) {
                    if (estado != null) {
                        return true;
                    } else {
                        throw new Exception("El estado no puede ser nulo");
                    }
                } else {
                    throw new Exception("Fecha inválida; debe ser igual o posterior a hoy");
                }
            } else {
                throw new Exception("El número de la carrera es inválido");
            }
        } else {
            throw new Exception("Nombre inválido");
        }
    }

    private boolean validarFecha() {
        if (fecha == null) {
            return false;
        }

        Date now = Fecha.fechaActual();

        if (now.before(fecha) || (now.getDay()) == (fecha.getDay())) {
            return true;
        }

        return false;
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
            Fachada.getInstancia().notificarObservadores(CambiosCarrera.CarreraAbierta);
            return true;
        }
        return false;
    }

    public boolean cerrar() {
        if (estado == EstadoCarrera.ABIERTA) {
            setEstado(EstadoCarrera.CERRADA);
            Fachada.getInstancia().notificarObservadores(CambiosCarrera.CarreraCerrada);
            return true;
        }
        return false;
    }

    public boolean existeNumeroCaballo(CaballoEnCarrera caballoCarrera) {
        boolean res = false;
        for (CaballoEnCarrera c : caballos) {
            if (c.getNumero() == caballoCarrera.getNumero()) {
                res = true;
            }
        }
        if (caballos.isEmpty()) {
            res = false;
        }
        return res;
    }

    private CaballoEnCarrera buscarCaballo(Caballo caballo) {
        for (CaballoEnCarrera c : caballos) {
            if (c.getCaballo().equals(caballo)) {
                return c;
            }
        }
        return null;
    }

    public boolean agregarCaballo(CaballoEnCarrera c) throws Exception {
        c.setCarrera(this);

        if (c.validar()) {
            for (CaballoEnCarrera cec : caballos) {
                if (cec.getNumero() == c.getNumero()) {
                    throw new Exception("Número de caballo repetido");
                }
            }
            return caballos.add(c);
        }
        throw new Exception("Los datos ingresados no son correctos");
    }

    public boolean quitarCaballo(Caballo c) {
        CaballoEnCarrera caballo = buscarCaballo(c);
        if (caballo != null) {
            return caballos.remove(caballo);
        } else {
            return false;
        }
    }

    public boolean isDefinidaAbierta() {
        // if ( getFecha().after(Fecha.fechaActual()) || getFecha().equals(Fecha.fechaActual()) ){
        if (getEstadoString().equals("DEFINIDA") || getEstadoString().equals("ABIERTA")) {
            return true;
        }
        // }
        return false;
    }

    public ArrayList<CaballoEnCarrera> getCaballosSinApuestas() {
        ArrayList<CaballoEnCarrera> lista = new ArrayList();
        for (CaballoEnCarrera cab : caballos) {
            if (cab.getCaballoSinApuesta()) {
                lista.add(cab);
            }
        }
        return lista;
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
    public String toString() {
        return nombre;
    }
}
