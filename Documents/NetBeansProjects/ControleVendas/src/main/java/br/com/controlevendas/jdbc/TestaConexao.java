/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controlevendas.jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author eduardowallacedev <eduardo.wallace@outlook.com.br>
 */
public class TestaConexao {
    
    public static void main(String[] args) {
        
        try {
            
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!");          
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Ops ocorreu um erro: " + error);
        }   
        
    }
    
}
