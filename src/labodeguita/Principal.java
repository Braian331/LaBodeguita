package labodeguita;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.apache.poi.ss.usermodel.Workbook;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        Date sistFecha=new Date();
        SimpleDateFormat formato=new SimpleDateFormat("dd MMMMM YYYY");
        fecha.setText(formato.format(sistFecha));
        
        Timer tiempo=new Timer(100, new Principal.horas());
        tiempo.start();
    }
    
    class horas implements ActionListener{
    
        public void actionPerformed(ActionEvent e){
            Date sistHora=new Date();
            String pmAm="hh:mm:ss a";
            SimpleDateFormat format=new SimpleDateFormat(pmAm);
            Calendar hoy=Calendar.getInstance();
            hora.setText(String.format(format.format(sistHora),hoy));          
        }      
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hora = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu14 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu15 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hora.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        hora.setForeground(new java.awt.Color(255, 255, 255));
        hora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 220, 60));

        fecha.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        fecha.setForeground(new java.awt.Color(255, 255, 255));
        fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 360, 60));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:/C:/Users/Braian Canjay/Desktop/Inte/fondo LB.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 410));

        jMenuBar1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "La Bodeguita", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Century Gothic", 0, 14), new java.awt.Color(255, 51, 51))); // NOI18N

        jMenu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jMenu1.setText("Inicio");
        jMenu1.setContentAreaFilled(false);
        jMenu1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jMenu5.setText("Ventas");
        jMenu5.setToolTipText("");
        jMenu5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        jMenuItem4.setText("Venta de Productos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem4);

        jMenuBar1.add(jMenu5);

        jMenu14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jMenu14.setText("Control");
        jMenu14.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        jMenuItem5.setText("Control de Ventas");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem5);

        jMenuItem8.setText("Control de trabajadores");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem8);

        jMenuBar1.add(jMenu14);

        jMenu2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jMenu2.setText("Reporte");
        jMenu2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        jMenuItem3.setText("Reporte de Ventas");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jMenu15.setText("Registros");
        jMenu15.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        jMenuItem11.setText("Registro de proveedores");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem11);

        jMenuItem6.setText("Registro de trabajadores");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem6);

        jMenuItem7.setText("Reabastecimieno de stock");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem7);

        jMenuBar1.add(jMenu15);

        jMenu3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jMenu3.setText("Salir");
        jMenu3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        VentaDeProductos obj=new VentaDeProductos();
        obj.setVisible(true);        
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        ControlDeVentas obj=new ControlDeVentas();
        obj.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
      System.out.println("generando...");
        String sql="select * from ventas";
         Workbook book = new HSSFWorkbook();
         org.apache.poi.ss.usermodel.Sheet sheet =  book.createSheet("Reporte");
         String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
         String file = date+".xls";
         int rowCount = 1;
         try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            Row rowHead;
            rowHead = sheet.createRow(0);
            org.apache.poi.ss.usermodel.Cell headCodigo_de_folio = rowHead.createCell(0);
            headCodigo_de_folio.setCellValue("Codigo de folio");
            
            org.apache.poi.ss.usermodel.Cell headDescripcion_de_la_venta = rowHead.createCell(1);
            headDescripcion_de_la_venta.setCellValue("Descripcion de la venta");
            
            org.apache.poi.ss.usermodel.Cell headCantidad_de_ventas_realizadas = rowHead.createCell(2);
            headCantidad_de_ventas_realizadas.setCellValue("Cantidad de ventas realizadas");
            
            org.apache.poi.ss.usermodel.Cell headPrecio_unitario = rowHead.createCell(3);
            headPrecio_unitario.setCellValue("Precio unitario");
            
            org.apache.poi.ss.usermodel.Cell headPrecio_total_de_la_venta = rowHead.createCell(4);
            headPrecio_total_de_la_venta.setCellValue("Precio total de la venta");
            
            org.apache.poi.ss.usermodel.Cell headFecha_de_la_venta = rowHead.createCell(5);
            headFecha_de_la_venta.setCellValue("Fecha de la venta");
            
                
            while(rs.next()){
                Row row;
                row = sheet.createRow(rowCount);
                
                org.apache.poi.ss.usermodel.Cell celdaNombre = row.createCell(0);
                celdaNombre.setCellValue(rs.getString("codVent"));
                
                org.apache.poi.ss.usermodel.Cell celdaApellido = row.createCell(1);
                celdaApellido.setCellValue(rs.getString("desVent"));
                
                org.apache.poi.ss.usermodel.Cell celdaCorreo = row.createCell(2);
                celdaCorreo.setCellValue(rs.getString("cantVent"));
                
                org.apache.poi.ss.usermodel.Cell celdaFecha = row.createCell(3);
                celdaFecha.setCellValue(rs.getString("preVent"));
                
                org.apache.poi.ss.usermodel.Cell celdaDes = row.createCell(4);
                celdaDes.setCellValue(rs.getString("totalVent"));
                
                org.apache.poi.ss.usermodel.Cell celdaCant = row.createCell(5);
                celdaCant.setCellValue(rs.getString("feVent"));
                
                org.apache.poi.ss.usermodel.Cell celdaPrecio = row.createCell(6);
                celdaPrecio.setCellValue(rs.getString("precio"));
                
                org.apache.poi.ss.usermodel.Cell celdaTotal = row.createCell(7);
                celdaTotal.setCellValue(rs.getString("total"));
                
                org.apache.poi.ss.usermodel.Cell celdaCod = row.createCell(8);
                celdaCod.setCellValue(rs.getString("cod"));
                
                rowCount++;
            }
            FileOutputStream out = new FileOutputStream(file);
            book.write(out);
            JOptionPane.showMessageDialog(null, "Reporte creado");
            out.close();
         } catch (Exception e) {
             
         }  
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        
        // TODO add your handling code here cojines, cachuate del rey vivoras
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        Principal obj=new Principal();
        obj.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        RegistroDeProveedores obj=new RegistroDeProveedores();
        obj.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
       RTrabajadores obj=new RTrabajadores();
        obj.setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
      ReabastecimientoDeStock obj=new ReabastecimientoDeStock();
        obj.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        ControlDeTrabajadores obj=new ControlDeTrabajadores();
        obj.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel hora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    // End of variables declaration//GEN-END:variables
LaBodeguita cc=new LaBodeguita();
Connection cn = cc.getConnection();
}
