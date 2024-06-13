package ModelClassTest;

import com.example.api.model.Match;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MatchTest {

    private Match match;
    private Date date;

    @BeforeEach
    public void setUp() {
        // Initialisation de la date
        date = new Date();
        // Initialisation du match
        match = new Match(date, "Lakers", "Warriors", "Staples Center");
    }

    @Test
    public void testMatchConstructor() {
        // Vérification des valeurs initiales
        assertEquals(date, match.getDate());
        assertEquals("Lakers", match.getEquipeDomicile());
        assertEquals("Warriors", match.getEquipeVisiteur());
        assertEquals("Staples Center", match.getLieu());
    }

    @Test
    public void testGetDate() {
        // Vérification du getter de la date
        assertEquals(date, match.getDate());
    }

    @Test
    public void testSetDate() {
        // Modification et vérification de la date
        Date newDate = new Date(date.getTime() + 86400000); // Ajout de 1 jour
        match.setDate(newDate);
        assertEquals(newDate, match.getDate());
    }

    @Test
    public void testGetEquipeDomicile() {
        // Vérification du getter de l'équipe domicile
        assertEquals("Lakers", match.getEquipeDomicile());
    }

    @Test
    public void testSetEquipeDomicile() {
        // Modification et vérification de l'équipe domicile
        match.setEquipeDomicile("Clippers");
        assertEquals("Clippers", match.getEquipeDomicile());
    }

    @Test
    public void testGetEquipeVisiteur() {
        // Vérification du getter de l'équipe visiteur
        assertEquals("Warriors", match.getEquipeVisiteur());
    }

    @Test
    public void testSetEquipeVisiteur() {
        // Modification et vérification de l'équipe visiteur
        match.setEquipeVisiteur("Nets");
        assertEquals("Nets", match.getEquipeVisiteur());
    }

    @Test
    public void testGetLieu() {
        // Vérification du getter du lieu
        assertEquals("Staples Center", match.getLieu());
    }

    @Test
    public void testSetLieu() {
        // Modification et vérification du lieu
        match.setLieu("Madison Square Garden");
        assertEquals("Madison Square Garden", match.getLieu());
    }

    @Test
    public void testSetId() {
        // Vérification que l'appel à setId lance une exception
        assertThrows(UnsupportedOperationException.class, () -> match.setId(1L));
    }
}
