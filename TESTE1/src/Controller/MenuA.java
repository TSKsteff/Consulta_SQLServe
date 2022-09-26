/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.DBConnection;
import Dao.SistemasCRUD;
import Model.Sistemas;
import View.SistemasView;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class MenuA {
    private SistemasView view;

    public MenuA(SistemasView view) {
        this.view = view;
    }
    
    public void cadastrar(){
        
        String nome = view.getnome().getText();
        String empresa = view.getempresa().getText();
        String responsavel = view.getresponsavel().getText();
        
        
        
        Sistemas usuario = new Sistemas(nome, empresa, responsavel);
        
        try {
            Connection conexao = new DBConnection().getConnection();
            SistemasCRUD usuarioDao = new SistemasCRUD(conexao);
            usuarioDao.insert(usuario);
            
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(SistemasView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizar(){
        String nome = view.getnome().getText();
        String empresa = view.getempresa().getText();
        String responsavel = view.getresponsavel().getText();
        
        Sistemas usuario = new Sistemas(nome, empresa, responsavel);
        
        try {
            Connection conexao = new DBConnection().getConnection();
            SistemasCRUD usuarioDao = new SistemasCRUD(conexao);
            usuarioDao.atualizarUser(usuario);
            
            JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(SistemasView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deletaUser(){
        
        String nome = view.getnome().getText();
        String empresa = view.getempresa().getText();
        String responsavel = view.getresponsavel().getText();
        Sistemas usuario = new Sistemas(nome, empresa, responsavel);
        
        try {
            Connection conexao = new DBConnection().getConnection();
            SistemasCRUD usuarioDao = new SistemasCRUD(conexao);
            usuarioDao.deletarUser(usuario);
            
            JOptionPane.showMessageDialog(null, "Usuario deletado com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(SistemasView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
