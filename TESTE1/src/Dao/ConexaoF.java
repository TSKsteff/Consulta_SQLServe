
package Dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConexaoF {
      public static Connection getConnection() throws SQLException{
          Connection conexaoF = null;
          try {
        conexaoF = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=NicolaSec;encrypt=false", "username=sa","password=");
        }catch (Exception e ) {
                        JOptionPane.showMessageDialog(null,"Conexion falhouuu" + e.getMessage());

        }
       return conexaoF;
    }
}
