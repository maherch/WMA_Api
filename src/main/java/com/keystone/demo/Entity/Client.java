package com.keystone.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client {
    @Id
    @GeneratedValue
    private Long id;
    private String societe;
    private String activite;
    private String CodePostal;
    private String ville;
    private String dep;
    private String region;
    private String tel1;
    private String tel2;
    private String mail;
    private String pays;

    public Client() {
    }

    public Client(String société, String activité, String codePostal, String ville, String dep, String region, String tel1, String tel2, String mail, String pays) {
        this.societe = société;
        this.activite = activité;
        CodePostal = codePostal;
        this.ville = ville;
        this.dep = dep;
        this.region = region;
        this.tel1 = tel1;
        this.tel2 = tel2;
        this.mail = mail;
        this.pays = pays;
    }


    public String getSociété() {
        return societe;
    }

    public void setSociété(String société) {
        this.societe = société;
    }

    public String getActivité() {
        return activite;
    }

    public void setActivité(String activité) {
        this.activite = activité;
    }

    public String getCodePostal() {
        return CodePostal;
    }

    public void setCodePostal(String codePostal) {
        CodePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}
