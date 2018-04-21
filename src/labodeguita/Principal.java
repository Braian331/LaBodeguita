package labodeguita;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        Date sistFecha=new Date();
        SimpleDateFormat formato=new SimpleDateFormat("dd MMMMM YYYY");
        fecha.setText(formato.format(sistFecha));
        
        Timer tiempo=new Timer(100, new Principal.horas());
        tiempo.start();
        
        privilegio();
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
    
    public void privilegio(){
        if (valor.getText().equals("1")) {
            MenuControl.setEnabled(true);
        }
        if (valor.getText().equals("2")) {
            MenuControl.setEnabled(false);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        trabajador = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        valor = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        MenuControl = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        trabajador.setFont(new java.awt.Font("Century Gothic", 0, 23)); // NOI18N
        trabajador.setForeground(new java.awt.Color(255, 255, 255));
        trabajador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(trabajador, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 220, 40));

        hora.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        hora.setForeground(new java.awt.Color(255, 255, 255));
        hora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 200, 30));

        fecha.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        fecha.setForeground(new java.awt.Color(255, 255, 255));
        fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 200, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Braian Canjay\\Desktop\\fonsd.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, -1, -1));
        getContentPane().add(valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 80, -1));

        jMenuBar1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jMenuBar1.setBorderPainted(false);
        jMenuBar1.setPreferredSize(new java.awt.Dimension(767, 50));

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

        jMenu6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jMenu6.setText("Compra");
        jMenu6.setToolTipText("Re abastecer stock");
        jMenu6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });

        jMenuItem7.setText("Compra de Productos");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem7);

        jMenuBar1.add(jMenu6);

        MenuControl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        MenuControl.setText("Control");
        MenuControl.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        jMenuItem10.setText("Control de Productos");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        MenuControl.add(jMenuItem10);

        jMenuItem5.setText("Control de Ventas");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        MenuControl.add(jMenuItem5);

        jMenuItem2.setText("Control de Trabajadores");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        MenuControl.add(jMenuItem2);

        jMenuItem11.setText("Control de Proveedores");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        MenuControl.add(jMenuItem11);

        jMenuBar1.add(MenuControl);

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

        jMenu4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jMenu4.setText("Cerrar sesion");
        jMenu4.setToolTipText("Cerrar sesion del usuario");
        jMenu4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        String valor = "09";
        System.out.println("Generando");
        String sql="select * from ventas where feVent Like '%"+ valor + "%'";
        Workbook book = new HSSFWorkbook();
        org.apache.poi.ss.usermodel.Sheet sheet =  book.createSheet("Reporte");
        String fe=fecha.getText();
        String file = fe+".xls";
            Mejorar la principal
            el focus
            lo de smar al eliminar
            ver stock
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
            JOptionPane.showMessageDialog(null, "Reporte creado");
            out.close();
        } catch (Exception e) {
             
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        Principal obj=new Principal();
        obj.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        Login obj=new Login();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu6MouseClicked

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu6ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

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
    public static javax.swing.JMenu MenuControl;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel hora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    public static javax.swing.JLabel trabajador;
    public static javax.swing.JTextField valor;
    // End of variables declaration//GEN-END:variables
LaBodeguita cc=new LaBodeguita();
Connection cn = cc.getConnection();
}
