package com.keystone.demo.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Suggestion {


    @Id
    @GeneratedValue
    private Long id;
    private Long idNc;
    private String description;

    public Suggestion() {
    }

    public Suggestion(Long idNc, String description) {
        this.idNc = idNc;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdNc() {
        return idNc;
    }

    public void setIdNc(Long idNc) {
        this.idNc = idNc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
