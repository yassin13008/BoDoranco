package com.example.api.dao;

import com.example.api.model.Match;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MatchDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MatchDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Méthode pour récupérer tous les matchs depuis la base de données
    public List<Match> getAllMatchs() {
        String sql = "SELECT * FROM match";
        return jdbcTemplate.query(sql, new MatchMapper());
    }

    // Méthode pour récupérer un match par son ID depuis la base de données
    public Match getMatchById(Long id) {
        String sql = "SELECT * FROM match WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new MatchMapper());
    }

    // Méthode pour créer un nouveau match dans la base de données
    public Match createMatch(Match match) {
        String sql = "INSERT INTO match (date, equipe_domicile, equipe_visiteur, lieu) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, match.getDate(), match.getEquipeDomicile(), match.getEquipeVisiteur(), match.getLieu());
        return match;
    }

    // Méthode pour mettre à jour un match existant dans la base de données
    public Match updateMatch(Long id, Match match) {
        String sql = "UPDATE match SET date = ?, equipe_domicile = ?, equipe_visiteur = ?, lieu = ? WHERE id = ?";
        jdbcTemplate.update(sql, match.getDate(), match.getEquipeDomicile(), match.getEquipeVisiteur(), match.getLieu(), id);
        return match;
    }

    // Méthode pour supprimer un match existant de la base de données
    public boolean deleteMatch(Long id) {
        String sql = "DELETE FROM match WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    // RowMapper pour mapper les lignes de la table match à des objets Match
    private static class MatchMapper implements RowMapper<Match> {
        @Override
        public Match mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Match match = new Match(null, null, null, null);
            match.setId(resultSet.getLong("id"));
            match.setDate(resultSet.getDate("date"));
            match.setEquipeDomicile(resultSet.getString("equipe_domicile"));
            match.setEquipeVisiteur(resultSet.getString("equipe_visiteur"));
            match.setLieu(resultSet.getString("lieu"));
            return match;
        }
    }
}
