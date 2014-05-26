package ui;

import bl.Administrador;
import bl.Fachada;

public class FrmLogin extends javax.swing.JFrame {

    Fachada fac = Fachada.getInstancia();
    DlgSeleccionarHipodromo dialog;

    public FrmLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogin = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        lblLoginMensaje = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin);
        btnLogin.setBounds(90, 150, 158, 37);

        txtUsuario.setText("Admin");
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(90, 60, 158, 20);

        txtPass.setText("111");
        txtPass.setToolTipText("");
        getContentPane().add(txtPass);
        txtPass.setBounds(90, 100, 158, 20);

        lblLoginMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblLoginMensaje);
        lblLoginMensaje.setBounds(20, 210, 310, 20);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setText("Ingresar :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 20, 150, 30);

        setBounds(0, 0, 376, 294);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String user = txtUsuario.getText();
        String pass = txtPass.getText();
        Administrador admin = new Administrador();
        if (admin.validarCamposLogin(user, pass)) {
            admin = fac.login(admin);
            if (admin != null) {
                //TODO: Revisar
                this.setVisible(false);
                FrmAdministrador frmAdmin = new FrmAdministrador(admin);
                dialog = new DlgSeleccionarHipodromo(this, true);
                dialog.cargarAdmin(admin);
                dialog.setVisible(true);
                dialog.cargarForm(frmAdmin);
            } else {
                lblLoginMensaje.setText("Nombre de usuario o contraseña incorrecta.");
            }
        } else {
            lblLoginMensaje.setText("Nombre de usuario o contraseña incorrecta.");
        }
    }//GEN-LAST:event_btnLoginActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblLoginMensaje;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
