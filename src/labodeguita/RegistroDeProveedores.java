/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labodeguita;

/**
 *
 * @author sasuk
 */
public class RegistroDeProveedores extends javax.swing.JFrame {

    /**
     * Creates new form RegistroDeProveedores
     */
    public RegistroDeProveedores() {
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        listbusqueda = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtproveedor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtempresa = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtnumeroemp = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtnumprov = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtcorreo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtidproveedor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 51, 153));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de proveedores");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(70, 10, 262, 29);

        jButton1.setText("jButton1");
        jPanel2.add(jButton1);
        jButton1.setBounds(860, 10, 40, 23);
        jPanel2.add(jTextField3);
        jTextField3.setBounds(590, 10, 250, 20);

        listbusqueda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        listbusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccion de busqueda...", "Nombre", "Empresa", "Telefono", "Correo", "Pagina", "Ciudad", "Pais", "Codigo proveedor", " " }));
        jPanel2.add(listbusqueda);
        listbusqueda.setBounds(416, 10, 170, 21);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 920, 50);

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Datos basicos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nombre del proveedor");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(20, 30, 160, 15);
        jPanel3.add(txtproveedor);
        txtproveedor.setBounds(20, 50, 150, 20);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Empresa");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(20, 80, 60, 15);
        jPanel3.add(txtempresa);
        txtempresa.setBounds(20, 100, 150, 20);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tel/Cel Empresa");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(20, 130, 110, 15);
        jPanel3.add(txtnumeroemp);
        txtnumeroemp.setBounds(20, 150, 150, 20);

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tel/Cel Proveedor");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(20, 180, 110, 15);
        jPanel3.add(txtnumprov);
        txtnumprov.setBounds(20, 200, 150, 20);

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Correo empresarial");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(20, 230, 110, 15);
        jPanel3.add(txtcorreo);
        txtcorreo.setBounds(20, 250, 150, 20);

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Codigo del proveedor");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(20, 280, 130, 15);
        jPanel3.add(txtidproveedor);
        txtidproveedor.setBounds(20, 300, 150, 20);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(190, 20, 720, 310);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 50, 920, 340);

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(null);

        jButton2.setText("Nuevo");
        jPanel4.add(jButton2);
        jButton2.setBounds(360, 20, 80, 60);

        jButton3.setText("Guardar");
        jPanel4.add(jButton3);
        jButton3.setBounds(460, 20, 80, 60);

        jButton4.setText("Cancelar");
        jPanel4.add(jButton4);
        jButton4.setBounds(570, 20, 80, 60);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 390, 920, 100);

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
            java.util.logging.Logger.getLogger(RegistroDeProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroDeProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroDeProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroDeProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroDeProveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JComboBox<String> listbusqueda;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtempresa;
    private javax.swing.JTextField txtidproveedor;
    private javax.swing.JTextField txtnumeroemp;
    private javax.swing.JTextField txtnumprov;
    private javax.swing.JTextField txtproveedor;
    // End of variables declaration//GEN-END:variables
}
