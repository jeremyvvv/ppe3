/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ppe3;

/**
 *
 * @author j.vassant
 */
public class CategorieCombo {
    String id;
    String value;
    String prix;

    public CategorieCombo(String id, String value, String prix) {
        this.id = id;
        this.value = value;
        this.prix = prix;
    }
    
    public CategorieCombo(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
    
}
