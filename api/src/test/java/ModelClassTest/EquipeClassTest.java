package ModelClassTest;


import static org.junit.Assert.assertEquals;

import com.example.api.repository.model.Equipe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.api.repository.model.Billet;



public class EquipeClassTest {

    @Test
    public void testEquipeConstructorAndGetters() {
        // Arrange
        String nom = "Om";
        String ville = "Marseille";
        String logo = "om.jpeg";


        // Act
        Equipe newEquipe = new Equipe(nom, ville, logo);

        // Assert
        Assertions.assertEquals(nom, newEquipe.getNom());
        Assertions.assertEquals(ville, newEquipe.getVille());
        Assertions.assertEquals(logo, newEquipe.getLogo());
    }

}
