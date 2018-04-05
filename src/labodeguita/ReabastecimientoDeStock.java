package labodeguita;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
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
        mostrardatos("");
        
        guardar.setEnabled(false);
        cancelar.setEnabled(false);
        
        ico1.setVisible(false);
        ico2.setVisible(false);
        ico3.setVisible(false);        
        //fecha local
        Calendar c;
        c=Calendar.getInstance();
        int d=c.get(Calendar.DATE), m=1+(c.get(Calendar.MONTH)), a=c.get(Calendar.YEAR);
        fecha.setText(a+"/"+m+"/"+d);
        
        Timer tiempo=new Timer(100, new ReabastecimientoDeStock.horas());
        tiempo.start();
    }
    
    class horas implements ActionListener{
    //hora local actualizable
        public void actionPerformed(ActionEvent e){
        Date sistHora=new Date();
        String pmAm="hh:mm:ss a";
        SimpleDateFormat format=new SimpleDateFormat(pmAm);
        Calendar hoy=Calendar.getInstance();
        hora.setText(String.format(format.format(sistHora),hoy));          
        }
    }
    
    public void borrar (){
        stComprar.setText("0");
        stDisponible.setText("0");
        stFinal.setText("0");
        prove.setText("");        
        stCoste.setText("");
        nom.setText("");
        descripcion.setText("");
        empresa.setText("");
        code.setText("");
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
           consultar="SELECT * FROM productos WHERE cod_prod LIKE '%"+txtbuscar.getText() + "%'";
       }
       else if (filtro.equals("Nombre")) {
           consultar="SELECT * FROM productos WHERE nombre_prod LIKE '%"+txtbuscar.getText() + "%'";
       }
       else if (filtro.equals("Empresa")) {
           consultar="SELECT * FROM productos WHERE nomEmp LIKE '%"+txtbuscar.getText() + "%'";
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
    
    int cont=0;
    public void validar(){
        if(prove.getText().equals("")){ico1.setVisible(true);cont++;}              else{ico1.setVisible(false);}
        if(stComprar.getText().equals("")){ico2.setVisible(true);cont++;}              else{ico2.setVisible(false);}
        if(stCoste.getText().equals("")){ico3.setVisible(true);cont++;}              else{ico3.setVisible(false);}
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdatos = new javax.swing.JTable();
        stComprar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        stCoste = new javax.swing.JTextField();
        prove = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        ico1 = new javax.swing.JLabel();
        ico2 = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        nom = new javax.swing.JLabel();
        empresa = new javax.swing.JLabel();
        stDisponible = new javax.swing.JLabel();
        code = new javax.swing.JLabel();
        stFinal = new javax.swing.JLabel();
        descripcion = new javax.swing.JLabel();
        ico3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        combo = new javax.swing.JComboBox<>();
        txtbuscar = new javax.swing.JTextField();

        jMenuItem1.setText("Comprar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Stock a comprar");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 130, 30));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Stock final");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, 90, 30));

        guardar.setText("Guardar");
        guardar.setToolTipText("Aceptar reabastecimiento");
        guardar.setBorder(null);
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jPanel1.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 520, 90, 30));

        cancelar.setText("Cancelar");
        cancelar.setToolTipText("Cancelar reabastecimiento");
        cancelar.setBorder(null);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 520, 90, 30));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Stock disponible");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 120, 30));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre del producto");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, 30));

        tbdatos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1020, 180));

        stComprar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        stComprar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        stComprar.setText("0");
        stComprar.setToolTipText("Enter para calcular");
        stComprar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                stComprarKeyPressed(evt);
            }
        });
        jPanel1.add(stComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 290, 130, 30));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Empresa");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 70, 30));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Descripcion");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 90, 30));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Codigo");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 60, 30));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Proveedor");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 80, 30));

        stCoste.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        stCoste.setToolTipText("Monto a pagar por el stock");
        jPanel1.add(stCoste, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 390, 130, 30));

        prove.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        prove.setToolTipText("Monto a pagar por el stock");
        jPanel1.add(prove, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 180, 30));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Coste de stock");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, 110, 30));

        ico1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Braian Canjay\\Desktop\\DES AP 1\\32x32.png")); // NOI18N
        ico1.setToolTipText("Este campo no puede estar vacio");
        jPanel1.add(ico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, -1, 30));

        ico2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Braian Canjay\\Desktop\\DES AP 1\\32x32.png")); // NOI18N
        ico2.setToolTipText("Este campo no puede estar vacio");
        jPanel1.add(ico2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 290, -1, 30));

        hora.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        hora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 50, 90, 20));

        fecha.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 20, 90, 20));

        nom.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        nom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 180, 30));

        empresa.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        empresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        empresa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 180, 30));

        stDisponible.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        stDisponible.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stDisponible.setText("0");
        stDisponible.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(stDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, 130, 30));

        code.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        code.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        code.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(code, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 90, 30));

        stFinal.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        stFinal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stFinal.setText("0");
        stFinal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(stFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, 130, 30));

        descripcion.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        descripcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 180, 30));

        ico3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Braian Canjay\\Desktop\\DES AP 1\\32x32.png")); // NOI18N
        ico3.setToolTipText("Este campo no puede estar vacio");
        jPanel1.add(ico3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 390, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1060, 590));

        jPanel2.setBackground(new java.awt.Color(101, 178, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reabastecimiento de stock");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 410, 40));

        jButton4.setText("Salir");
        jButton4.setToolTipText("regresar pestaña anterior");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 10, 50, 40));

        combo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nombre", "Empresa" }));
        jPanel2.add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 90, 30));

        txtbuscar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtbuscar.setToolTipText("Enter para buscar");
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
        });
        jPanel2.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 200, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      Principal obj=new Principal();
        obj.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed
        buscar(combo.getSelectedItem().toString());
    }//GEN-LAST:event_txtbuscarKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int fila= tbdatos.getSelectedRow();
        if(fila>=0){
            code.setText(tbdatos.getValueAt(fila, 0).toString());
            nom.setText(tbdatos.getValueAt(fila, 1).toString());
            descripcion.setText(tbdatos.getValueAt(fila, 2).toString());
            empresa.setText(tbdatos.getValueAt(fila, 3).toString());
            stDisponible.setText(tbdatos.getValueAt(fila, 5).toString());
        }
        else{
            JOptionPane.showMessageDialog(null,"no seleciono fila");
        }
        guardar.setEnabled(true);
        cancelar.setEnabled(true);
        prove.setText("");
        stComprar.setText("0");
        stCoste.setText("");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void stComprarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stComprarKeyPressed
        // TODO add your handling code here:
        int dis,comp,fin;
        dis= Integer.parseInt(stDisponible.getText());
        comp= Integer.parseInt(stComprar.getText());
        
        fin=dis+comp;
        
        stFinal.setText(""+fin);
    }//GEN-LAST:event_stComprarKeyPressed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        cont=0;
        validar();
        //si todos son invisibles hacer update si no, mensaje de llenar campos
        if (ico1.isVisible() || ico2.isVisible() || ico3.isVisible()) {
            JOptionPane.showMessageDialog(null,"Llenó todos los campos?");
        }
        else{
            try {
                PreparedStatement pstm = cn.prepareStatement("INSERT INTO compraproductos (nomProd, desProd, stCom, nomEmp, nom_prove, feCom, cod_prod, Nstock) VALUES (?,?,?,?,?,?,?,?)");
                pstm.setString(1, nom.getText());
                pstm.setString(2, descripcion.getText());
                pstm.setString(3, stComprar.getText());
                pstm.setString(4, empresa.getText());
                pstm.setString(5, prove.getText());
                pstm.setString(6, fecha.getText());
                pstm.setString(7, code.getText());
                pstm.setString(8, stFinal.getText());
                pstm.executeUpdate();
                PreparedStatement pst2 = cn.prepareStatement("UPDATE productos SET stock_prod='"+stFinal.getText()+"' WHERE cod_prod='"+code.getText()+"'");
                pst2.executeUpdate();
                mostrardatos("");
                guardar.setEnabled(false);
                cancelar.setEnabled(false);
                borrar();
            }catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        guardar.setEnabled(false);
        cancelar.setEnabled(false);
        borrar();
    }//GEN-LAST:event_cancelarActionPerformed

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
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel code;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel descripcion;
    private javax.swing.JLabel empresa;
    private javax.swing.JLabel fecha;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel hora;
    private javax.swing.JLabel ico1;
    private javax.swing.JLabel ico2;
    private javax.swing.JLabel ico3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nom;
    private javax.swing.JTextField prove;
    private javax.swing.JTextField stComprar;
    private javax.swing.JTextField stCoste;
    private javax.swing.JLabel stDisponible;
    private javax.swing.JLabel stFinal;
    private javax.swing.JTable tbdatos;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
LaBodeguita cc=new LaBodeguita();
Connection cn = cc.getConnection();
}
