package bl;

import bl.enums.ErroresHipodromo;
import java.util.ArrayList;
import java.util.Date;

public class SSHipodromos {

    private ArrayList<Hipodromo> hipodromos;
    private ArrayList<Caballo> caballos;
    private Hipodromo hipodromoActual;

    public SSHipodromos() {
        hipodromos = new ArrayList<>();
        caballos = new ArrayList<>();
    }

    public ArrayList<Hipodromo> getHipodromos() {
        return hipodromos;
    }

    public Hipodromo getHipodromoActual() {
        return hipodromoActual;
    }

    public ErroresHipodromo agregarHipodromo(Hipodromo hipodromo) {
        ErroresHipodromo ret = ErroresHipodromo.OK;

        for (Hipodromo h : hipodromos) {
            if (h.getNombre().equals(hipodromo.getNombre())) {
                ret = ErroresHipodromo.NombreDup;
            } else if (h.getDireccion().equals(hipodromo.getDireccion())) {
                ret = ErroresHipodromo.DireccionDup;
            }
        }

        if (ret == ErroresHipodromo.OK) {
            ret = hipodromos.add(hipodromo)
                    ? ErroresHipodromo.OK : ErroresHipodromo.ErrorGenerico;
        }
        return ret;
    }

    public Hipodromo seleccionarHipodromo(Hipodromo hipodromo) {
        Hipodromo seleccionado = buscarHipodromo(hipodromo.getNombre());
        if (seleccionado != null) {
            setHipodromoActual(seleccionado);
            return seleccionado;
        }
        return null;
    }

    public boolean agregarCaballo(Caballo caballo) {
        if (!caballos.contains(caballo)) {
            return caballos.add(caballo);
        }
        return false;
    }

    public ArrayList<Caballo> getCaballosDisponibles(Date fecha) {
        ArrayList<Caballo> retorno = new ArrayList<>();

        boolean estaDisponible = true;
        for (Caballo c : caballos) {
            for (Hipodromo h : hipodromos) {
                if (!estaDisponible(c, fecha, h)) {
                    estaDisponible = false;
                    break;
                }
            }
            if (estaDisponible) {
                retorno.add(c);
            }
            estaDisponible = true;
        }
        return retorno;
    }

    public Hipodromo buscarHipodromo(String nombre) {
        for (Hipodromo h : hipodromos) {
            if (h.getNombre().equals(nombre)) {
                return h;
            }
        }
        return null;
    }

    public Caballo buscarCaballo(String nombre) {
        for (Caballo c : caballos) {
            if (c.getNombre().equals(nombre)) {
                return c;
            }
        }
        return null;
    }

    public Carrera buscarCarreraPorOid(int oid) {
        for (Hipodromo h : hipodromos) {
            Carrera c = h.buscarCarreraPorOid(oid);
            if (c != null) {
                return c;
            }
        }
        return null;
    }

    //<editor-fold defaultstate="collapsed" desc="Métodos privados">
    private boolean estaDisponible(Caballo caballo, Date fecha, Hipodromo h) {
        return h.estaDisponible(caballo, fecha);
    }

    private void setHipodromoActual(Hipodromo actual) {
        this.hipodromoActual = actual;
    }
    //</editor-fold>
}
