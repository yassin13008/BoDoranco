package ModelClassTest;

import com.example.api.model.Billet;
import com.example.api.model.GestionnaireBillets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GestionnaireBilletsTest {

    private GestionnaireBillets gestionnaireBillets;

    @BeforeEach
    public void setUp() {
        gestionnaireBillets = new GestionnaireBillets();
    }

    @Test
    public void testAjouterBillet() {
        // Arrange
        Billet billet = new Billet("Standard", "Tribune", 25.0);

        // Act
        gestionnaireBillets.ajouterBillet(billet);

        // Assert
        List<Billet> billets = gestionnaireBillets.billets; // Assurez-vous que billets est accessible pour les tests, sinon utilisez un getter
        assertEquals(1, billets.size());
        assertEquals("Standard", billets.get(0).getType());
        assertEquals("Tribune", billets.get(0).getCategorie());
        assertEquals(25.0, billets.get(0).getPrix());
    }

    @Test
    public void testAfficherBillets() {
        // Arrange
        Billet billet1 = new Billet("Standard", "Tribune", 25.0);
        Billet billet2 = new Billet("VIP", "Loge", 100.0);
        gestionnaireBillets.ajouterBillet(billet1);
        gestionnaireBillets.ajouterBillet(billet2);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        gestionnaireBillets.afficherBillets();

        // Assert
        String expectedOutput = "Liste des billets disponibles :\n" +
                "Type: Standard, Catégorie: Tribune, Prix: 25.0€\n" +
                "Type: VIP, Catégorie: Loge, Prix: 100.0€\n";
        assertTrue(outContent.toString().contains(expectedOutput));
    }
}
