package labodeguita;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LaBodeguita {
    //crear un objeto privado estatico en clase
    // connection with parametres
    private static Connection conn;
    //crear variables privadas estaticas tipo string
    private static final String driver="com.mysql.jdbc.Driver";
    //referencia de archivo agregado
    private static final String user="root";
    private static final String password="";
    private static final String url="jdbc:mysql://localhost:3306/LaBodeguita";
    
    //creando constructor de clase
    public LaBodeguita() {
    conn=null;
        try {
          Class.forName(driver);
          //codigo de acceso para la base de datos
          conn =DriverManager.getConnection(url,user, password);
          //2.validacion de BD
          
          if(conn!=null){
              System.out.println("Conexion establecida!!!");
            }
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error de conexion :( "+ e);
            }
    }
    
    //metodo conectar
    public Connection getConnection(){
       
        return conn; 
    }
    public void Desconectar(){
        conn=null;
        //validacion
        if(conn==null){
            System.out.println("Conexion terminada...");
        }
    }
}