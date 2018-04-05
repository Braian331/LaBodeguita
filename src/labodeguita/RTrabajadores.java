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

public class RTrabajadores extends javax.swing.JFrame {

    /**
     * Creates new form RTrabajadores
     */
    public RTrabajadores() {
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
        
        privilegio(combo1.getSelectedItem().toString());
    }
    
    void privilegio(String filtro){
        if (filtro.equals("Administrador")) priv.setText("Admin");
        
        if (filtro.equals("Invitado")) priv.setText("Invitado");
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
       modelo.addColumn("PRIVILEGIO");
    tbdatos.setModel(modelo);
    String sql="";
    if(valor.equals(""))
    {
        sql="SELECT * FROM trabajadores";
    }
    else{
        sql="SELECT * FROM trabajadores WHERE id_trab='"+valor+"'";
    }
 
    String []datos = new String [10];
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
                datos[9]=rs.getString("priv");
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
       modelo.addColumn("PRIVILEGIO");
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
                datos[9]=rs.getString("priv");
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
        combo1.setEnabled(false);
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
        combo1.setEnabled(true);
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
    
    void iconos(){
        ico1.setVisible(false);
        ico2.setVisible(false);
        ico3.setVisible(false);
        ico4.setVisible(false);
        ico5.setVisible(false);
        ico6.setVisible(false);
        ico7.setVisible(false);
        ico8.setVisible(false);
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
        txtcod = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        priv = new javax.swing.JTextField();
        combo1 = new javax.swing.JComboBox<>();
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
        setTitle("Control de trabajadores");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 204, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtnom.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(txtnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 160, -1));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, 20));

        txtsex.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(txtsex, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 160, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel2.setText("Apellido");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, 20));

        txttelefono.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, 160, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel5.setText("Tel/Cel");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, -1, 20));

        txtturno.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(txtturno, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 230, 160, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel6.setText("Fecha de nacimiento");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, -1, 20));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel7.setText("Sexo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, -1, 20));

        actualizar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        actualizar.setText("Actualizar");
        actualizar.setToolTipText("Actualizar registro");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });
        jPanel1.add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 380, 100, 40));

        cancelar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setToolTipText("Limpiar o cancelar registro");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 380, 90, 40));

        nuevo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        nuevo.setText("Nuevo");
        nuevo.setToolTipText("Crear nuevo registro");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        jPanel1.add(nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, 80, 40));

        txtpass.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 160, -1));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel10.setText("Contraseña");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, 20));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel4.setText("Codigo");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, -1, 20));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel8.setText("Cargo");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 270, 50, 20));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel13.setText("Turno");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 230, 50, 20));

        txtape.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(txtape, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 160, -1));

        txtcargo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(txtcargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 270, 160, -1));

        txtfechaNacim.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(txtfechaNacim, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 160, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1040, 160));

        guardar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        guardar.setText("Guardar");
        guardar.setToolTipText("Guardar nuevo registro");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jPanel1.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, 90, 40));

        ico1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Braian Canjay\\Desktop\\DES AP 1\\32x32.png")); // NOI18N
        jPanel1.add(ico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, 20));

        ico2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Braian Canjay\\Desktop\\DES AP 1\\32x32.png")); // NOI18N
        jPanel1.add(ico2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, -1, 20));

        ico3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Braian Canjay\\Desktop\\DES AP 1\\32x32.png")); // NOI18N
        jPanel1.add(ico3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, -1, 20));

        ico4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Braian Canjay\\Desktop\\DES AP 1\\32x32.png")); // NOI18N
        jPanel1.add(ico4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, -1, 20));

        ico5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Braian Canjay\\Desktop\\DES AP 1\\32x32.png")); // NOI18N
        jPanel1.add(ico5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, -1, 20));

        ico6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Braian Canjay\\Desktop\\DES AP 1\\32x32.png")); // NOI18N
        jPanel1.add(ico6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 310, -1, 20));

        ico7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Braian Canjay\\Desktop\\DES AP 1\\32x32.png")); // NOI18N
        jPanel1.add(ico7, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 230, -1, 20));

        ico8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Braian Canjay\\Desktop\\DES AP 1\\32x32.png")); // NOI18N
        jPanel1.add(ico8, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 270, -1, 20));

        txtcod.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtcod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtcod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 80, 20));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel9.setText("Privilegio");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 310, 70, 20));

        priv.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(priv, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 310, 140, -1));

        combo1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        combo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Invitado", "Administrador" }));
        combo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo1ActionPerformed(evt);
            }
        });
        jPanel1.add(combo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 310, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1090, 450));

        jPanel3.setBackground(new java.awt.Color(0, 153, 51));
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
        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Telefono", "Nombre", "Apellido", "Cargo" }));
        jPanel3.add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 110, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 60));

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
            PreparedStatement pst = cn.prepareStatement("UPDATE trabajadores SET nom_trab='"+txtnom.getText()+"', apellidos_trab='"+txtape.getText()+"', "
                    + "sexo_trab='"+txtsex.getText()+"', telefono_trab='"+txttelefono.getText()+"',  turno_trab='"+txtturno.getText()+"',  "
                    + "fNacim_trab='"+txtfechaNacim.getText()+"',  password='"+txtpass.getText()+"',  cargo='"+txtcargo.getText()+"',  "
                    + "priv='"+priv.getText()+"' WHERE id_trab='"+txtcod.getText()+"'");
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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int fila= tbdatos.getSelectedRow();
        if(fila>=0){
            txtcod.setText(tbdatos.getValueAt(fila, 0).toString());
            txtnom.setText(tbdatos.getValueAt(fila, 1).toString());
            txtape.setText(tbdatos.getValueAt(fila, 2).toString());
            txtsex.setText(tbdatos.getValueAt(fila, 3).toString());
            txttelefono.setText(tbdatos.getValueAt(fila, 4).toString());
            txtturno.setText(tbdatos.getValueAt(fila, 5).toString());
            txtfechaNacim.setText(tbdatos.getValueAt(fila, 6).toString());
            txtpass.setText(tbdatos.getValueAt(fila, 7).toString());
            txtcargo.setText(tbdatos.getValueAt(fila, 8).toString());
            priv.setText(tbdatos.getValueAt(fila, 9).toString());
            iconos();
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
        // TODO add your handling code here:
        int fila = tbdatos.getSelectedRow();
        String cod="";
        cod=tbdatos.getValueAt(fila, 0).toString();

        try {
            PreparedStatement pst = cn.prepareStatement("DELETE FROM trabajadores WHERE id_trab='"+cod+"'");
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null,"Registro eliminado");
            mostrardatos("");

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
                PreparedStatement pst = cn.prepareStatement("INSERT INTO trabajadores (nom_trab, apellidos_trab, sexo_trab, telefono_trab, turno_trab, fNacim_trab, password, cargo, priv) VALUES (?,?,?,?,?,?,?,?,?)");
                pst.setString(1, txtnom.getText());
                pst.setString(2, txtape.getText());
                pst.setString(3, txtsex.getText());
                pst.setString(4, txttelefono.getText());
                pst.setString(5, txtturno.getText());
                pst.setString(6, txtfechaNacim.getText());
                pst.setString(7, txtpass.getText());
                pst.setString(8, txtcargo.getText());
                pst.setString(9, priv.getText());
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

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        limpiar();
        nuevo.setEnabled(true);
        guardar.setEnabled(false);
        actualizar.setEnabled(false);
        cancelar.setEnabled(false);
        bloquear();
        iconos();
    }//GEN-LAST:event_cancelarActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        limpiar();
        desbloquear();
        nuevo.setEnabled(false);
        guardar.setEnabled(true);
        actualizar.setEnabled(false);
        cancelar.setEnabled(true);
    }//GEN-LAST:event_nuevoActionPerformed

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed
        buscar(combo.getSelectedItem().toString());
    }//GEN-LAST:event_txtbuscarKeyPressed

    private void combo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo1ActionPerformed
        // TODO add your handling code here:
        privilegio(combo1.getSelectedItem().toString());
    }//GEN-LAST:event_combo1ActionPerformed

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
            java.util.logging.Logger.getLogger(RTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold> 
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RTrabajadores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JButton btsalir;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JComboBox<String> combo1;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nuevo;
    private javax.swing.JTextField priv;
    private javax.swing.JTable tbdatos;
    private javax.swing.JTextField txtape;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcargo;
    private javax.swing.JLabel txtcod;
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

