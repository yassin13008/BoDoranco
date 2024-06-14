package ModelClassTest;

import com.example.api.model.Equipe;
import com.example.api.model.Joueur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JoueurTest {

    private Joueur joueur;
    private Equipe equipe;

    @BeforeEach
    public void setUp() {
        // Initialize the equipe object before each test
        equipe = new Equipe();
        equipe.setId(1L);
        equipe.setNom("Bulls");

        // Initialize the joueur object before each test
        joueur = new Joueur("Jordan", "Michael", equipe);
    }

    @Test
    public void testJoueurConstructor() {
        // Verify initial values from constructor
        assertEquals("Jordan", joueur.getNom());
        assertEquals("Michael", joueur.getPrenom());
        assertEquals(equipe, joueur.getEquipe());
    }

    @Test
    public void testGetNom() {
        // Verify getter for nom
        assertEquals("Jordan", joueur.getNom());
    }

    @Test
    public void testSetNom() {
        // Modify and verify nom
        joueur.setNom("Bryant");
        assertEquals("Bryant", joueur.getNom());
    }

    @Test
    public void testGetPrenom() {
        // Verify getter for prenom
        assertEquals("Michael", joueur.getPrenom());
    }

    @Test
    public void testSetPrenom() {
        // Modify and verify prenom
        joueur.setPrenom("Kobe");
        assertEquals("Kobe", joueur.getPrenom());
    }

    @Test
    public void testGetEquipe() {
        // Verify getter for equipe
        assertEquals(equipe, joueur.getEquipe());
    }

    @Test
    public void testSetEquipe() {
        // Modify and verify equipe
        Equipe newEquipe = new Equipe();
        newEquipe.setId(2L);
        newEquipe.setNom("Lakers");

        joueur.setEquipe(newEquipe);
        assertEquals(newEquipe, joueur.getEquipe());
    }

    @Test
    public void testGetId() {
        // Verify getter for id
        Long id = 1L;
        joueur.setId(id);
        assertEquals(id, joueur.getId());
    }

    @Test
    public void testSetId() {
        // Modify and verify id
        Long newId = 2L;
        joueur.setId(newId);
        assertEquals(newId, joueur.getId());
    }
}
