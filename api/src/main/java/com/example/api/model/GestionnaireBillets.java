package com.example.api.model;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireBillets {
    public List<Billet> billets;

    // Constructeur
    public GestionnaireBillets() {
        this.billets = new ArrayList<>();
    }

    // Méthode pour ajouter un billet
    public void ajouterBillet(Billet billet) {
        billets.add(billet);
    }

    // Méthode pour afficher tous les billets
    public void afficherBillets() {
        System.out.println("Liste des billets disponibles :");
        for (Billet billet : billets) {
            System.out.println("Type: " + billet.getType() + ", Catégorie: " + billet.getCategorie() + ", Prix: " + billet.getPrix() + "€");
        }
    }

    // Méthode principale pour tester le gestionnaire de billets
    public static void main(String[] args) {
        GestionnaireBillets gestionnaire = new GestionnaireBillets();
        
        // Ajout de quelques billets pour tester
        // gestionnaire.ajouterBillet(new Billet("Standard", "Tribune", 25.0));
        // gestionnaire.ajouterBillet(new Billet("VIP", "Loge", 100.0));
        
        // Affichage des billets
        gestionnaire.afficherBillets();
    }
}

