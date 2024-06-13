package com.example.api.model;

public class Joueur {
    private String nom;
    private int numeroMaillot;
    private Equipe equipe;

    // Constructeur
    public Joueur(String nom, int numeroMaillot, Equipe equipe) {
        this.nom = nom;
        this.numeroMaillot = numeroMaillot;
        this.equipe = equipe;
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumeroMaillot() {
        return numeroMaillot;
    }

    public void setNumeroMaillot(int numeroMaillot) {
        this.numeroMaillot = numeroMaillot;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
