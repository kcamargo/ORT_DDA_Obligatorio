package ui;

import bl.CaballoEnCarrera;
import bl.Carrera;
import bl.Fachada;
import bl.Hipodromo;
import bl.Jugador;
import java.util.ArrayList;
import util.Observable;
import util.Observador;

public class FrmJugador extends javax.swing.JFrame implements Observador {

    private Fachada fachada;

    public FrmJugador() {
        initComponents();
        fachada = Fachada.getInstancia();
        fachada.agregarObservador(this);
        cargarHipodromos();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblNumeroCarrera = new javax.swing.JLabel();
        lblNombreCarrera = new javax.swing.JLabel();
        lblEstadoCarrera = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        btnApostar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        cmbHipodromo = new javax.swing.JComboBox();
        txtMonto = new javax.swing.JFormattedTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstCaballos = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Jugador");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Usuario:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 20, 100, 20);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Contraseña:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 50, 100, 20);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Hipódromo:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(25, 110, 130, 30);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Información de la carrera actual:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(17, 170, 410, 20);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Número:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 210, 120, 20);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Nombre:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 250, 120, 20);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Estado:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 290, 120, 20);
        getContentPane().add(lblNumeroCarrera);
        lblNumeroCarrera.setBounds(150, 210, 210, 20);
        getContentPane().add(lblNombreCarrera);
        lblNombreCarrera.setBounds(150, 250, 210, 20);
        getContentPane().add(lblEstadoCarrera);
        lblEstadoCarrera.setBounds(150, 290, 210, 20);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Caballos participantes:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(19, 340, 410, 20);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Monto a apostar:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(23, 640, 190, 20);

        btnConsultar.setLabel("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(btnConsultar);
        btnConsultar.setBounds(310, 30, 100, 30);

        btnApostar.setText("Apostar");
        btnApostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApostarActionPerformed(evt);
            }
        });
        getContentPane().add(btnApostar);
        btnApostar.setBounds(160, 680, 130, 40);
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(130, 20, 150, 20);
        getContentPane().add(txtPass);
        txtPass.setBounds(130, 50, 150, 20);

        cmbHipodromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHipodromoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbHipodromo);
        cmbHipodromo.setBounds(160, 110, 200, 30);
        getContentPane().add(txtMonto);
        txtMonto.setBounds(220, 640, 109, 20);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(20, 320, 410, 10);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(20, 90, 410, 10);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(20, 160, 410, 10);

        jScrollPane2.setViewportView(lstCaballos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 370, 410, 250);

        setBounds(0, 0, 469, 773);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbHipodromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHipodromoActionPerformed
        fachada.seleccionarHipodromo((Hipodromo) cmbHipodromo.getSelectedItem());
        mostrarInfoDeCarrera(fachada.getHipodromoActual().getSiguienteCarrera());
    }//GEN-LAST:event_cmbHipodromoActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        Jugador j = new Jugador(0, txtUsuario.getText().toString(), txtPass.getPassword().toString());

        if (fachada.login(j) != null) {
            //TODO Consultar saldo y ultima apuesta.
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApostarActionPerformed
        Jugador j = new Jugador(0, txtUsuario.getText().toString(), txtPass.getPassword().toString());

        if (fachada.login(j) != null) {
            // TODO Apostar
        }
    }//GEN-LAST:event_btnApostarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApostar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JComboBox cmbHipodromo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblEstadoCarrera;
    private javax.swing.JLabel lblNombreCarrera;
    private javax.swing.JLabel lblNumeroCarrera;
    private javax.swing.JList lstCaballos;
    private javax.swing.JFormattedTextField txtMonto;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private void mostrarInfoDeCarrera(Carrera c) {
        if (c != null) {
            this.lblNombreCarrera.setText(c.getNombre());
            this.lblNumeroCarrera.setText(String.valueOf(c.getNumero()));
            this.lblEstadoCarrera.setText(c.getEstadoString());

            mostrarCaballosParticipantes(c.getCaballos());
        } else {
            limpiarDatosDeCarrera();
            limpiarDatosDeCaballos();
        }
    }

    private void mostrarCaballosParticipantes(ArrayList<CaballoEnCarrera> caballos) {
        lstCaballos.setListData(formatearListaDeCaballos(caballos));
    }

    private Object[] formatearListaDeCaballos(ArrayList<CaballoEnCarrera> caballos) {
        Object[] ret = new Object[caballos.size()];

        for (int i = 0; i < caballos.size(); i++) {
            CaballoEnCarrera c = caballos.get(i);
            ret[i] = "(" + c.getNumero() + ") " + c.getCaballo().getNombre() + " - " + c.getDividendo();

            if (c.isGanador()) {
                ret[i] += " ***GANADOR***";
            }
        }

        return ret;
    }

    @Override
    public void actualizar(Observable origen, Object param) {
        //TODO Actualizar FrmJugador cuando cambie la fachada
    }

    private void cargarHipodromos() {
        for (Hipodromo h : fachada.getHipodromos()) {
            cmbHipodromo.addItem(h);
        }
    }

    private void limpiarDatosDeCarrera() {
        this.lblNombreCarrera.setText("");
        this.lblNumeroCarrera.setText("");
        this.lblEstadoCarrera.setText("");
    }

    private void limpiarDatosDeCaballos() {
        this.lstCaballos.setListData(new Object[0]);
    }
}
