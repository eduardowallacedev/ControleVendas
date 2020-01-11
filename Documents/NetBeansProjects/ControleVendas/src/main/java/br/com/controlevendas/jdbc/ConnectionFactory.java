/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controlevendas.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author eduardowallacedev <eduardo.wallace@outlook.com.br>
 */
public class ConnectionFactory {
    
    public Connection getConnection(){
        
        try {
            
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdvendas?useTimezone=true&serverTimezone=UTC","usuario","123");
                    
                    
        } catch (Exception error) {
            throw new RuntimeException(error);
        }
 
            
    }
    
}
