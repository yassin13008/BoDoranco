package com.example.api.controllers;

import com.example.api.repository.BilletRepository;
import com.example.api.repository.model.Billet;
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
    public BilletController(BilletRepository equipeDAO) {
        this.billetRepository = equipeDAO;
    }

    // Endpoint pour récupérer toutes les équipes
    @GetMapping
    public ResponseEntity<List<Billet>> getAllBillets() {
        List<Billet> billets = billetRepository.findAll();
        return new ResponseEntity<>(billets, HttpStatus.OK);
    }



}