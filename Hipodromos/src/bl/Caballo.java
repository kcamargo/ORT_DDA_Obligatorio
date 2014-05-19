package bl;

public class Caballo {

    private String nombre;
    private String nombreResponsable;

    public Caballo(String nombre, String nombreResponsable) {
        this.nombre = nombre;
        this.nombreResponsable = nombreResponsable;
    }

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

    @Override
    public String toString() {
        return nombre; 
    }
    
}
