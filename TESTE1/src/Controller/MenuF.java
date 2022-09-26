/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Dao.ConexaoF;
import Dao.FuncionarioCRUD;
import Dao.SistemasCRUD;
import Model.Funcionario;
import View.FuncionarioView;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class MenuF {
    private FuncionarioView view;

    public MenuF(FuncionarioView view) {
        this.view = view;
    }
    
    public void cadastrar(){
        
        String nome = view.getnome().getText();
        String empresa = view.getstatus().getText();
        String responsavel = view.getcargo().getText();
        
        Funcionario usuario = new Funcionario(nome, empresa, responsavel);
        
        try {
            Connection conexao = new ConexaoF().getConnection();
            FuncionarioCRUD usuarioDao = new FuncionarioCRUD(conexao);
            usuarioDao.insert(usuario);
            
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizar(){
        String nome = view.getnome().getText();
        String empresa = view.getstatus().getText();
        String responsavel = view.getcargo().getText();
        
        Funcionario usuario = new Funcionario(nome, empresa, responsavel);
        
        try {
            Connection conexao = new ConexaoF().getConnection();
            FuncionarioCRUD usuarioDao = new FuncionarioCRUD(conexao);
            usuarioDao.atualizarUser(usuario);
            
            JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deletaUser(){
        
        String nome = view.getnome().getText();
        String status = view.getstatus().getText();
        String cargo = view.getcargo().getText();
        Funcionario usuario = new Funcionario(nome, status, cargo);
        
        try {
            Connection conexao = new ConexaoF().getConnection();
            FuncionarioCRUD usuarioDao = new FuncionarioCRUD(conexao);
            usuarioDao.insert(usuario);
            
            JOptionPane.showMessageDialog(null, "Usuario deletado com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
