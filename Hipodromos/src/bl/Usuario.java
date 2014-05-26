package bl;

public class Usuario {

    private String username;
    private String password;
    private String nombre;
    private String apellido;

    //<editor-fold defaultstate="collapsed" desc="Get/Set">
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

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Usuario() {
    }

    //TODO: Revisar
    public boolean validarCamposLogin(String pUser, String pPass) {
        boolean retorno = false;
        if (pUser != null && !pUser.isEmpty() && pPass != null && !pPass.isEmpty()) {
            retorno = true;
        }
        if (retorno) {
            this.setUsername(pUser);
            this.setPassword(pPass);
        }
        return retorno;
    }

    @Override
    public boolean equals(Object o) {
        Usuario u = (Usuario) o;
        return username.equals(u.getUsername())
                && password.equals(u.getPassword());
        // && nombre.equals(u.getNombre())
        // && apellido.equals(u.getApellido());
    }
}
