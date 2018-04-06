package labodeguita;
//anular campos vacios
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RegistroDeProveedores extends javax.swing.JFrame {

    public RegistroDeProveedores() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrardatosProve("");
        
        bloquear();
        
        nuevo.setEnabled(true);
        guardar.setEnabled(false);
        actualizar.setEnabled(false);
        cancelar.setEnabled(false);
        
        ico1.setVisible(false);
        ico2.setVisible(false);
        ico3.setVisible(false);
        ico4.setVisible(false);
        ico5.setVisible(false);
        ico6.setVisible(false);
        ico7.setVisible(false);
    }
    
    int cont=0;
    public void validar(){
        if(nomProv.getText().equals("")){ico1.setVisible(true);cont++;}              else{ico1.setVisible(false);}
        if(apeProv.getText().equals("")){ico2.setVisible(true);cont++;}              else{ico2.setVisible(false);}
        if(telProv.getText().equals("")){ico3.setVisible(true);cont++;}              else{ico3.setVisible(false);}
        if(nomEmpre.getText().equals("")){ico4.setVisible(true);cont++;}              else{ico4.setVisible(false);}
        if(telEmpre.getText().equals("")){ico5.setVisible(true);cont++;}              else{ico5.setVisible(false);}
        if(correoEmpre.getText().equals("")){ico6.setVisible(true);cont++;}              else{ico6.setVisible(false);}
        if(dirEmpre.getText().equals("")){ico7.setVisible(true);cont++;}              else{ico7.setVisible(false);}
    }
    
    void mostrardatosProve(String valor){
       DefaultTableModel modelo= new DefaultTableModel();
       modelo.addColumn("CODIGO");
       modelo.addColumn("NOMBRE PROVEEDOR");
       modelo.addColumn("APELLIDO PROVEEDOR");
       modelo.addColumn("TELEFONO PROVEEDOR");
       modelo.addColumn("EMPRESA");
       modelo.addColumn("TELEFONO EMPRESA");
       modelo.addColumn("CORREO EMPRESA");
       modelo.addColumn("DIRECCION EMPRESA");
    tbdatos.setModel(modelo);
    String sql="";
    if(valor.equals(""))
    {
        sql="SELECT * FROM proveedores";
    }
    else{
        sql="SELECT * FROM proveedores WHERE id_prove='"+valor+"'";
    }
 
    String []datos = new String [20];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString("id_prove");
                datos[1]=rs.getString("nom_prove");
                datos[2]=rs.getString("ape_prove");
                datos[3]=rs.getString("tel_prove");
                datos[4]=rs.getString("nomEmp");
                datos[5]=rs.getString("tel_emp");
                datos[6]=rs.getString("correo_emp");
                datos[7]=rs.getString("dir_emp");
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
       modelo.addColumn("NOMBRE PROVEEDOR");
       modelo.addColumn("APELLIDO PROVEEDOR");
       modelo.addColumn("TELEFONO PROVEEDOR");
       modelo.addColumn("EMPRESA");
       modelo.addColumn("TELEFONO EMPRESA");
       modelo.addColumn("CORREO EMPRESA");
       modelo.addColumn("DIRECCION EMPRESA");
       tbdatos.setModel(modelo);

       String consultar=null;
       if (filtro.equals("Nombre")) {
           consultar="SELECT * FROM proveedores WHERE nom_prove LIKE '%"+txtbuscar.getText() + "%'";
       }
       else if (filtro.equals("Codigo")) {
           consultar="SELECT * FROM proveedores WHERE id_prove LIKE '%"+txtbuscar.getText() + "%'";
       }
       else if (filtro.equals("Empresa")) {
           consultar="SELECT * FROM proveedores WHERE nomEmp LIKE '%"+txtbuscar.getText() + "%'";
       }
       else if (filtro.equals("Telefono")) {
           consultar="SELECT * FROM proveedores WHERE tel_emp LIKE '%"+txtbuscar.getText() + "%'";
       }
       String []datos= new String[15];
       try {
           Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(consultar);
            while(rs.next())
            {
                datos[0]=rs.getString("id_prove");
                datos[1]=rs.getString("nom_prove");
                datos[2]=rs.getString("ape_prove");
                datos[3]=rs.getString("tel_prove");
                datos[4]=rs.getString("nomEmp");
                datos[5]=rs.getString("tel_emp");
                datos[6]=rs.getString("correo_emp");
                datos[7]=rs.getString("dir_emp");
                modelo.addRow(datos);
            }
            tbdatos.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void bloquear(){
        nomProv.setEnabled(false);
        apeProv.setEnabled(false);
        nomEmpre.setEnabled(false);
        telProv.setEnabled(false);
        telEmpre.setEnabled(false);
        correoEmpre.setEnabled(false);
        cod.setEnabled(false);
        dirEmpre.setEnabled(false);
    }
    
    void desbloquear(){
        nomProv.setEnabled(true);
        apeProv.setEnabled(true);
        nomEmpre.setEnabled(true);
        telProv.setEnabled(true);
        telEmpre.setEnabled(true);
        correoEmpre.setEnabled(true);
        cod.setEnabled(true);
        dirEmpre.setEnabled(true);
    }
    
    void limpiar(){
        txtbuscar.setText("");
        nomProv.setText("");
        apeProv.setText("");
        nomEmpre.setText("");
        telProv.setText("");
        telEmpre.setText("");
        correoEmpre.setText("");
        cod.setText("");
        dirEmpre.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        combo = new javax.swing.JComboBox<>();
        txtbuscar = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        telProv = new javax.swing.JTextField();
        apeProv = new javax.swing.JTextField();
        nomProv = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cod = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdatos = new javax.swing.JTable();
        cancelar = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        nuevo = new javax.swing.JButton();
        correoEmpre = new javax.swing.JTextField();
        dirEmpre = new javax.swing.JTextField();
        telEmpre = new javax.swing.JTextField();
        nomEmpre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        ico1 = new javax.swing.JLabel();
        ico2 = new javax.swing.JLabel();
        ico3 = new javax.swing.JLabel();
        ico4 = new javax.swing.JLabel();
        ico5 = new javax.swing.JLabel();
        ico6 = new javax.swing.JLabel();
        ico7 = new javax.swing.JLabel();

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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 51, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de proveedores");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 380, -1));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, 80, -1));

        combo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Codigo", "Empresa", "Telefono" }));
        jPanel2.add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 110, -1));

        txtbuscar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtbuscar.setToolTipText("Enter para buscar");
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
        });
        jPanel2.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 200, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 60));

        jPanel3.setBackground(new java.awt.Color(0, 102, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Direccion de la empresa");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 190, -1));

        telProv.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel3.add(telProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 180, 30));

        apeProv.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel3.add(apeProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 180, 30));

        nomProv.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel3.add(nomProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 180, 30));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Codigo");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 60, 20));

        cod.setEditable(false);
        cod.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 70, 30));

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
        tbdatos.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tbdatos);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 990, 160));

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel3.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, 80, 50));

        actualizar.setText("Actualizar");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });
        jPanel3.add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, 90, 50));

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jPanel3.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, 80, 50));

        nuevo.setText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        jPanel3.add(nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 70, 50));

        correoEmpre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel3.add(correoEmpre, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 290, 180, 30));

        dirEmpre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel3.add(dirEmpre, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 330, 180, 30));

        telEmpre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel3.add(telEmpre, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 250, 180, 30));

        nomEmpre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel3.add(nomEmpre, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, 180, 30));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Telefono del proveedor");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 190, -1));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Telefono de la empresa");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 190, -1));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Correo de la empresa");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 170, -1));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Nombre del proveedor");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 180, -1));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Apellido del proveedor");
        jLabel16.setToolTipText("");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 190, -1));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Nombre de la empresa");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 180, -1));
        jPanel3.add(ico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, -1, 20));
        jPanel3.add(ico2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, -1, 20));
        jPanel3.add(ico3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, -1, 20));
        jPanel3.add(ico4, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 210, -1, 20));
        jPanel3.add(ico5, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 250, -1, 20));
        jPanel3.add(ico6, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 290, -1, 20));
        jPanel3.add(ico7, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 330, -1, 20));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1040, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        limpiar();
        nuevo.setEnabled(true);
        guardar.setEnabled(false);
        actualizar.setEnabled(false);
        cancelar.setEnabled(false);
        bloquear();
    }//GEN-LAST:event_cancelarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        cont=0;
        validar();
        //si todos son invisibles hacer insert si no, mensaje de llenar campos
        if (ico1.isVisible() || ico2.isVisible() || ico3.isVisible() || ico4.isVisible() 
            || ico5.isVisible() || ico6.isVisible() || ico7.isVisible()) {
            JOptionPane.showMessageDialog(null,"Llenó todos los campos?");
        }
        else {
        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO proveedores (nom_prove, ape_prove, tel_prove, nomEmp, tel_emp, correo_emp, dir_emp)VALUES (?,?,?,?,?,?,?)");
            pst.setString(1, nomProv.getText());
            pst.setString(2, apeProv.getText());
            pst.setString(3, telProv.getText());
            pst.setString(4, nomEmpre.getText());
            pst.setString(5, telEmpre.getText());
            pst.setString(6, correoEmpre.getText());
            pst.setString(7, dirEmpre.getText());
            int n=pst.executeUpdate();
            
            if (n>0){
                JOptionPane.showMessageDialog(null,"Registro guardado");
            }
        } catch (Exception e){}
        mostrardatosProve("");
        nuevo.setEnabled(true);
        guardar.setEnabled(false);
        actualizar.setEnabled(false);
        cancelar.setEnabled(false);
        bloquear();
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int fila= tbdatos.getSelectedRow();
        if(fila>=0){
            cod.setText(tbdatos.getValueAt(fila, 0).toString());
            nomProv.setText(tbdatos.getValueAt(fila, 1).toString());
            apeProv.setText(tbdatos.getValueAt(fila, 2).toString());
            telProv.setText(tbdatos.getValueAt(fila, 3).toString());
            nomEmpre.setText(tbdatos.getValueAt(fila, 4).toString());
            telEmpre.setText(tbdatos.getValueAt(fila, 5).toString());
            correoEmpre.setText(tbdatos.getValueAt(fila, 6).toString());
            dirEmpre.setText(tbdatos.getValueAt(fila, 7).toString());
        }
        else{
            JOptionPane.showMessageDialog(null,"no seleciono fila");
        }
        nuevo.setEnabled(false);
        guardar.setEnabled(false);
        actualizar.setEnabled(true);
        cancelar.setEnabled(true);
        desbloquear();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        int fila = tbdatos.getSelectedRow();
        String cod="";
        cod=tbdatos.getValueAt(fila, 0).toString();

        try {
            PreparedStatement pst = cn.prepareStatement("DELETE FROM proveedores WHERE id_Prove='"+cod+"'");
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null,"Registro eliminado");
            mostrardatosProve("");

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        limpiar();
        desbloquear();
        nuevo.setEnabled(false);
        guardar.setEnabled(true);
        actualizar.setEnabled(false);
        cancelar.setEnabled(true);
    }//GEN-LAST:event_nuevoActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        cont=0;
        validar();
        //si todos son invisibles hacer update si no, mensaje de llenar campos
        if (ico1.isVisible() || ico2.isVisible() || ico3.isVisible() || ico4.isVisible() 
            || ico5.isVisible() || ico6.isVisible() || ico7.isVisible()) {
            JOptionPane.showMessageDialog(null,"Llenó todos los campos?");
        }
        else{
            try {                                                                                                                           //ape_prove, tel_prove, nomEmp, tel_emp, correo_emp)VALUES (?,?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement("UPDATE proveedores SET nom_prove='"+nomProv.getText()+"', ape_prove='"+apeProv.getText()+"', tel_prove='"+telProv.getText()+"', nomEmp='"+nomEmpre.getText()+"', tel_emp='"+telEmpre.getText()+"', correo_emp='"+correoEmpre.getText()+"', dir_emp='"+dirEmpre.getText()+"' WHERE id_Prove='"+cod.getText()+"'");
                pst.executeUpdate();
                mostrardatosProve("");
                limpiar();
                bloquear();
                nuevo.setEnabled(true);
                guardar.setEnabled(false);
                actualizar.setEnabled(false);
                cancelar.setEnabled(false);
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }
    }//GEN-LAST:event_actualizarActionPerformed

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed
        buscar(combo.getSelectedItem().toString());
    }//GEN-LAST:event_txtbuscarKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Principal obj=new Principal();
        obj.setVisible(true);
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
    private javax.swing.JButton actualizar;
    private javax.swing.JTextField apeProv;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField cod;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JTextField correoEmpre;
    private javax.swing.JTextField dirEmpre;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel ico1;
    private javax.swing.JLabel ico2;
    private javax.swing.JLabel ico3;
    private javax.swing.JLabel ico4;
    private javax.swing.JLabel ico5;
    private javax.swing.JLabel ico6;
    private javax.swing.JLabel ico7;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomEmpre;
    private javax.swing.JTextField nomProv;
    private javax.swing.JButton nuevo;
    private javax.swing.JTable tbdatos;
    private javax.swing.JTextField telEmpre;
    private javax.swing.JTextField telProv;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
LaBodeguita cc=new LaBodeguita();
Connection cn = cc.getConnection();
}

