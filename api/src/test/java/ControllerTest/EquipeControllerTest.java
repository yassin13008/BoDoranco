package ControllerTest;

import com.example.api.controllers.EquipeController;
import com.example.api.model.Equipe;
import com.example.api.repository.EquipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EquipeControllerTest {

    @Mock
    private EquipeRepository equipeRepository;

    @InjectMocks
    private EquipeController equipeController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllEquipes() {
        // Given
        Equipe equipe1 = new Equipe("Equipe A", "Logo A", "Ville A");
        Equipe equipe2 = new Equipe("Equipe B", "Logo B", "Ville B");
        List<Equipe> equipes = Arrays.asList(equipe1, equipe2);

        when(equipeRepository.findAll()).thenReturn(equipes);

        // When
        ResponseEntity<List<Equipe>> response = equipeController.getAllEquipes();

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(equipes, response.getBody());
    }

    @Test
    public void testGetEquipeById() {
        // Given
        Long equipeId = 1L;
        Equipe equipe = new Equipe("Equipe A", "Logo A", "Ville A");

        when(equipeRepository.findById(equipeId)).thenReturn(Optional.of(equipe));

        // When
        ResponseEntity<Equipe> response = equipeController.getEquipeById(equipeId);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(equipe, response.getBody());
    }

    @Test
    public void testGetEquipeByIdNotFound() {
        // Given
        Long equipeId = 1L;

        when(equipeRepository.findById(equipeId)).thenReturn(Optional.empty());

        // When
        ResponseEntity<Equipe> response = equipeController.getEquipeById(equipeId);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testCreateEquipe() {
        // Given
        Equipe equipe = new Equipe("Equipe A", "Logo A", "Ville A");

        when(equipeRepository.save(any(Equipe.class))).thenReturn(equipe);

        // When
        ResponseEntity<Equipe> response = equipeController.createEquipe(equipe);

        // Then
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(equipe, response.getBody());
    }

    @Test
    public void testUpdateEquipe() {
        // Given
        Long equipeId = 1L;
        Equipe existingEquipe = new Equipe("Equipe A", "Logo A", "Ville A");
        Equipe updatedEquipe = new Equipe("Equipe A Updated", "Logo A Updated", "Ville A Updated");

        when(equipeRepository.findById(equipeId)).thenReturn(Optional.of(existingEquipe));
        when(equipeRepository.save(any(Equipe.class))).thenReturn(updatedEquipe);

        // When
        ResponseEntity<Equipe> response = equipeController.updateEquipe(equipeId, updatedEquipe);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testUpdateEquipeNotFound() {
        // Given
        Long equipeId = 1L;
        Equipe updatedEquipe = new Equipe("Equipe A Updated", "Logo A Updated", "Ville A Updated");

        when(equipeRepository.findById(equipeId)).thenReturn(Optional.empty());

        // When
        ResponseEntity<Equipe> response = equipeController.updateEquipe(equipeId, updatedEquipe);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testDeleteEquipe() {
        // Given
        Long equipeId = 1L;

        when(equipeRepository.existsById(equipeId)).thenReturn(true);

        // When
        ResponseEntity<Void> response = equipeController.deleteEquipe(equipeId);

        // Then
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(equipeRepository, times(1)).deleteById(equipeId);
    }

    @Test
    public void testDeleteEquipeNotFound() {
        // Given
        Long equipeId = 1L;

        when(equipeRepository.existsById(equipeId)).thenReturn(false);

        // When
        ResponseEntity<Void> response = equipeController.deleteEquipe(equipeId);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(equipeRepository, never()).deleteById(equipeId);
    }
}
