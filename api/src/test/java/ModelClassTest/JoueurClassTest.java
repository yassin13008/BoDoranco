package ModelClassTest;

import com.example.api.repository.model.Equipe;
import com.example.api.repository.model.Joueur;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JoueurClassTest {


    @Test
    public void testJoueurConstructorAndGetters() {
        // Arrange
        String nom = "Rachid";
        String prenom = "Hadati";
        Equipe om = new Equipe("Om", "Marseille", "logoOm.jpeg");


        // Act
        Joueur newJoueur = new Joueur(nom, prenom, om);

        // Assert
        Assertions.assertEquals(nom, newJoueur.getNom());
        Assertions.assertEquals(prenom, newJoueur.getPrenom());
        Assertions.assertEquals(om, newJoueur.getEquipe());
    }
}
