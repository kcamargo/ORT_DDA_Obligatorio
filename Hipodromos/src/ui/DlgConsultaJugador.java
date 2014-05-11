package ui;

import bl.Apuesta;
import bl.Hipodromo;
import bl.Jugador;

public class DlgConsultaJugador extends javax.swing.JDialog {

    private Apuesta apuesta;
    private Jugador jugador;
    private Hipodromo hipodromo;

    public DlgConsultaJugador(java.awt.Frame parent, boolean modal, Jugador jugador, Apuesta apuesta) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);

        FrmJugador frmJug = (FrmJugador) parent;
        hipodromo = frmJug.getHipodromoSeleccionado();
        this.apuesta = apuesta;
        this.jugador = jugador;
        mostrarInfoDeApuesta();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblDividendo = new javax.swing.JLabel();
        lblApostado = new javax.swing.JLabel();
        lblGanado = new javax.swing.JLabel();
        lblHipodromo = new javax.swing.JLabel();
        lblNroCarrera = new javax.swing.JLabel();
        lblNomCarrera = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblNroCaballo = new javax.swing.JLabel();
        lblNomCaballo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Jugador");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Información de la carrera");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 180, 300, 20);
        getContentPane().add(lblSaldo);
        lblSaldo.setBounds(150, 30, 160, 20);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Monto apostado:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 100, 120, 20);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Información del caballo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 350, 300, 20);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Saldo restante:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 30, 130, 20);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Hipódromo:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 210, 100, 20);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Información de la apuesta");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 70, 300, 20);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Nombre:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 410, 90, 20);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Monto ganado:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 130, 120, 20);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Fecha:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 300, 100, 20);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Número:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(10, 380, 90, 20);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Dividendo:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(10, 440, 90, 20);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Número:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(10, 240, 100, 20);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Nombre:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(10, 270, 100, 20);
        getContentPane().add(lblDividendo);
        lblDividendo.setBounds(110, 440, 200, 20);
        getContentPane().add(lblApostado);
        lblApostado.setBounds(140, 100, 170, 20);
        getContentPane().add(lblGanado);
        lblGanado.setBounds(140, 130, 170, 20);
        getContentPane().add(lblHipodromo);
        lblHipodromo.setBounds(120, 210, 190, 20);
        getContentPane().add(lblNroCarrera);
        lblNroCarrera.setBounds(120, 240, 190, 20);
        getContentPane().add(lblNomCarrera);
        lblNomCarrera.setBounds(120, 270, 190, 20);
        getContentPane().add(lblFecha);
        lblFecha.setBounds(120, 300, 190, 20);
        getContentPane().add(lblNroCaballo);
        lblNroCaballo.setBounds(110, 380, 200, 20);
        getContentPane().add(lblNomCaballo);
        lblNomCaballo.setBounds(110, 410, 200, 20);

        setBounds(0, 0, 339, 515);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblApostado;
    private javax.swing.JLabel lblDividendo;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblGanado;
    private javax.swing.JLabel lblHipodromo;
    private javax.swing.JLabel lblNomCaballo;
    private javax.swing.JLabel lblNomCarrera;
    private javax.swing.JLabel lblNroCaballo;
    private javax.swing.JLabel lblNroCarrera;
    private javax.swing.JLabel lblSaldo;
    // End of variables declaration//GEN-END:variables

    private void mostrarInfoDeApuesta() {
        this.lblSaldo.setText(String.valueOf(jugador.getSaldo()));

        this.lblApostado.setText(String.valueOf(apuesta.getMonto()));
        this.lblGanado.setText(String.valueOf(apuesta.getGanado()));

        this.lblHipodromo.setText(hipodromo.getNombre() + " (" + hipodromo.getDireccion() + ")");
        this.lblNroCarrera.setText(String.valueOf(apuesta.getCaballo().getCarrera().getNumero()));
        this.lblNomCarrera.setText(apuesta.getCaballo().getCarrera().getNombre());
        this.lblFecha.setText(apuesta.getCaballo().getCarrera().getFecha().toString());

        this.lblNroCaballo.setText(String.valueOf(apuesta.getCaballo().getNumero()));
        this.lblNomCaballo.setText(apuesta.getCaballo().getCaballo().getNombre());
        this.lblDividendo.setText(String.valueOf(apuesta.getCaballo().getDividendo()));
    }
}
