package labodeguita;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class ControlDeVentas extends javax.swing.JFrame {

    public ControlDeVentas() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        Date sistFecha=new Date();
        SimpleDateFormat formato=new SimpleDateFormat("dd MMMMM YYYY");
        fecha.setText(formato.format(sistFecha));
        
        mostrardatosVenta("");
        mostrardatosProductos("");
        sumar();
    }
    
    void mostrardatosVenta(String valor){
       DefaultTableModel modelo= new DefaultTableModel();
       modelo.addColumn("CODIGO");
       modelo.addColumn("NOMBRE");
       modelo.addColumn("DESCRIPCION");
       modelo.addColumn("EMPRESA");
       modelo.addColumn("CANTIDAD");
       modelo.addColumn("PRECIO");
       modelo.addColumn("TOTAL");
       modelo.addColumn("FECHA");
       modelo.addColumn("ID PROD");
    tbdatos.setModel(modelo);
    String sql="";
    if(valor.equals(""))
    {
        sql="SELECT * FROM ventas";
    }
    else{
        sql="SELECT * FROM ventas WHERE codVent='"+valor+"'";
    }
 
    String []datos = new String [20];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString("codVent");
                datos[1]=rs.getString("nomVent");
                datos[2]=rs.getString("desVent");
                datos[3]=rs.getString("nomEmp");
                datos[4]=rs.getString("cantVent");
                datos[5]=rs.getString("preVent");
                datos[6]=rs.getString("totalVent");
                datos[7]=rs.getString("feVent");
                datos[8]=rs.getString("cod_prod");
                modelo.addRow(datos);
            }
            tbdatos.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(ControlDeVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void mostrardatosProductos(String valor) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("CODIGO");
        modelo.addColumn("STOCK");
        tbdatos2.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT * FROM productos";
        } else {
            sql = "SELECT * FROM productos WHERE cod_prod='" + valor + "'";
        }

        String[] datos = new String[3];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("cod_prod");
                datos[1] = rs.getString("stock_prod");
                modelo.addRow(datos);
            }
            tbdatos2.setModel(modelo);
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
       modelo.addColumn("CANTIDAD");
       modelo.addColumn("PRECIO");
       modelo.addColumn("TOTAL");
       modelo.addColumn("FECHA");
       modelo.addColumn("ID PROD");
       tbdatos.setModel(modelo);

       String consultar=null;
       if (filtro.equals("Codigo")) {
           consultar="SELECT * FROM ventas WHERE codVent LIKE '%"+txtbuscar.getText() + "%'";
       }
       else if (filtro.equals("Nombre")) {
           consultar="SELECT * FROM ventas WHERE nomVent LIKE '%"+txtbuscar.getText() + "%'";
       }
       else if (filtro.equals("Descripcion")) {
           consultar="SELECT * FROM ventas WHERE desVent LIKE '%"+txtbuscar.getText() + "%'";
       }
       else if (filtro.equals("Fecha")) {
           consultar="SELECT * FROM ventas WHERE feVent LIKE '%"+txtbuscar.getText() + "%'";
       }

       String []datos= new String[15];
       try {
           Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(consultar);
            while(rs.next())
            {
                datos[0]=rs.getString("codVent");
                datos[1]=rs.getString("nomVent");
                datos[2]=rs.getString("desVent");
                datos[3]=rs.getString("nomEmp");
                datos[4]=rs.getString("cantVent");
                datos[5]=rs.getString("preVent");
                datos[6]=rs.getString("totalVent");
                datos[7]=rs.getString("feVent");
                datos[8]=rs.getString("cod_prod");
                modelo.addRow(datos);
            }
            tbdatos.setModel(modelo);

        } catch (SQLException ex) {
            Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void buscarStock(String filtro){
    DefaultTableModel modelo= new DefaultTableModel();
       modelo.addColumn("CODIGO");
        modelo.addColumn("STOCK");
       tbdatos2.setModel(modelo);

       String consultar = "SELECT * FROM productos WHERE cod_prod = " + code.getText();

       String []datos= new String[15];
       try {
           Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(consultar);
            while(rs.next())
            {
                datos[0] = rs.getString("cod_prod");
                datos[1] = rs.getString("stock_prod");
                modelo.addRow(datos);
            }
            tbdatos2.setModel(modelo);

        } catch (SQLException ex) {
            Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sumar(){
    double b=0,a;
        for(int i= 0; i<tbdatos.getRowCount();i++){
            String Calculo = String.valueOf(tbdatos.getValueAt(i, 6));
            a=Double.parseDouble(Calculo);
            b=b+a;
            if(i==tbdatos.getRowCount()-1){
                total.setText(""+b);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtbuscar = new javax.swing.JTextField();
        total = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbdatos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        stockProd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        newStock = new javax.swing.JTextField();
        code = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        GReporte = new javax.swing.JButton();
        fecha = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cant = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdatos2 = new javax.swing.JTable();

        jMenuItem2.setText("Eliminar venta");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Control de ventas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Salir");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 10, 60, 30));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Control de ventas");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 60));

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtbuscar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        jPanel2.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 320, 30));

        total.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        total.setForeground(new java.awt.Color(255, 255, 255));
        total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        total.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel2.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 170, 30));

        combo.setBackground(new java.awt.Color(153, 255, 153));
        combo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Fecha", "Nombre", "Descripcion" }));
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
        tbdatos.setComponentPopupMenu(jPopupMenu1);
        jScrollPane2.setViewportView(tbdatos);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 1000, 250));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Stock Prod");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, -1, -1));

        stockProd.setText("0");
        jPanel2.add(stockProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 470, 140, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nuevo Stock");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 440, -1, -1));

        newStock.setText("0");
        jPanel2.add(newStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 470, 140, -1));

        code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codeKeyReleased(evt);
            }
        });
        jPanel2.add(code, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 140, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cod");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Busqueda");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 30));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total:   $");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, -1, 30));

        GReporte.setBackground(new java.awt.Color(0, 255, 51));
        GReporte.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        GReporte.setText("Generar reporte");
        GReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GReporteActionPerformed(evt);
            }
        });
        jPanel2.add(GReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 210, 40));

        fecha.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        fecha.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Cant");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, -1, -1));
        jPanel2.add(cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 140, -1));

        tbdatos2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbdatos2);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 500, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1060, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed
    }//GEN-LAST:event_txtbuscarKeyPressed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        int fila =tbdatos.getSelectedRow();
        if(fila>=0){
            code.setText(tbdatos.getValueAt(fila, 8).toString());
            cant.setText(tbdatos.getValueAt(fila, 4).toString());
            buscarStock("");
            tbdatos2.selectAll();
                int fila2 = tbdatos2.getSelectedRow();
                if (fila2 >= 0) {
                    stockProd.setText(tbdatos2.getValueAt(fila2, 1).toString());
                }
                
                int cantidad = Integer.parseInt(cant.getText());
                int stockP = Integer.parseInt(stockProd.getText());
                
                int nuevo=stockP+cantidad;
                newStock.setText(""+nuevo);
                
                String cod="";
                cod=tbdatos.getValueAt(fila, 0).toString();
                
                try {
                    PreparedStatement pst = cn.prepareStatement("DELETE FROM ventas WHERE codVent='"+cod+"'");
                    pst.executeUpdate();
                    PreparedStatement pst2 = cn.prepareStatement("UPDATE productos SET stock_prod='"+newStock.getText()+"' WHERE cod_prod='"+code.getText()+"'");
                    pst2.executeUpdate();
                    mostrardatosProductos("");
                    JOptionPane.showMessageDialog(null,"Registro eliminado");
                    mostrardatosVenta("");

                }catch (Exception e){}
                
        }
        else{
            JOptionPane.showMessageDialog(null,"no seleciono fila");
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        // TODO add your handling code here:
        buscar(combo.getSelectedItem().toString());
        sumar();
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void GReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GReporteActionPerformed
        //Generar reporte de tabla
        String valor = txtbuscar.getText();
        String sql = null;
    if (combo.getSelectedItem().toString().equals("Codigo")) {
        sql="select * from ventas where codVent Like '%"+valor+"%'";
    }
    if (combo.getSelectedItem().toString().equals("Nombre")) {
        sql="select * from ventas where nomVent Like '%"+valor+"%'";
    }
    if (combo.getSelectedItem().toString().equals("Descripcion")) {
        sql="select * from ventas where desVent Like '%"+valor+"%'";
    }
    if (combo.getSelectedItem().toString().equals("Fecha")) {
        sql="select * from ventas where feVent Like '%"+valor+"%'";
    }
        Workbook book = new HSSFWorkbook();
        org.apache.poi.ss.usermodel.Sheet sheet =  book.createSheet("Reporte");
        String fe=fecha.getText();
        String file = "("+valor+") "+fe+".xls";//(2018-03-09) 06-abril-2018.xls separar lo de el reporte
            
            int rowCount = 1;
            
            try{
               Statement st = cn.createStatement();
               ResultSet rs = st.executeQuery(sql);

               Row rowHead;
               rowHead = sheet.createRow(0);
               org.apache.poi.ss.usermodel.Cell headFolio = rowHead.createCell(0);
               headFolio.setCellValue("Folio");
               
               org.apache.poi.ss.usermodel.Cell headNombre_de_venta = rowHead.createCell(1);
               headNombre_de_venta.setCellValue("Nombre de venta");

               org.apache.poi.ss.usermodel.Cell headDescripcion_de_venta = rowHead.createCell(2);
               headDescripcion_de_venta.setCellValue("Descripcion de venta");
               
               org.apache.poi.ss.usermodel.Cell headEmpresa = rowHead.createCell(3);
               headEmpresa.setCellValue("Empresa");

               org.apache.poi.ss.usermodel.Cell headVentas_realizadas = rowHead.createCell(4);
               headVentas_realizadas.setCellValue("Ventas realizadas");

               org.apache.poi.ss.usermodel.Cell headPrecio_unitario = rowHead.createCell(5);
               headPrecio_unitario.setCellValue("Precio unitario");

               org.apache.poi.ss.usermodel.Cell headTotal_de_la_venta = rowHead.createCell(6);
               headTotal_de_la_venta.setCellValue("Total de la venta");

               org.apache.poi.ss.usermodel.Cell headFecha = rowHead.createCell(7);
               headFecha.setCellValue("Fecha");
               
               org.apache.poi.ss.usermodel.Cell headTotal_Vendido = rowHead.createCell(8);
               headTotal_Vendido.setCellValue("Total Vendido");
               
               org.apache.poi.ss.usermodel.Cell headTotal = rowHead.createCell(9);
               headTotal.setCellValue((total.getText()));
               
            while(rs.next()){
                Row row;
                row = sheet.createRow(rowCount);
                
                org.apache.poi.ss.usermodel.Cell celdaFolio = row.createCell(0);
                celdaFolio.setCellValue(rs.getInt("codVent"));
                
                org.apache.poi.ss.usermodel.Cell celdaNombre_de_venta = row.createCell(1);
                celdaNombre_de_venta.setCellValue(rs.getString("nomVent"));
                
                org.apache.poi.ss.usermodel.Cell celdaDescripcion_de_venta = row.createCell(2);
                celdaDescripcion_de_venta.setCellValue(rs.getString("desVent"));
                
                org.apache.poi.ss.usermodel.Cell celdaEmpresa = row.createCell(3);
                celdaEmpresa.setCellValue(rs.getString("nomEmp"));
                
                org.apache.poi.ss.usermodel.Cell celdaVentas_realizadas = row.createCell(4);
                celdaVentas_realizadas.setCellValue(rs.getInt("cantVent"));
                
                org.apache.poi.ss.usermodel.Cell celdaPrecio_unitario = row.createCell(5);
                celdaPrecio_unitario.setCellValue(rs.getInt("preVent"));
                
                org.apache.poi.ss.usermodel.Cell celdaTotal_de_la_venta = row.createCell(6);
                celdaTotal_de_la_venta.setCellValue(rs.getInt("totalVent"));
                
                org.apache.poi.ss.usermodel.Cell celdaFecha = row.createCell(7);
                celdaFecha.setCellValue(rs.getString("feVent"));
                
                rowCount++;
            }
            
            FileOutputStream out = new FileOutputStream(file);
            book.write(out);
            JOptionPane.showMessageDialog(null, "Reporte creado con el nombre ("+txtbuscar.getText()+")");
            out.close();
        } catch (Exception e) {
             
        }
    
    }//GEN-LAST:event_GReporteActionPerformed

    private void codeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codeKeyReleased
        // TODO add your handling code here: buscar en tbdtos 2 al ser autoselect
        buscarStock("");
    }//GEN-LAST:event_codeKeyReleased

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
            java.util.logging.Logger.getLogger(ControlDeVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlDeVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlDeVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlDeVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControlDeVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GReporte;
    private javax.swing.JTextField cant;
    private javax.swing.JTextField code;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel fecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField newStock;
    private javax.swing.JTextField stockProd;
    private javax.swing.JTable tbdatos;
    private javax.swing.JTable tbdatos2;
    private javax.swing.JLabel total;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
LaBodeguita cc=new LaBodeguita();
Connection cn = cc.getConnection();
}
