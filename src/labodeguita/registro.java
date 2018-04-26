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
    
    public static void limpiar(){
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
    tbdatos2.setModel(modelo);
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
            tbdatos2.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(ControlDeVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void buscarST() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("CODIGO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("EMPRESA");
        modelo.addColumn("PRECIO");
        modelo.addColumn("STOCK");
        tbdatos2.setModel(modelo);

        String consultar = "SELECT * FROM productos WHERE cod_prod = " + txtbuscar.getText();

        String[] datos = new String[15];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consultar);
            while (rs.next()) {
                datos[0] = rs.getString("cod_prod");
                datos[1] = rs.getString("nombre_prod");
                datos[2] = rs.getString("descripcion_prod");
                datos[3] = rs.getString("nomEmp");
                datos[4] = rs.getString("precio_prod");
                datos[5] = rs.getString("stock_prod");
                modelo.addRow(datos);
            }
            tbdatos2.setModel(modelo);
            tbdatos2.selectAll();
        } catch (SQLException ex) {
            Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int fila = tbdatos2.getSelectedRow();
        if (fila >= 0) {
            code.setText(tbdatos2.getValueAt(fila, 0).toString());
            code1.setText(tbdatos2.getValueAt(fila, 0).toString());
            nombre.setText(tbdatos2.getValueAt(fila, 1).toString());
            descripcion.setText(tbdatos2.getValueAt(fila, 2).toString());
            empresa.setText(tbdatos2.getValueAt(fila, 3).toString());
            precio.setText(tbdatos2.getValueAt(fila, 4).toString());
            stock.setText(tbdatos2.getValueAt(fila, 5).toString());
            stockProd.setText(tbdatos2.getValueAt(fila, 5).toString());
            
            ico1.setVisible(false);
            ico2.setVisible(false);
            ico3.setVisible(false);
            ico4.setVisible(false);
            ico5.setVisible(false);

            guardar.setEnabled(false);
            nuevo.setEnabled(false);
            actualizar.setEnabled(true);
            cancelar.setEnabled(true);
            eliminar.setEnabled(true);
            
            desbloquear();
        } else {
            limpiar();
            bloquear();
            guardar.setEnabled(false);
            nuevo.setEnabled(true);
            actualizar.setEnabled(false);
            cancelar.setEnabled(false);
            eliminar.setEnabled(false);
            JOptionPane.showMessageDialog(null, "No existe un producto con el codigo "+txtbuscar.getText());
        }
    }
    
    public void buscarST2(){
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
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        stockProd = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        newStock = new javax.swing.JTextField();
        code1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cant = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdatos2 = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btsalir = new javax.swing.JButton();

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
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, 60, -1));

        jLabel6.setBackground(new java.awt.Color(204, 0, 204));
        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setText("Stock");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 60, -1));

        jLabel7.setBackground(new java.awt.Color(204, 0, 204));
        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel7.setText("Codigo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 70, 30));

        descripcion.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel1.add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 170, 30));

        jLabel4.setBackground(new java.awt.Color(204, 0, 204));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setText("Empresa");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 70, -1));

        jLabel3.setBackground(new java.awt.Color(204, 0, 204));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setText("Descripcion");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 90, -1));

        jLabel1.setBackground(new java.awt.Color(204, 0, 204));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 70, 20));

        empresa.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel1.add(empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 170, 30));

        precio.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel1.add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, 170, 30));

        stock.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel1.add(stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, 170, 30));

        nombre.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 170, 30));

        code.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        code.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        code.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(code, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, 90, 23));

        ico1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Braian Canjay\\Desktop\\DES AP 1\\32x32.png")); // NOI18N
        ico1.setToolTipText("Este campo no puede estar vacio");
        jPanel1.add(ico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, 30));

        ico2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Braian Canjay\\Desktop\\DES AP 1\\32x32.png")); // NOI18N
        ico2.setToolTipText("Este campo no puede estar vacio");
        jPanel1.add(ico2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, -1, 30));

        ico3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Braian Canjay\\Desktop\\DES AP 1\\32x32.png")); // NOI18N
        ico3.setToolTipText("Este campo no puede estar vacio");
        jPanel1.add(ico3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, -1, 30));

        ico4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Braian Canjay\\Desktop\\DES AP 1\\32x32.png")); // NOI18N
        ico4.setToolTipText("Este campo no puede estar vacio");
        jPanel1.add(ico4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 110, -1, 30));

        ico5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Braian Canjay\\Desktop\\DES AP 1\\32x32.png")); // NOI18N
        ico5.setToolTipText("Este campo no puede estar vacio");
        jPanel1.add(ico5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 150, -1, 30));

        nuevo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        nuevo.setText("Nuevo");
        nuevo.setToolTipText("Crear nuevo registro");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        jPanel1.add(nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 80, 40));

        guardar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        guardar.setText("Guardar");
        guardar.setToolTipText("Guardar nuevo registro");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jPanel1.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 90, 40));

        actualizar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        actualizar.setText("Actualizar");
        actualizar.setToolTipText("Actualizar registro");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });
        jPanel1.add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 100, 40));

        cancelar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setToolTipText("Limpiar o cancelar registro");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, 90, 40));

        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton1.setText("Ver Tabla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, -1, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Stock Prod");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, -1, -1));

        stockProd.setText("0");
        jPanel1.add(stockProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, 140, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Nuevo Stock");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, -1, -1));

        newStock.setText("0");
        jPanel1.add(newStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, 140, -1));

        code1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                code1KeyReleased(evt);
            }
        });
        jPanel1.add(code1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 140, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Cod");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Cant");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, -1, -1));
        jPanel1.add(cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 140, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 500, 50));

        txtbuscar.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
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
        jPanel1.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 370, -1));

        jLabel8.setBackground(new java.awt.Color(204, 0, 204));
        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setText("Codigo");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, 70, -1));

        eliminar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        eliminar.setText("Eliminar");
        eliminar.setToolTipText("Limpiar o cancelar registro");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 280, 90, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 990, 510));

        jPanel3.setBackground(new java.awt.Color(51, 51, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Control de productos");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        btsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/x-1.png"))); // NOI18N
        btsalir.setContentAreaFilled(false);
        btsalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/x-2.png"))); // NOI18N
        btsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsalirActionPerformed(evt);
            }
        });
        jPanel3.add(btsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 50, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed
    }//GEN-LAST:event_txtbuscarKeyPressed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        limpiar();
        desbloquear();
        nuevo.setEnabled(false);
        guardar.setEnabled(true);
        actualizar.setEnabled(false);
        cancelar.setEnabled(true);
        txtbuscar.setEnabled(false);
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
                txtbuscar.setEnabled(true);
                eliminar.setEnabled(false);
                txtbuscar.setText("");
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
                eliminar.setEnabled(false);
                txtbuscar.setText("");
            }catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }
    }//GEN-LAST:event_actualizarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        limpiar();
        nuevo.setEnabled(true);
        eliminar.setEnabled(false);
        guardar.setEnabled(false);
        actualizar.setEnabled(false);
        cancelar.setEnabled(false);
        txtbuscar.setEnabled(true);
        txtbuscar.setText("");
        bloquear();
        iconos();
    }//GEN-LAST:event_cancelarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
//        int fila = tbdatos2.getSelectedRow();
//        String cod="";
//        cod=tbdatos2.getValueAt(fila, 0).toString();
//
//        try {
//            PreparedStatement pst = cn.prepareStatement("DELETE FROM productos WHERE cod_prod='"+cod+"'");
//            pst.executeUpdate();
//
//            JOptionPane.showMessageDialog(null,"Registro eliminado");
//            mostrardatos("");
//
//        } catch (Exception e) {
//        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
        if (txtbuscar.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No ingreso un dato a buscar");
            limpiar();
            bloquear();
            guardar.setEnabled(false);
            nuevo.setEnabled(true);
            actualizar.setEnabled(false);
            cancelar.setEnabled(false);
            eliminar.setEnabled(false);
        }
        else{
            buscarST();
            desbloquear();
        }
        
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ReabastecerProd obj=new ReabastecerProd();
        obj.setVisible(true);
        this.dispose();
        ReabastecerProd.comprobador.setText("2");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void code1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_code1KeyReleased
        // TODO add your handling code here: buscar en tbdtos 2 al ser autoselect
        buscarST2();
    }//GEN-LAST:event_code1KeyReleased

    private void btsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsalirActionPerformed
        // TODO add your handling code here:
        Principal obj=new Principal();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btsalirActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        int fila = tbdatos2.getSelectedRow();
        String cod="";
        cod=tbdatos2.getValueAt(fila, 0).toString();

        try {
            PreparedStatement pst = cn.prepareStatement("DELETE FROM productos WHERE cod_prod='"+cod+"'");
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null,"Registro eliminado");
            mostrardatos("");

        } catch (Exception e) {
        }
    }//GEN-LAST:event_eliminarActionPerformed

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
    public static javax.swing.JTextField cant;
    public static javax.swing.JLabel code;
    public static javax.swing.JTextField code1;
    public static javax.swing.JTextField descripcion;
    private javax.swing.JButton eliminar;
    public static javax.swing.JTextField empresa;
    private javax.swing.JButton guardar;
    public static javax.swing.JLabel ico1;
    public static javax.swing.JLabel ico2;
    public static javax.swing.JLabel ico3;
    public static javax.swing.JLabel ico4;
    public static javax.swing.JLabel ico5;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField newStock;
    public static javax.swing.JTextField nombre;
    private javax.swing.JButton nuevo;
    public static javax.swing.JTextField precio;
    public static javax.swing.JTextField stock;
    public static javax.swing.JTextField stockProd;
    private javax.swing.JTable tbdatos2;
    public static javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
LaBodeguita cc=new LaBodeguita();
Connection cn = cc.getConnection();
}
