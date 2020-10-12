/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ppe3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author j.vassant
 */
public class BDD {
    Connection connexion;
    
    public void coProject(){
     String   nomBDD = "projet";
     String   port = "3306";
     String   serveur = "jdbc:mysql://10.0.10.142:" + port + "/" + nomBDD;
     String   id = "root";
     String   mdp = "root";
        
        try {
            this.connexion = DriverManager.getConnection(serveur, id, mdp);
            System.out.println("Connecté");
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erreur de connexion, vérifiez les donnée fournies");
        Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
