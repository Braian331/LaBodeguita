package labodeguita;
//limpiar despues de fiar

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
import javax.swing.InputMap;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;

public class VentaDeProductos extends javax.swing.JFrame {

    public VentaDeProductos() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrardatos("");

        comprar.setVisible(false);
        nomFiado.setEnabled(false);
        cant.setEnabled(false);
        cancelar.setEnabled(false);
        combo.setEnabled(false);

        invalidNom.setVisible(false);
        invalidCod.setVisible(false);
        InSt.setVisible(false);
        ico1.setVisible(false);
        ico2.setVisible(false);
        ico3.setVisible(false);
        //fecha local
        Calendar c;
        c = Calendar.getInstance();
        int d = c.get(Calendar.DATE), m = 1 + (c.get(Calendar.MONTH)), a = c.get(Calendar.YEAR);
        fecha.setText(a + "/" + m + "/" + d);

        Timer tiempo = new Timer(100, new VentaDeProductos.horas());
        tiempo.start();

        fiar(combo.getSelectedItem().toString());

        InputMap map = new InputMap();

        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "pressed");
        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), "released");

        btBuscar.setInputMap(0, map);
    }

    class horas implements ActionListener {
        //hora local actualizable

        public void actionPerformed(ActionEvent e) {
            Date sistHora = new Date();
            String pmAm = "hh:mm:ss a";
            SimpleDateFormat format = new SimpleDateFormat(pmAm);
            Calendar hoy = Calendar.getInstance();
            hora.setText(String.format(format.format(sistHora), hoy));
        }
    }

    public void fiar(String filtro) {
        if (filtro.equals("Pago")) {
            nomFiado.setEnabled(false);
            ico2.setVisible(false);
            fiado.setEnabled(false);
            comprar.setEnabled(true);
        }
        if (filtro.equals("Fiado")) {
            nomFiado.setEnabled(true);
            fiado.setEnabled(true);
            comprar.setEnabled(false);
        }
    }

    int cont = 0;

    public void validar() {
        if (nomFiado.isEnabled()) {
            if (cant.getText().equals("")) {
                ico1.setVisible(true);
                cont++;
            } else {
                ico1.setVisible(false);
            }
            if (nomFiado.getText().equals("")) {
                ico2.setVisible(true);
                cont++;
            } else {
                ico2.setVisible(false);
            }
        } else if (cant.getText().equals("")) {
            ico1.setVisible(true);
            cont++;
        } else {
            ico1.setVisible(false);
        }

    }

    void limpiar() {
        nomFiado.setText("");
        prec1o.setText("");
        cant.setText("");
        total.setText("");
        cod.setText("");
        txtbuscar.setText("");
        nombre.setText("");
        desc.setText("");
        empre.setText("");
        stock.setText("");
        newStock.setText("");

        combo.setEnabled(false);
        cant.setEnabled(false);
        nomFiado.setEnabled(false);
        fiado.setEnabled(false);
        cancelar.setEnabled(false);
        comprar.setVisible(false);
        invalidNom.setVisible(false);
        invalidCod.setVisible(false);
        InSt.setVisible(false);
    }

    void mostrardatos(String valor) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("CODIGO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("EMPRESA");
        modelo.addColumn("PRECIO");
        modelo.addColumn("STOCK");
        tbdatos.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT * FROM productos";
        } else {
            sql = "SELECT * FROM productos WHERE cod_prod='" + valor + "'";
        }

        String[] datos = new String[6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("cod_prod");
                datos[1] = rs.getString("nombre_prod");
                datos[2] = rs.getString("descripcion_prod");
                datos[3] = rs.getString("nomEmp");
                datos[4] = rs.getString("precio_prod");
                datos[5] = rs.getString("stock_prod");
                modelo.addRow(datos);
            }
            tbdatos.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(ControlDeVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscar() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("CODIGO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("EMPRESA");
        modelo.addColumn("PRECIO");
        modelo.addColumn("STOCK");
        tbdatos.setModel(modelo);

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
            tbdatos.setModel(modelo);
            tbdatos.selectAll();
        } catch (SQLException ex) {
            Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
        }

        int cantidad, precio;
        int fila = tbdatos.getSelectedRow();
        if (fila >= 0) {
            cod.setText(tbdatos.getValueAt(fila, 0).toString());
            nombre.setText(tbdatos.getValueAt(fila, 1).toString());
            desc.setText(tbdatos.getValueAt(fila, 2).toString());
            empre.setText(tbdatos.getValueAt(fila, 3).toString());
            prec1o.setText(tbdatos.getValueAt(fila, 4).toString());
            stock.setText(tbdatos.getValueAt(fila, 5).toString());
            newStock.setText(tbdatos.getValueAt(fila, 5).toString());

            cant.setText("1");
            cantidad = Integer.parseInt(cant.getText());
            precio = Integer.parseInt(prec1o.getText());
            total.setText("" + cantidad * precio);
            ico1.setVisible(false);
            ico2.setVisible(false);
            ico3.setVisible(false);

            comprar.setVisible(true);
            cant.setEnabled(true);
            cancelar.setEnabled(true);
            combo.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "no seleciono fila");
        }
    }

    public void cargarInterfaz() {
        DefaultTableModel modelo = (DefaultTableModel) tbcuenta.getModel();
        Object[] fila = new Object[3];
        fila[0] = cant.getText();
        fila[1] = nombre.getText();
        fila[2] = total.getText();
        modelo.addRow(fila);
        tbcuenta.setModel(modelo);
    }

    public void sumarCeldas() {
        Float valores = new Float(0.0);
        for (int i = 0; i < tbcuenta.getRowCount(); i++) {
            Float valor = new Float(tbcuenta.getValueAt(i, 2).toString());
            valores += valor;
        }
        totalPagar.setText("" + valores);
    }

    public void eliminar() {
        DefaultTableModel tb = (DefaultTableModel) tbcuenta.getModel();
        int a = tbcuenta.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
            totalPagar.setText("0.0");
        }
    }

    public void cancel() {
        DefaultTableModel model = (DefaultTableModel) tbcuenta.getModel();
        int a = tbcuenta.getSelectedRow();
        if (a >= 0) {
            model.removeRow(tbcuenta.getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdatos = new javax.swing.JTable();
        cant = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        prec1o = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        total = new javax.swing.JLabel();
        cod = new javax.swing.JLabel();
        comprar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        combo = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        nomFiado = new javax.swing.JTextField();
        stock = new javax.swing.JTextField();
        desc = new javax.swing.JTextField();
        empre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        newStock = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        ico1 = new javax.swing.JLabel();
        ico2 = new javax.swing.JLabel();
        fiado = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        invalidNom = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        totalPagar = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbcuenta = new javax.swing.JTable();
        btBuscar = new javax.swing.JButton();
        nombre = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        ico3 = new javax.swing.JLabel();
        InSt = new javax.swing.JLabel();
        invalidCod = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jMenuItem1.setText("Comprar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jPopupMenu2.setComponentPopupMenu(jPopupMenu2);

        jMenuItem2.setText("Eliminar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Venta de productos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        jLabel8.setText("Venta De Productos");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 60));

        jPanel2.setBackground(new java.awt.Color(153, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        tbdatos.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tbdatos);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 460, 200, 100));

        cant.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        cant.setToolTipText("Enter para ver el total");
        cant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cantKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cantKeyReleased(evt);
            }
        });
        jPanel2.add(cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 80, -1));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setText("Codigo");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 80, 30));

        prec1o.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        prec1o.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        prec1o.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(prec1o, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 90, 30));

        txtbuscar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtbuscar.setToolTipText("buscar");
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        jPanel2.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 370, 30));

        total.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, 90, 30));

        cod.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 90, 20));

        comprar.setText("Comprar");
        comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprarActionPerformed(evt);
            }
        });
        jPanel2.add(comprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, -1, 40));

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel2.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, -1, 40));

        combo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pago", "Fiado" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });
        jPanel2.add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 170, 30));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel13.setText("Nombre de la persona a fiar");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        nomFiado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel2.add(nomFiado, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 170, -1));
        jPanel2.add(stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 300, 140, -1));
        jPanel2.add(desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 180, 140, -1));

        empre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        empre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empreActionPerformed(evt);
            }
        });
        jPanel2.add(empre, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 240, 140, -1));

        jLabel3.setText("Stock");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 280, -1, -1));

        jLabel9.setText("Descripcion");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 160, -1, -1));

        jLabel10.setText("Empresa");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 220, -1, -1));
        jPanel2.add(newStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 360, 140, -1));

        jLabel11.setText("Nuevo stock");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 340, -1, -1));

        hora.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        hora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 60, 90, 20));

        fecha.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 90, 90, 20));

        ico1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Braian Canjay\\Desktop\\DES AP 1\\32x32.png")); // NOI18N
        ico1.setToolTipText("Este campo no puede estar vacio");
        jPanel2.add(ico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, 30));

        ico2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Braian Canjay\\Desktop\\DES AP 1\\32x32.png")); // NOI18N
        ico2.setToolTipText("Este campo no puede estar vacio");
        jPanel2.add(ico2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, -1, 20));

        fiado.setText("Fiar");
        fiado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiadoActionPerformed(evt);
            }
        });
        jPanel2.add(fiado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 60, 40));

        jLabel12.setText("Comprobador");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 400, -1, -1));

        jTextField1.setText("1");
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 420, 50, -1));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel14.setText("Nombre");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 30));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel15.setText("Total    $");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 390, -1, 30));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel7.setText("Total   $");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, 70, 30));

        invalidNom.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        invalidNom.setForeground(new java.awt.Color(255, 0, 0));
        invalidNom.setText("Introduce un nombre");
        jPanel2.add(invalidNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, 30));

        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 390, 100, 30));

        totalPagar.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        totalPagar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalPagar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(totalPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, 90, 30));

        tbcuenta.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        tbcuenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cant", "Nombre", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbcuenta.setComponentPopupMenu(jPopupMenu2);
        jScrollPane2.setViewportView(tbcuenta);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 760, 180));

        btBuscar.setText("buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 100, 30));

        nombre.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 140, 30));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel16.setText("Precio  $");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 80, 30));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel17.setText("Codigo");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, 20));

        ico3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Braian Canjay\\Desktop\\DES AP 1\\32x32.png")); // NOI18N
        ico3.setToolTipText("Este campo no puede estar vacio");
        jPanel2.add(ico3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, 30));

        InSt.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        InSt.setForeground(new java.awt.Color(255, 0, 0));
        InSt.setText("Stock insuficiente");
        jPanel2.add(InSt, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, 30));

        invalidCod.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        invalidCod.setForeground(new java.awt.Color(255, 0, 0));
        invalidCod.setText("Codigo invalido");
        jPanel2.add(invalidCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, 30));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setText("Cantidad");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1190, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed

    }//GEN-LAST:event_txtbuscarKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
//        int cantidad,precio;
//        int fila= tbdatos.getSelectedRow();
//        if(fila>=0){
//            cod.setText(tbdatos.getValueAt(fila, 0).toString());
//            nombre.setText(tbdatos.getValueAt(fila, 1).toString());
//            txtbuscar.setText(tbdatos.getValueAt(fila, 1).toString());
//            desc.setText(tbdatos.getValueAt(fila, 2).toString());
//            empre.setText(tbdatos.getValueAt(fila, 3).toString());
//            nomb.setText(tbdatos.getValueAt(fila, 4).toString());
//            stock.setText(tbdatos.getValueAt(fila, 5).toString());
//            newStock.setText(tbdatos.getValueAt(fila, 5).toString());
//            
//            cant.setText("1");
//            cantidad = Integer.parseInt(cant.getText());
//            precio = Integer.parseInt(nomb.getText());
//            total.setText(""+cantidad*precio);
//            ico1.setVisible(false);
//            ico2.setVisible(false);
//            
//            comprar.setVisible(true);
//            cant.setEnabled(true);
//            cancelar.setEnabled(true);
//            combo.setEnabled(true);
//        }
//        else{
//            JOptionPane.showMessageDialog(null,"no seleciono fila");
//        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void empreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empreActionPerformed

    }//GEN-LAST:event_empreActionPerformed

    private void cantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantKeyPressed
    }//GEN-LAST:event_cantKeyPressed

    private void comprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprarActionPerformed
        int cantidad, stock1, nuevo;
        cont = 0;
        validar();
        //si todos son invisibles hacer accion,si no mensaje de llenar campos
        if (ico1.isVisible() || ico2.isVisible() || ico3.isVisible()) {
            JOptionPane.showMessageDialog(null, "Llenó todos los campos?");
        } else if (InSt.isVisible()) {
            JOptionPane.showMessageDialog(null, "No hay suficiente stock");
        } else {
            cantidad = Integer.parseInt(cant.getText());
            stock1 = Integer.parseInt(stock.getText());

            nuevo = stock1 - cantidad;

            newStock.setText("" + nuevo);
            stock.setText("" + nuevo);

            try {
                PreparedStatement pstm = cn.prepareStatement("INSERT INTO ventas (nomVent, desVent, nomEmp, cantVent, preVent, totalVent, feVent, cod_prod, stock_prod) VALUES (?,?,?,?,?,?,?,?,?)");
                pstm.setString(1, nombre.getText());
                pstm.setString(2, desc.getText());
                pstm.setString(3, empre.getText());
                pstm.setString(4, cant.getText());
                pstm.setString(5, prec1o.getText());
                pstm.setString(6, total.getText());
                pstm.setString(7, fecha.getText());
                pstm.setString(8, cod.getText());
                pstm.setString(9, stock.getText());
                pstm.executeUpdate();
                PreparedStatement pst2 = cn.prepareStatement("UPDATE productos SET stock_prod='" + newStock.getText() + "', nomEmp='" + empre.getText() + "', nombre_prod='" + nombre.getText() + "', descripcion_prod='" + desc.getText() + "',  precio_prod='" + prec1o.getText() + "' WHERE cod_prod='" + cod.getText() + "'");
                pst2.executeUpdate();
                mostrardatos("");
                cargarInterfaz();
                sumarCeldas();
                limpiar();
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }
    }//GEN-LAST:event_comprarActionPerformed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        fiar(combo.getSelectedItem().toString());
    }//GEN-LAST:event_comboActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        limpiar();
    }//GEN-LAST:event_cancelarActionPerformed

    private void fiadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiadoActionPerformed
        // TODO add your handling code here:
        int cantidad, stock1, nuevo;
        cont = 0;
        validar();
        //si todos son invisibles hacer update si no, mensaje de llenar campos
        if (ico1.isVisible() || ico2.isVisible() || ico3.isVisible()) {
            JOptionPane.showMessageDialog(null, "Llenó todos los campos?");
        } else if (InSt.isVisible()) {
            JOptionPane.showMessageDialog(null, "No hay suficiente stock");
        } else {
            cantidad = Integer.parseInt(cant.getText());
            stock1 = Integer.parseInt(stock.getText());

            nuevo = stock1 - cantidad;

            newStock.setText("" + nuevo);
            stock.setText("" + nuevo);

            try {
                PreparedStatement pst = cn.prepareStatement("INSERT INTO fiado(cliente, nomVent_f, desVent_f, nomEmp_f, cantVent_f, preVent_f, totalVent_f, feVent_F, cod_prod, Nstock) VALUES (?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1, nomFiado.getText());
                pst.setString(2, nombre.getText());
                pst.setString(3, desc.getText());
                pst.setString(4, empre.getText());
                pst.setString(5, cant.getText());
                pst.setString(6, prec1o.getText());
                pst.setString(7, total.getText());
                pst.setString(8, fecha.getText());
                pst.setString(9, cod.getText());
                pst.setString(10, stock.getText());
                pst.executeUpdate();
                PreparedStatement pst2 = cn.prepareStatement("UPDATE productos SET stock_prod='" + newStock.getText() + "', nomEmp='" + empre.getText() + "', nombre_prod='" + nombre.getText() + "', descripcion_prod='" + desc.getText() + "',  precio_prod='" + prec1o.getText() + "' WHERE cod_prod='" + cod.getText() + "'");
                pst2.executeUpdate();
                mostrardatos("");
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }

    }//GEN-LAST:event_fiadoActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased

    }//GEN-LAST:event_txtbuscarKeyReleased

    private void cantKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantKeyReleased
        // TODO add your handling code here:
        int cantidad, precio, st;
        cantidad = Integer.parseInt(cant.getText());
        precio = Integer.parseInt(prec1o.getText());
        st = Integer.parseInt(stock.getText());
        total.setText("" + cantidad * precio);

        if (cantidad > st) {
            InSt.setVisible(true);
        } else {
            InSt.setVisible(false);
        }
    }//GEN-LAST:event_cantKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        eliminar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        cancel();
        limpiar();
        sumarCeldas();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_btBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(VentaDeProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentaDeProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentaDeProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentaDeProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentaDeProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel InSt;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField cant;
    private javax.swing.JLabel cod;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton comprar;
    private javax.swing.JTextField desc;
    private javax.swing.JTextField empre;
    private javax.swing.JLabel fecha;
    private javax.swing.JButton fiado;
    private javax.swing.JLabel hora;
    private javax.swing.JLabel ico1;
    private javax.swing.JLabel ico2;
    private javax.swing.JLabel ico3;
    private javax.swing.JLabel invalidCod;
    private javax.swing.JLabel invalidNom;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField newStock;
    private javax.swing.JTextField nomFiado;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel prec1o;
    private javax.swing.JTextField stock;
    private javax.swing.JTable tbcuenta;
    private javax.swing.JTable tbdatos;
    private javax.swing.JLabel total;
    private javax.swing.JLabel totalPagar;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
LaBodeguita cc = new LaBodeguita();
    Connection cn = cc.getConnection();
}
