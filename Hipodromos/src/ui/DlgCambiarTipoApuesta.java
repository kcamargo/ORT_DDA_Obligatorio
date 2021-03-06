package ui;

import bl.CaballoEnCarrera;
import bl.Fachada;
import bl.Hipodromo;
import bl.Carrera;
import bl.enums.TiposApuestas;
import java.util.ArrayList;

public class DlgCambiarTipoApuesta extends javax.swing.JDialog {

    Fachada fac = Fachada.getInstancia();
    boolean inicio = false;
    ArrayList<Hipodromo> hipodromos = new ArrayList();
    ArrayList<Carrera> carreras = new ArrayList();

    public DlgCambiarTipoApuesta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        cargarDatos();
        inicio = true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbHipodromos = new javax.swing.JComboBox();
        cmbTipoApuesta = new javax.swing.JComboBox();
        btnCambiar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCarreras = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstCaballos = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cambiar Tipo de Apuesta");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(190, 20, 190, 17);

        cmbHipodromos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHipodromosActionPerformed(evt);
            }
        });
        getContentPane().add(cmbHipodromos);
        cmbHipodromos.setBounds(240, 120, 90, 20);

        cmbTipoApuesta.setToolTipText("");
        getContentPane().add(cmbTipoApuesta);
        cmbTipoApuesta.setBounds(240, 200, 90, 20);

        btnCambiar.setText("Cambiar");
        btnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCambiar);
        btnCambiar.setBounds(210, 290, 120, 30);

        jLabel2.setText("Hipódromo");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(240, 100, 80, 14);

        jLabel3.setText("Carrera");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(90, 80, 80, 14);

        jLabel4.setText("Tipo de Apuesta");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(240, 180, 80, 14);

        jLabel5.setText("Caballos");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(410, 80, 50, 14);

        lstCarreras.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCarrerasValueChanged(evt);
            }
        });
        lstCarreras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lstCarrerasFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(lstCarreras);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 100, 180, 130);

        jScrollPane2.setViewportView(lstCaballos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(360, 100, 180, 130);

        setBounds(0, 0, 581, 391);
    }// </editor-fold>//GEN-END:initComponents

    private void lstCarrerasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCarrerasValueChanged

        cargarCaballos((Carrera) lstCarreras.getSelectedValue());
    }//GEN-LAST:event_lstCarrerasValueChanged

    private void lstCarrerasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lstCarrerasFocusGained
    }//GEN-LAST:event_lstCarrerasFocusGained

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed
        try {
            CaballoEnCarrera cab = (CaballoEnCarrera) lstCaballos.getSelectedValue();

            TiposApuestas tipoNuevo = null;
            switch (cmbTipoApuesta.getSelectedItem().toString()) {
                case "Simple":
                    tipoNuevo = TiposApuestas.Simple;
                    break;
                case "Triple":
                    tipoNuevo = TiposApuestas.Triple;
                    break;
                case "Cuadruple":
                    tipoNuevo = TiposApuestas.Cuadruple;
                    break;
            }
            cab.modificarTipoApuesta(tipoNuevo);
        } catch (Exception ex) {
            System.out.println("Error***: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnCambiarActionPerformed

    private void cmbHipodromosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHipodromosActionPerformed
    }//GEN-LAST:event_cmbHipodromosActionPerformed

    private void cargarDatos() {
        hipodromos = fac.getHipodromos();
        for (Hipodromo h : hipodromos) {
            cmbHipodromos.addItem(h);
            carreras.addAll(h.getCarrerasDefinidasAbiertas());
        }

        cmbHipodromos.getItemAt(1);
        lstCarreras.setListData(carreras.toArray());
        if (carreras.size() > 0) {
            Carrera c = carreras.get(0);
            lstCaballos.setListData(c.getCaballosSinApuestas().toArray());
        }
        cmbTipoApuesta.addItem(TiposApuestas.Simple);
        cmbTipoApuesta.addItem(TiposApuestas.Triple);
        cmbTipoApuesta.addItem(TiposApuestas.Cuadruple);
    }

    private void cargarCaballos(Carrera carrera) {
        if (carrera != null) {
            lstCaballos.setListData(carrera.getCaballosSinApuestas().toArray());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiar;
    private javax.swing.JComboBox cmbHipodromos;
    private javax.swing.JComboBox cmbTipoApuesta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lstCaballos;
    private javax.swing.JList lstCarreras;
    // End of variables declaration//GEN-END:variables
}
