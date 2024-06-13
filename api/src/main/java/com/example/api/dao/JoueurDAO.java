package com.example.api.dao;

import com.example.api.model.Joueur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JoueurDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JoueurDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Méthode pour récupérer tous les joueurs depuis la base de données
    public List<Joueur> getAllJoueurs() {
        String sql = "SELECT * FROM joueur";
        return jdbcTemplate.query(sql, new JoueurMapper());
    }

    // Méthode pour récupérer un joueur par son ID depuis la base de données
    public Joueur getJoueurById(Long id) {
        String sql = "SELECT * FROM joueur WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new JoueurMapper());
    }

    // Méthode pour créer un nouveau joueur dans la base de données
    public Joueur createJoueur(Joueur joueur) {
        String sql = "INSERT INTO joueur (nom, prenom, equipe_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, joueur.getNom(), joueur.getEquipe());
        return joueur;
    }

    // Méthode pour mettre à jour un joueur existant dans la base de données
    public Joueur updateJoueur(Long id, Joueur joueur) {
        String sql = "UPDATE joueur SET nom = ?, prenom = ?, equipe_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, joueur.getNom(), joueur.getEquipe(), id);
        return joueur;
    }

    // Méthode pour supprimer un joueur existant de la base de données
    public boolean deleteJoueur(Long id) {
        String sql = "DELETE FROM joueur WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    // RowMapper pour mapper les lignes de la table joueur à des objets Joueur
    private static class JoueurMapper implements RowMapper<Joueur> {
        @Override
        public Joueur mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Joueur joueur = new Joueur(null, rowNum, null);
            joueur.setNom(resultSet.getString("nom"));
            return joueur;
        }
    }
}
