package bl;

import java.util.ArrayList;
import java.util.Date;

public class Jornada implements Comparable<Jornada> {

    private Date fecha;
    private ArrayList<Carrera> carreras;
    private Carrera siguienteCarrera;
    private Carrera carreraAbierta;
    private Carrera carreraCerrada;

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

    public Carrera getSiguienteCarrera() {
        if (siguienteCarrera == null) {
            for (Carrera c : carreras) {
                if (c.getEstado() == Carrera.EstadoCarrera.DEFINIDA) {
                    return c;
                }
            }
        }
        return siguienteCarrera;
    }

    public Carrera getCarreraAbierta() {
        if (carreraAbierta == null) {
            for (Carrera c : carreras) {
                if (c.getEstado() == Carrera.EstadoCarrera.ABIERTA) {
                    setCarreraAbierta(c);
                }
            }
        }
        return carreraAbierta;
    }

    public Carrera getCarreraCerrada() {
        if (carreraCerrada == null) {
            for (Carrera c : carreras) {
                if (c.getEstado() == Carrera.EstadoCarrera.CERRADA) {
                    setCarreraCerrada(c);
                }
            }
        }
        return carreraCerrada;
    }

    public void setSiguienteCarrera(Carrera siguienteCarrera) {
        this.siguienteCarrera = siguienteCarrera;
    }

    public void setCarreraAbierta(Carrera carreraAbierta) {
        this.carreraAbierta = carreraAbierta;
    }

    public void setCarreraCerrada(Carrera carreraCerrada) {
        this.carreraCerrada = carreraCerrada;
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
            c.setNumero(getSiguienteNumeroDeCarrera());
            return carreras.add(c);
        }
        return false;
    }

    public boolean abrirCarrera(Carrera c) {
        int indiceAnterior = carreras.indexOf(c) - 1;
        if (indiceAnterior >= 0) {
            Carrera anterior = carreras.get(indiceAnterior);
            if (anterior.getEstado() == Carrera.EstadoCarrera.FINALIZADA) {
                if (c.abrir()) {
                    setSiguienteCarrera(null);
                    setSiguienteCarrera(getSiguienteCarrera());
                    setCarreraAbierta(c);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return c.abrir();
        }
    }

    public boolean cerrarCarrera(Carrera c) {
        if (c.cerrar()) {
            setCarreraAbierta(null);
            setCarreraCerrada(c);
            return true;
        } else {
            return false;
        }
    }

    public boolean asignarGanador(Carrera c, CaballoEnCarrera caballo) {
        boolean ret = false;
        Carrera carrera = buscarCarrera(c);
        if (carrera != null) {
            carrera.setGanador(caballo);
            if (carrera.getEstado() == Carrera.EstadoCarrera.FINALIZADA) {
                setCarreraCerrada(null);
                setSiguienteCarrera(getSiguienteCarrera());
                ret = true;
            }
        }
        return ret;
    }
    
    public void eliminarCarrera(Carrera c){
        Carrera carrera = buscarCarrera(c);
        if(c!=null){
            carreras.remove(c);
        }
    }

    private Carrera buscarCarrera(Carrera carrera) {
        for (Carrera c : carreras) {
            if (c.equals(carrera)) {
                return c;
            }
        }
        return null;
    }
    

    private int getSiguienteNumeroDeCarrera() {
        return carreras.size() + 1;
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
