package com.example.api.model;

import java.util.Date;

public class Match {
    private Date date;
    private String equipeDomicile;
    private String equipeVisiteur;
    private String lieu;

    // Constructeur
    public Match(Date date, String equipeDomicile, String equipeVisiteur, String lieu) {
        this.date = date;
        this.equipeDomicile = equipeDomicile;
        this.equipeVisiteur = equipeVisiteur;
        this.lieu = lieu;
    }

    // Getters et Setters
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEquipeDomicile() {
        return equipeDomicile;
    }

    public void setEquipeDomicile(String equipeDomicile) {
        this.equipeDomicile = equipeDomicile;
    }

    public String getEquipeVisiteur() {
        return equipeVisiteur;
    }

    public void setEquipeVisiteur(String equipeVisiteur) {
        this.equipeVisiteur = equipeVisiteur;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setId(long long1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
}

