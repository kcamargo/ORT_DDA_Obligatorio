package ui;

import bl.Caballo;
import bl.CaballoEnCarrera;
import bl.Carrera;
import bl.Fachada;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class DlgSeleccionarCaballosCarrera extends javax.swing.JDialog {

    Fachada fac = Fachada.getInstancia();
    Carrera carrera;
    ArrayList<CaballoEnCarrera> caballosCarrera = new ArrayList();

    public DlgSeleccionarCaballosCarrera(java.awt.Frame parent, boolean modal, Carrera c) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        carrera = c;
        listarCaballosDisponibles();
        CerrarVentana();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstDisponibles = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstSeleccionados = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtNumeroCaballo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        txtDividendo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lblMensajee = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jScrollPane1.setViewportView(lstDisponibles);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 80, 170, 130);

        jScrollPane2.setViewportView(lstSeleccionados);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(380, 80, 155, 130);

        jLabel1.setText("Seleccionar caballos ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(220, 20, 139, 14);

        jButton1.setText("Finalizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(440, 230, 94, 23);

        jLabel2.setText("Disponibles");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 60, 130, 14);

        jLabel3.setText("Seleccionados");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(390, 60, 113, 14);
        getContentPane().add(lblMensaje);
        lblMensaje.setBounds(145, 302, 192, 0);

        jButton2.setText("Seleccionar      >>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(200, 140, 170, 23);

        txtNumeroCaballo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroCaballoActionPerformed(evt);
            }
        });
        getContentPane().add(txtNumeroCaballo);
        txtNumeroCaballo.setBounds(260, 80, 110, 20);

        jLabel4.setText("Numero :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(200, 80, 60, 20);

        jButton3.setText("<<  Quitar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(200, 170, 170, 23);
        getContentPane().add(txtDividendo);
        txtDividendo.setBounds(260, 110, 110, 20);

        jLabel7.setText("Dividendo");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(200, 110, 50, 14);
        getContentPane().add(lblMensajee);
        lblMensajee.setBounds(200, 220, 180, 14);

        setBounds(0, 0, 577, 317);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (caballosCarrera.size() < 2) {
            lblMensajee.setText("Deberá seleccionar al menos 2 caballos.");
        } else {
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            int numero = Integer.parseInt(txtNumeroCaballo.getText());
            double dividendo = Double.parseDouble(txtDividendo.getText());
            Caballo c = (Caballo) lstDisponibles.getSelectedValue();
            if (c != null) {
                CaballoEnCarrera caballoCarrera = new CaballoEnCarrera(numero, dividendo, c);
                if (!carrera.existeNumeroCaballo(caballoCarrera)) {
                    if (caballoCarrera.validar()) {
                        caballoCarrera = carrera.agregarCaballo(c, numero, dividendo);
                        //Metodos para la UI
                        caballosCarrera.add(caballoCarrera);
                        lstSeleccionados.setListData(caballosCarrera.toArray());
                        lblMensajee.setText("");
                    } else {
                        lblMensajee.setText("Los datos ingresados no son correctos.");
                    }
                } else {
                    lblMensajee.setText("Numero de caballo invalido.");
                }
            } else {
                lblMensajee.setText("Seleccione un caballo.");
            }
        } catch (Exception ex) {
            lblMensajee.setText("Complete los campos.");
        }

        listarCaballosDisponibles();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtNumeroCaballoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroCaballoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroCaballoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            CaballoEnCarrera c = (CaballoEnCarrera) lstSeleccionados.getSelectedValue();
            if (c != null) {
                carrera.quitarCaballo(c.getCaballo());
                //metodos para la UI
                caballosCarrera.remove(c);
                lstSeleccionados.setListData(caballosCarrera.toArray());
                listarCaballosDisponibles();

            } else {
                lblMensajee.setText("No hay caballos para quitar.");
            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void listarCaballosDisponibles() {
        lstDisponibles.setListData(fac.getCaballosDisponibles(carrera.getFecha()).toArray());
    }

    private void CerrarVentana() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                fac.getHipodromoActual().borrarCarrera(carrera);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblMensajee;
    private javax.swing.JList lstDisponibles;
    private javax.swing.JList lstSeleccionados;
    private javax.swing.JTextField txtDividendo;
    private javax.swing.JTextField txtNumeroCaballo;
    // End of variables declaration//GEN-END:variables
}
