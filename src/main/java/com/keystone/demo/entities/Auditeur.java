package com.keystone.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Auditeur {

    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String prenom;
    private String datenais;
    private String cin;
    private String sexe;
    private String type;
    private String email;
    private String telephone;
    private String pays;
    private String NomUtili;
    private String motPass;


    public Auditeur(String nom, String prenom, String datenais, String cin, String sexe, String type, String email, String telephone, String pays) {
        this.nom = nom;
        this.prenom = prenom;
        this.datenais = datenais;
        this.cin = cin;
        this.sexe = sexe;
        this.type = type;
        this.email = email;
        this.telephone = telephone;
        this.pays = pays;
    }


    public Auditeur() {
    }


    public String getNomUtili() {
        return NomUtili;
    }

    public void setNomUtili(String nomUtili) {
        NomUtili = nomUtili;
    }

    public String getMotPass() {
        return motPass;
    }

    public void setMotPass(String motPass) {
        this.motPass = motPass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDatenais() {
        return datenais;
    }

    public void setDatenais(String datenais) {
        this.datenais = datenais;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}
