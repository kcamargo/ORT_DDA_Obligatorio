package bl;

import java.util.ArrayList;

public class SSUsuarios {

    private ArrayList<Usuario> usuarios;

    public SSUsuarios() {
        usuarios = new ArrayList<>();
    }

    public boolean login(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.equals(usuario)) {
                return true;
            }
        }
        return false;
    }

    public boolean agregarUsuario(Usuario u) {
        if (!usuarios.contains(u)) {
            return usuarios.add(u);
        }
        return false;
    }
}
