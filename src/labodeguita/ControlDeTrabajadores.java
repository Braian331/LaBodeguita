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

public class ControlDeTrabajadores extends javax.swing.JFrame {

    public ControlDeTrabajadores() {
            initComponents();
        this.setLocationRelativeTo(null);
        
        ico1.setVisible(false);
        ico2.setVisible(false);
        ico3.setVisible(false);
        ico4.setVisible(false);
        ico5.setVisible(false);
        ico6.setVisible(false);
        ico7.setVisible(false);
        ico8.setVisible(false);
        
        mostrardatos("");
        
        nuevo.setEnabled(true);
        guardar.setEnabled(false);
        actualizar.setEnabled(false);
        cancelar.setEnabled(false);
        
        bloquear();
    }
    
    int cont=0;
    public void validar(){
        if(txtnom.getText().equals("")){ico1.setVisible(true);cont++;}              else{ico1.setVisible(false);}
        if(txtape.getText().equals("")){ico2.setVisible(true);cont++;}              else{ico2.setVisible(false);}
        if(txtpass.getText().equals("")){ico3.setVisible(true);cont++;}              else{ico3.setVisible(false);}
        if(txtsex.getText().equals("")){ico4.setVisible(true);cont++;}              else{ico4.setVisible(false);}
        if(txtfechaNacim.getText().equals("")){ico5.setVisible(true);cont++;}              else{ico5.setVisible(false);}
        if(txttelefono.getText().equals("")){ico6.setVisible(true);cont++;}              else{ico6.setVisible(false);}
        if(txtturno.getText().equals("")){ico7.setVisible(true);cont++;}              else{ico7.setVisible(false);}
        if(txtcargo.getText().equals("")){ico8.setVisible(true);cont++;}              else{ico8.setVisible(false);}
    }
    
    void mostrardatos(String valor){
    DefaultTableModel modelo= new DefaultTableModel();
       modelo.addColumn("ID");
       modelo.addColumn("NOMBRE");
       modelo.addColumn("APELLIDO");
       modelo.addColumn("SEXO");
       modelo.addColumn("TELEFONO");
       modelo.addColumn("TURNO");
       modelo.addColumn("FECHA NACIM");
       modelo.addColumn("PASSWORD");
       modelo.addColumn("CARGO");
    tbdatos.setModel(modelo);
    String sql="";
    if(valor.equals(""))
    {
        sql="SELECT * FROM trabajadores";
    }
    else{
        sql="SELECT * FROM trabajadores WHERE id_trab='"+valor+"'";
    }
 
    String []datos = new String [9];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString("id_trab");
                datos[1]=rs.getString("nom_trab");
                datos[2]=rs.getString("apellidos_trab");
                datos[3]=rs.getString("sexo_trab");
                datos[4]=rs.getString("telefono_trab");
                datos[5]=rs.getString("turno_trab");
                datos[6]=rs.getString("fNacim_trab");
                datos[7]=rs.getString("password");
                datos[8]=rs.getString("cargo");
                modelo.addRow(datos);
            }
            tbdatos.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(ControlDeVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void buscar(String filtro){
    DefaultTableModel modelo= new DefaultTableModel();
       modelo.addColumn("ID");
       modelo.addColumn("NOMBRE");
       modelo.addColumn("APELLIDO");
       modelo.addColumn("SEXO");
       modelo.addColumn("TELEFONO");
       modelo.addColumn("TURNO");
       modelo.addColumn("FECHA NACIM");
       modelo.addColumn("PASSWORD");
       modelo.addColumn("CARGO");
       tbdatos.setModel(modelo);

       String consultar=null;
       if (filtro.equals("Codigo")) {
           consultar="SELECT * FROM trabajadores WHERE id_trab LIKE '%"+txtbuscar.getText() + "%'";
       }
       else if (filtro.equals("Telefono")) {
           consultar="SELECT * FROM trabajadores WHERE telefono_trab LIKE '%"+txtbuscar.getText() + "%'";
       }
       else if (filtro.equals("Nombre")) {
           consultar="SELECT * FROM trabajadores WHERE nom_trab LIKE '%"+txtbuscar.getText() + "%'";
       }
       else if (filtro.equals("Apellido")) {
           consultar="SELECT * FROM trabajadores WHERE apellidos_trab LIKE '%"+txtbuscar.getText() + "%'";
       }
       else if (filtro.equals("Cargo")) {
           consultar="SELECT * FROM trabajadores WHERE cargo LIKE '%"+txtbuscar.getText() + "%'";
       }

       String []datos= new String[15];
       try {
           Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(consultar);
            while(rs.next())
            {
                datos[0]=rs.getString("id_trab");
                datos[1]=rs.getString("nom_trab");
                datos[2]=rs.getString("apellidos_trab");
                datos[3]=rs.getString("sexo_trab");
                datos[4]=rs.getString("telefono_trab");
                datos[5]=rs.getString("turno_trab");
                datos[6]=rs.getString("fNacim_trab");
                datos[7]=rs.getString("password");
                datos[8]=rs.getString("cargo");
                modelo.addRow(datos);
            }
            tbdatos.setModel(modelo);

        } catch (SQLException ex) {
            Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void bloquear(){
        txtnom.setEnabled(false);
        txtape.setEnabled(false);
        txtpass.setEnabled(false);
        txtsex.setEnabled(false);
        txtfechaNacim.setEnabled(false);
        txttelefono.setEnabled(false);
        txtturno.setEnabled(false);
        txtcargo.setEnabled(false);
    }
    
    void desbloquear(){
        txtnom.setEnabled(true);
        txtape.setEnabled(true);
        txtpass.setEnabled(true);
        txtsex.setEnabled(true);
        txtfechaNacim.setEnabled(true);
        txttelefono.setEnabled(true);
        txtturno.setEnabled(true);
        txtcargo.setEnabled(true);
    }
    
    void limpiar(){
        txtnom.setText("");
        txtape.setText("");
        txtpass.setText("");
        txtsex.setText("");
        txtfechaNacim.setText("");
        txttelefono.setText("");
        txtturno.setText("");
        txtcargo.setText("");
        txtcod.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtnom = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtsex = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtturno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        actualizar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        nuevo = new javax.swing.JButton();
        txtpass = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtape = new javax.swing.JTextField();
        txtcargo = new javax.swing.JTextField();
        txtfechaNacim = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdatos = new javax.swing.JTable();
        guardar = new javax.swing.JButton();
        ico1 = new javax.swing.JLabel();
        ico2 = new javax.swing.JLabel();
        ico3 = new javax.swing.JLabel();
        ico4 = new javax.swing.JLabel();
        ico5 = new javax.swing.JLabel();
        ico6 = new javax.swing.JLabel();
        ico7 = new javax.swing.JLabel();
        ico8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btsalir = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        combo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtnom.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(txtnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 202, 160, 30));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, 20));

        txtsex.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(txtsex, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 202, 160, 30));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel2.setText("Apellido");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, 20));

        txttelefono.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 282, 160, 30));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel5.setText("Tel/Cel");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, -1, 20));

        txtturno.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(txtturno, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 202, 160, 30));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel6.setText("Fecha de nacimiento");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, -1, 20));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel7.setText("Sexo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, -1, 20));

        actualizar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        actualizar.setText("Actualizar");
        actualizar.setToolTipText("Actualizar registro");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });
        jPanel1.add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 100, 40));

        cancelar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setToolTipText("Limpiar o cancelar registro");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 370, 90, 40));

        nuevo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        nuevo.setText("Nuevo");
        nuevo.setToolTipText("Crear nuevo registro");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        jPanel1.add(nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 80, 40));

        txtpass.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 282, 160, 30));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel10.setText("Contraseña");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, 20));

        txtcod.setEditable(false);
        txtcod.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtcod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 282, 70, 30));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel4.setText("Codigo");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 290, -1, 20));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel8.setText("Cargo");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 250, -1, 20));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel13.setText("Turno");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 210, -1, 20));

        txtape.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(txtape, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 242, 160, 30));

        txtcargo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(txtcargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 242, 160, 30));

        txtfechaNacim.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(txtfechaNacim, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 242, 160, 30));

        tbdatos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1040, 160));

        guardar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        guardar.setText("Guardar");
        guardar.setToolTipText("Guardar nuevo registro");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jPanel1.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 90, 40));
        jPanel1.add(ico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, -1, 20));
        jPanel1.add(ico2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, 20));
        jPanel1.add(ico3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, -1, 20));
        jPanel1.add(ico4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 210, -1, 20));
        jPanel1.add(ico5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, -1, 20));
        jPanel1.add(ico6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, -1, 20));
        jPanel1.add(ico7, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 210, -1, 20));
        jPanel1.add(ico8, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 250, -1, 20));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Control de trabajadores");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        btsalir.setText("Salir");
        jPanel3.add(btsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, 70, -1));

        txtbuscar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtbuscar.setToolTipText("Enter para buscar");
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
        });
        jPanel3.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 210, -1));

        combo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "tipo de busqueda", "Codigo", "Telefono", "Nombre", "Apellido", "Cargo" }));
        jPanel3.add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 130, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1090, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1090, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        cont=0;
        validar();
        //si todos son invisibles hacer update si no, mensaje de llenar campos
        if (ico1.isVisible() || ico2.isVisible() || ico3.isVisible() || ico4.isVisible()
            || ico5.isVisible() || ico6.isVisible() || ico7.isVisible() || ico8.isVisible()) {
            JOptionPane.showMessageDialog(null,"Llenó todos los campos?");
        }
        else{
            try {
                PreparedStatement pst = cn.prepareStatement("UPDATE trabajadores SET nom_trab='"+txtnom.getText()+"', apellidos_trab='"+txtape.getText()+"', sexo_trab='"+txtsex.getText()+"', telefono_trab='"+txttelefono.getText()+"',  "
                    + "turno_trab='"+txtturno.getText()+"',  fNacim_trab='"+txtfechaNacim.getText()+"',  password='"+txtpass.getText()+"',  cargo='"+txtcargo.getText()+"' WHERE id_trab='"+txtcod.getText()+"'");
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
    }//GEN-LAST:event_cancelarActionPerformed

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
        if (ico1.isVisible() || ico2.isVisible() || ico3.isVisible() || ico4.isVisible()
            || ico5.isVisible() || ico6.isVisible() || ico7.isVisible() || ico8.isVisible()) {
            JOptionPane.showMessageDialog(null,"Llenó todos los campos?");
        }
        else {
            try {
                PreparedStatement pst = cn.prepareStatement("INSERT INTO trabajadores (nom_trab, apellidos_trab, sexo_trab, telefono_trab, turno_trab, fNacim_trab, password, cargo) VALUES (?,?,?,?,?,?,?,?)");
                pst.setString(1, txtnom.getText());
                pst.setString(2, txtape.getText());
                pst.setString(3, txtsex.getText());
                pst.setString(4, txttelefono.getText());
                pst.setString(5, txtturno.getText());
                pst.setString(6, txtfechaNacim.getText());
                pst.setString(7, txtpass.getText());
                pst.setString(8, txtcargo.getText());
                pst.executeUpdate();
                mostrardatos("");
                JOptionPane.showMessageDialog(null,"Registro guardado");

                nuevo.setEnabled(true);
                guardar.setEnabled(false);
                actualizar.setEnabled(false);
                cancelar.setEnabled(false);

                bloquear();
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }

    }//GEN-LAST:event_guardarActionPerformed

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed
        buscar(combo.getSelectedItem().toString());
    }//GEN-LAST:event_txtbuscarKeyPressed

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
            java.util.logging.Logger.getLogger(ControlDeTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlDeTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlDeTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlDeTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControlDeTrabajadores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JButton btsalir;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel ico1;
    private javax.swing.JLabel ico2;
    private javax.swing.JLabel ico3;
    private javax.swing.JLabel ico4;
    private javax.swing.JLabel ico5;
    private javax.swing.JLabel ico6;
    private javax.swing.JLabel ico7;
    private javax.swing.JLabel ico8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nuevo;
    private javax.swing.JTable tbdatos;
    private javax.swing.JTextField txtape;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcargo;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtfechaNacim;
    private javax.swing.JTextField txtnom;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtsex;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txtturno;
    // End of variables declaration//GEN-END:variables
LaBodeguita cc=new LaBodeguita();
Connection cn = cc.getConnection();
}
