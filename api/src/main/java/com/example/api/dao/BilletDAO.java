/** package com.example.api.dao;

import com.example.api.model.Billet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BilletDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BilletDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Méthode pour récupérer tous les billets depuis la base de données
    public List<Billet> getAllBillets() {
        String sql = "SELECT * FROM billet";
        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new Billet(resultSet.getString("type"),
                        resultSet.getString("categorie"),
                        resultSet.getDouble("prix")));
    }

    // Méthode pour récupérer un billet par son ID depuis la base de données
    public Billet getBilletById(Long id) {
        String sql = "SELECT * FROM billet WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, rowNum) ->
                new Billet(resultSet.getString("type"),
                        resultSet.getString("categorie"),
                        resultSet.getDouble("prix")));
    }

    // Méthode pour créer un nouveau billet dans la base de données
    public Billet createBillet(Billet billet) {
        String sql = "INSERT INTO billet (type, categorie, prix) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, billet.getType(), billet.getCategorie(), billet.getPrix());
        return billet;
    }

    // Méthode pour mettre à jour un billet existant dans la base de données
    public Billet updateBillet(Long id, Billet billet) {
        String sql = "UPDATE billet SET type = ?, categorie = ?, prix = ? WHERE id = ?";
        jdbcTemplate.update(sql, billet.getType(), billet.getCategorie(), billet.getPrix(), id);
        return billet;
    }

    // Méthode pour supprimer un billet existant de la base de données
    public boolean deleteBillet(Long id) {
        String sql = "DELETE FROM billet WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    // Méthode pour récupérer le prix de base d'un billet standard depuis la base de données
    public double getPrixBaseBilletStandard() {
        String sql = "SELECT prix FROM billet WHERE type = 'Standard'";
        return jdbcTemplate.queryForObject(sql, Double.class);
    }

    // Méthode pour récupérer le prix de base d'un billet VIP depuis la base de données
    public double getPrixBaseBilletVIP() {
        String sql = "SELECT prix FROM billet WHERE type = 'VIP'";
        return jdbcTemplate.queryForObject(sql, Double.class);
    }

    // Méthode pour récupérer le prix de base d'un billet Premium depuis la base de données
    public double getPrixBaseBilletPremium() {
        String sql = "SELECT prix FROM billet WHERE type = 'Premium'";
        return jdbcTemplate.queryForObject(sql, Double.class);
    }
} **/
