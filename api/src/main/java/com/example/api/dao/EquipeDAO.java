package com.example.api.dao;

import com.example.api.model.Equipe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EquipeDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EquipeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Méthode pour récupérer toutes les équipes depuis la base de données
    public List<Equipe> getAllEquipes() {
        String sql = "SELECT * FROM equipe";
        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new Equipe(resultSet.getString("nom"),
                        resultSet.getString("ville"),
                        resultSet.getString("logo")));
    }

    // Méthode pour récupérer une équipe par son ID depuis la base de données
    public Equipe getEquipeById(Long id) {
        String sql = "SELECT * FROM equipe WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, rowNum) ->
                new Equipe(resultSet.getString("nom"),
                        resultSet.getString("ville"),
                        resultSet.getString("logo")));
    }

    // Méthode pour créer une nouvelle équipe dans la base de données
    public Equipe createEquipe(Equipe equipe) {
        String sql = "INSERT INTO equipe (nom, ville, logo) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, equipe.getNom(), equipe.getVille(), equipe.getLogo());
        return equipe;
    }

    // Méthode pour mettre à jour une équipe existante dans la base de données
    public Equipe updateEquipe(Long id, Equipe equipe) {
        String sql = "UPDATE equipe SET nom = ?, ville = ?, logo = ? WHERE id = ?";
        jdbcTemplate.update(sql, equipe.getNom(), equipe.getVille(), equipe.getLogo(), id);
        return equipe;
    }

    // Méthode pour supprimer une équipe existante de la base de données
    public boolean deleteEquipe(Long id) {
        String sql = "DELETE FROM equipe WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }
}
