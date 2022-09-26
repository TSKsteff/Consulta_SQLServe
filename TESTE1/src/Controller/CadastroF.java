
package Controller;

import Dao.ConexaoF;
import Dao.FuncionarioCRUD;
import View.FuncionarioLogin;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Model.Funcionario;
import Model.Funcionario;
import View.FuncionarioLogin;

public class CadastroF {
    
    
     private FuncionarioLogin view;

    public CadastroF (FuncionarioLogin view) {
        this.view = view;
    }
    
    public void salvaUsuario() throws SQLException{
        String nome = view.getjTextFieldNome().getText();
        String estado = view.getjTextFieldstatus().getText();
        String cargo = view.getjTextFieldcargo().getText();
        
        
        Funcionario funcionario = new Funcionario(nome, estado, cargo);
        Connection conexao = new ConexaoF().getConnection();
        FuncionarioCRUD funcrud = new FuncionarioCRUD(conexao);
        boolean usuariousado = funcrud.usuarioDuplicado(funcionario);
        
        
            if(usuariousado){
                try {
                    
                    Funcionario usuario = new Funcionario(nome, estado, cargo);
                
                    funcrud.insert(usuario);
            
                    JOptionPane.showMessageDialog(null, "Usuario salvo com sucesso");
                    FuncionarioLogin login = new FuncionarioLogin();
                    login.setVisible(true);
            
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else {
                JOptionPane.showMessageDialog(null, "Usuario ja cadastrado");
            }

}
    
    
}
