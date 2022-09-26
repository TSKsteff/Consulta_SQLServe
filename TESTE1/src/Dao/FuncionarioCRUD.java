
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Funcionario;
import Model.Funcionario;

public class FuncionarioCRUD {
    
    private final Connection connection;

    public FuncionarioCRUD(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Funcionario usuario) throws SQLException{        
           
        String QUERY = "INSERT INTO funcionario (nome, status,cargo,)" 
                + "VALUES('"+usuario.getNome()+"', '"+usuario.getestado()+"', '"+usuario.getCargo()+"')";           
        System.out.println(QUERY);
        PreparedStatement statement = connection.prepareStatement(QUERY);
        statement.execute();
        connection.close();
        
    }

    public boolean existeUsuario(Funcionario usuario) throws SQLException {
        String QUERY = "SELECT * FROM funcionario WHERE nome = '"+usuario.getNome()+"' AND cargo = '"+usuario.getCargo()+"'";
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
   
    public void atualizarUser(Funcionario usuario) throws SQLException{
        String QUERY = "UPDATE funcionario SET nome = '"+usuario.getNome()+"',"
                + " status = '"+usuario.getestado()+"',"
                + " cargo = '"+usuario.getCargo()+"',"
                + " WHERE id = '"+usuario.getId()+"'";
        PreparedStatement statement = connection.prepareStatement(QUERY);
        statement.executeUpdate();
        connection.close();
    }
    
    public void deletarUser(Funcionario usuario) throws SQLException{
        String QUERY = "DELETE funcionario  WHERE id = '"+usuario.getId()+"'";
        PreparedStatement statement = connection.prepareStatement(QUERY);
        statement.executeUpdate();
        connection.close();
    }
  
    public boolean usuarioDuplicado(Funcionario usuario) throws SQLException{
        String QUERY = "SELECT * FROM funcioanrio WHERE Nome = '"+usuario.getNome()+"'empresa = '"+usuario.getestado()+"'responsavel = '"+usuario.getCargo()+"'";
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
