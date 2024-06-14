package ControllerTest;

import com.example.api.model.Billet;
import com.example.api.repository.BilletRepository;
import com.example.api.controllers.BilletController;
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
import static org.mockito.Mockito.*;

public class BilletControllerTest {

    @Mock
    private BilletRepository billetRepository;

    @InjectMocks
    private BilletController billetController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllBillets() {
        // Mock data
        Billet billet1 = new Billet("Match", "VIP", 150.0);
        Billet billet2 = new Billet("Concert", "Standard", 75.0);
        List<Billet> billetList = Arrays.asList(billet1, billet2);

        // Mock repository method
        when(billetRepository.findAll()).thenReturn(billetList);

        // Call controller method
        ResponseEntity<List<Billet>> response = billetController.getAllBillets();

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        assertEquals(billet1, response.getBody().get(0));
        assertEquals(billet2, response.getBody().get(1));
    }

    @Test
    public void testGetBilletById() {
        // Mock data
        Long billetId = 1L;
        Billet billet = new Billet("Match", "VIP", 150.0);
        billet.setId(billetId);

        // Mock repository method
        when(billetRepository.findById(billetId)).thenReturn(Optional.of(billet));

        // Call controller method
        ResponseEntity<Billet> response = billetController.getBilletById(billetId);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(billet, response.getBody());
    }

    @Test
    public void testGetBilletById_NotFound() {
        // Mock data
        Long billetId = 1L;

        // Mock repository method
        when(billetRepository.findById(billetId)).thenReturn(Optional.empty());

        // Call controller method
        ResponseEntity<Billet> response = billetController.getBilletById(billetId);

        // Verify the response
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testCreateBillet() {
        // Mock data
        Billet billet = new Billet("Match", "VIP", 150.0);

        // Mock repository method
        when(billetRepository.save(billet)).thenReturn(billet);

        // Call controller method
        ResponseEntity<Billet> response = billetController.createBillet(billet);

        // Verify the response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(billet, response.getBody());
    }

    @Test
    public void testUpdateBillet() {
        // Mock data
        Long billetId = 1L;
        Billet existingBillet = new Billet("Match", "VIP", 150.0);
        existingBillet.setId(billetId);
        Billet updatedBillet = new Billet("Concert", "Standard", 75.0);

        // Mock repository methods
        when(billetRepository.findById(billetId)).thenReturn(Optional.of(existingBillet));
        when(billetRepository.save(existingBillet)).thenReturn(existingBillet);

        // Call controller method
        ResponseEntity<Billet> response = billetController.updateBillet(billetId, updatedBillet);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedBillet.getType(), response.getBody().getType());
        assertEquals(updatedBillet.getCategorie(), response.getBody().getCategorie());
        assertEquals(updatedBillet.getPrix(), response.getBody().getPrix());
    }

    @Test
    public void testUpdateBillet_NotFound() {
        // Mock data
        Long billetId = 1L;
        Billet updatedBillet = new Billet("Concert", "Standard", 75.0);

        // Mock repository method
        when(billetRepository.findById(billetId)).thenReturn(Optional.empty());

        // Call controller method
        ResponseEntity<Billet> response = billetController.updateBillet(billetId, updatedBillet);

        // Verify the response
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testDeleteBillet() {
        // Mock data
        Long billetId = 1L;

        // Mock repository method
        when(billetRepository.existsById(billetId)).thenReturn(true);

        // Call controller method
        ResponseEntity<Void> response = billetController.deleteBillet(billetId);

        // Verify the response
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(billetRepository, times(1)).deleteById(billetId);
    }

    @Test
    public void testDeleteBillet_NotFound() {
        // Mock data
        Long billetId = 1L;

        // Mock repository method
        when(billetRepository.existsById(billetId)).thenReturn(false);

        // Call controller method
        ResponseEntity<Void> response = billetController.deleteBillet(billetId);

        // Verify the response
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(billetRepository, never()).deleteById(billetId);
    }
}
