package com.example.api.controllers;

import com.example.api.repository.EquipeRepository;
import com.example.api.model.Equipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipes")
public class EquipeController {

    private final EquipeRepository equipeRepository;

    @Autowired
    public EquipeController(EquipeRepository equipeDAO) {
        this.equipeRepository = equipeDAO;
    }

    // Endpoint pour récupérer toutes les équipes
    @GetMapping
    public ResponseEntity<List<Equipe>> getAllEquipes() {
        List<Equipe> equipes = equipeRepository.findAll();
        return new ResponseEntity<>(equipes, HttpStatus.OK);
    }

    // Endpoint pour récupérer une équipe par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Equipe> getEquipeById(@PathVariable("id") Long id) {
        return equipeRepository.findById(id)
                .map(equipe -> new ResponseEntity<>(equipe, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint pour créer une nouvelle équipe
    @PostMapping
    public ResponseEntity<Equipe> createEquipe(@RequestBody Equipe equipe) {
        Equipe newEquipe = equipeRepository.save(equipe);
        return new ResponseEntity<>(newEquipe, HttpStatus.CREATED);
    }

    // Endpoint pour mettre à jour une équipe existante
    @PutMapping("/{id}")
    public ResponseEntity<Equipe> updateEquipe(@PathVariable("id") Long id, @RequestBody Equipe equipe) {
        return equipeRepository.findById(id)
                .map(existingBillet -> {
                    existingBillet.setLogo(existingBillet.getLogo());
                    existingBillet.setNom(existingBillet.getNom());
                    existingBillet.setVille(existingBillet.getVille());
                    equipeRepository.save(existingBillet);
                    return new ResponseEntity<>(existingBillet, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint pour supprimer une équipe existante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipe(@PathVariable("id") Long id) {
        if (equipeRepository.existsById(id)) {
            equipeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
