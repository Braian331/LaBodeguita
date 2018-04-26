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

public class ReabastecimientoDeStock extends javax.swing.JFrame {

    public ReabastecimientoDeStock() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrardatos("");
        
        guardar.setEnabled(false);
        cancelar.setEnabled(false);
        
        prove.setEnabled(false);
        stComprar.setEnabled(false);
        stCoste.setEnabled(false);
        
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
    
    public static void borrar (){
        stComprar.setText("");
        stDisponible.setText("0");
        stFinal.setText("0");
        prove.setText("");        
        stCoste.setText("");
        nom.setText("");
        descripcion.setText("");
        empresa.setText("");
        code.setText("");
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
            nom.setText(tbdatos2.getValueAt(fila, 1).toString());
            descripcion.setText(tbdatos2.getValueAt(fila, 2).toString());
            empresa.setText(tbdatos2.getValueAt(fila, 3).toString());
            stDisponible.setText(tbdatos2.getValueAt(fila, 5).toString());
            stockProd.setText(tbdatos2.getValueAt(fila, 5).toString());
            
            ico1.setVisible(false);
            ico2.setVisible(false);
            ico3.setVisible(false);

            guardar.setEnabled(true);
            cancelar.setEnabled(true);
            prove.setEnabled(true);
            stComprar.setEnabled(true);
            stCoste.setEnabled(true);
        } else {
            borrar();
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
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
        txtbuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        stockProd = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        newStock = new javax.swing.JTextField();
        code1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cant = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdatos2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Stock a comprar");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 130, 30));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Stock final");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 90, 30));

        guardar.setText("Guardar");
        guardar.setToolTipText("Aceptar reabastecimiento");
        guardar.setBorder(null);
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jPanel1.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 90, 40));

        cancelar.setText("Cancelar");
        cancelar.setToolTipText("Cancelar reabastecimiento");
        cancelar.setBorder(null);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, 90, 40));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Stock disponible");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 120, 30));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre del producto");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, 30));

        stComprar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        stComprar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        stComprar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                stComprarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stComprarKeyReleased(evt);
            }
        });
        jPanel1.add(stComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 130, 30));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Empresa");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 70, 30));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Descripcion");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 90, 30));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Codigo");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 60, 30));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Proveedor");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 80, 30));

        stCoste.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        stCoste.setToolTipText("Monto a pagar por el stock");
        jPanel1.add(stCoste, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, 130, 30));

        prove.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        prove.setToolTipText("Nombre del proveedor");
        jPanel1.add(prove, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 180, 30));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Coste de stock");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 110, 30));

        ico1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Braian Canjay\\Desktop\\DES AP 1\\32x32.png")); // NOI18N
        ico1.setToolTipText("Este campo no puede estar vacio");
        jPanel1.add(ico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, -1, 30));

        ico2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Braian Canjay\\Desktop\\DES AP 1\\32x32.png")); // NOI18N
        ico2.setToolTipText("Este campo no puede estar vacio");
        jPanel1.add(ico2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 130, -1, 30));

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
        jPanel1.add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 180, 30));

        empresa.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        empresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        empresa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 180, 30));

        stDisponible.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        stDisponible.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stDisponible.setText("0");
        stDisponible.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(stDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 130, 30));

        code.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        code.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        code.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(code, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 90, 30));

        stFinal.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        stFinal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stFinal.setText("0");
        stFinal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(stFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, 130, 30));

        descripcion.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        descripcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 180, 30));

        ico3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Braian Canjay\\Desktop\\DES AP 1\\32x32.png")); // NOI18N
        ico3.setToolTipText("Este campo no puede estar vacio");
        jPanel1.add(ico3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 230, -1, 30));

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
        jPanel1.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 360, 30));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Codigo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 80, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Stock Prod");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, -1, -1));

        stockProd.setText("0");
        jPanel1.add(stockProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 470, 140, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Nuevo Stock");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 440, -1, -1));

        newStock.setText("0");
        jPanel1.add(newStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 470, 140, -1));

        code1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                code1KeyReleased(evt);
            }
        });
        jPanel1.add(code1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 140, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Cod");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Cant");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, -1, -1));
        jPanel1.add(cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 140, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 500, 50));

        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton1.setText("Ver Tabla");
        jButton1.setToolTipText("Buscar en la tabla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 980, 580));

        jPanel2.setBackground(new java.awt.Color(101, 178, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reabastecimiento de Stock");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 410, 40));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/x-1.png"))); // NOI18N
        jButton4.setToolTipText("Regresar");
        jButton4.setBorder(null);
        jButton4.setContentAreaFilled(false);
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/x-2.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 50, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      Principal obj=new Principal();
      obj.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed
       
    }//GEN-LAST:event_txtbuscarKeyPressed

    private void stComprarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stComprarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_stComprarKeyPressed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        cont=0;
        validar();
        //si todos son invisibles hacer update si no, mensaje de llenar campos
        if (ico1.isVisible() || ico2.isVisible() || ico3.isVisible()) {
            JOptionPane.showMessageDialog(null,"Llenó todos los campos?");
        }
        else{
            cant.setText(""+stComprar.getText());
            int cantidad = Integer.parseInt(cant.getText());
            int stockP = Integer.parseInt(stockProd.getText());

            int nuevo=stockP+cantidad;
            newStock.setText(""+nuevo);
                
            try {
                PreparedStatement pstm = cn.prepareStatement("INSERT INTO compraproductos (nomProd, desProd, stCom, nomEmp, nom_prove, feCom, cod_prod) VALUES (?,?,?,?,?,?,?)");
                pstm.setString(1, nom.getText());
                pstm.setString(2, descripcion.getText());
                pstm.setString(3, stComprar.getText());
                pstm.setString(4, empresa.getText());
                pstm.setString(5, prove.getText());
                pstm.setString(6, fecha.getText());
                pstm.setString(7, code.getText());
                pstm.executeUpdate();
                PreparedStatement pst2 = cn.prepareStatement("UPDATE productos SET stock_prod='"+stFinal.getText()+"' WHERE cod_prod='"+code.getText()+"'");
                pst2.executeUpdate();
                mostrardatos("");
                guardar.setEnabled(false);
                cancelar.setEnabled(false);
                borrar();
                JOptionPane.showMessageDialog(null, "Compra registrada");
            }catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        guardar.setEnabled(false);
        cancelar.setEnabled(false);
        
        prove.setEnabled(false);
        stComprar.setEnabled(false);
        stCoste.setEnabled(false);
        
        borrar();
    }//GEN-LAST:event_cancelarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void stComprarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stComprarKeyReleased
        int dis,comp,fin;
        dis= Integer.parseInt(stDisponible.getText());
        comp= Integer.parseInt(stComprar.getText());
        
        fin=dis+comp;
        
        stFinal.setText(""+fin);
    }//GEN-LAST:event_stComprarKeyReleased

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
        if (txtbuscar.getText().equals("")) {
            guardar.setEnabled(false);
            cancelar.setEnabled(false);
            prove.setEnabled(false);
            stComprar.setEnabled(false);
            stCoste.setEnabled(false);
            borrar();
        }
        else{
            buscarST();
        }
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void code1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_code1KeyReleased
        // TODO add your handling code here: buscar en tbdtos 2 al ser autoselect
        buscarST2();
    }//GEN-LAST:event_code1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ReabastecerProd obj=new ReabastecerProd();
        obj.setVisible(true);
        this.dispose();
        ReabastecerProd.comprobador.setText("1");
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
    public static javax.swing.JButton cancelar;
    public static javax.swing.JTextField cant;
    public static javax.swing.JLabel code;
    public static javax.swing.JTextField code1;
    public static javax.swing.JLabel descripcion;
    public static javax.swing.JLabel empresa;
    private javax.swing.JLabel fecha;
    public static javax.swing.JButton guardar;
    private javax.swing.JLabel hora;
    public static javax.swing.JLabel ico1;
    public static javax.swing.JLabel ico2;
    public static javax.swing.JLabel ico3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField newStock;
    public static javax.swing.JLabel nom;
    public static javax.swing.JTextField prove;
    public static javax.swing.JTextField stComprar;
    public static javax.swing.JTextField stCoste;
    public static javax.swing.JLabel stDisponible;
    public static javax.swing.JLabel stFinal;
    public static javax.swing.JTextField stockProd;
    private javax.swing.JTable tbdatos2;
    public static javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
LaBodeguita cc=new LaBodeguita();
Connection cn = cc.getConnection();
}
