/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labodeguita;

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
        cam = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        recibo = new javax.swing.JTextField();
        cambio = new javax.swing.JTextField();
        pagar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(null);

        cam.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        cam.setText("Cambio");
        jPanel1.add(cam);
        cam.setBounds(90, 150, 80, 23);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setText("Total a pagar");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(70, 50, 117, 23);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setText("Recibo");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(120, 100, 62, 23);

        recibo.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        recibo.setText("0");
        recibo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                reciboKeyPressed(evt);
            }
        });
        jPanel1.add(recibo);
        recibo.setBounds(200, 100, 120, 29);

        cambio.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        cambio.setText("0");
        jPanel1.add(cambio);
        cambio.setBounds(200, 150, 120, 29);

        pagar.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        pagar.setText("0");
        jPanel1.add(pagar);
        pagar.setBounds(200, 50, 120, 29);

        jButton1.setBackground(new java.awt.Color(51, 255, 51));
        jButton1.setText("OK");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 255, 153), 3, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(170, 210, 80, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 420, 260);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reciboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reciboKeyPressed
        double pag,rec,R;
        pag = Double.parseDouble(pagar.getText());
        rec = Double.parseDouble(recibo.getText());
        
        R=rec-pag;
        if (R<0) cam.setText("Faltan");
        
        if (R>0) cam.setText("Cambio");
        
        cambio.setText(""+R);
    }//GEN-LAST:event_reciboKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField pagar;
    private javax.swing.JTextField recibo;
    // End of variables declaration//GEN-END:variables
}
