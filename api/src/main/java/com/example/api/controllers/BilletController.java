package com.example.api.controllers;

import com.example.api.repository.BilletRepository;
import com.example.api.model.Billet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billets")
public class BilletController {

    private final BilletRepository billetRepository;

    @Autowired
    public BilletController(BilletRepository billetRepository) {
        this.billetRepository = billetRepository;
    }

    @GetMapping
    public ResponseEntity<List<Billet>> getAllBillets() {
        List<Billet> billets = billetRepository.findAll();
        return new ResponseEntity<>(billets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Billet> getBilletById(@PathVariable("id") Long id) {
        return billetRepository.findById(id)
                .map(billet -> new ResponseEntity<>(billet, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Billet> createBillet(@RequestBody Billet billet) {
        Billet newBillet = billetRepository.save(billet);
        return new ResponseEntity<>(newBillet, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Billet> updateBillet(@PathVariable("id") Long id, @RequestBody Billet billet) {
        return billetRepository.findById(id)
                .map(existingBillet -> {
                    existingBillet.setType(billet.getType());
                    existingBillet.setCategorie(billet.getCategorie());
                    existingBillet.setPrix(billet.getPrix());
                    billetRepository.save(existingBillet);
                    return new ResponseEntity<>(existingBillet, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBillet(@PathVariable("id") Long id) {
        if (billetRepository.existsById(id)) {
            billetRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
