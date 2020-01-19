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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author eduardowallacedev <eduardo.wallace@outlook.com.br>
 */
public class ClientesDAO {
    
    private Connection con;
    
    public ClientesDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    //Method cadastra Cliente
    
    public void cadastrarCliente(Clientes obj){
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
    public void alterarCliente(){
        
    }
    
    //Method exclui um Cliente
    public void excluirCliente(Clientes obj){
                  
        try {
            // Prepara o comando sql
            String sql = "delete from tb_clientes where id=?";
            
            try ( // Conectar com o DB e organizar o comando sql
                    PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1,obj.getId());
                
                // Executar o comando sql
                stmt.execute();
                stmt.close();
            }
            
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
                              
        } catch (SQLException error) {
          JOptionPane.showMessageDialog(null, "Erro: "+ error);                        
        }
    
        
    }
    
    //Method listar todos clientes
    public List<Clientes> listarClientes(){
        try {
            //Cria a lista
            List<Clientes> lista = new ArrayList<>();
            //Criar o comando sql, organizar e executar a sql
            String sql = "select * from tb_clientes";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("Nome"));
                obj.setRg(rs.getString("Rg"));
                obj.setCpf(rs.getString("Cpf"));
                obj.setEmail(rs.getString("Email"));
                obj.setTelefone(rs.getString("Telefone"));
                obj.setCelular(rs.getString("Celular"));
                obj.setCep(rs.getString("Cep"));
                obj.setEndereco(rs.getString("Endereco"));
                obj.setNumero(rs.getInt("Numero"));
                obj.setCidade(rs.getString("Cidade"));
                obj.setBairro(rs.getString("Bairro"));
                obj.setComplemento(rs.getString("Complemento"));
                obj.setEstado(rs.getString("Estado"));
                
                lista.add(obj);
            }
            
            return lista;
            
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro:"+ error);
            return null;
        }
    }
    
}
