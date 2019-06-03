package com.keystone.demo.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
public class Questionnaire {

    @Id
    @GeneratedValue
    private Long id;
    private String reference;
    private String titre;
    private String description;


    public Questionnaire() {
    }

    public Questionnaire(String reference, String titre, String description) {
        this.reference = reference;
        this.titre = titre;
        this.description = description;
    }


    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
