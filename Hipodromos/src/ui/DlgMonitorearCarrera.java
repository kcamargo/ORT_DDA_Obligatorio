package ui;

import bl.Apuesta;
import bl.CaballoEnCarrera;
import bl.Carrera;
import bl.Fachada;
import bl.enums.CambiosCarrera;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import util.Fecha;
import util.Observable;
import util.Observador;

public class DlgMonitorearCarrera extends javax.swing.JDialog implements Observador {

    Date fecha;
    Fachada fac = Fachada.getInstancia();
    Carrera carreraSeleccionada;
    ArrayList<Carrera> carreras;
    ArrayList<Apuesta> ganadores;

    public DlgMonitorearCarrera(java.awt.Frame parent, boolean modal, Date fecha) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);

        fac.agregarObservador(this);

        this.fecha = fecha;
        carreras = fac.getHipodromoActual().getCarreras(Fecha.crearFecha(25, 4, 2014));
        carreraSeleccionada = null;

        mostrarCarreras();
    }

    private void mostrarCarreras() {
        ArrayList<String> listado = new ArrayList();
        if (carreras != null) {
            for (Carrera c : carreras) {
                listado.add(c.getNumero() + " - " + c.getNombre() + " - " + c.getEstadoString());
            }
            int i = lstCarreras.getSelectedIndex();
            lstCarreras.setListData(listado.toArray());
            lstCarreras.setSelectedIndex(i);
        } else {
            JOptionPane.showMessageDialog(this, "No hay carreras para la fecha.");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstCarreras = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblDatosCarrera = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstCaballos = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstGanadores = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        lstCarreras.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCarrerasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstCarreras);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 100, 220, 160);

        jLabel1.setText("Seleccionar Carreras :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 70, 160, 14);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setText("Monitorear Carreras");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 20, 240, 30);

        lblDatosCarrera.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(lblDatosCarrera);
        lblDatosCarrera.setBounds(240, 100, 240, 160);

        jScrollPane2.setViewportView(lstCaballos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 310, 210, 170);

        jScrollPane3.setViewportView(lstGanadores);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(270, 310, 210, 170);

        jLabel3.setText("Caballos");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 280, 60, 20);

        jLabel4.setText("Ganadores :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(270, 280, 90, 20);

        setBounds(0, 0, 516, 532);
    }// </editor-fold>//GEN-END:initComponents

    private void lstCarrerasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCarrerasValueChanged
        if (lstCarreras.getSelectedIndex() != -1) {
            carreraSeleccionada = carreras.get(lstCarreras.getSelectedIndex());
            mostrarCarrera();
        }
    }//GEN-LAST:event_lstCarrerasValueChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDatosCarrera;
    private javax.swing.JList lstCaballos;
    private javax.swing.JList lstCarreras;
    private javax.swing.JList lstGanadores;
    // End of variables declaration//GEN-END:variables

    private ArrayList<String> formaterarListaGanadores(ArrayList<Apuesta> ganadores) {
        ArrayList<String> listado = new ArrayList();
        for (Apuesta a : ganadores) {
            listado.add(a.getJugador().getUsername() + " - Apostado(" + a.getMonto() + ") - " + "Ganado: (" + a.getGanado() + ")");
        }
        return listado;
    }

    @Override
    public void actualizar(Observable origen, Object param) {
        if (param.equals(CambiosCarrera.CambioEstado)) {
            mostrarCarreras();
            mostrarCarrera();
        }
    }

    private void mostrarCarrera() {
        if (carreraSeleccionada != null) {
            lblDatosCarrera.setText("<html> Numero: " + carreraSeleccionada.getNumero() + "<br>"
                    + "Nombre: " + carreraSeleccionada.getNombre() + "<br>"
                    + "Estado: " + carreraSeleccionada.getEstadoString() + "<br>"
                    + "Cantidad de Caballos: " + carreraSeleccionada.getCaballos().size() + "</html>");

            lstCaballos.setListData(carreraSeleccionada.getCaballos().toArray());

            for (CaballoEnCarrera cab : carreraSeleccionada.getCaballos()) {
                if (cab.isGanador()) {
                    ganadores = cab.getApuestas();
                }
            }
            if (ganadores != null) {
                lstGanadores.setListData(formaterarListaGanadores(ganadores).toArray());
            }
        }
    }
}
