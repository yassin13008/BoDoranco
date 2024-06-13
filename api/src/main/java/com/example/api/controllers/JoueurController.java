package com.example.api.controllers;

import com.example.api.dao.JoueurDAO;
import com.example.api.model.Joueur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joueurs")
public class JoueurController {

    private final JoueurDAO joueurDAO;

    @Autowired
    public JoueurController(JoueurDAO joueurDAO) {
        this.joueurDAO = joueurDAO;
    }

    // Endpoint pour récupérer tous les joueurs
    @GetMapping
    public ResponseEntity<List<Joueur>> getAllJoueurs() {
        List<Joueur> joueurs = joueurDAO.getAllJoueurs();
        return new ResponseEntity<>(joueurs, HttpStatus.OK);
    }

    // Endpoint pour récupérer un joueur par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Joueur> getJoueurById(@PathVariable("id") Long id) {
        Joueur joueur = joueurDAO.getJoueurById(id);
        if (joueur != null) {
            return new ResponseEntity<>(joueur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour créer un nouveau joueur
    @PostMapping
    public ResponseEntity<Joueur> createJoueur(@RequestBody Joueur joueur) {
        Joueur newJoueur = joueurDAO.createJoueur(joueur);
        return new ResponseEntity<>(newJoueur, HttpStatus.CREATED);
    }

    // Endpoint pour mettre à jour un joueur existant
    @PutMapping("/{id}")
    public ResponseEntity<Joueur> updateJoueur(@PathVariable("id") Long id, @RequestBody Joueur joueur) {
        Joueur updatedJoueur = joueurDAO.updateJoueur(id, joueur);
        if (updatedJoueur != null) {
            return new ResponseEntity<>(updatedJoueur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour supprimer un joueur existant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJoueur(@PathVariable("id") Long id) {
        boolean deleted = joueurDAO.deleteJoueur(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
