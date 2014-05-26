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
        btnFinalizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        txtNumeroCaballo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnQuitar = new javax.swing.JButton();
        txtDividendo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
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

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnFinalizar);
        btnFinalizar.setBounds(440, 230, 94, 23);

        jLabel2.setText("Disponibles");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 60, 130, 14);

        jLabel3.setText("Seleccionados");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(390, 60, 113, 14);

        btnSeleccionar.setText("Seleccionar      >>");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeleccionar);
        btnSeleccionar.setBounds(200, 140, 170, 23);

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

        btnQuitar.setText("<<  Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        getContentPane().add(btnQuitar);
        btnQuitar.setBounds(200, 170, 170, 23);
        getContentPane().add(txtDividendo);
        txtDividendo.setBounds(260, 110, 110, 20);

        jLabel7.setText("Dividendo");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(200, 110, 50, 14);

        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblMensaje);
        lblMensaje.setBounds(20, 230, 390, 20);

        setBounds(0, 0, 577, 317);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        if (caballosCarrera.size() < 2) {
            lblMensaje.setText("Deberá seleccionar al menos 2 caballos.");
        } else {
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed

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
                        limpiarCampos();
                    } else {
                        lblMensaje.setText("Los datos ingresados no son correctos.");
                    }
                } else {
                    lblMensaje.setText("Numero de caballo invalido.");
                }
            } else {
                lblMensaje.setText("Seleccione un caballo.");
            }
        } catch (Exception ex) {
            lblMensaje.setText("Complete los campos.");
        }

        listarCaballosDisponibles();

    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void txtNumeroCaballoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroCaballoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroCaballoActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        try {
            CaballoEnCarrera c = (CaballoEnCarrera) lstSeleccionados.getSelectedValue();
            if (c != null) {
                carrera.quitarCaballo(c.getCaballo());
                //metodos para la UI
                caballosCarrera.remove(c);
                lstSeleccionados.setListData(caballosCarrera.toArray());
                listarCaballosDisponibles();

            } else {
                lblMensaje.setText("No hay caballos para quitar.");
            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

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
    
    private void limpiarCampos(){
        this.txtNumeroCaballo.setText("");
        this.txtDividendo.setText("");
        this.lblMensaje.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JList lstDisponibles;
    private javax.swing.JList lstSeleccionados;
    private javax.swing.JTextField txtDividendo;
    private javax.swing.JTextField txtNumeroCaballo;
    // End of variables declaration//GEN-END:variables
}
