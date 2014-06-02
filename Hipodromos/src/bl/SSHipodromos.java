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

        for (Hipodromo h1 : hipodromos) {
            for (Caballo c : caballos) {
                if (estaDisponible(c, fecha, h1)) {
                    retorno.add(c);
                }
            }
        }

        return retorno;
    }

    //<editor-fold defaultstate="collapsed" desc="Métodos privados">
    private boolean estaDisponible(Caballo caballo, Date fecha, Hipodromo h1) {
        return h1.estaDisponible(caballo, fecha);
    }

    private Hipodromo buscarHipodromo(String nombre) {
        for (Hipodromo h : hipodromos) {
            if (h.getNombre().equals(nombre)) {
                return h;
            }
        }
        return null;
    }

    private void setHipodromoActual(Hipodromo actual) {
        this.hipodromoActual = actual;
    }
    //</editor-fold>
}
