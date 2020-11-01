/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ppe3;

/**
 * Cette classe permet d'insérer un objet dans une combobox, puis de récupérer l'id, valeur ou prix de l'objet contenu dans cette ComboBox
 * @author j.vassant
 */
public class ManipComboBox {
    String id;
    String value;
    float prix;

    public ManipComboBox(String id, String value, float prix) {
        this.id = id;
        this.value = value;
        this.prix = prix;
    }
    
    public ManipComboBox(String id, String value) {
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

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
    
}
