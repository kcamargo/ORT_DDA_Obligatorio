package ui;

import bl.Administrador;
import bl.Fachada;
import bl.Hipodromo;
import java.util.ArrayList;

public class DlgSeleccionarHipodromo extends javax.swing.JDialog {

    Fachada fac = Fachada.getInstancia();
    Administrador admin;

    public DlgSeleccionarHipodromo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        seleccionarHipodromo();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbHipodromos = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btnSeeccionarHipodromo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblBienvenida = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        getContentPane().add(cmbHipodromos);
        cmbHipodromos.setBounds(35, 107, 151, 20);

        jLabel1.setText("Seleccionar Hipodromo");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(136, 58, 138, 14);

        btnSeeccionarHipodromo.setText("Seleccionar");
        btnSeeccionarHipodromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeccionarHipodromoActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeeccionarHipodromo);
        btnSeeccionarHipodromo.setBounds(229, 106, 90, 23);

        jLabel2.setText("Bienvenido :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 11, 80, 14);

        lblBienvenida.setText("jLabel3");
        getContentPane().add(lblBienvenida);
        lblBienvenida.setBounds(96, 11, 188, 14);

        setBounds(0, 0, 416, 188);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeeccionarHipodromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeccionarHipodromoActionPerformed
        // TODO add your handling code here:        
        Hipodromo h = (Hipodromo) cmbHipodromos.getItemAt(cmbHipodromos.getSelectedIndex());
        fac.seleccionarHipodromo(h);
        this.setVisible(false);
    }//GEN-LAST:event_btnSeeccionarHipodromoActionPerformed

    private void seleccionarHipodromo() {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Hipodromo> hipodromos = fac.getHipodromos();
        for (Hipodromo h : hipodromos) {
            cmbHipodromos.addItem(h);
        }
        cmbHipodromos.getItemAt(1);
    }

    public void cargarForm(FrmAdministrador instance) {
        instance.setVisible(true);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeeccionarHipodromo;
    private javax.swing.JComboBox cmbHipodromos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblBienvenida;
    // End of variables declaration//GEN-END:variables

    public void cargarAdmin(Administrador a) {
        lblBienvenida.setText(a.getUsername());
    }
}
