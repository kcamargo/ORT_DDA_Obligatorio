package bl;

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

    public boolean agregarHipodromo(Hipodromo hipodromo) {
        if (!hipodromos.contains(hipodromo)) {
            return hipodromos.add(hipodromo);
        }
        return false;
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
        for (Caballo c : caballos) {
            if (estaDisponible(c, fecha)) {
                retorno.add(c);
            }
        }
        return retorno;
    }

    //<editor-fold defaultstate="collapsed" desc="Métodos privados">
    private boolean estaDisponible(Caballo caballo, Date fecha) {
        boolean disp = true;
        while (disp) {
            int i = 0;
            Hipodromo h = hipodromos.get(i);
            if (!h.estaDisponible(caballo, fecha)) {
                disp = false;
            }
            i++;
        }
        return disp;
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
