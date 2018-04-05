package labodeguita;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static labodeguita.Principal.valor;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        ico1.setVisible(false);
        ico2.setVisible(false);
        
         this.setLocationRelativeTo(null);
    }
    void acceder(String usuario, String pass ){
        String car="";
        String sql ="SELECT * FROM  trabajadores WHERE nom_trab='"+usuario+"' && password='"+pass+"'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
                    while (rs.next())
                    {
                     car=rs.getString("priv");
                    }                    
                    if(car.equals("Admin")){
                    this.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Bienvenido "+usuario);
                        Principal obj = new Principal();
                        Principal.trabajador.setText(""+usuario);
                        obj.setVisible(true);
                        obj.valor.setText("1");
                        obj.pack();
                        privilegio();
                    }
                    if(car.equals("Invitado")){
                        this.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Bienvenido "+usuario);
                        Principal obj = new Principal();
                        Principal.trabajador.setText(""+usuario);
                        obj.setVisible(true);
                        obj.valor.setText("2");
                        obj.pack();
                        privilegio();
                    }     
                    if ((!car.equals("Admin"))&&(!car.equals("Invitado"))){
                        
            JOptionPane.showMessageDialog(this,"Nombre o contraseña incorrectos");
        }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void privilegio(){
        if (valor.getText().equals("1")) {
            Principal.MenuControl.setEnabled(true);
        }
        if (valor.getText().equals("2")) {
            Principal.MenuControl.setEnabled(false);
        }
    }
    
    int cont=0;
    public void validar(){
        
            if(txtuser.getText().equals("")){ico1.setVisible(true);cont++;}              else{ico1.setVisible(false);}
            if(txtpass.getText().equals("")){ico2.setVisible(true);cont++;}          else{ico2.setVisible(false);}    
    }
    
    void limpiar(){
        txtpass.setText("");
        txtuser.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        ico1 = new javax.swing.JLabel();
        ico2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INICIAR SESIÓN");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255), 3));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 102, 255), 2, true));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("Contraseña");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 80, 160, 30);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 102, 255));
        jLabel4.setText("Nombre");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(60, 30, 120, 30);

        txtuser.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jPanel1.add(txtuser);
        txtuser.setBounds(180, 30, 190, 30);

        txtpass.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jPanel1.add(txtpass);
        txtpass.setBounds(180, 80, 190, 29);

        ico1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Braian Canjay\\Desktop\\DES AP 1\\32x32.png")); // NOI18N
        ico1.setToolTipText("Este campo no puede estar vacio");
        jPanel1.add(ico1);
        ico1.setBounds(370, 30, 32, 30);

        ico2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Braian Canjay\\Desktop\\DES AP 1\\32x32.png")); // NOI18N
        ico2.setToolTipText("Este campo no puede estar vacio");
        jPanel1.add(ico2);
        ico2.setBounds(370, 80, 32, 30);

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 420, 150));

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cancelar");
        jButton1.setToolTipText("Borra el contenido");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, 90, 40));

        jButton3.setBackground(new java.awt.Color(0, 153, 0));
        jButton3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Acceder");
        jButton3.setToolTipText("Inicie sesion");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 90, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jLabel1.setBackground(new java.awt.Color(51, 102, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setText("Inicio de sesión");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 280, 40));

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 260, 200));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiar();
        ico1.setVisible(false);
        ico2.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String User=txtuser.getText();
        String Pass=txtpass.getText();
        validar();
        //si todos son invisibles hacer accion,si no mensaje de llenar campos
        if (ico1.isVisible() || ico2.isVisible()) {
            JOptionPane.showMessageDialog(null,"Llenó todos los campos?");
        }
        else{
        //llamada del metodo
        acceder(User, Pass);
        }
               // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ico1;
    private javax.swing.JLabel ico2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
LaBodeguita cc=new LaBodeguita();
Connection cn = cc.getConnection();
}
