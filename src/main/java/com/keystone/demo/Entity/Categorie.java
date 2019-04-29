package com.keystone.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idCategorie;
    private String nomCategorie;
    private String descriptionCategorie;

    public Categorie(){

    }

    public Categorie(int idCategorie,String nomCategorie,String descriptionCategorie )
    {
        super();
        this.idCategorie=idCategorie;
        this.nomCategorie=nomCategorie;
        this.descriptionCategorie=descriptionCategorie;

    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public String getDescriptionCategorie() {
        return descriptionCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public void setDescriptionCategorie(String descriptionCategorie) {
        this.descriptionCategorie = descriptionCategorie;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "idCategorie=" + idCategorie +
                ", nomCategorie='" + nomCategorie + '\'' +
                ", descriptionCategorie='" + descriptionCategorie + '\'' +
                '}';
    }
}
