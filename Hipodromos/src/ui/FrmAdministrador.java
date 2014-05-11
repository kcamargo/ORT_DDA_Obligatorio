package ui;
import bl.Administrador;
import bl.Caballo;
import bl.Fachada;
import bl.Carrera;
import bl.Hipodromo;
import java.util.ArrayList;

public class FrmAdministrador extends javax.swing.JFrame {

    Fachada fac = Fachada.getInstancia();
    public FrmAdministrador(Administrador a ) {
        initComponents();
        if(a != null ){
            lblBienvenida.setText(a.getUsername());
            System.out.println(a.getUsername());
            cargarMenu();
            ArrayList<Hipodromo> hipodromos = fac.getHipodromos();
            for(Hipodromo h:hipodromos){
                cmbHipodromos.addItem(h);
            }
            System.out.println("GET ITEM");
            cmbHipodromos.getItemAt(1);
        }
        
    }
    private void crearHipodromo(){
        String nombre = txtNombreHipodromo.getText();
        String direccion = txtDireccionHipodromo.getText();
        Hipodromo h = new Hipodromo(nombre, direccion);
        if ( null != h.getNombre() ) {
            int res = fac.crearHipodromo(h);
            if( res == 1 ){
                System.out.println("Hipodromo Creado");
                lblMensajeCrear.setText("Hipodromo Creado");
            }else if(res == 0){
                System.out.println("Nombre de hipodromo repetido");
                lblMensajeCrear.setText("Nombre de hipodromo repetido");
            }else{
                System.out.println("Direccion repetida");
                lblMensajeCrear.setText("Direccion de Hipodromo ya ingresada");
            }
            
        }else{
            System.out.println("Todos los campos son requeridos.");
            lblMensajeCrear.setText("Todos los campos son requerdos.");
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblBienvenida = new javax.swing.JLabel();
        cmbHipodromos = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtNombreHipodromo = new javax.swing.JTextField();
        txtDireccionHipodromo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAgregarHipodromo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblMensajeCrear = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Bienvenido");

        cmbHipodromos.setToolTipText("");
        cmbHipodromos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHipodromosActionPerformed(evt);
            }
        });

        jLabel2.setText("Seleccione un Hipodromo :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hipodromos", "Carreras", "Emular Termina de Usuario", "Salir" }));

        jLabel3.setText("Crear un Hipodrormmo");

        jLabel4.setText("Nombre : ");

        jLabel5.setText("Direccion  :");

        btnAgregarHipodromo.setText("Crear Hipodromo");
        btnAgregarHipodromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarHipodromoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbHipodromos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblBienvenida))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreHipodromo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccionHipodromo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregarHipodromo))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(lblMensajeCrear))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(159, Short.MAX_VALUE))
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblBienvenida))
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbHipodromos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtNombreHipodromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtDireccionHipodromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(btnAgregarHipodromo)))
                .addGap(161, 161, 161)
                .addComponent(lblMensajeCrear)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbHipodromosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHipodromosActionPerformed
        // TODO add your handling code here:
        Hipodromo h = (Hipodromo)cmbHipodromos.getItemAt(cmbHipodromos.getSelectedIndex());
        fac.seleccionarHipodromo(h);
        System.out.println(fac.getHipodromoActual().getNombre() +  " --"+ fac.getHipodromoActual().getDireccion());
        

        
    }//GEN-LAST:event_cmbHipodromosActionPerformed

    private void btnAgregarHipodromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarHipodromoActionPerformed
        // TODO add your handling code here:
        crearHipodromo();
    }//GEN-LAST:event_btnAgregarHipodromoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarHipodromo;
    private javax.swing.JComboBox cmbHipodromos;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblMensajeCrear;
    private javax.swing.JTextField txtDireccionHipodromo;
    private javax.swing.JTextField txtNombreHipodromo;
    // End of variables declaration//GEN-END:variables

    private void cargarMenu( ) {
        
    }
}
