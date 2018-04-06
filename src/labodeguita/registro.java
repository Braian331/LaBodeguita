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

public class registro extends javax.swing.JFrame {

    public registro() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrardatos("");
        
        nuevo.setEnabled(true);
        guardar.setEnabled(false);
        actualizar.setEnabled(false);
        cancelar.setEnabled(false);
        
        ico1.setVisible(false);
        ico2.setVisible(false);
        ico3.setVisible(false);
        ico4.setVisible(false);
        ico5.setVisible(false);
        
        bloquear();
    }
    
    void iconos(){
        ico1.setVisible(false);
        ico2.setVisible(false);
        ico3.setVisible(false);
        ico4.setVisible(false);
        ico5.setVisible(false);
    }
    
    void bloquear(){
        nombre.setEnabled(false);
        descripcion.setEnabled(false);
        empresa.setEnabled(false);
        precio.setEnabled(false);
        stock.setEnabled(false);
    }
    
    void desbloquear(){
        nombre.setEnabled(true);
        descripcion.setEnabled(true);
        empresa.setEnabled(true);
        precio.setEnabled(true);
        stock.setEnabled(true);
    }
    
    void limpiar(){
        nombre.setText("");
        descripcion.setText("");
        empresa.setText("");
        precio.setText("");
        stock.setText("");
        code.setText("");
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
           consultar="SELECT * FROM productos WHERE cod_prod LIKE '%"+txtbuscar.getText() + "%'";
       }
       else if (filtro.equals("Nombre")) {
           consultar="SELECT * FROM productos WHERE nombre_prod LIKE '%"+txtbuscar.getText() + "%'";
       }
       else if (filtro.equals("Descripcion")) {
           consultar="SELECT * FROM productos WHERE descripcion_prod LIKE '%"+txtbuscar.getText() + "%'";
       }
       else if (filtro.equals("Empresa")) {
           consultar="SELECT * FROM productos WHERE nomEmp LIKE '%"+txtbuscar.getText() + "%'";
       }
       else if (filtro.equals("Precio")) {
           consultar="SELECT * FROM productos WHERE precio_prod LIKE '%"+txtbuscar.getText() + "%'";
       }
       else if (filtro.equals("Stock")) {
           consultar="SELECT * FROM productos WHERE stock_prod LIKE '%"+txtbuscar.getText() + "%'";
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
        if(nombre.getText().equals("")){ico1.setVisible(true);cont++;}              else{ico1.setVisible(false);}
        if(descripcion.getText().equals("")){ico2.setVisible(true);cont++;}              else{ico2.setVisible(false);}
        if(empresa.getText().equals("")){ico3.setVisible(true);cont++;}              else{ico3.setVisible(false);}
        if(precio.getText().equals("")){ico4.setVisible(true);cont++;}              else{ico4.setVisible(false);}
        if(stock.getText().equals("")){ico5.setVisible(true);cont++;}              else{ico5.setVisible(false);}
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
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        descripcion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdatos = new javax.swing.JTable();
        empresa = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        stock = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        code = new javax.swing.JLabel();
        ico1 = new javax.swing.JLabel();
        ico2 = new javax.swing.JLabel();
        ico3 = new javax.swing.JLabel();
        ico4 = new javax.swing.JLabel();
        ico5 = new javax.swing.JLabel();
        nuevo = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btsalir = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        combo = new javax.swing.JComboBox<>();

        jMenuItem1.setText("Modificar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Eliminar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Control de Productos");
        setName("eli"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(204, 0, 204));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setText("Precio");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, 60, -1));

        jLabel6.setBackground(new java.awt.Color(204, 0, 204));
        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setText("Stock");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, 60, -1));

        jLabel7.setBackground(new java.awt.Color(204, 0, 204));
        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setText("Codigo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, 70, -1));

        descripcion.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel1.add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 170, 30));

        jLabel4.setBackground(new java.awt.Color(204, 0, 204));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setText("Empresa");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 70, -1));

        jLabel3.setBackground(new java.awt.Color(204, 0, 204));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setText("Descripcion");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 90, -1));

        jLabel1.setBackground(new java.awt.Color(204, 0, 204));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 70, 20));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 960, 180));

        empresa.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel1.add(empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 170, 30));

        precio.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel1.add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, 170, 30));

        stock.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel1.add(stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, 170, 30));

        nombre.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 170, 30));

        code.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        code.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        code.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(code, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 313, 90, 30));

        ico1.setToolTipText("Este campo no puede estar vacio");
        jPanel1.add(ico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, -1, 30));

        ico2.setToolTipText("Este campo no puede estar vacio");
        jPanel1.add(ico2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, -1, 30));

        ico3.setToolTipText("Este campo no puede estar vacio");
        jPanel1.add(ico3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, -1, 30));

        ico4.setToolTipText("Este campo no puede estar vacio");
        jPanel1.add(ico4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 230, -1, 30));

        ico5.setToolTipText("Este campo no puede estar vacio");
        jPanel1.add(ico5, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 270, -1, 30));

        nuevo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        nuevo.setText("Nuevo");
        nuevo.setToolTipText("Crear nuevo registro");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        jPanel1.add(nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 80, 40));

        guardar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        guardar.setText("Guardar");
        guardar.setToolTipText("Guardar nuevo registro");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jPanel1.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, 90, 40));

        actualizar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        actualizar.setText("Actualizar");
        actualizar.setToolTipText("Actualizar registro");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });
        jPanel1.add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 100, 40));

        cancelar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setToolTipText("Limpiar o cancelar registro");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 390, 90, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1020, 450));

        jPanel3.setBackground(new java.awt.Color(51, 51, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Control de productos");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        btsalir.setText("Salir");
        btsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsalirActionPerformed(evt);
            }
        });
        jPanel3.add(btsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, 70, -1));

        txtbuscar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtbuscar.setToolTipText("Enter para buscar");
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
        });
        jPanel3.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 210, -1));

        combo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nombre", "Descripcion", "Empresa", "Precio", "Stock" }));
        jPanel3.add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 110, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed
        buscar(combo.getSelectedItem().toString());
    }//GEN-LAST:event_txtbuscarKeyPressed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        limpiar();
        desbloquear();
        nuevo.setEnabled(false);
        guardar.setEnabled(true);
        actualizar.setEnabled(false);
        cancelar.setEnabled(true);
    }//GEN-LAST:event_nuevoActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        cont=0;
        validar();
        //si todos son invisibles hacer insert si no, mensaje de llenar campos
        if (ico1.isVisible() || ico2.isVisible() || ico3.isVisible() || ico4.isVisible() || ico5.isVisible()) {
            JOptionPane.showMessageDialog(null,"Llenó todos los campos?");
        }
        else {
            try {
                PreparedStatement pst = cn.prepareStatement("INSERT INTO productos (nombre_prod, descripcion_prod, nomEmp, precio_prod, stock_prod) VALUES (?,?,?,?,?)");
                pst.setString(1, nombre.getText());
                pst.setString(2, descripcion.getText());
                pst.setString(3, empresa.getText());
                pst.setString(4, precio.getText());
                pst.setString(5, stock.getText());
                pst.executeUpdate();
                mostrardatos("");
                JOptionPane.showMessageDialog(null,"Registro guardado");

                nuevo.setEnabled(true);
                guardar.setEnabled(false);
                actualizar.setEnabled(false);
                cancelar.setEnabled(false);
                
                limpiar();

                bloquear();
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }

    }//GEN-LAST:event_guardarActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        cont=0;
        validar();
        //si todos son invisibles hacer update si no, mensaje de llenar campos
        if (ico1.isVisible() || ico2.isVisible() || ico3.isVisible() || ico4.isVisible() || ico5.isVisible()) {
            JOptionPane.showMessageDialog(null,"Llenó todos los campos?");
        }
        else{
            try {
                PreparedStatement pst = cn.prepareStatement("UPDATE productos SET nombre_prod='"+nombre.getText()+"', descripcion_prod='"+descripcion.getText()+"', "
                        + "nomEmp='"+empresa.getText()+"', precio_prod='"+precio.getText()+"', stock_prod='"+stock.getText()+"' WHERE cod_prod='"+code.getText()+"'");
                pst.executeUpdate();
                mostrardatos("");
                JOptionPane.showMessageDialog(null,"Registro actualizado");

                limpiar();
                bloquear();
                nuevo.setEnabled(true);
                guardar.setEnabled(false);
                actualizar.setEnabled(false);
                cancelar.setEnabled(false);

            }catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }
    }//GEN-LAST:event_actualizarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        limpiar();
        nuevo.setEnabled(true);
        guardar.setEnabled(false);
        actualizar.setEnabled(false);
        cancelar.setEnabled(false);
        bloquear();
        iconos();
    }//GEN-LAST:event_cancelarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int fila= tbdatos.getSelectedRow();
        if(fila>=0){
            code.setText(tbdatos.getValueAt(fila, 0).toString());
            nombre.setText(tbdatos.getValueAt(fila, 1).toString());
            descripcion.setText(tbdatos.getValueAt(fila, 2).toString());
            empresa.setText(tbdatos.getValueAt(fila, 3).toString());
            precio.setText(tbdatos.getValueAt(fila, 4).toString());
            stock.setText(tbdatos.getValueAt(fila, 5).toString());
            iconos();
        }
        else{
            JOptionPane.showMessageDialog(null,"no seleciono fila");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        int fila = tbdatos.getSelectedRow();
        String cod="";
        cod=tbdatos.getValueAt(fila, 0).toString();

        try {
            PreparedStatement pst = cn.prepareStatement("DELETE FROM productos WHERE cod_prod='"+cod+"'");
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null,"Registro eliminado");
            mostrardatos("");

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsalirActionPerformed
        Principal obj=new Principal();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btsalirActionPerformed

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
            java.util.logging.Logger.getLogger(registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JButton btsalir;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel code;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JTextField descripcion;
    private javax.swing.JTextField empresa;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel ico1;
    private javax.swing.JLabel ico2;
    private javax.swing.JLabel ico3;
    private javax.swing.JLabel ico4;
    private javax.swing.JLabel ico5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton nuevo;
    private javax.swing.JTextField precio;
    private javax.swing.JTextField stock;
    private javax.swing.JTable tbdatos;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
LaBodeguita cc=new LaBodeguita();
Connection cn = cc.getConnection();
}
