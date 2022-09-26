
package Controller;

import View.SistemasLogin;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Dao.DBConnection;
import Dao.SistemasCRUD;
import Model.Sistemas;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

//import view.SistemasView;


/**
 *
 * @author eduar
 */
public class CadastroA {
    
    private SistemasLogin view;

    public CadastroA (SistemasLogin view) {
        this.view = view;
    }
    
    public void salvaUsuario() throws SQLException{
        String nome = view.gettxtnome().getText();
        String empresa = view.gettxtempresa().getText();
        String responsavel = view.gettxtresponsavel().getText();
        
        
        Sistemas sisteminhadu = new Sistemas(nome, empresa, responsavel);
        Connection conexao = new DBConnection().getConnection();
        SistemasCRUD sistemascrud = new SistemasCRUD(conexao);
        boolean usuariousado = sistemascrud.usuarioDuplicado(sisteminhadu);
        
        
            if(usuariousado){
                try {
                    
                    Sistemas usuario = new Sistemas(nome, empresa, responsavel);
                
                    sistemascrud.insert(usuario);
            
                    JOptionPane.showMessageDialog(null, "Usuario salvo com sucesso");
                    SistemasLogin login = new SistemasLogin();
                    login.setVisible(true);
            
                } catch (SQLException ex) {
                    Logger.getLogger(SistemasLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else {
                JOptionPane.showMessageDialog(null, "Usuario ja cadastrado");
            }

}
}

