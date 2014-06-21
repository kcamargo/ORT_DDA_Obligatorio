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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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
        btnLogin.setBounds(60, 160, 158, 37);

        txtUsuario.setText("admin");
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(100, 60, 158, 20);

        txtPass.setText("admin");
        txtPass.setToolTipText("");
        getContentPane().add(txtPass);
        txtPass.setBounds(100, 90, 158, 20);

        lblLoginMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblLoginMensaje);
        lblLoginMensaje.setBounds(10, 120, 250, 20);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingresar :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 260, 30);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Usuario:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 60, 80, 20);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Contraseña:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 90, 80, 20);

        setBounds(0, 0, 295, 254);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String user = txtUsuario.getText().trim();
        String pass = txtPass.getText().trim();
        
        Administrador admin = fac.login(new Administrador(user, pass));
        
        if (admin != null) {
            this.setVisible(false);
                FrmAdministrador frmAdmin = new FrmAdministrador(admin);
                dialog = new DlgSeleccionarHipodromo(this, true);
                dialog.cargarAdmin(admin);
                dialog.setVisible(true);
                dialog.cargarForm(frmAdmin);
        } else {
            lblLoginMensaje.setText("Acceso denegado.");
        }
    }//GEN-LAST:event_btnLoginActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblLoginMensaje;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
