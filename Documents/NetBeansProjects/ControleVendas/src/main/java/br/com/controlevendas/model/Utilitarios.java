/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controlevendas.model;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author eduardowallacedev <eduardo.wallace@outlook.com.br>
 */
public class Utilitarios {
    
    //Metodo limpa campos
    public void limpaTela(JPanel container){
        Component components[] = container.getComponents();
        for (Component component : components){
            if (component instanceof JTextField){
            ((JTextField) component).setText(null);    
            }            
        }
    }
    
}
