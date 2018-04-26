/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labodeguita;

import java.awt.event.KeyEvent;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

/**
 *
 * @author Braian Canjay
 */
public class calculo extends javax.swing.JFrame {

    /**
     * Creates new form calculo
     */
    public calculo() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        InputMap map = new InputMap();

        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "pressed");
        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), "released");

        ok.setInputMap(0, map);
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
        jLabel4 = new javax.swing.JLabel();
        cam = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        recibo = new javax.swing.JTextField();
        cambio = new javax.swing.JTextField();
        pagar = new javax.swing.JTextField();
        ok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        jLabel4.setText("Recibo    $");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 120, 30));

        cam.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        cam.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        cam.setText("Cambio");
        jPanel1.add(cam, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 130, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        jLabel2.setText("Total a pagar   $");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 200, 30));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        jLabel3.setText(" $");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 30, 30));

        recibo.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        recibo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        recibo.setText("0");
        recibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reciboActionPerformed(evt);
            }
        });
        recibo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                reciboKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                reciboKeyReleased(evt);
            }
        });
        jPanel1.add(recibo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 160, -1));

        cambio.setEditable(false);
        cambio.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        cambio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cambio.setText("0");
        jPanel1.add(cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 160, -1));

        pagar.setEditable(false);
        pagar.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        pagar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pagar.setText("0");
        jPanel1.add(pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 160, -1));

        ok.setBackground(new java.awt.Color(51, 255, 51));
        ok.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        ok.setText("OK");
        ok.setBorder(null);
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        jPanel1.add(ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 110, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reciboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reciboKeyPressed
        
    }//GEN-LAST:event_reciboKeyPressed

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        this.dispose();
        VentaDeProductos obj=new VentaDeProductos();
        obj.limpiar();
        obj.verTotal();
    }//GEN-LAST:event_okActionPerformed

    private void reciboKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reciboKeyReleased
        // TODO add your handling code here:
        double pag,rec,R;
        pag = Double.parseDouble(pagar.getText());
        rec = Double.parseDouble(recibo.getText());
        
        R=rec-pag;
        if (R<0) cam.setText("Faltan");
        
        if (R>0) cam.setText("Cambio");
        
        cambio.setText(""+R);
    }//GEN-LAST:event_reciboKeyReleased

    private void reciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reciboActionPerformed
        // TODO add your handling code here:
        cambio.transferFocus();
    }//GEN-LAST:event_reciboActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(calculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(calculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(calculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(calculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new calculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cam;
    private javax.swing.JTextField cambio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton ok;
    public static javax.swing.JTextField pagar;
    public static javax.swing.JTextField recibo;
    // End of variables declaration//GEN-END:variables
}
