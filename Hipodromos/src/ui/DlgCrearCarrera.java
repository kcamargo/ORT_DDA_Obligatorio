package ui;

import bl.Carrera;
import bl.Fachada;
import java.awt.Frame;
import java.util.Calendar;
import java.util.Date;
import util.Fecha;

public class DlgCrearCarrera extends javax.swing.JDialog {

    Fachada fac = Fachada.getInstancia();

    public DlgCrearCarrera(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDay = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnCrearCarrera = new javax.swing.JButton();
        txtMonth = new javax.swing.JTextField();
        txtYear = new javax.swing.JTextField();
        lblMensaje = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jTextField2.setText("jTextField2");

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setText("Crear Carrera");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, 20, 124, 14);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Fecha :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 60, 80, 20);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 100, 80, 20);
        getContentPane().add(txtDay);
        txtDay.setBounds(130, 60, 26, 20);
        getContentPane().add(txtNombre);
        txtNombre.setBounds(130, 100, 143, 20);

        btnCrearCarrera.setText("Continuar");
        btnCrearCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCarreraActionPerformed(evt);
            }
        });
        getContentPane().add(btnCrearCarrera);
        btnCrearCarrera.setBounds(140, 140, 101, 42);
        getContentPane().add(txtMonth);
        txtMonth.setBounds(160, 60, 25, 20);
        getContentPane().add(txtYear);
        txtYear.setBounds(190, 60, 80, 20);

        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblMensaje);
        lblMensaje.setBounds(30, 200, 360, 23);

        jLabel4.setText("dd/mm/yyyy");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(280, 60, 83, 20);

        setBounds(0, 0, 422, 282);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCarreraActionPerformed
        Date fch;
        int year;
        int month;
        int day;
        Calendar cal = Calendar.getInstance();
        try {
            year = Integer.parseInt(txtYear.getText());
            month = Integer.parseInt(txtMonth.getText()) - 1;
            day = Integer.parseInt(txtDay.getText());
            fch = Fecha.crearFecha(day, month, year);
        } catch (Exception e) {
            fch = Fecha.fechaActual();
        }
        String nombre = txtNombre.getText();
        Carrera c = new Carrera(nombre, fch);

        if (fac.getHipodromoActual().validarDatosCarrera(c)) {
            if (c.validarFecha(fch)) {
                fac.getHipodromoActual().agregarCarrera(c);
                limpiarCampos();
                Frame parent = (Frame) this.getParent();
                new DlgSeleccionarCaballosCarrera(parent, true, c).setVisible(true);
            } else {
                lblMensaje.setText("La fecha de la carrera no es correcta");
            }
        } else {
            lblMensaje.setText("El nombre para de carrera para la jornada ya existe");
        }



    }//GEN-LAST:event_btnCrearCarreraActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearCarrera;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTextField txtDay;
    private javax.swing.JTextField txtMonth;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        this.txtDay.setText("");
        this.txtMonth.setText("");
        this.txtYear.setText("");
        this.txtNombre.setText("");
    }
}
