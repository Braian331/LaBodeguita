package labodeguita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sasuk
 */
public class ReabastecimientoDeStock extends javax.swing.JFrame {

    /**
     * Creates new form ReabastecimientoDeStock
     */
    public ReabastecimientoDeStock() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        actual = new javax.swing.JTextField();
        listbusqueda = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdatos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        agregar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        actual1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reabastecimiento de stock");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(110, 10, 300, 40);

        jButton4.setText("...");
        jButton4.setToolTipText("regresar pestaña anterior");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jButton4);
        jButton4.setBounds(20, 10, 40, 30);

        actual.setText(" ");
        actual.setToolTipText("Stock actual");
        jPanel2.add(actual);
        actual.setBounds(630, 10, 230, 30);

        listbusqueda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        listbusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "eliga tipo de busqueda...", "Nombre", "Codigo", "Descripcion", "Fecha", "Proveedor" }));
        listbusqueda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(listbusqueda);
        listbusqueda.setBounds(466, 10, 160, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 10, 880, 60);

        tbdatos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbdatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbdatos);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(222, 90, 640, 220);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("stock a reabastecer ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 150, 210, 17);

        agregar.setText(" ");
        agregar.setToolTipText("cantidad que desea agregar a su stock");
        jPanel1.add(agregar);
        agregar.setBounds(10, 170, 130, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Stock total");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 210, 90, 17);

        total.setText(" ");
        total.setToolTipText("stock actual y el solicitado");
        jPanel1.add(total);
        total.setBounds(10, 230, 130, 30);

        jButton1.setText("Guardar");
        jButton1.setToolTipText("Aceptar reabastecimiento");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jButton1);
        jButton1.setBounds(20, 290, 80, 30);

        jButton2.setText("Cancelar");
        jButton2.setToolTipText("Cancelar reabastecimiento");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jButton2);
        jButton2.setBounds(110, 290, 90, 30);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Stock disponible");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 90, 110, 17);

        actual1.setText(" ");
        actual1.setToolTipText("Stock actual");
        jPanel1.add(actual1);
        actual1.setBounds(10, 110, 130, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 880, 330);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ReabastecimientoDeStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReabastecimientoDeStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReabastecimientoDeStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReabastecimientoDeStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReabastecimientoDeStock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actual;
    private javax.swing.JTextField actual1;
    private javax.swing.JTextField agregar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> listbusqueda;
    private javax.swing.JTable tbdatos;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}