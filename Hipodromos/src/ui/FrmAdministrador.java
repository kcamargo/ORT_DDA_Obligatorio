package ui;

import bl.Carrera;
import bl.Fachada;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmAdministrador extends javax.swing.JFrame {

    Fachada fachada = Fachada.getInstancia();

    public FrmAdministrador() {
        initComponents();
        cargarMenu();
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        lblBienvenida = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblMensajeCrear = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemSeleccionar = new javax.swing.JMenuItem();
        itemCrearHipodromo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        administrarCarreras = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(lblBienvenida);
        lblBienvenida.setBounds(72, 11, 0, 0);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(10, 228, 499, 2);
        getContentPane().add(lblMensajeCrear);
        lblMensajeCrear.setBounds(176, 439, 0, 0);

        jMenuBar1.setToolTipText("");

        jMenu1.setText("Hipodromos");

        itemSeleccionar.setText("Seleccionar");
        itemSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSeleccionarActionPerformed(evt);
            }
        });
        jMenu1.add(itemSeleccionar);

        itemCrearHipodromo.setText("Crear");
        itemCrearHipodromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCrearHipodromoActionPerformed(evt);
            }
        });
        jMenu1.add(itemCrearHipodromo);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Carreras");

        jMenuItem1.setText("Crear Carrera");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        administrarCarreras.setText("Administrar");
        administrarCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrarCarrerasActionPerformed(evt);
            }
        });
        jMenu2.add(administrarCarreras);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Finalizar");

        jMenuItem3.setText("Salie de la aplicacion");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        setBounds(0, 0, 525, 509);
    }// </editor-fold>//GEN-END:initComponents

    private void itemSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSeleccionarActionPerformed
        new DlgSeleccionarHipodromo(this, true).setVisible(true);
    }//GEN-LAST:event_itemSeleccionarActionPerformed

    private void itemCrearHipodromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCrearHipodromoActionPerformed
        new DlgCrearHipodromo(this, true).setVisible(true);
    }//GEN-LAST:event_itemCrearHipodromoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new DlgCrearCarrera(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void administrarCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrarCarrerasActionPerformed
        Carrera abierta = fachada.getHipodromoActual().getCarreraAbierta();
        Carrera cerrada = fachada.getHipodromoActual().getCarreraCerrada();
        Carrera siguiente = fachada.getHipodromoActual().getSiguienteCarrera();

        new DlgAdministrarCarreras(this, true, siguiente, abierta, cerrada, fachada.getHipodromoActual()).setVisible(true);
    }//GEN-LAST:event_administrarCarrerasActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem administrarCarreras;
    private javax.swing.JMenuItem itemCrearHipodromo;
    private javax.swing.JMenuItem itemSeleccionar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblMensajeCrear;
    // End of variables declaration//GEN-END:variables

    private void cargarMenu() {
    }
}
