package bl;

public class Administrador extends Usuario {

    public Administrador(String username, String password, String nombre, String apellido) {
        super(username, password, nombre, apellido);
    }

    public Administrador(String user, String pass) {
        super(user, pass);
    }

    public Administrador() {
        super();
    }
}
