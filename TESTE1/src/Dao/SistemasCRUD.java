
package Dao;

import Model.Sistemas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SistemasCRUD {
    
    private final Connection connection;

    public SistemasCRUD(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Sistemas usuario) throws SQLException{        
           
        String QUERY = "INSERT INTO sistemas (nome, empres,responsavel,)" 
                + "VALUES('"+usuario.getNome()+"', '"+usuario.getEmpresa()+"', '"+usuario.getResponsavel()+"')";           
        System.out.println(QUERY);
        PreparedStatement statement = connection.prepareStatement(QUERY);
        statement.execute();
        connection.close();
        
    }

    public boolean existeUsuario(Sistemas usuario) throws SQLException {
        String QUERY = "SELECT * FROM sistemas WHERE nome = '"+usuario.getNome()+"' AND senha = '"+usuario.getResponsavel()+"'";
        System.out.println(QUERY);
        PreparedStatement statement = connection.prepareStatement(QUERY);
        statement.execute();
        
        ResultSet resultSet = statement.getResultSet();
        
        if (resultSet.next()){
            return true;
        } else{
            return false;
        }
                   
    }
   
    public void atualizarUser(Sistemas usuario) throws SQLException{
        String QUERY = "UPDATE sistemas SET nome = '"+usuario.getNome()+"',"
                + " empresa = '"+usuario.getEmpresa()+"',"
                + " responsavel = '"+usuario.getResponsavel()+"',"
                + " WHERE id = '"+usuario.getId()+"'";
        PreparedStatement statement = connection.prepareStatement(QUERY);
        statement.executeUpdate();
        connection.close();
    }
    
    public void deletarUser(Sistemas usuario) throws SQLException{
        String QUERY = " Delete sistemas WHERE id = '"+usuario.getId()+"'";
        PreparedStatement statement = connection.prepareStatement(QUERY);
        statement.executeUpdate();
        connection.close();
    }
  
    
    public boolean usuarioDuplicado(Sistemas usuario) throws SQLException{
        String QUERY = "SELECT * FROM sistemas WHERE nome = '"+usuario.getNome()+"'empresa = '"+usuario.getEmpresa()+"'responsavel = '"+usuario.getResponsavel()+"'";
        PreparedStatement statement = connection.prepareStatement(QUERY);
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        if (resultSet.next()){
            return false;
        } else{
            return true;
        }
    }

}
