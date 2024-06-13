package com.example.api.controllers;

import com.example.api.dao.MatchDAO;
import com.example.api.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matchs")
public class MatchController {

    private final MatchDAO matchDAO;

    @Autowired
    public MatchController(MatchDAO matchDAO) {
        this.matchDAO = matchDAO;
    }

    // Endpoint pour récupérer tous les matchs
    @GetMapping
    public ResponseEntity<List<Match>> getAllMatchs() {
        List<Match> matchs = matchDAO.getAllMatchs();
        return new ResponseEntity<>(matchs, HttpStatus.OK);
    }

    // Endpoint pour récupérer un match par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable("id") Long id) {
        Match match = matchDAO.getMatchById(id);
        if (match != null) {
            return new ResponseEntity<>(match, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour créer un nouveau match
    @PostMapping
    public ResponseEntity<Match> createMatch(@RequestBody Match match) {
        Match newMatch = matchDAO.createMatch(match);
        return new ResponseEntity<>(newMatch, HttpStatus.CREATED);
    }

    // Endpoint pour mettre à jour un match existant
    @PutMapping("/{id}")
    public ResponseEntity<Match> updateMatch(@PathVariable("id") Long id, @RequestBody Match match) {
        Match updatedMatch = matchDAO.updateMatch(id, match);
        if (updatedMatch != null) {
            return new ResponseEntity<>(updatedMatch, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour supprimer un match existant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable("id") Long id) {
        boolean deleted = matchDAO.deleteMatch(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
