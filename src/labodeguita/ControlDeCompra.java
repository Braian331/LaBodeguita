package labodeguita;
//hacer la cancelacion y restauracion
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class ControlDeCompra extends javax.swing.JFrame {

    public ControlDeCompra() {
        initComponents();
        mostrardatos("");
    }
    
    void mostrardatos(String valor){
       DefaultTableModel modelo= new DefaultTableModel();
       modelo.addColumn("CODIGO");
       modelo.addColumn("NOMBRE");
       modelo.addColumn("DESCRIPCION");
       modelo.addColumn("COMPRADO");
       modelo.addColumn("EMPRESA");
       modelo.addColumn("PROVEEDOR");
       modelo.addColumn("FECHA");
       modelo.addColumn("ID PROD");
       modelo.addColumn("NUEVO STOCK");
    tbdatos.setModel(modelo);
    String sql="";
    if(valor.equals(""))
    {
        sql="SELECT * FROM compraproductos";
    }
    else{
        sql="SELECT * FROM compraproductos WHERE idCom='"+valor+"'";
    }
 
    String []datos = new String [20];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString("idCom");
                datos[1]=rs.getString("nomProd");
                datos[2]=rs.getString("desProd");
                datos[3]=rs.getString("stCom");
                datos[4]=rs.getString("nomEmp");
                datos[5]=rs.getString("nom_prove");
                datos[6]=rs.getString("feCom");
                datos[7]=rs.getString("cod_prod");
                datos[8]=rs.getString("stock_prod");
                modelo.addRow(datos);
            }
            tbdatos.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(ControlDeVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void buscar(String filtro){
    DefaultTableModel modelo= new DefaultTableModel();
       modelo.addColumn("CODIGO");
       modelo.addColumn("NOMBRE");
       modelo.addColumn("DESCRIPCION");
       modelo.addColumn("COMPRADO");
       modelo.addColumn("EMPRESA");
       modelo.addColumn("PROVEEDOR");
       modelo.addColumn("FECHA");
       modelo.addColumn("ID PROD");
       modelo.addColumn("NUEVO STOCK");
       tbdatos.setModel(modelo);
       
       String consultar=null;
       if (filtro.equals("Codigo")) {
           consultar="SELECT * FROM compraproductos WHERE idCom LIKE '%"+txtbuscar.getText() + "%'";
       }
       else if (filtro.equals("Nombre")) {
           consultar="SELECT * FROM compraproductos WHERE nomProd LIKE '%"+txtbuscar.getText() + "%'";
       }
       else if (filtro.equals("Descripcion")) {
           consultar="SELECT * FROM compraproductos WHERE desProd LIKE '%"+txtbuscar.getText() + "%'";
       }
       else if (filtro.equals("Fecha")) {
           consultar="SELECT * FROM compraproductos WHERE feCom LIKE '%"+txtbuscar.getText() + "%'";
       }
       else if (filtro.equals("Comprado")) {
           consultar="SELECT * FROM compraproductos WHERE stCom LIKE '%"+txtbuscar.getText() + "%'";
       }
       else if (filtro.equals("Proveedor")) {
           consultar="SELECT * FROM compraproductos WHERE nom_prove LIKE '%"+txtbuscar.getText() + "%'";
       }
       else if (filtro.equals("Empresa")) {
           consultar="SELECT * FROM compraproductos WHERE nomEmp LIKE '%"+txtbuscar.getText() + "%'";
       }

       String []datos= new String[15];
       try {
           Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(consultar);
            while(rs.next())
            {
                datos[0]=rs.getString("idCom");
                datos[1]=rs.getString("nomProd");
                datos[2]=rs.getString("desProd");
                datos[3]=rs.getString("stCom");
                datos[4]=rs.getString("nomEmp");
                datos[5]=rs.getString("nom_prove");
                datos[6]=rs.getString("feCom");
                datos[7]=rs.getString("cod_prod");
                datos[8]=rs.getString("stock_prod");
                modelo.addRow(datos);
            }
            tbdatos.setModel(modelo);

        } catch (SQLException ex) {
            Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtbuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbdatos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        stock = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        newStock = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        code = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Salir");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 10, 60, 30));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        jLabel2.setText("Control de compras");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 60));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setToolTipText("");
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtbuscar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtbuscar.setToolTipText("Enter para buscar");
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        jPanel2.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 320, 30));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Busqueda");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 30));

        combo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nombre", "Descripcion", "Empresa", "Comprado", "Fecha", "Proveedor" }));
        jPanel2.add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 150, 30));

        tbdatos.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tbdatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbdatos);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 1060, 250));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Stock");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, -1, -1));
        jPanel2.add(stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 140, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nuevo Stock");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, -1, -1));
        jPanel2.add(newStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 140, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cod");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, -1, -1));
        jPanel2.add(code, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, 140, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1120, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed

    }//GEN-LAST:event_txtbuscarKeyPressed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        // TODO add your handling code here:
        buscar(combo.getSelectedItem().toString());
    }//GEN-LAST:event_txtbuscarKeyReleased

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
            java.util.logging.Logger.getLogger(ControlDeCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlDeCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlDeCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlDeCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControlDeCompra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField code;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField newStock;
    private javax.swing.JTextField stock;
    private javax.swing.JTable tbdatos;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
LaBodeguita cc=new LaBodeguita();
Connection cn = cc.getConnection();
}
