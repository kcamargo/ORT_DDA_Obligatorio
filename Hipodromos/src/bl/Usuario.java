package bl;

public class Usuario {

    private String username;
    private String password;

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
    //</editor-fold>

    public boolean validar() {
        return username != null && !username.equals("")
                && password != null && !password.equals("");
    }
}
