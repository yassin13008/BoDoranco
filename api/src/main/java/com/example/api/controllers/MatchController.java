package com.example.api.controllers;

import com.example.api.model.Match;
import com.example.api.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    private final MatchRepository matchRepository;

    @Autowired
    public MatchController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    // Endpoint to get all matches
    @GetMapping
    public ResponseEntity<List<Match>> getAllMatches() {
        List<Match> matches = matchRepository.findAll();
        return new ResponseEntity<>(matches, HttpStatus.OK);
    }

    // Endpoint to get a match by ID
    @GetMapping("/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable("id") Long id) {
        return matchRepository.findById(id)
                .map(match -> new ResponseEntity<>(match, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint to create a new match
    @PostMapping
    public ResponseEntity<Match> createMatch(@RequestBody Match match) {
        Match newMatch = matchRepository.save(match);
        return new ResponseEntity<>(newMatch, HttpStatus.CREATED);
    }

    // Endpoint to update an existing match
    @PutMapping("/{id}")
    public ResponseEntity<Match> updateMatch(@PathVariable("id") Long id, @RequestBody Match match) {
        return matchRepository.findById(id)
                .map(existingMatch -> {
                    existingMatch.setDate(match.getDate());
                    existingMatch.setLocation(match.getLocation());
                    existingMatch.setTeamA(match.getTeamA());
                    existingMatch.setTeamB(match.getTeamB());
                    existingMatch.setScoreA(match.getScoreA());
                    existingMatch.setScoreB(match.getScoreB());
                    matchRepository.save(existingMatch);
                    return new ResponseEntity<>(existingMatch, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint to delete an existing match
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable("id") Long id) {
        if (matchRepository.existsById(id)) {
            matchRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
