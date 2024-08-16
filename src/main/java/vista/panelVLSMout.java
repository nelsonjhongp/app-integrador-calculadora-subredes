/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import controlador.ExportarExcel;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import controlador.funcionesFLSM;
import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JPanel;
import modelo.*;

/**
 *
 * @author Nelson
 */
public class panelVLSMout extends javax.swing.JPanel {

    funcionesFLSM flsm = new funcionesFLSM();
    
    
    public panelVLSMout(paramVLSM prm) throws UnknownHostException {
        initComponents();
        InetAddress dirIP = InetAddress.getByName(prm.getDireccionIP());
        int prefijo = prm.getPrefijo();
        int nSubred = prm.getnSubred();
        ArrayList<String> varioshost = prm.getVarioshost();
        List<tablaVLSM> result = flsm.calcularVLSM(dirIP, nSubred, prefijo, varioshost);
        actualizarTabla(result);
    }

    public void MostrarPanel(JPanel panel){
        panel.setSize(800,430);
        panel.setLocation(0,0);
        this.removeAll();
        this.add(panel, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnEjecutar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaVLSM = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEjecutar.setText("Exportar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEjecutar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 390, 120, -1));

        TablaVLSM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Subred", "N° Host", "IP de Red", "Pref", "Mascara", "Primer Host", "Ultimo Host", "Broadcast"
            }
        ));
        jScrollPane1.setViewportView(TablaVLSM);
        if (TablaVLSM.getColumnModel().getColumnCount() > 0) {
            TablaVLSM.getColumnModel().getColumn(0).setPreferredWidth(40);
            TablaVLSM.getColumnModel().getColumn(1).setPreferredWidth(40);
            TablaVLSM.getColumnModel().getColumn(3).setPreferredWidth(5);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 760, 360));

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 120, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void actualizarTabla(List<tablaVLSM> tblVLSM){
        DefaultTableModel dt=(DefaultTableModel)TablaVLSM.getModel();
        dt.setRowCount(0);
        for (tablaVLSM data:tblVLSM) {
            Object v[]={
                data.getNombreSubred(),
                data.getNhosts(),
                data.getIPred().getHostAddress(),
                "/"+data.getPrefijo(),
                data.getMascara(),
                data.getPrimerHost().getHostAddress(),
                data.getUltimoHost().getHostAddress(),
                data.getBroadcast().getHostAddress()
            };
            dt.addRow(v);
        }
    }
    
    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        ExportarExcel obj;

        try {
            obj = new ExportarExcel();
            obj.exportarExcel(TablaVLSM);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        panelVLSM vlsm = new panelVLSM();
        MostrarPanel(vlsm);
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaVLSM;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
