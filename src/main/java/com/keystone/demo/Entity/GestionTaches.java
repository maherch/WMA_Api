package com.keystone.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GestionTaches {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int idGestionTaches;
    private String titreGestionTaches;
    private String descriptionGestionTaches;
    private int durééGestionTaches;

    public GestionTaches() {
    }

    public GestionTaches( int idGestionTaches,String titreGestionTaches, String descriptionGestionTaches, int durééGestionTaches) {

        this.idGestionTaches=idGestionTaches;
        this.titreGestionTaches = titreGestionTaches;
        this.descriptionGestionTaches = descriptionGestionTaches;
        this.durééGestionTaches = durééGestionTaches;
    }

    public int getIdGestionTaches() {
        return idGestionTaches;
    }

    public String getTitreGestionTaches() {
        return titreGestionTaches;
    }

    public String getDescriptionGestionTaches() {
        return descriptionGestionTaches;
    }

    public int getDurééGestionTaches() {
        return durééGestionTaches;
    }

    public void setIdGestionTaches(int idGestionTaches) {
        this.idGestionTaches = idGestionTaches;
    }

    public void setTitreGestionTaches(String titreGestionTaches) {
        this.titreGestionTaches = titreGestionTaches;
    }

    public void setDescriptionGestionTaches(String descriptionGestionTaches) {
        this.descriptionGestionTaches = descriptionGestionTaches;
    }

    public void setDurééGestionTaches(int durééGestionTaches) {
        this.durééGestionTaches = durééGestionTaches;
    }

    @Override
    public String toString() {
        return "Gestion_Taches{" +
                "idGestionTaches=" + idGestionTaches +
                ", titreGestionTaches='" + titreGestionTaches + '\'' +
                ", descriptionGestionTaches='" + descriptionGestionTaches + '\'' +
                ", durééGestionTaches=" + durééGestionTaches +
                '}';
    }
}
