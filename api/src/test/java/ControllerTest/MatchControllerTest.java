package ControllerTest;

import com.example.api.controllers.MatchController;
import com.example.api.model.Equipe;
import com.example.api.model.Match;
import com.example.api.repository.MatchRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MatchControllerTest {

    @Mock
    private MatchRepository matchRepository;

    @InjectMocks
    private MatchController matchController;

    private Equipe teamA;
    private Equipe teamB;
    private Equipe teamC;
    private Equipe teamD;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        teamA = new Equipe();
        teamA.setId(1L);
        teamA.setNom("Team A");

        teamB = new Equipe();
        teamB.setId(2L);
        teamB.setNom("Team B");

        teamC = new Equipe();
        teamC.setId(3L);
        teamC.setNom("Team C");

        teamD = new Equipe();
        teamD.setId(4L);
        teamD.setNom("Team D");
    }

    @Test
    public void testGetAllMatches() {
        // Given
        List<Match> matches = new ArrayList<>();
        matches.add(new Match(new Date(), "Location A", teamA, teamB, 1, 2));
        matches.add(new Match(new Date(), "Location B", teamC, teamD, 3, 4));

        when(matchRepository.findAll()).thenReturn(matches);

        // When
        ResponseEntity<List<Match>> response = matchController.getAllMatches();

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(matches, response.getBody());
    }

    @Test
    public void testGetMatchById() {
        // Given
        Long id = 1L;
        Match match = new Match(new Date(), "Location A", teamA, teamB, 1, 2);

        when(matchRepository.findById(id)).thenReturn(Optional.of(match));

        // When
        ResponseEntity<Match> response = matchController.getMatchById(id);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(match, response.getBody());
    }

    @Test
    public void testGetMatchByIdNotFound() {
        // Given
        Long id = 2L;

        when(matchRepository.findById(id)).thenReturn(Optional.empty());

        // When
        ResponseEntity<Match> response = matchController.getMatchById(id);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testCreateMatch() {
        // Given
        Match newMatch = new Match(new Date(), "Location A", teamA, teamB, 1, 2);

        when(matchRepository.save(any(Match.class))).thenReturn(newMatch);

        // When
        ResponseEntity<Match> response = matchController.createMatch(newMatch);

        // Then
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newMatch, response.getBody());
    }

    @Test
    public void testUpdateMatch() {
        // Given
        Long id = 1L;
        Match existingMatch = new Match(new Date(), "Location A", teamA, teamB, 1, 2);
        Match updatedMatch = new Match(new Date(), "Location B", teamC, teamD, 3, 4);

        when(matchRepository.findById(id)).thenReturn(Optional.of(existingMatch));
        when(matchRepository.save(any(Match.class))).thenReturn(updatedMatch);

        // When
        ResponseEntity<Match> response = matchController.updateMatch(id, updatedMatch);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testUpdateMatchNotFound() {
        // Given
        Long id = 2L;
        Match updatedMatch = new Match(new Date(), "Location B", teamC, teamD, 3, 4);

        when(matchRepository.findById(id)).thenReturn(Optional.empty());

        // When
        ResponseEntity<Match> response = matchController.updateMatch(id, updatedMatch);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testDeleteMatch() {
        // Given
        Long id = 1L;

        when(matchRepository.existsById(id)).thenReturn(true);

        // When
        ResponseEntity<Void> response = matchController.deleteMatch(id);

        // Then
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(matchRepository, times(1)).deleteById(id);
    }

    @Test
    public void testDeleteMatchNotFound() {
        // Given
        Long id = 2L;

        when(matchRepository.existsById(id)).thenReturn(false);

        // When
        ResponseEntity<Void> response = matchController.deleteMatch(id);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(matchRepository, never()).deleteById(id);
    }
}
