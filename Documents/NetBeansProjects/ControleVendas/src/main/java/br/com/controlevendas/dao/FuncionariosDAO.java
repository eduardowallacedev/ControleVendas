/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controlevendas.dao;

import br.com.controlevendas.jdbc.ConnectionFactory;
import br.com.controlevendas.model.Funcionarios;
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
public class FuncionariosDAO {
    
    //Conexao
     private Connection con;
    
    public FuncionariosDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    //Metodo cadastrar Funcionario
    public void cadastrarFuncionarios(Funcionarios obj){
        try {
            // Prepara o comando sql
            String sql = "insert into tb_funcionarios (nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            try ( // Conectar com o DB e organizar o comando sql
                    PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1,obj.getNome());
                stmt.setString(2,obj.getRg());
                stmt.setString(3,obj.getCpf());
                stmt.setString(4,obj.getEmail());
                stmt.setString(5,obj.getSenha());
                stmt.setString(6,obj.getCargo());
                stmt.setString(7,obj.getNivelAcesso());
                stmt.setString(8,obj.getTelefone());
                stmt.setString(9,obj.getCelular());
                stmt.setString(10,obj.getCep());
                stmt.setString(11,obj.getEndereco());
                stmt.setInt(12,obj.getNumero());
                stmt.setString(13,obj.getComplemento());
                stmt.setString(14,obj.getBairro());
                stmt.setString(15,obj.getCidade());
                stmt.setString(16,obj.getEstado());
                
                // Executar o comando sql
                stmt.execute();
            }
            
            JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso!");
                              
        } catch (SQLException error) {
          JOptionPane.showMessageDialog(null, "Erro: "+ error);                        
        }
    }
    
    //Metodo listar todos os funcionarios
    public List<Funcionarios> listarFuncionarios(){
        try {
            //Cria a lista
            List<Funcionarios> lista = new ArrayList<>();
            //Criar o comando sql, organizar e executar a sql
            String sql = "select * from tb_funcionarios";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Funcionarios obj = new Funcionarios();
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
