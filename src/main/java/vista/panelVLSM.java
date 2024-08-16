
package vista;

import java.net.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import controlador.funcionesFLSM;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import modelo.Validadores;
import modelo.paramVLSM;

/**
 *
 * @author Nelson
 */
public class panelVLSM extends javax.swing.JPanel {

    funcionesFLSM flsm = new funcionesFLSM();
    AutoCompletarManager autoComp = new AutoCompletarManager();
    Validadores valid = new Validadores();
    
    public panelVLSM() {
        initComponents();
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

        panelVLSM = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDirIp = new javax.swing.JTextField();
        txtPrefijoRed = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNumSubredes = new javax.swing.JTextField();
        btnResult = new javax.swing.JButton();
        btnEjecutar3 = new javax.swing.JButton();
        jscrIngresarDatos = new javax.swing.JScrollPane();

        panelVLSM.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Calculadora VLSM");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panelVLSM.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 170, 20));

        jLabel2.setText("Dirección IP");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panelVLSM.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 70, 20));

        txtDirIp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDirIpKeyReleased(evt);
            }
        });
        panelVLSM.add(txtDirIp, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 130, -1));

        txtPrefijoRed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrefijoRedKeyReleased(evt);
            }
        });
        panelVLSM.add(txtPrefijoRed, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 70, -1));

        jLabel3.setText("Prefijo de Red");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panelVLSM.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 90, 20));

        jLabel4.setText("Numero de Subredes");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panelVLSM.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, 20));

        txtNumSubredes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumSubredesKeyReleased(evt);
            }
        });
        panelVLSM.add(txtNumSubredes, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 120, -1));

        btnResult.setText("Ir a Resultados");
        btnResult.setEnabled(false);
        btnResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResultActionPerformed(evt);
            }
        });
        panelVLSM.add(btnResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, 120, -1));

        btnEjecutar3.setText("Limpiar");
        btnEjecutar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutar3ActionPerformed(evt);
            }
        });
        panelVLSM.add(btnEjecutar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 120, -1));

        jscrIngresarDatos.setBorder(null);
        panelVLSM.add(jscrIngresarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 460, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVLSM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVLSM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btnResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResultActionPerformed
        
        paramVLSM prm =  new paramVLSM();
        prm.setDireccionIP(txtDirIp.getText());
        prm.setPrefijo(Integer.parseInt(txtPrefijoRed.getText()));
        prm.setnSubred(Integer.parseInt(txtNumSubredes.getText()));
        prm.setVarioshost(extraerDatos());
        
        panelVLSMout vlsmout = null;
        try {
            vlsmout = new panelVLSMout(prm);
        } catch (UnknownHostException ex) {
            Logger.getLogger(panelVLSM.class.getName()).log(Level.SEVERE, null, ex);
        }
        MostrarPanel(vlsmout);
    }//GEN-LAST:event_btnResultActionPerformed

    private void txtDirIpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirIpKeyReleased
        if (valid.validacionIP(txtDirIp.getText())) {
            int prefijo = autoComp.calcPrefijo(txtDirIp.getText());
            txtPrefijoRed.setText(String.valueOf(prefijo));
        } else {
            txtPrefijoRed.setText("");
            txtNumSubredes.setText("");
            ActualizarIngresoDatos(0);
        }
    }//GEN-LAST:event_txtDirIpKeyReleased
    
    
    int HostSubred;
    private void txtNumSubredesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumSubredesKeyReleased
        String numSubredes = txtNumSubredes.getText();
        if (numSubredes != null && !numSubredes.isEmpty() && numSubredes.matches("-?\\d+")) {
            System.out.println("SIII es numero");
            if (Integer.parseInt(numSubredes)<=0) {
                System.out.println("Es menor que 0!!"); 
            } else {
                ActualizarIngresoDatos(Integer.parseInt(numSubredes));
                btnResult.setEnabled(true);
            }
            
        } else {
            System.out.println("NO es numero");
        }
        
        
        try {
            int nsubredes = Integer.parseInt(txtNumSubredes.getText());
            int prefijo = Integer.parseInt(txtPrefijoRed.getText());

            if (nsubredes <= 0) {
                //System.out.println("Número negativo o cero: " + nsubredes);
                HostSubred = 0;
            } else {
                //System.out.println("Número válido: " + nsubredes);
                int calcHost = autoComp.calcHost(nsubredes, prefijo);
                HostSubred = calcHost;
            }
        } catch (NumberFormatException e) {
            //System.out.println("No es un número válido");
            HostSubred = 0;
        } 
    }//GEN-LAST:event_txtNumSubredesKeyReleased

    private void btnEjecutar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutar3ActionPerformed
        txtDirIp.setText("");
        txtNumSubredes.setText("");
        txtPrefijoRed.setText("");
    }//GEN-LAST:event_btnEjecutar3ActionPerformed

    private void txtPrefijoRedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrefijoRedKeyReleased
        try {
            int prefijo = Integer.parseInt(txtPrefijoRed.getText());

            if (prefijo > 0 && prefijo<=32) {
            } else {
                txtNumSubredes.setText("");
            }
        } catch (NumberFormatException e) {
            //System.out.println("No es un número válido");
            txtNumSubredes.setText("");
        }
    }//GEN-LAST:event_txtPrefijoRedKeyReleased
    
    private ArrayList<JTextField> textFieldList = new ArrayList<>();

    public void ActualizarIngresoDatos(int numeroSubredes){
        // Obtén el panel contenido dentro del JScrollPane
        textFieldList.clear();
        JPanel panelIngresarDatos = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.NORTHWEST; // Ancla en la parte superior izquierda
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL; // Ocupa toda la anchura de la celda

        for (int i = 1; i <= numeroSubredes; i++) {
            JLabel label = new JLabel("Subred n°" + i);
            JTextField textField = new JTextField(10); // Puedes ajustar el ancho del JTextField aquí

            gbc.gridx = 0;
            gbc.gridy = i - 1;
            panelIngresarDatos.add(label, gbc);

            gbc.gridx = 1;
            panelIngresarDatos.add(textField, gbc);

            textFieldList.add(textField);
        }

        jscrIngresarDatos.setViewportView(panelIngresarDatos);

        panelIngresarDatos.revalidate();
        panelIngresarDatos.repaint();
    }
    
    public ArrayList<String> extraerDatos(){
        ArrayList<String> datosIngresados = new ArrayList<>();
        datosIngresados.clear();
        
        for (JTextField textField : textFieldList) {
            datosIngresados.add(textField.getText());
        }
        return datosIngresados;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEjecutar3;
    private javax.swing.JButton btnResult;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jscrIngresarDatos;
    private javax.swing.JPanel panelVLSM;
    private javax.swing.JTextField txtDirIp;
    private javax.swing.JTextField txtNumSubredes;
    private javax.swing.JTextField txtPrefijoRed;
    // End of variables declaration//GEN-END:variables
}
