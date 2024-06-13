package ModelClassTest;

import com.example.api.model.Billet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BilletClassTest {

    @Test
    public void testBilletConstructorAndGetters() {
        // Arrange
        String type = "Match";
        String categorie = "VIP";
        double prix = 150.0;

        // Act
        Billet billet = new Billet(type, categorie, prix);

        // Assert
        assertEquals(type, billet.getType());
        assertEquals(categorie, billet.getCategorie());
        assertEquals(prix, billet.getPrix());
    }

    @Test
    public void testSetters() {
        // Arrange
        Billet billet = new Billet("Match", "VIP", 150.0);

        // Act
        billet.setType("Concert");
        billet.setCategorie("Standard");
        billet.setPrix(75.0);

        // Assert
        assertEquals("Concert", billet.getType());
        assertEquals("Standard", billet.getCategorie());
        assertEquals(75.0, billet.getPrix());
    }
}
