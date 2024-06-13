package com.example.api.model;

public class Equipe {
    private String nom;
    private String ville;
    private String logo; // Logo de l'équipe

    // Constructeur
    public Equipe(String nom, String ville, String logo) {
        this.nom = nom;
        this.ville = ville;
        this.logo = logo;
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    // Méthode pour afficher les détails de l'équipe
    public void afficherDetails() {
        System.out.println("Nom de l'équipe : " + nom);
        System.out.println("Ville de l'équipe : " + ville);
        // Affichage du logo ici (à implémenter selon les besoins)
    }
}

