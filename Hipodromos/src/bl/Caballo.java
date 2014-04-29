package bl;

public class Caballo {

    private String nombre;
    private String nombreResponsable;

    //<editor-fold defaultstate="collapsed" desc="Get/Set">
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
    }
    //</editor-fold>

    @Override
    public boolean equals(Object o) {
        Caballo c = (Caballo) o;
        return nombre.equals(c.getNombre());
    }
}
