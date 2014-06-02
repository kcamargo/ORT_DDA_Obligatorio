package ui;

import bl.CaballoEnCarrera;
import bl.Carrera;
import bl.Fachada;
import bl.Hipodromo;
import bl.enums.CambiosCarrera;
import javax.swing.JOptionPane;
import util.Observable;
import util.Observador;

public class DlgAdministrarCarreras extends javax.swing.JDialog implements Observador {

    Hipodromo hipodromoSeleccionado;
    Carrera siguiente;
    Carrera abierta;
    Carrera cerrada;

    public DlgAdministrarCarreras(java.awt.Frame parent, boolean modal,
            Carrera siguiente, Carrera abierta, Carrera cerrada, Hipodromo hipodromo) {
        super(parent, modal);

        this.siguiente = siguiente;
        this.abierta = abierta;
        this.cerrada = cerrada;
        this.hipodromoSeleccionado = hipodromo;
        Fachada.getInstancia().agregarObservador(this);

        initComponents();
        this.setLocationRelativeTo(null);

        mostrarHipodromo();
        mostrarCarreras();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNombreSiguiente = new javax.swing.JLabel();
        lblNumeroSiguiente = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblNombreAbierta = new javax.swing.JLabel();
        lblNumeroAbierta = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblNombreCerrada = new javax.swing.JLabel();
        lblNumeroCerrada = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCaballosSiguiente = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstCaballosAbierta = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstCaballosCerrada = new javax.swing.JList();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        lblHipodromo = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnCerrar = new javax.swing.JButton();
        btnAsignar = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Carrera siguiente:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 430, 170, 20);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 470, 70, 20);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Numero:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 500, 70, 20);
        getContentPane().add(lblNombreSiguiente);
        lblNombreSiguiente.setBounds(100, 470, 90, 20);
        getContentPane().add(lblNumeroSiguiente);
        lblNumeroSiguiente.setBounds(100, 500, 90, 20);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Caballos participantes");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(195, 430, 180, 20);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Carrera abierta:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 70, 180, 20);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Nombre:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 110, 70, 20);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Numero:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 140, 70, 20);
        getContentPane().add(lblNombreAbierta);
        lblNombreAbierta.setBounds(100, 110, 90, 20);
        getContentPane().add(lblNumeroAbierta);
        lblNumeroAbierta.setBounds(100, 140, 90, 20);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Caballos participantes:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(189, 70, 180, 20);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Carrera cerrada:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(10, 250, 180, 20);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Nombre:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(20, 290, 70, 20);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Numero:");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(20, 320, 70, 20);
        getContentPane().add(lblNombreCerrada);
        lblNombreCerrada.setBounds(100, 290, 90, 20);
        getContentPane().add(lblNumeroCerrada);
        lblNumeroCerrada.setBounds(100, 320, 90, 20);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Caballos participantes:");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(189, 250, 180, 20);

        lstCaballosSiguiente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstCaballosSiguiente.setEnabled(false);
        jScrollPane1.setViewportView(lstCaballosSiguiente);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(200, 450, 170, 130);

        lstCaballosAbierta.setEnabled(false);
        jScrollPane2.setViewportView(lstCaballosAbierta);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(200, 90, 170, 130);

        jScrollPane3.setViewportView(lstCaballosCerrada);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(200, 270, 170, 130);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(10, 50, 370, 10);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Hipódromo:");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(20, 20, 80, 20);

        lblHipodromo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(lblHipodromo);
        lblHipodromo.setBounds(110, 20, 270, 20);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(10, 410, 370, 10);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar);
        btnCerrar.setBounds(60, 180, 90, 23);

        btnAsignar.setText("Asignar Ganador");
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAsignar);
        btnAsignar.setBounds(30, 370, 140, 23);

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        getContentPane().add(btnAbrir);
        btnAbrir.setBounds(50, 540, 100, 23);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(10, 230, 370, 10);

        setBounds(0, 0, 405, 629);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        if (siguiente != null) {
            if (hipodromoSeleccionado.abrirCarrera(siguiente)) {
                abierta = hipodromoSeleccionado.getCarreraAbierta();
                siguiente = hipodromoSeleccionado.getSiguienteCarrera();
                mostrarCarreras();
                messageBox("Carrera abierta");
            } else {
                messageBox("No se pudo abrir la carrera");
            }
        } else {
            messageBox("No hay carrera para abrir");
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        if (abierta != null) {
            if (hipodromoSeleccionado.cerrarCarrera(abierta)) {
                cerrada = hipodromoSeleccionado.getCarreraCerrada();
                abierta = hipodromoSeleccionado.getCarreraAbierta();
                mostrarCarreras();
                messageBox("Carrera cerrada");
            } else {
                messageBox("No se pudo cerrar la carrera");
            }
        } else {
            messageBox("No hay carrera para cerrar");
        }
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed
        if (cerrada != null) {
            if (lstCaballosCerrada.getSelectedValue() != null) {
                CaballoEnCarrera caballo = (CaballoEnCarrera) lstCaballosCerrada.getSelectedValue();
                if (hipodromoSeleccionado.asignarGanador(cerrada, caballo)) {
                    cerrada = hipodromoSeleccionado.getCarreraCerrada();
                    siguiente = hipodromoSeleccionado.getSiguienteCarrera();
                    mostrarCarreras();
                    messageBox("Ganador asignado");
                }
            } else {
                messageBox("Debe seleccionar un caballo de la lista");
            }
        } else {
            messageBox("No hay una carrera cerrada");
        }
    }//GEN-LAST:event_btnAsignarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblHipodromo;
    private javax.swing.JLabel lblNombreAbierta;
    private javax.swing.JLabel lblNombreCerrada;
    private javax.swing.JLabel lblNombreSiguiente;
    private javax.swing.JLabel lblNumeroAbierta;
    private javax.swing.JLabel lblNumeroCerrada;
    private javax.swing.JLabel lblNumeroSiguiente;
    private javax.swing.JList lstCaballosAbierta;
    private javax.swing.JList lstCaballosCerrada;
    private javax.swing.JList lstCaballosSiguiente;
    // End of variables declaration//GEN-END:variables

    private void mostrarCarreras() {
        limpiarInfoCarreras();

        if (abierta != null) {
            this.lblNombreAbierta.setText(abierta.getNombre());
            this.lblNumeroAbierta.setText(String.valueOf(abierta.getNumero()));
            this.lstCaballosAbierta.setListData(abierta.getCaballos().toArray());
        }

        if (cerrada != null) {
            this.lblNombreCerrada.setText(cerrada.getNombre());
            this.lblNumeroCerrada.setText(String.valueOf(cerrada.getNumero()));
            this.lstCaballosCerrada.setListData(cerrada.getCaballos().toArray());
        }

        if (siguiente != null) {
            this.lblNombreSiguiente.setText(siguiente.getNombre());
            this.lblNumeroSiguiente.setText(String.valueOf(siguiente.getNumero()));
            this.lstCaballosSiguiente.setListData(siguiente.getCaballos().toArray());
        }
    }

    private void mostrarHipodromo() {
        this.lblHipodromo.setText(hipodromoSeleccionado.getNombre());
    }

    private void messageBox(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void limpiarInfoCarreras() {
        this.lblNombreAbierta.setText("");
        this.lblNumeroAbierta.setText("");
        this.lstCaballosAbierta.setListData(new Object[0]);

        this.lblNombreCerrada.setText("");
        this.lblNumeroCerrada.setText("");
        this.lstCaballosCerrada.setListData(new Object[0]);

        this.lblNombreSiguiente.setText("");
        this.lblNumeroSiguiente.setText("");
        this.lstCaballosSiguiente.setListData(new Object[0]);
    }

    @Override
    public void actualizar(Observable origen, Object param) {
        if (param.equals(CambiosCarrera.CarreraAbierta)) {
            siguiente = hipodromoSeleccionado.getSiguienteCarrera();
            abierta = hipodromoSeleccionado.getCarreraAbierta();
        }
        
        if (param.equals(CambiosCarrera.CarreraCerrada)) {
            abierta = null;
            cerrada = hipodromoSeleccionado.getCarreraCerrada();
        }
        
        if (param.equals(CambiosCarrera.CarreraFinalizada)) {
            cerrada = null;
        }
        mostrarCarreras();
    }
}