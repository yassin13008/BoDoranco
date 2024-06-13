package ModelClassTest;

import com.example.api.model.Equipe;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class EquipeTest {

    @Test
    public void testEquipeConstructorAndGetters() {
        // Arrange
        String nom = "Les Lions";
        String ville = "Paris";
        String logo = "lion.png";

        // Act
        Equipe equipe = new Equipe(nom, ville, logo);

        // Assert
        assertEquals(nom, equipe.getNom());
        assertEquals(ville, equipe.getVille());
        assertEquals(logo, equipe.getLogo());
    }

    @Test
    public void testSetters() {
        // Arrange
        Equipe equipe = new Equipe("Les Lions", "Paris", "lion.png");

        // Act
        equipe.setNom("Les Tigres");
        equipe.setVille("Lyon");
        equipe.setLogo("tigre.png");

        // Assert
        assertEquals("Les Tigres", equipe.getNom());
        assertEquals("Lyon", equipe.getVille());
        assertEquals("tigre.png", equipe.getLogo());
    }

    @Test
    public void testAfficherDetails() {
        // Arrange
        Equipe equipe = new Equipe("Les Lions", "Paris", "lion.png");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        equipe.afficherDetails();

        // Assert
        String expectedOutput = "Nom de l'équipe : Les Lions\nVille de l'équipe : Paris\n";
        assertTrue(outContent.toString().contains(expectedOutput));
    }
}
