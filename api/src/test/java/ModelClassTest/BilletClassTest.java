package ModelClassTest;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.api.repository.model.Billet;



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
        Assertions.assertEquals(type, billet.getType());
        Assertions.assertEquals(categorie, billet.getCategorie());
        Assertions.assertEquals(prix, billet.getPrix());
    }

}
