/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controlevendas.dao;

import br.com.controlevendas.jdbc.ConnectionFactory;
import br.com.controlevendas.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author eduardowallacedev <eduardo.wallace@outlook.com.br>
 */
public class ClientesDao {
    
    private Connection con;
    
    public ClientesDao(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    //Method cadastra Cliente
    
    public void cadastrar(Clientes obj){
        try {
            // Prepara o comando sql
            String sql = "insert into tb_clientes (nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            // Conectar com o DB e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,obj.getNome());
            stmt.setString(2,obj.getRg());
            stmt.setString(3,obj.getCpf());
            stmt.setString(4,obj.getEmail());
            stmt.setString(5,obj.getTelefone());
            stmt.setString(6,obj.getCelular());
            stmt.setString(7,obj.getCep());
            stmt.setString(8,obj.getEndereco());
            stmt.setInt(9,obj.getNumero());
            stmt.setString(10,obj.getComplemento());
            stmt.setString(11,obj.getBairro());
            stmt.setString(12,obj.getCidade());
            stmt.setString(13,obj.getEstado());
            
            // Executar o comando sql
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                              
        } catch (SQLException error) {
          JOptionPane.showMessageDialog(null, "Erro: "+ error);                        
        }
    }
    
    //Method atualiza o Cliente
    public void alterar(){
        
    }
    
    //Method exclui um Cliente
    public void excluir(){
        
    }
    
}
