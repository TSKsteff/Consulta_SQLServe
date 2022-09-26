
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DBConnection {
    
  
      public static Connection getConnection() throws SQLException{
          
        Connection conexaoF=null; 
                try{
                conexaoF = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=NicolaSec;encrypt=false", "username=sa","password=");
                }catch (Exception e ){
                     JOptionPane.showMessageDialog(null,"Conexion falhouuu" + e.getMessage());
                }
        return conexaoF;
    
   }
}