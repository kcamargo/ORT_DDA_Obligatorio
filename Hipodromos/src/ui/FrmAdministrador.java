package ui;

import bl.Administrador;
import bl.Carrera;
import bl.Fachada;
import javax.swing.JOptionPane;

public class FrmAdministrador extends javax.swing.JFrame {

    Fachada fachada = Fachada.getInstancia();

    public FrmAdministrador(Administrador a) {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarMenu();
        if (a != null) {
            lblAdmin.setText(a.getUsername());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        lblBienvenida = new javax.swing.JLabel();
        lblMensajeCrear = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblAdmin = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuHipodromos = new javax.swing.JMenu();
        itemSeleccionar = new javax.swing.JMenuItem();
        itemCrearHipodromo = new javax.swing.JMenuItem();
        menuCarreras = new javax.swing.JMenu();
        crearCarrera = new javax.swing.JMenuItem();
        monitorearCarreras = new javax.swing.JMenuItem();
        administrarCarreras = new javax.swing.JMenuItem();
        menuEmular = new javax.swing.JMenu();
        itenAbrirTerminal = new javax.swing.JMenuItem();
        menuFinalizar = new javax.swing.JMenu();
        salir = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(lblBienvenida);
        lblBienvenida.setBounds(72, 11, 0, 0);
        getContentPane().add(lblMensajeCrear);
        lblMensajeCrear.setBounds(176, 439, 0, 0);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("Bienvenido :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 80, 150, 40);

        lblAdmin.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblAdmin.setText("jLabel2");
        getContentPane().add(lblAdmin);
        lblAdmin.setBounds(270, 80, 100, 40);

        jMenuBar1.setToolTipText("");

        menuHipodromos.setText("Hipodromos");

        itemSeleccionar.setText("Seleccionar");
        itemSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSeleccionarActionPerformed(evt);
            }
        });
        menuHipodromos.add(itemSeleccionar);

        itemCrearHipodromo.setText("Crear");
        itemCrearHipodromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCrearHipodromoActionPerformed(evt);
            }
        });
        menuHipodromos.add(itemCrearHipodromo);

        jMenuBar1.add(menuHipodromos);

        menuCarreras.setText("Carreras");

        crearCarrera.setText("Crear Carrera");
        crearCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearCarreraActionPerformed(evt);
            }
        });
        menuCarreras.add(crearCarrera);

        monitorearCarreras.setText("Monitorear");
        monitorearCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monitorearCarrerasActionPerformed(evt);
            }
        });
        menuCarreras.add(monitorearCarreras);

        administrarCarreras.setText("Administrar");
        administrarCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrarCarrerasActionPerformed(evt);
            }
        });
        menuCarreras.add(administrarCarreras);

        jMenuBar1.add(menuCarreras);

        menuEmular.setText("Emular Terminal de Apuestas");

        itenAbrirTerminal.setText("Abrir");
        itenAbrirTerminal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itenAbrirTerminalActionPerformed(evt);
            }
        });
        menuEmular.add(itenAbrirTerminal);

        jMenuBar1.add(menuEmular);

        menuFinalizar.setText("Finalizar");

        salir.setText("Salir de la aplicacion");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        menuFinalizar.add(salir);

        jMenuBar1.add(menuFinalizar);

        setJMenuBar(jMenuBar1);

        setBounds(0, 0, 525, 264);
    }// </editor-fold>//GEN-END:initComponents

    private void itemSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSeleccionarActionPerformed
        new DlgSeleccionarHipodromo(this, true).setVisible(true);
    }//GEN-LAST:event_itemSeleccionarActionPerformed

    private void itemCrearHipodromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCrearHipodromoActionPerformed
        new DlgCrearHipodromo(this, true).setVisible(true);
    }//GEN-LAST:event_itemCrearHipodromoActionPerformed

    private void crearCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearCarreraActionPerformed
        new DlgCrearCarrera(this, true).setVisible(true);
    }//GEN-LAST:event_crearCarreraActionPerformed

    private void administrarCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrarCarrerasActionPerformed
        Carrera abierta = fachada.getHipodromoActual().getCarreraAbierta();
        Carrera cerrada = fachada.getHipodromoActual().getCarreraCerrada();
        Carrera siguiente = fachada.getHipodromoActual().getSiguienteCarrera();

        new DlgAdministrarCarreras(this, true, siguiente, abierta, cerrada, fachada.getHipodromoActual()).setVisible(true);
    }//GEN-LAST:event_administrarCarrerasActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void itenAbrirTerminalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itenAbrirTerminalActionPerformed
        new FrmJugador().setVisible(true);
    }//GEN-LAST:event_itenAbrirTerminalActionPerformed

    private void monitorearCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monitorearCarrerasActionPerformed
        PanelFecha panelFecha = new PanelFecha();
        try {
            int resultado = JOptionPane.showConfirmDialog(this, panelFecha, "Monitorear carreras", JOptionPane.OK_CANCEL_OPTION);
            if (resultado == JOptionPane.OK_OPTION) {
                new DlgMonitorearCarrera(this, false, panelFecha.getFecha()).setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Fecha inválida!");
        }
    }//GEN-LAST:event_monitorearCarrerasActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem administrarCarreras;
    private javax.swing.JMenuItem crearCarrera;
    private javax.swing.JMenuItem itemCrearHipodromo;
    private javax.swing.JMenuItem itemSeleccionar;
    private javax.swing.JMenuItem itenAbrirTerminal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblMensajeCrear;
    private javax.swing.JMenu menuCarreras;
    private javax.swing.JMenu menuEmular;
    private javax.swing.JMenu menuFinalizar;
    private javax.swing.JMenu menuHipodromos;
    private javax.swing.JMenuItem monitorearCarreras;
    private javax.swing.JMenuItem salir;
    // End of variables declaration//GEN-END:variables

    private void cargarMenu() {
    }
}
