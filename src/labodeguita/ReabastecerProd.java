package labodeguita;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReabastecerProd extends javax.swing.JFrame {
    public ReabastecerProd() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrardatos("");
    }
    
    void mostrardatos(String valor){
    DefaultTableModel modelo= new DefaultTableModel();
       modelo.addColumn("CODIGO");
       modelo.addColumn("NOMBRE");
       modelo.addColumn("DESCRIPCION");
       modelo.addColumn("EMPRESA");
       modelo.addColumn("PRECIO");
       modelo.addColumn("STOCK");
    tbdatos.setModel(modelo);
    String sql="";
    if(valor.equals(""))
    {
        sql="SELECT * FROM productos";
    }
    else{
        sql="SELECT * FROM productos WHERE cod_prod='"+valor+"'";
    }
    String []datos = new String [6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString("cod_prod");
                datos[1]=rs.getString("nombre_prod");
                datos[2]=rs.getString("descripcion_prod");
                datos[3]=rs.getString("nomEmp");
                datos[4]=rs.getString("precio_prod");
                datos[5]=rs.getString("stock_prod");
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
       modelo.addColumn("EMPRESA");
       modelo.addColumn("PRECIO");
       modelo.addColumn("STOCK");
       tbdatos.setModel(modelo);

       String consultar=null;
       if (filtro.equals("Codigo")) {
           consultar="SELECT * FROM productos WHERE cod_prod='"+txtbuscar.getText()+"'";
       }
       else if (filtro.equals("Nombre")) {
           consultar="SELECT * FROM productos WHERE nombre_prod='"+txtbuscar.getText() + "'";
       }
       else if (filtro.equals("Descripcion")) {
           consultar="SELECT * FROM productos WHERE descripcion_prod='"+txtbuscar.getText() + "'";
       }
       else if (filtro.equals("Empresa")) {
           consultar="SELECT * FROM productos WHERE nomEmp='"+txtbuscar.getText() + "'";
       }
       else if (filtro.equals("Precio")) {
           consultar="SELECT * FROM productos WHERE precio_prod='"+txtbuscar.getText() + "'";
       }
       else if (filtro.equals("Stock")) {
           consultar="SELECT * FROM productos WHERE stock_prod='"+txtbuscar.getText() + "'";
       }

       String []datos= new String[15];
       try {
           Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(consultar);
            while(rs.next())
            {
                datos[0]=rs.getString("cod_prod");
                datos[1]=rs.getString("nombre_prod");
                datos[2]=rs.getString("descripcion_prod");
                datos[3]=rs.getString("nomEmp");
                datos[4]=rs.getString("precio_prod");
                datos[5]=rs.getString("stock_prod");
                modelo.addRow(datos);
            }
            tbdatos.setModel(modelo);

        } catch (SQLException ex) {
            Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ReabastecimientoStock(){
        int fila = tbdatos.getSelectedRow();
        if (fila >= 0) {
            ReabastecimientoDeStock.txtbuscar.setText(tbdatos.getValueAt(fila, 0).toString());
            ReabastecimientoDeStock.code.setText(tbdatos.getValueAt(fila, 0).toString());
            ReabastecimientoDeStock.code1.setText(tbdatos.getValueAt(fila, 0).toString());
            ReabastecimientoDeStock.nom.setText(tbdatos.getValueAt(fila, 1).toString());
            ReabastecimientoDeStock.descripcion.setText(tbdatos.getValueAt(fila, 2).toString());
            ReabastecimientoDeStock.empresa.setText(tbdatos.getValueAt(fila, 3).toString());
            ReabastecimientoDeStock.stDisponible.setText(tbdatos.getValueAt(fila, 5).toString());
            ReabastecimientoDeStock.stockProd.setText(tbdatos.getValueAt(fila, 5).toString());
            
            ReabastecimientoDeStock.ico1.setVisible(false);
            ReabastecimientoDeStock.ico2.setVisible(false);
            ReabastecimientoDeStock.ico3.setVisible(false);
            
            ReabastecimientoDeStock.guardar.setEnabled(true);
            ReabastecimientoDeStock.cancelar.setEnabled(true);

        } else {
            ReabastecimientoDeStock.borrar();
            JOptionPane.showMessageDialog(null, "No existe un producto con el codigo "+txtbuscar.getText());
        }
    }
    
    public void ControlProd(){
        int fila = tbdatos.getSelectedRow();
        if (fila >= 0) {
            registro.txtbuscar.setText(tbdatos.getValueAt(fila, 0).toString());
            registro.code.setText(tbdatos.getValueAt(fila, 0).toString());
            registro.code1.setText(tbdatos.getValueAt(fila, 0).toString());
            registro.nombre.setText(tbdatos.getValueAt(fila, 1).toString());
            registro.descripcion.setText(tbdatos.getValueAt(fila, 2).toString());
            registro.empresa.setText(tbdatos.getValueAt(fila, 3).toString());
            registro.precio.setText(tbdatos.getValueAt(fila, 4).toString());
            registro.stock.setText(tbdatos.getValueAt(fila, 5).toString());
            registro.stockProd.setText(tbdatos.getValueAt(fila, 5).toString());
            
            registro.ico1.setVisible(false);
            registro.ico2.setVisible(false);
            registro.ico3.setVisible(false);
            registro.ico4.setVisible(false);
            registro.ico5.setVisible(false);

        } else {
            registro.limpiar();
            JOptionPane.showMessageDialog(null, "No existe un producto con el codigo "+txtbuscar.getText());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdatos = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        combo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        comprobador = new javax.swing.JTextField();
        code = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        jMenuItem1.setText("Seleccionar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbdatos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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
        tbdatos.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tbdatos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 1100, 250));

        txtbuscar.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txtbuscar.setToolTipText("Enter para buscar");
        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 370, 40));

        combo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nombre", "Descripcion", "Empresa", "Precio", "Stock" }));
        jPanel1.add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 140, 40));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar por:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 120, 40));

        comprobador.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jPanel1.add(comprobador, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 110, -1));

        code.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jPanel1.add(code, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, 110, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1160, 440));

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar Producto");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 250, 40));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/x-1.png"))); // NOI18N
        jButton4.setToolTipText("regresar pestaña anterior");
        jButton4.setBorder(null);
        jButton4.setContentAreaFilled(false);
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/x-2.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 50, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
        if (txtbuscar.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese un dato a buscar");
        }
        else{
            buscar(combo.getSelectedItem().toString());
        }
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed

    }//GEN-LAST:event_txtbuscarKeyPressed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (comprobador.getText().equals("1")) {
            ReabastecimientoDeStock obj=new ReabastecimientoDeStock();
            obj.setVisible(true);
            this.dispose();
        }
        if (comprobador.getText().equals("2")) {
            registro obj=new registro();
            obj.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (comprobador.getText().equals("1")) {
            ReabastecimientoDeStock obj=new ReabastecimientoDeStock();
            obj.setVisible(true);
            ReabastecimientoStock();
            obj.buscarST();
            this.dispose();
        }
        if (comprobador.getText().equals("2")) {
            registro obj=new registro();
            obj.setVisible(true);
            ControlProd();
            obj.buscarST();
            this.dispose();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(ReabastecerProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReabastecerProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReabastecerProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReabastecerProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReabastecerProd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField code;
    private javax.swing.JComboBox<String> combo;
    public static javax.swing.JTextField comprobador;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbdatos;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
LaBodeguita cc=new LaBodeguita();
Connection cn = cc.getConnection();
}
