/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ppe3;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author j.vassant
 */
public class PPE3 extends javax.swing.JFrame {

    DaoSIO monDao = DaoSIO.getInstance();
    /**
     * Ouvre la jFrame permettant l'accès aux produits, clients, ventes et profils
     */
    public PPE3(){
        
    }
    
    /**
     * Ce constructeur permet de récupérer l'identifiant de la personne connectée grâce au jTextField de la classe Connexion
     */
        public PPE3(String co) {
        initComponents();   
        jLabelNoAccessProfil.setVisible(false);
        try {
            ResultSet lesTuples = DaoSIO.getInstance().requeteSelection("select * from personnel p inner Join profil on p.id_1=Profil.id where identifiant = '" + co + "' ");
            if (lesTuples.next()) {
                int id = lesTuples.getInt("id_1");

                if (id == 1) {
                    connecte = 1;
                }
                else {
                    connecte = 2;
                }

                jLabelEtat.setText(co);
                jLabelEtatProfil.setText(lesTuples.getString("libelle"));
                
             
                jLabelEtat.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(this,"Echec du chargement, la requête n'a pas retourné d'informations !!");
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(this, "Mauvais id ou mdp");
            Logger.getLogger(PPE3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (DaoSIO.getInstance().connexionActive()){
            System.out.println("Connecté");
        }
        else {
            System.out.println("Erreur de connexion à la base de donnée, veuillez rééssayer.");
        }
        if (jLabelEtatProfil.getText().equals("agent"))
        {
            jScrollPane2.setVisible(false);
            jButtonAfficherProfil.setVisible(false);
            jButtonModifProfil.setVisible(false);
            jButtonAddProfil.setVisible(false);
            jLabelNoAccessProfil.setVisible(true);
        }
                else {}
        /**
         * Création de models permettant de récupérer le contenu des jComboBox et d'y insérer les tuples voulus
         */
  
        DefaultComboBoxModel leModel= (DefaultComboBoxModel)jComboBoxClient.getModel();
        DefaultComboBoxModel leModel2= (DefaultComboBoxModel) jComboBoxProduit.getModel();
        DefaultComboBoxModel leModel3 = (DefaultComboBoxModel) jComboBoxPersonnel.getModel();
        DefaultTableModel leModelVente= (DefaultTableModel) jTableVente.getModel();
        leModelVente.addColumn("Produit");
        leModelVente.addColumn("Stock");
        leModelVente.addColumn("Prix");
        jTextFieldQte.setText("1");
        jComboBoxPersonnel.setVisible(false);
    /**
     * Ces requetes SQL permettent ensuite d'insérer le contenu des tables voulus dans les jTable.
     */    
           try{
               ResultSet lesTuples3 = DaoSIO.getInstance().requeteSelection("select * from personnel where identifiant = '" + jLabelEtat.getText() + "'");
            while (lesTuples3.next())
            {
                ManipComboBox cPers = new ManipComboBox(lesTuples3.getString("id"), lesTuples3.getString("identifiant"));
                leModel3.addElement(cPers);
            }
           }
            catch(SQLException ex)
                    {
                    JOptionPane.showMessageDialog(this,"Erreur, l'exécution de la requête est un échec mec !!");
            Logger.getLogger(PPE3.class.getName()).log(Level.SEVERE, null, ex);
                    }
           
           try {
            ResultSet lesTuples = DaoSIO.getInstance().requeteSelection("select * from client");
            ResultSet lesTuples2 = DaoSIO.getInstance().requeteSelection("select * from produit");
            
    
    
            while (lesTuples.next()) {
                ManipComboBox cc = new ManipComboBox(lesTuples.getString("id"), lesTuples.getString("nomClient"));
                leModel.addElement(cc);
            }
            while (lesTuples2.next()) {
                ManipComboBox cp = new ManipComboBox(lesTuples2.getString("id"), lesTuples2.getString("nomproduit"), lesTuples2.getFloat("prixProduit"));
                leModel2.addElement(cp);
            }
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Erreur, l'exécution de la requête est un échec !!");
            Logger.getLogger(PPE3.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
    }
    
    
    
    int connecte = 0;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelProd = new javax.swing.JPanel();
        jButtonAfficherProd = new javax.swing.JButton();
        jButtonAjouterProd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProd = new javax.swing.JTable();
        jButtonModifProd = new javax.swing.JButton();
        jPanelCli = new javax.swing.JPanel();
        jButtonAfficherCli = new javax.swing.JButton();
        jButtonAjouterCli = new javax.swing.JButton();
        jButtonModifCli = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableCli = new javax.swing.JTable();
        jPanelPersonnel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePersonnel = new javax.swing.JTable();
        jButtonAfficherProfil = new javax.swing.JButton();
        jButtonModifProfil = new javax.swing.JButton();
        jButtonAddProfil = new javax.swing.JButton();
        jLabelNoAccessProfil = new javax.swing.JLabel();
        jPanelVente = new javax.swing.JPanel();
        jLabelClient = new javax.swing.JLabel();
        jComboBoxClient = new javax.swing.JComboBox<>();
        jLabelProduit = new javax.swing.JLabel();
        jComboBoxProduit = new javax.swing.JComboBox<>();
        jTextFieldQte = new javax.swing.JTextField();
        jLabelQte = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableVente = new javax.swing.JTable();
        jButtonDeleteProd = new javax.swing.JButton();
        jButtonValider = new javax.swing.JButton();
        jComboBoxPersonnel = new javax.swing.JComboBox<>();
        jLabelEtat = new javax.swing.JLabel();
        jLabelCo = new javax.swing.JLabel();
        jLabelProfil = new javax.swing.JLabel();
        jLabelEtatProfil = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonAfficherProd.setText("Afficher Produits");
        jButtonAfficherProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAfficherProdActionPerformed(evt);
            }
        });

        jButtonAjouterProd.setText("Ajouter Produit");
        jButtonAjouterProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterProdActionPerformed(evt);
            }
        });

        jTableProd.setModel(new DefaultTableModel());
        jScrollPane1.setViewportView(jTableProd);

        jButtonModifProd.setText("Modifier sélection");
        jButtonModifProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelProdLayout = new javax.swing.GroupLayout(jPanelProd);
        jPanelProd.setLayout(jPanelProdLayout);
        jPanelProdLayout.setHorizontalGroup(
            jPanelProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonAfficherProd, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(jButtonAjouterProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonModifProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelProdLayout.setVerticalGroup(
            jPanelProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProdLayout.createSequentialGroup()
                .addGroup(jPanelProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProdLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jButtonAfficherProd)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonModifProd, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAjouterProd))
                    .addGroup(jPanelProdLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Produits", jPanelProd);

        jButtonAfficherCli.setText("Afficher clients");
        jButtonAfficherCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAfficherCliActionPerformed(evt);
            }
        });

        jButtonAjouterCli.setText("Ajouter Client");
        jButtonAjouterCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterCliActionPerformed(evt);
            }
        });

        jButtonModifCli.setText("Modifier sélection");
        jButtonModifCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifCliActionPerformed(evt);
            }
        });

        jTableCli.setModel(new DefaultTableModel());
        jScrollPane3.setViewportView(jTableCli);

        javax.swing.GroupLayout jPanelCliLayout = new javax.swing.GroupLayout(jPanelCli);
        jPanelCli.setLayout(jPanelCliLayout);
        jPanelCliLayout.setHorizontalGroup(
            jPanelCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCliLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonAfficherCli, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(jButtonAjouterCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonModifCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanelCliLayout.setVerticalGroup(
            jPanelCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCliLayout.createSequentialGroup()
                .addGroup(jPanelCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCliLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jButtonAfficherCli)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonModifCli)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAjouterCli))
                    .addGroup(jPanelCliLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Clients", jPanelCli);

        jTablePersonnel.setModel(new DefaultTableModel());
        jScrollPane2.setViewportView(jTablePersonnel);

        jButtonAfficherProfil.setText("Afficher Profil");
        jButtonAfficherProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAfficherProfilActionPerformed(evt);
            }
        });

        jButtonModifProfil.setText("Modifier sélection");
        jButtonModifProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifProfilActionPerformed(evt);
            }
        });

        jButtonAddProfil.setText("Ajouter Profil");
        jButtonAddProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddProfilActionPerformed(evt);
            }
        });

        jLabelNoAccessProfil.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelNoAccessProfil.setText("Veuillez vous connecter en tant qu'administrateur pour gérer le personnel.");

        javax.swing.GroupLayout jPanelPersonnelLayout = new javax.swing.GroupLayout(jPanelPersonnel);
        jPanelPersonnel.setLayout(jPanelPersonnelLayout);
        jPanelPersonnelLayout.setHorizontalGroup(
            jPanelPersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPersonnelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelPersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonAfficherProfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonModifProfil, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(jButtonAddProfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPersonnelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelNoAccessProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanelPersonnelLayout.setVerticalGroup(
            jPanelPersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPersonnelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNoAccessProfil)
                .addGroup(jPanelPersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPersonnelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelPersonnelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jButtonAfficherProfil)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonModifProfil)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAddProfil)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Personnel", jPanelPersonnel);

        jLabelClient.setText("Client");

        jLabelProduit.setText("Produit");

        jLabelQte.setText("Quantité");

        jButtonAdd.setText("+");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jTableVente.setModel(new DefaultTableModel());
        jScrollPane4.setViewportView(jTableVente);

        jButtonDeleteProd.setText("-");
        jButtonDeleteProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteProdActionPerformed(evt);
            }
        });

        jButtonValider.setText("Valider Vente");
        jButtonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelVenteLayout = new javax.swing.GroupLayout(jPanelVente);
        jPanelVente.setLayout(jPanelVenteLayout);
        jPanelVenteLayout.setHorizontalGroup(
            jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVenteLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelVenteLayout.createSequentialGroup()
                        .addComponent(jLabelClient)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxClient, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153)
                        .addComponent(jComboBoxPersonnel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanelVenteLayout.createSequentialGroup()
                            .addComponent(jLabelProduit)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jComboBoxProduit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(44, 44, 44)
                            .addComponent(jLabelQte)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextFieldQte, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51)
                            .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonDeleteProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jButtonValider)
                .addContainerGap())
        );
        jPanelVenteLayout.setVerticalGroup(
            jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVenteLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonValider)
                    .addGroup(jPanelVenteLayout.createSequentialGroup()
                        .addGroup(jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelClient)
                            .addComponent(jComboBoxPersonnel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxProduit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldQte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelProduit)
                            .addComponent(jLabelQte)
                            .addComponent(jButtonAdd)
                            .addComponent(jButtonDeleteProd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 23, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Vente", jPanelVente);

        jLabelEtat.setText("Etat connexion");

        jLabelCo.setText("Connecté en tant que");

        jLabelProfil.setText("Profil");

        jLabelEtatProfil.setText("Etat profil");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelProfil, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEtat)
                    .addComponent(jLabelEtatProfil))
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEtat)
                    .addComponent(jLabelCo))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProfil)
                    .addComponent(jLabelEtatProfil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed
    
    float total = 0;
    /**
     * Boucle permettant de parcourir la table Vente et d'affecter toutes les valeurs de la colonne Prix à une variable
     */
    for (int i = 0; i < jTableVente.getRowCount(); i++)
    total += (float) jTableVente.getValueAt(i, 2);
         
    
    Date d = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    
    ManipComboBox cc = (ManipComboBox) jComboBoxClient.getSelectedItem();
    ManipComboBox cp = (ManipComboBox) jComboBoxPersonnel.getSelectedItem();
    
    
    
    Integer lesTuplesInsert = DaoSIO.getInstance().requeteAction("insert into vente (dateVente, chiffreAffaire, id_1, id_2) values ('" + formatter.format(d) + "', '" + total + "', '"+ cc.getId() +"' , '"+ cp.getId() +"')");            
    if (lesTuplesInsert == 0)
    {
        JOptionPane.showMessageDialog(this, "Echec de la requête.");
    }
    else {
        JOptionPane.showMessageDialog(this, "Vente créée !");
    }
    
            for (int i = 0; i < jTableVente.getRowCount(); i++)
                {
                String qte = jTableVente.getValueAt(i,1).toString();
                ManipComboBox cProd = (ManipComboBox) jTableVente.getValueAt(i,0);
                Integer lesTuplesContient = DaoSIO.getInstance().requeteAction("select last_insert_id() into lastid"
                        + "insert into contient values ('lastid','" + cProd.getId() + "','"+ qte +"')");
            if (lesTuplesContient == 0)
                {
                JOptionPane.showMessageDialog(this, "Echec de la requête (contient).");
                }
            else {
                JOptionPane.showMessageDialog(this, "Table OK");
                }
                } 
            DefaultTableModel leModel = (DefaultTableModel) jTableVente.getModel();
    }//GEN-LAST:event_jButtonValiderActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        
        String cp = jComboBoxProduit.getSelectedItem().toString();
        ManipComboBox pp = (ManipComboBox) jComboBoxProduit.getSelectedItem();
        DefaultTableModel leModel = (DefaultTableModel) jTableVente.getModel();
        
//                if(jTable4.getRowCount() > 0)
//                {   
//                    for (int i = 0; i < jTable4.getRowCount(); i++)
//                    {
//                    if (jTable4.getValueAt(i, 0).equals(cp))
//                    {
//                    int qte = Integer.valueOf(jTable4.getValueAt(i,1).toString());
//                    qte = qte + Integer.valueOf(jTextFieldQte.getText());
//                    jTable4.setValueAt(qte, i, 1); 
//                    }
//                    else {
                    leModel.addRow(new Object[]{cp, jTextFieldQte.getText(), pp.getPrix()});
//                    }
//                    }
//                }        
//                else         
//                {
//                leModel.addRow(new Object[]{cp, jTextFieldQte.getText(), pp.getPrix()});
//                }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonAddProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddProfilActionPerformed
     
        DetailProfil profil = new DetailProfil(this, true);
        profil.setVisible(true);
    }//GEN-LAST:event_jButtonAddProfilActionPerformed

    private void jButtonModifProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifProfilActionPerformed
    
        if (jTableProd.getSelectedRow() == -1)
        {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne");
        }
        else{
            ModifProfil modifp = new ModifProfil(this, true, this.getIDpr(), this.getIdent(), this.getNom(), this.getPrenom(), this.getMail(), this.getTel());
            modifp.setVisible(true);
        }
    }//GEN-LAST:event_jButtonModifProfilActionPerformed

    private void jButtonAfficherProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAfficherProfilActionPerformed
            DefaultTableModel leModel= (DefaultTableModel) jTablePersonnel.getModel();
        try {
            ResultSet lesTuples = DaoSIO.getInstance().requeteSelection("select * from personnel p inner join profil pr on p.id_1 = pr.id");
            leModel.setColumnCount(0);
            leModel.setRowCount(0);
            leModel.addColumn("ID");
            leModel.addColumn("Identifiant");
            leModel.addColumn("Nom");
            leModel.addColumn("Prenom");
            leModel.addColumn("Mail");
            leModel.addColumn("Tel");
            leModel.addColumn("Profil");// (a et b)

            while (lesTuples.next()) {
                leModel.addRow(new Object[]{lesTuples.getString("id"),lesTuples.getString("identifiant"), lesTuples.getString("nom"), lesTuples.getString("prenom"), lesTuples.getString("email"), lesTuples.getString("tel"), lesTuples.getString("libelle")});
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Erreur, l'exécution de la requête est un échec !!");
            Logger.getLogger(PPE3.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAfficherProfilActionPerformed

    private void jButtonModifCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifCliActionPerformed
        
        if (jTableCli.getSelectedRow() == -1)
        {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne");
        }
        else{
            ModifCli modif = new ModifCli (this, true, this.getID(), this.getCli(), this.getAdr(), this.getNum());
            modif.setVisible(true);
        }
    }//GEN-LAST:event_jButtonModifCliActionPerformed

    private void jButtonAjouterCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterCliActionPerformed
        /**
         * Affiche la jDialog DetailCli qui permet d'ajouter un client dans la table
         */
        DetailCli addCli = new DetailCli(this, true);
        addCli.setVisible(true);
    }//GEN-LAST:event_jButtonAjouterCliActionPerformed

    private void jButtonAfficherCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAfficherCliActionPerformed
       
        DefaultTableModel leModel= (DefaultTableModel) jTableCli.getModel();
        try {
            ResultSet lesTuples = DaoSIO.getInstance().requeteSelection("select * from client");
            leModel.setColumnCount(0);
            leModel.setRowCount(0);
            leModel.addColumn("ID");
            leModel.addColumn("Nom");
            leModel.addColumn("Adresse");
            leModel.addColumn("Numero");// (a et b)

            while (lesTuples.next()) {

                leModel.addRow(new Object[]{lesTuples.getString("id"), lesTuples.getString("nomClient"), lesTuples.getString("adresseClient"), lesTuples.getString("numClient")});
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Erreur, l'exécution de la requête est un échec !!");
            Logger.getLogger(PPE3.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAfficherCliActionPerformed

    private void jButtonModifProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifProdActionPerformed
        
        if (this.connecte != 0)

        {
            if (jTableProd.getSelectedRow() == -1)
            {
                JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne");
            }
            else{
                ModifProd modif = new ModifProd (this, true, this.getIDp(), this.getProd(), this.getStock(), this.getRef(), this.getPrix());
                modif.setVisible(true);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Veuillez vous connecter.");
        }
    }//GEN-LAST:event_jButtonModifProdActionPerformed

    private void jButtonAjouterProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterProdActionPerformed
  
        DetailProd detail = new DetailProd(this, true);
        detail.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButtonAjouterProdActionPerformed

    private void jButtonAfficherProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAfficherProdActionPerformed
        DefaultTableModel leModel= (DefaultTableModel) jTableProd.getModel();
        try {
            ResultSet lesTuples = DaoSIO.getInstance().requeteSelection("select * from produit p inner join categorie c on p.id_1 = c.id");
            leModel.setColumnCount(0);
            leModel.setRowCount(0);
            leModel.addColumn("ID");
            leModel.addColumn("Produit");
            leModel.addColumn("Stock");
            leModel.addColumn("Référence");
            leModel.addColumn("Prix");
            leModel.addColumn("Popularité");
            leModel.addColumn("Categorie");

            while (lesTuples.next()) {
                
                leModel.addRow(new Object[]{lesTuples.getString("id"), lesTuples.getString("nomproduit"), lesTuples.getString("stock"), lesTuples.getString("refproduit"),lesTuples.getString("prixProduit"), lesTuples.getString("populariteProduit") + "★", lesTuples.getString("nomcategorie")});
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Erreur, l'exécution de la requête est un échec !!");
            Logger.getLogger(PPE3.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonAfficherProdActionPerformed

    private void jButtonDeleteProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteProdActionPerformed
    /**
     * Supprime la ligne sélectionnée dans la jTable Vente
     */
    DefaultTableModel leModel= (DefaultTableModel) jTableVente.getModel();
    Integer id = jTableVente.getSelectedRow();
    if (jTableVente.getSelectedRow() == -1)
        {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne");
        }
        else
        
        {
        leModel.removeRow(id);
        }
    }//GEN-LAST:event_jButtonDeleteProdActionPerformed
    
    /**
     * Toutes les méthodes suivantes permettent d'obtenir les valeurs des différentes lignes dans chaques tables pour les renvoyer dans le jDialog Modif correspondant aux tables.  
     */
    public String getID(){
        Integer id = jTableCli.getSelectedRow();
        return (String) jTableCli.getValueAt(id,0);
    }
    
    public String getCli(){
    Integer nom = jTableCli.getSelectedRow();  
    return (String) jTableCli.getValueAt(nom,1);
}
    public String getAdr(){
    Integer adr = jTableCli.getSelectedRow();
    return (String) jTableCli.getValueAt(adr,2);
}
    public String getNum(){
    Integer num = jTableCli.getSelectedRow();
    return (String) jTableCli.getValueAt(num,3);
}
    public String getIDp(){
        Integer id = jTableProd.getSelectedRow();
        return (String) jTableProd.getValueAt(id, 0);
    }
   
    public String getProd(){
        Integer nom = jTableProd.getSelectedRow();
        return (String) jTableProd.getValueAt(nom, 1);
    }
    public String getStock(){
        Integer stock = jTableProd.getSelectedRow();
        return (String) jTableProd.getValueAt(stock, 2);
    }
    public String getRef(){
        Integer ref = jTableProd.getSelectedRow();
        return (String) jTableProd.getValueAt (ref, 3);
    }
    public String getPrix(){
        Integer prix = jTableProd.getSelectedRow();
        return (String) jTableProd.getValueAt(prix, 4);
    }
    
    public String getIDpr(){
        Integer id = jTablePersonnel.getSelectedRow();
        return (String) jTablePersonnel.getValueAt(id, 0);
    }
   
    public String getIdent(){
        Integer ident = jTablePersonnel.getSelectedRow();
        return (String) jTablePersonnel.getValueAt(ident, 1);
    }
    public String getNom(){
        Integer nom = jTablePersonnel.getSelectedRow();
        return (String) jTablePersonnel.getValueAt(nom, 2);
    }
    public String getPrenom(){
        Integer prenom = jTablePersonnel.getSelectedRow();
        return (String) jTablePersonnel.getValueAt (prenom, 3);
    }
    public String getMail(){
        Integer mail = jTablePersonnel.getSelectedRow();
        return (String) jTablePersonnel.getValueAt (mail, 4);
    }
    public String getTel(){
        Integer tel = jTablePersonnel.getSelectedRow();
        return (String) jTablePersonnel.getValueAt (tel, 5);
    }
       
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PPE3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PPE3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PPE3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PPE3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PPE3().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAddProfil;
    private javax.swing.JButton jButtonAfficherCli;
    private javax.swing.JButton jButtonAfficherProd;
    private javax.swing.JButton jButtonAfficherProfil;
    private javax.swing.JButton jButtonAjouterCli;
    private javax.swing.JButton jButtonAjouterProd;
    private javax.swing.JButton jButtonDeleteProd;
    private javax.swing.JButton jButtonModifCli;
    private javax.swing.JButton jButtonModifProd;
    private javax.swing.JButton jButtonModifProfil;
    private javax.swing.JButton jButtonValider;
    private javax.swing.JComboBox<String> jComboBoxClient;
    private javax.swing.JComboBox<String> jComboBoxPersonnel;
    private javax.swing.JComboBox<String> jComboBoxProduit;
    private javax.swing.JLabel jLabelClient;
    private javax.swing.JLabel jLabelCo;
    private javax.swing.JLabel jLabelEtat;
    private javax.swing.JLabel jLabelEtatProfil;
    private javax.swing.JLabel jLabelNoAccessProfil;
    private javax.swing.JLabel jLabelProduit;
    private javax.swing.JLabel jLabelProfil;
    private javax.swing.JLabel jLabelQte;
    private javax.swing.JPanel jPanelCli;
    private javax.swing.JPanel jPanelPersonnel;
    private javax.swing.JPanel jPanelProd;
    private javax.swing.JPanel jPanelVente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableCli;
    private javax.swing.JTable jTablePersonnel;
    private javax.swing.JTable jTableProd;
    private javax.swing.JTable jTableVente;
    private javax.swing.JTextField jTextFieldQte;
    // End of variables declaration//GEN-END:variables
}
