package bl;

import java.util.ArrayList;
import java.util.Date;

public class SSHipodromos {

    private ArrayList<Hipodromo> hipodromos;
    private ArrayList<Caballo> caballos;

    public SSHipodromos() {
        hipodromos = new ArrayList<>();
        caballos = new ArrayList<>();
    }

    public boolean agregarHipodromo(Hipodromo hipodromo) {
        if (!hipodromos.contains(hipodromo)) {
            return hipodromos.add(hipodromo);
        }
        return false;
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

    //<editor-fold defaultstate="collapsed" desc="Operaciones con carreras delegadas a Hipodromo">
    public boolean agregarCarrera(Hipodromo hipodromo, Carrera carrera) {
        Hipodromo h = buscarHipodromo(hipodromo.getNombre());
        return h.agregarCarrera(carrera);
    }

    public ArrayList<Carrera> getCarreras(Hipodromo hipodromo, Date fecha) {
        Hipodromo h = buscarHipodromo(hipodromo.getNombre());
        return h.getCarreras(fecha);
    }

    public ArrayList<Carrera> getCarrerasAbiertas(Hipodromo hipodromo) {
        Hipodromo h = buscarHipodromo(hipodromo.getNombre());
        return h.getCarrerasAbiertas();
    }

    public Carrera getSiguienteCarrera(Hipodromo hipodromo) {
        Hipodromo h = buscarHipodromo(hipodromo.getNombre());
        return h.getSiguienteCarrera();
    }

    public boolean abrirCarrera(Hipodromo hipodromo, Carrera carrera) {
        Hipodromo h = buscarHipodromo(hipodromo.getNombre());
        return h.abrirCarrera(carrera);
    }

    public boolean cerrarCarrera(Hipodromo hipodromo, Carrera carrera) {
        Hipodromo h = buscarHipodromo(hipodromo.getNombre());
        return h.cerrarCarrera(carrera);
    }
    //</editor-fold>

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
    //</editor-fold>
}
