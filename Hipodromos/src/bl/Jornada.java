package bl;

import java.util.ArrayList;
import java.util.Date;

public class Jornada implements Comparable<Jornada> {

    private Date fecha;
    private ArrayList<Carrera> carreras;

    //<editor-fold defaultstate="collapsed" desc="Get/Set">
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Jornada() {
        carreras = new ArrayList<>();
    }

    public Jornada(Date fecha) {
        this();
        this.fecha = fecha;
    }
    //</editor-fold>

    public boolean estaDisponible(Caballo caballo) {
        boolean flag = true;
        for (Carrera c : carreras) {
            if (!c.estaDisponible(caballo)) {
                flag = false;
            }
        }
        return flag;
    }

    public boolean agregarCarrera(Carrera c) {
        if (!carreras.contains(c)) {
            return carreras.add(c);
        }
        return false;
    }

    public ArrayList<Carrera> getCarrerasAbiertas() {
        ArrayList<Carrera> retorno = new ArrayList<>();
        for (Carrera c : carreras) {
            if (c.getEstado() == Carrera.EstadoCarrera.ABIERTA) {
                retorno.add(c);
            }
        }
        return retorno;
    }

    public Carrera getSiguienteCarrera() {
        for (Carrera c : carreras) {
            if (c.getEstado() == Carrera.EstadoCarrera.DEFINIDA) {
                return c;
            }
        }
        return null;
    }

    public int getSiguienteNumeroDeCarrera() {
        Carrera ultima = carreras.get(carreras.size() - 1);
        return ultima.getNumero();
    }

    public boolean abrirCarrera(Carrera c) {
        Carrera anterior = carreras.get(carreras.indexOf(c) - 1);
        if (anterior.getEstado() == Carrera.EstadoCarrera.FINALIZADA) {
            return c.abrir();
        }
        return false;
    }

    public boolean cerrarCarrera(Carrera c) {
        return c.cerrar();
    }

    @Override
    public boolean equals(Object obj) {
        Jornada j = (Jornada) obj;
        return fecha.equals(j.getFecha());
    }

    @Override
    public int compareTo(Jornada o) {
        if (fecha.after(o.getFecha())) {
            return 1;
        } else if (fecha.before(o.getFecha())) {
            return -1;
        } else {
            return 0;
        }
    }
}
