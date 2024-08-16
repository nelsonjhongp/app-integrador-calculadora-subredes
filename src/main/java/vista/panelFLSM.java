/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import controlador.ExportarExcel;
import java.net.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import controlador.funcionesFLSM;
import java.io.IOException;
import modelo.*;

/**
 *
 * @author Nelson
 */
public class panelFLSM extends javax.swing.JPanel {

    funcionesFLSM flsm = new funcionesFLSM();
    AutoCompletarManager autoComp = new AutoCompletarManager();
    Validadores valid = new Validadores();
    
    public panelFLSM() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDirIp = new javax.swing.JTextField();
        txtPrefijoRed = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNumSubredes = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtHostSubred = new javax.swing.JTextField();
        btnEjecutar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaFLSM = new javax.swing.JTable();
        btnEjecutar2 = new javax.swing.JButton();
        btnEjecutar3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Calculadora FLSM");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 120, 20));

        jLabel2.setText("Dirección IP");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 20));

        txtDirIp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDirIpKeyReleased(evt);
            }
        });
        jPanel1.add(txtDirIp, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 180, -1));

        txtPrefijoRed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrefijoRedKeyReleased(evt);
            }
        });
        jPanel1.add(txtPrefijoRed, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 160, -1));

        jLabel3.setText("Prefijo de Red");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 90, 20));

        jLabel4.setText("Numero de Subredes");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 20));

        txtNumSubredes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumSubredesKeyReleased(evt);
            }
        });
        jPanel1.add(txtNumSubredes, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 140, -1));

        jLabel5.setText("Host por Subred");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 100, 20));
        jPanel1.add(txtHostSubred, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 140, -1));

        btnEjecutar.setText("Exportar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEjecutar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 390, 120, -1));

        TablaFLSM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Subred", "N° Host", "IP de Red", "Mascara", "Primer Host", "Ultimo Host", "Broadcast"
            }
        ));
        jScrollPane1.setViewportView(TablaFLSM);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 760, 290));

        btnEjecutar2.setText("Ejecutar");
        btnEjecutar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutar2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnEjecutar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 120, -1));

        btnEjecutar3.setText("Limpiar");
        btnEjecutar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutar3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnEjecutar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, 120, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Historial", "Historial 1", "Historial 2", "Historial 3", "Historial 4", "Historial 5" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 140, -1));

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

    public void actualizarTabla(List<tablaFLSM> tblFLSM){
        DefaultTableModel dt=(DefaultTableModel)TablaFLSM.getModel();
        dt.setRowCount(0);
        for (tablaFLSM data:tblFLSM) {
            Object v[]={
                data.getNombreSubred(),
                data.getNhosts(),
                data.getIPred().getHostAddress(),
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
            obj.exportarExcel(TablaFLSM);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void txtDirIpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirIpKeyReleased
        if (valid.validacionIP(txtDirIp.getText())) {
            int prefijo = autoComp.calcPrefijo(txtDirIp.getText());
            txtPrefijoRed.setText(String.valueOf(prefijo));
        } else {
            txtPrefijoRed.setText("");
        }
    }//GEN-LAST:event_txtDirIpKeyReleased

    private void txtNumSubredesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumSubredesKeyReleased
        try {
            int nsubredes = Integer.parseInt(txtNumSubredes.getText());
            int prefijo = Integer.parseInt(txtPrefijoRed.getText());

            if (nsubredes <= 0) {
                //System.out.println("Número negativo o cero: " + nsubredes);
                txtHostSubred.setText("");
            } else {
                //System.out.println("Número válido: " + nsubredes);
                int calcHost = autoComp.calcHost(nsubredes, prefijo);
                txtHostSubred.setText(String.valueOf(calcHost));
            }
        } catch (NumberFormatException e) {
            //System.out.println("No es un número válido");
            txtHostSubred.setText("");
        } 
    }//GEN-LAST:event_txtNumSubredesKeyReleased

    private void btnEjecutar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutar2ActionPerformed
        try {
            InetAddress dirIP = InetAddress.getByName(txtDirIp.getText());
            int nsubredes = Integer.parseInt(txtNumSubredes.getText());
            int prefijo = Integer.parseInt(txtPrefijoRed.getText());
            int nhost = Integer.parseInt(txtHostSubred.getText());
            
            actualizarTabla(flsm.calcularFLSM(dirIP, nsubredes, prefijo, nhost));
        } catch (UnknownHostException e) {
            System.err.println("No se pudo resolver la dirección IP.");
        }
    }//GEN-LAST:event_btnEjecutar2ActionPerformed

    private void btnEjecutar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutar3ActionPerformed
        txtDirIp.setText("");
        txtHostSubred.setText("");
        txtNumSubredes.setText("");
        txtPrefijoRed.setText("");
    }//GEN-LAST:event_btnEjecutar3ActionPerformed

    private void txtPrefijoRedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrefijoRedKeyReleased
        try {
            int prefijo = Integer.parseInt(txtPrefijoRed.getText());

            if (prefijo > 0 && prefijo<=32) {
            } else {
                txtNumSubredes.setText("");
                txtHostSubred.setText("");
            }
        } catch (NumberFormatException e) {
            //System.out.println("No es un número válido");
            txtNumSubredes.setText("");
            txtHostSubred.setText("");
        }
    }//GEN-LAST:event_txtPrefijoRedKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaFLSM;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnEjecutar2;
    private javax.swing.JButton btnEjecutar3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDirIp;
    private javax.swing.JTextField txtHostSubred;
    private javax.swing.JTextField txtNumSubredes;
    private javax.swing.JTextField txtPrefijoRed;
    // End of variables declaration//GEN-END:variables
}
