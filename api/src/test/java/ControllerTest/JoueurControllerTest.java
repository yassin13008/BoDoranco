package ControllerTest;

import com.example.api.controllers.JoueurController;
import com.example.api.model.Equipe;
import com.example.api.model.Joueur;
import com.example.api.repository.JoueurRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class JoueurControllerTest {

    @Mock
    private JoueurRepository joueurRepository;

    @InjectMocks
    private JoueurController joueurController;

    private Equipe teamA;
    private Equipe teamB;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        teamA = new Equipe();
        teamA.setId(1L);
        teamA.setNom("Team A");

        teamB = new Equipe();
        teamB.setId(2L);
        teamB.setNom("Team B");
    }

    @Test
    public void testGetAllJoueurs() {
        // Given
        List<Joueur> joueurs = new ArrayList<>();
        joueurs.add(new Joueur("Doe", "John", teamA));
        joueurs.add(new Joueur("Smith", "Jane", teamB));

        when(joueurRepository.findAll()).thenReturn(joueurs);

        // When
        ResponseEntity<List<Joueur>> response = joueurController.getAllJoueurs();

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(joueurs, response.getBody());
    }

    @Test
    public void testGetJoueurById() {
        // Given
        Long id = 1L;
        Joueur joueur = new Joueur("Doe", "John", teamA);

        when(joueurRepository.findById(id)).thenReturn(Optional.of(joueur));

        // When
        ResponseEntity<Joueur> response = joueurController.getJoueurById(id);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(joueur, response.getBody());
    }

    @Test
    public void testGetJoueurByIdNotFound() {
        // Given
        Long id = 2L;

        when(joueurRepository.findById(id)).thenReturn(Optional.empty());

        // When
        ResponseEntity<Joueur> response = joueurController.getJoueurById(id);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testCreateJoueur() {
        // Given
        Joueur newJoueur = new Joueur("Doe", "John", teamA);

        when(joueurRepository.save(any(Joueur.class))).thenReturn(newJoueur);

        // When
        ResponseEntity<Joueur> response = joueurController.createJoueur(newJoueur);

        // Then
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newJoueur, response.getBody());
    }

    @Test
    public void testUpdateJoueur() {
        // Given
        Long id = 1L;
        Joueur existingJoueur = new Joueur("Doe", "John", teamA);
        Joueur updatedJoueur = new Joueur("Smith", "Jane", teamB);

        when(joueurRepository.findById(id)).thenReturn(Optional.of(existingJoueur));
        when(joueurRepository.save(any(Joueur.class))).thenReturn(updatedJoueur);

        // When
        ResponseEntity<Joueur> response = joueurController.updateJoueur(id, updatedJoueur);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testUpdateJoueurNotFound() {
        // Given
        Long id = 2L;
        Joueur updatedJoueur = new Joueur("Smith", "Jane", teamB);

        when(joueurRepository.findById(id)).thenReturn(Optional.empty());

        // When
        ResponseEntity<Joueur> response = joueurController.updateJoueur(id, updatedJoueur);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testDeleteJoueur() {
        // Given
        Long id = 1L;

        when(joueurRepository.existsById(id)).thenReturn(true);

        // When
        ResponseEntity<Void> response = joueurController.deleteJoueur(id);

        // Then
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(joueurRepository, times(1)).deleteById(id);
    }

    @Test
    public void testDeleteJoueurNotFound() {
        // Given
        Long id = 2L;

        when(joueurRepository.existsById(id)).thenReturn(false);

        // When
        ResponseEntity<Void> response = joueurController.deleteJoueur(id);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(joueurRepository, never()).deleteById(id);
    }
}
