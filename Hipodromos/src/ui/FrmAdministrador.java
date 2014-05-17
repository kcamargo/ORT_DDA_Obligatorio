package ui;

import bl.Administrador;
import bl.Caballo;
import bl.Fachada;
import bl.Carrera;
import bl.enums.ErroresHipodromo;
import bl.Hipodromo;
import java.util.ArrayList;

public class FrmAdministrador extends javax.swing.JFrame {

    Fachada fac = Fachada.getInstancia();
    DlgSeleccionarHipodromo dialogSeleccionar;
    DlgCrearHipodromo dialogCrear;
    DlgCrearCarrera dialogCarrera;
    public FrmAdministrador() {
        initComponents();
        cargarMenu();
        dialogSeleccionar = new DlgSeleccionarHipodromo(this, true);
        dialogCrear = new DlgCrearHipodromo(this,true);
        dialogCarrera = new DlgCrearCarrera(this, true);
        System.out.println("/////"+ fac.getHipodromoActual());
        
    }

   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBienvenida = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblMensajeCrear = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemSeleccionar = new javax.swing.JMenuItem();
        itemCrearHipodromo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(lblBienvenida))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(lblMensajeCrear)))
                .addContainerGap(333, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBienvenida)
                .addGap(217, 217, 217)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(209, 209, 209)
                .addComponent(lblMensajeCrear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSeleccionarActionPerformed
        // TODO add your handling code here:
        dialogSeleccionar.setVisible(true);
        
    }//GEN-LAST:event_itemSeleccionarActionPerformed

    private void itemCrearHipodromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCrearHipodromoActionPerformed
        // TODO add your handling code here:       
        dialogCrear.setVisible(true);
    }//GEN-LAST:event_itemCrearHipodromoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        dialogCarrera.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemCrearHipodromo;
    private javax.swing.JMenuItem itemSeleccionar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblMensajeCrear;
    // End of variables declaration//GEN-END:variables

    private void cargarMenu() {
    }
}
