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
        // Initialisation de l'équipe
        equipe = new Equipe("Lakers", "Los Angeles", "logo.png");
        // Initialisation du joueur
        joueur = new Joueur("LeBron James", 23, equipe);
    }

    @Test
    public void testJoueurConstructor() {
        // Vérification des valeurs initiales
        assertEquals("LeBron James", joueur.getNom());
        assertEquals(23, joueur.getNumeroMaillot());
        assertEquals(equipe, joueur.getEquipe());
    }

    @Test
    public void testGetNom() {
        // Vérification du getter du nom
        assertEquals("LeBron James", joueur.getNom());
    }

    @Test
    public void testSetNom() {
        // Modification et vérification du nom
        joueur.setNom("Anthony Davis");
        assertEquals("Anthony Davis", joueur.getNom());
    }

    @Test
    public void testGetNumeroMaillot() {
        // Vérification du getter du numéro de maillot
        assertEquals(23, joueur.getNumeroMaillot());
    }

    @Test
    public void testSetNumeroMaillot() {
        // Modification et vérification du numéro de maillot
        joueur.setNumeroMaillot(3);
        assertEquals(3, joueur.getNumeroMaillot());
    }

    @Test
    public void testGetEquipe() {
        // Vérification du getter de l'équipe
        assertEquals(equipe, joueur.getEquipe());
    }

    @Test
    public void testSetEquipe() {
        // Modification et vérification de l'équipe
        Equipe nouvelleEquipe = new Equipe("Nets", "Brooklyn", "logo_nets.png");
        joueur.setEquipe(nouvelleEquipe);
        assertEquals(nouvelleEquipe, joueur.getEquipe());
    }
}
