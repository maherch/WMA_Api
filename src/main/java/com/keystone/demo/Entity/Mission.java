package com.keystone.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mission {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idMission;
    private String dateDebut;
    private String dateFin;
    private String nomMission;
    private String sujetMission;

    public Mission(){}

    public Mission(int idMission,String dateDebut,String dateFin,String nomMission,String sujetMission )
    {
        super();
        this.idMission=idMission;
        this.dateDebut=dateDebut;
        this.dateFin=dateFin;
        this.nomMission=nomMission;
        this.sujetMission=sujetMission;

    }

    public int getIdMission() {
        return idMission;
    }

    public void setIdMission(int idMission) {
        this.idMission = idMission;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getNomMission() {
        return nomMission;
    }

    public void setNomMission(String nomMission) {
        this.nomMission = nomMission;
    }

    public String getSujetMission() {
        return sujetMission;
    }

    public void setSujetMission(String sujetMission) {
        this.sujetMission = sujetMission;
    }

    @Override
    public String toString() {
        return "Mission{" +
                "idMission=" + idMission +
                ", dateDebut='" + dateDebut + '\'' +
                ", dateFin='" + dateFin + '\'' +
                ", nomMission='" + nomMission + '\'' +
                ", sujetMission='" + sujetMission + '\'' +
                '}';
    }
}


