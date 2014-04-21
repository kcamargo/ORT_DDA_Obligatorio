package bl;

import java.util.Calendar;

public class Carrera {

    public enum EstadoCarrera {

        DEFINIDA,
        ABIERTA,
        CERRADA,
        FINALIZADA
    }
    private String nombre;
    private int numero;
    private Calendar fecha;
    private EstadoCarrera estado;

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

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public EstadoCarrera getEstado() {
        return estado;
    }

    public void setEstado(EstadoCarrera estado) {
        this.estado = estado;
    }
    //</editor-fold>

    public boolean validar() {
        return nombre != null && !nombre.equals("")
                && numero > 0
                && (fecha.equals(Calendar.getInstance()) || fecha.after(Calendar.getInstance()))
                && estado != null;
    }
}
