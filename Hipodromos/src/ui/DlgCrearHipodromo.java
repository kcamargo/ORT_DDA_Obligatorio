package ui;

import bl.Hipodromo;
import bl.enums.ErroresHipodromo;
import bl.Fachada;
import static bl.enums.ErroresHipodromo.DireccionDup;
import static bl.enums.ErroresHipodromo.ErrorGenerico;
import static bl.enums.ErroresHipodromo.NombreDup;
import static bl.enums.ErroresHipodromo.OK;

public class DlgCrearHipodromo extends javax.swing.JDialog {

    Fachada fac = Fachada.getInstancia();

    public DlgCrearHipodromo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCrearHipodromo = new javax.swing.JButton();
        lblMensajeCrear = new javax.swing.JLabel();
        txtNombreHipodromo = new javax.swing.JTextField();
        txtDireccionHipodromo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        btnCrearHipodromo.setText("Crear");
        btnCrearHipodromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearHipodromoActionPerformed(evt);
            }
        });
        getContentPane().add(btnCrearHipodromo);
        btnCrearHipodromo.setBounds(110, 170, 92, 48);
        getContentPane().add(lblMensajeCrear);
        lblMensajeCrear.setBounds(10, 240, 280, 20);
        getContentPane().add(txtNombreHipodromo);
        txtNombreHipodromo.setBounds(100, 60, 183, 20);
        getContentPane().add(txtDireccionHipodromo);
        txtDireccionHipodromo.setBounds(100, 110, 183, 20);

        jLabel1.setText("Nombre :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 60, 82, 14);

        jLabel2.setText("Direccion :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 120, 69, 14);

        jLabel3.setText("Crear Hipodromo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 20, 183, 14);

        setBounds(0, 0, 328, 318);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearHipodromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearHipodromoActionPerformed
        crearHipodromo();
    }//GEN-LAST:event_btnCrearHipodromoActionPerformed

    private void crearHipodromo() {
        String nombre = txtNombreHipodromo.getText();
        String direccion = txtDireccionHipodromo.getText();
        Hipodromo h = new Hipodromo(nombre, direccion);

        if (h.validar()) {
            try {
                fac.agregarHipodromo(h);
                lblMensajeCrear.setText("Hipodromo Creado");
            } catch (Exception e) {
                lblMensajeCrear.setText(e.getMessage());
            }
        } else {
            lblMensajeCrear.setText("Todos los campos son requerdos.");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearHipodromo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblMensajeCrear;
    private javax.swing.JTextField txtDireccionHipodromo;
    private javax.swing.JTextField txtNombreHipodromo;
    // End of variables declaration//GEN-END:variables
}
