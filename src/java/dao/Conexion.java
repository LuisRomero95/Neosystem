
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    protected Connection conexion;
    
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3309/bdmudanza4";

    private String user = "root";
    private String password = "";
        
    public void conectar(){
        try{
            conexion = DriverManager.getConnection(url, user, password);
            Class.forName(driver);                        
        }catch(ClassNotFoundException | SQLException e){

        }
    }
        
    public void cerrar() throws SQLException{
        if(conexion != null){
            if(!conexion.isClosed()){
                conexion.close();
            }
        }
    }
}
