package ui;

import bl.Administrador;
import bl.Caballo;
import bl.Fachada;
import bl.Hipodromo;
import bl.Jugador;

public class FrmLogin extends javax.swing.JFrame {

    Fachada fac = Fachada.getInstancia();
    public FrmLogin() {
        initComponents();
        fac.agregarAdministrador(new Administrador("Admin", "111"));
        fac.agregarAdministrador(new Administrador("aaa", "111"));
        
        fac.agregarJugador(new Jugador(0 ,"Pedro", "222"));
        fac.agregarJugador(new Jugador(10 ,"Juan", "333"));
        fac.agregarJugador(new Jugador(20 ,"Ana", "444"));
        fac.agregarJugador(new Jugador(30 ,"Jose", "555"));
        fac.agregarJugador(new Jugador(40 ,"Maria", "666"));
        
        fac.agregarCaballo(new Caballo("Chispazo","Adrian"));
        fac.agregarCaballo(new Caballo("Alegre","Adrian"));
        fac.agregarCaballo(new Caballo("Retonto","Adrian"));
        fac.agregarCaballo(new Caballo("El Manco","Jorge"));
        fac.agregarCaballo(new Caballo("Negro","Jorge"));
        fac.agregarCaballo(new Caballo("Diente","Jorge"));
        fac.agregarCaballo(new Caballo("El Corto","Esteban"));
        fac.agregarCaballo(new Caballo("Revelde","Esteban"));
        fac.agregarCaballo(new Caballo("Tornado","Esteban"));
        fac.agregarCaballo(new Caballo("El Rayo","Esteban"));
        
        fac.agregarHipodromo(new Hipodromo("Maroñas","General Flores"));
        fac.agregarHipodromo(new Hipodromo("Colonia","Calle 1243"));
        fac.agregarHipodromo(new Hipodromo("Paysandu","Ruta 15 "));
        fac.agregarHipodromo(new Hipodromo("Artigas","Av Brasil"));
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPass = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        lblLoginMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuario :");

        txtUsuario.setText("Admin");

        jLabel2.setText("Contraseña :");

        txtPass.setText("111");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(40, 40, 40)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnLogin)
                                    .addComponent(txtPass)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(lblLoginMensaje)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(btnLogin)
                .addGap(18, 18, 18)
                .addComponent(lblLoginMensaje)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String user = txtUsuario.getText();
        String pass = txtPass.getText();
        Administrador admin = new Administrador();
        if(admin.validarCamposLogin(user, pass)){
            admin = fac.login(admin);
            if(admin != null){
                this.setVisible(false);
                FrmAdministrador menuAdmin = new  FrmAdministrador(admin);
                menuAdmin.setVisible(true);
               
            }else{
                lblLoginMensaje.setText("Nombre de usuario o contraseña incorrecta.");
            }
        }else {
            lblLoginMensaje.setText("Nombre de usuario o contraseña incorrecta.");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblLoginMensaje;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
