package com.example.api.controllers;

import com.example.api.dao.EquipeDAO;
import com.example.api.model.Equipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipes")
public class EquipeController {

    private final EquipeDAO equipeDAO;

    @Autowired
    public EquipeController(EquipeDAO equipeDAO) {
        this.equipeDAO = equipeDAO;
    }

    // Endpoint pour récupérer toutes les équipes
    @GetMapping
    public ResponseEntity<List<Equipe>> getAllEquipes() {
        List<Equipe> equipes = equipeDAO.getAllEquipes();
        return new ResponseEntity<>(equipes, HttpStatus.OK);
    }

    // Endpoint pour récupérer une équipe par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Equipe> getEquipeById(@PathVariable("id") Long id) {
        Equipe equipe = equipeDAO.getEquipeById(id);
        if (equipe != null) {
            return new ResponseEntity<>(equipe, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour créer une nouvelle équipe
    @PostMapping
    public ResponseEntity<Equipe> createEquipe(@RequestBody Equipe equipe) {
        Equipe newEquipe = equipeDAO.createEquipe(equipe);
        return new ResponseEntity<>(newEquipe, HttpStatus.CREATED);
    }

    // Endpoint pour mettre à jour une équipe existante
    @PutMapping("/{id}")
    public ResponseEntity<Equipe> updateEquipe(@PathVariable("id") Long id, @RequestBody Equipe equipe) {
        Equipe updatedEquipe = equipeDAO.updateEquipe(id, equipe);
        if (updatedEquipe != null) {
            return new ResponseEntity<>(updatedEquipe, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour supprimer une équipe existante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipe(@PathVariable("id") Long id) {
        boolean deleted = equipeDAO.deleteEquipe(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
