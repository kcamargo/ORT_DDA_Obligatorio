package bl;

public class Usuario {

    private int oid;
    private String username;
    private String password;
    private String nombre;
    private String apellido;

    //<editor-fold defaultstate="collapsed" desc="Get/Set">
    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    //</editor-fold>

    public Usuario(String username, String password, String nombre, String apellido) {
        this(username, password);
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Usuario() {
    }

    @Override
    public boolean equals(Object o) {
        Usuario u = (Usuario) o;
        return username.equals(u.getUsername())
                && password.equals(u.getPassword());
    }
}
