package com.keystone.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class NonConformite {

    @Id
    @GeneratedValue
    private Long id;
    private long idControle;
    private String description;


    public NonConformite() {
    }


    public NonConformite(long idControle, String description) {
        this.idControle = idControle;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getIdControle() {
        return idControle;
    }

    public void setIdControle(long idControle) {
        this.idControle = idControle;
    }

    public NonConformite(String description) {
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
