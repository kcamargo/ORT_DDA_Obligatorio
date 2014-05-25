package ui;

import bl.Apuesta;
import bl.CaballoEnCarrera;
import bl.Carrera;
import bl.Fachada;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import util.Fecha;

public class DlgMonitorearCarrera extends javax.swing.JDialog {

    Date fecha;
    Fachada fac = Fachada.getInstancia();
    ArrayList<Carrera> carreras;
    ArrayList<Apuesta> ganadores;
    public DlgMonitorearCarrera(java.awt.Frame parent, boolean modal, Date fecha) {
        super(parent, modal);
        initComponents();
        this.fecha = fecha;
        carreras = fac.getHipodromoActual().getCarreras(Fecha.crearFecha(25, 4, 2014));
        mostrarCarreras();
        this.setLocationRelativeTo(null);
        
    }
    public void mostrarCarreras(){
    
        ArrayList<String> listado = new ArrayList();
        if(carreras != null){
            for(Carrera c: carreras){
                listado.add(c.getNumero() + " - " + c.getNombre() + " - " + c.getEstadoString());
            }
            lstCarreras.setListData(listado.toArray());
        }else {
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
        getContentPane().setLayout(null);

        lstCarreras.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCarrerasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstCarreras);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 100, 320, 80);

        jLabel1.setText("Seleccionar Carreras :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 70, 160, 14);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setText("Monitorear Carreras");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(190, 20, 240, 30);
        getContentPane().add(lblDatosCarrera);
        lblDatosCarrera.setBounds(10, 190, 320, 90);

        jScrollPane2.setViewportView(lstCaballos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 310, 240, 60);

        jScrollPane3.setViewportView(lstGanadores);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(20, 400, 240, 60);

        jLabel3.setText("Caballos");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 290, 60, 14);

        jLabel4.setText("Ganadores :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 380, 90, 14);

        setBounds(0, 0, 584, 503);
    }// </editor-fold>//GEN-END:initComponents

    private void lstCarrerasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCarrerasValueChanged
        // TODO add your handling code here:
        int numero = lstCarreras.getSelectedIndex();
        Carrera c = carreras.get(numero);
        lblDatosCarrera.setText("<html> Numero :" + c.getNumero() + "<br>"+
                "Nombre :" + c.getNombre() + "<br>"+
                "Estado :" + c.getEstadoString() + "<br>"+                
                "Cantidad de Caballos : "+ c.getCaballos().size() + "</html>"  );
        
        lstCaballos.setListData(c.getCaballos().toArray());
        
        for(CaballoEnCarrera cab : c.getCaballos()){
            if(cab.isGanador()){
                ganadores = cab.getApuestas();
            }
        }
        if(ganadores != null){
            lstGanadores.setListData(formaterarLista(ganadores).toArray());
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

    private ArrayList<String> formaterarLista(ArrayList<Apuesta> ganadores) {
        ArrayList<String> listado = new ArrayList();
            for(Apuesta a : ganadores){
                listado.add("Username : " + a.getJugador().getUsername() + "Monto apostad: " + a.getMonto() + "Monto Ganado : " + a.getGanado() );
            }
        return listado;
    }
}
