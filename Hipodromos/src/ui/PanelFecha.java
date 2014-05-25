package ui;

import java.util.Date;
import util.Fecha;

public class PanelFecha extends javax.swing.JPanel {

    public PanelFecha() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMes = new javax.swing.JTextField();
        txtDia = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(218, 86));
        setLayout(null);
        add(txtMes);
        txtMes.setBounds(80, 50, 40, 20);
        add(txtDia);
        txtDia.setBounds(20, 50, 40, 20);
        add(txtAnio);
        txtAnio.setBounds(140, 50, 60, 20);

        jLabel1.setText("/");
        add(jLabel1);
        jLabel1.setBounds(70, 50, 10, 20);

        jLabel2.setText("/");
        add(jLabel2);
        jLabel2.setBounds(130, 50, 10, 20);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Ingrese una fecha:");
        add(jLabel3);
        jLabel3.setBounds(20, 20, 180, 20);
    }// </editor-fold>//GEN-END:initComponents

    public Date getFecha() {
        if (txtDia.getText().equals("") & txtMes.getText().equals("") & txtAnio.getText().equals("")) {
            return Fecha.fechaActual();
        }
        try {
            int dia = Integer.parseInt(txtDia.getText());
            int mes = Integer.parseInt(txtMes.getText());
            int anio = Integer.parseInt(txtAnio.getText());
            return Fecha.crearFecha(dia, mes, anio);
        } catch (Exception e) {
            throw e;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtMes;
    // End of variables declaration//GEN-END:variables
}
