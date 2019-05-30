package com.keystone.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ControlExistant {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int idControlExistant;
    private String titreControlExistant;
    private String descriptionControlExistant;

    public ControlExistant() {
    }

    public ControlExistant(int idControlExistant,String titreControlExistant, String descriptionControlExistant) {

        this.idControlExistant=idControlExistant;
        this.titreControlExistant = titreControlExistant;
        this.descriptionControlExistant = descriptionControlExistant;
    }

    public int getIdControlExistant() {
        return idControlExistant;
    }

    public String getTitreControlExistant() {
        return titreControlExistant;
    }

    public String getDescriptionControlExistant() {
        return descriptionControlExistant;
    }

    public void setIdControlExistant(int idControlExistant) {
        this.idControlExistant = idControlExistant;
    }

    public void setTitreControlExistant(String titreControlExistant) {
        this.titreControlExistant = titreControlExistant;
    }

    public void setDescriptionControlExistant(String descriptionControlExistant) {
        this.descriptionControlExistant = descriptionControlExistant;
    }

    @Override
    public String toString() {
        return "Control_Existant{" +
                "idControlExistant=" + idControlExistant +
                ", titreControlExistant='" + titreControlExistant + '\'' +
                ", descriptionControlExistant='" + descriptionControlExistant + '\'' +
                '}';
    }
}
