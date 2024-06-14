package ModelClassTest;

import com.example.api.model.Equipe;
import com.example.api.model.Match;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatchTest {

    private Match match;
    private Date date;
    private Equipe teamA;
    private Equipe teamB;

    @BeforeEach
    public void setUp() {
        // Initialize the date
        date = new Date();

        // Initialize teams
        teamA = new Equipe();
        teamA.setId(1L);
        teamA.setNom("Lakers");

        teamB = new Equipe();
        teamB.setId(2L);
        teamB.setNom("Warriors");

        // Initialize the match
        match = new Match(date, "Staples Center", teamA, teamB, 100, 99);
    }

    @Test
    public void testMatchConstructor() {
        // Verify initial values
        assertEquals(date, match.getDate());
        assertEquals("Staples Center", match.getLocation());
        assertEquals(teamA, match.getTeamA());
        assertEquals(teamB, match.getTeamB());
        assertEquals(100, match.getScoreA());
        assertEquals(99, match.getScoreB());
    }

    @Test
    public void testGetDate() {
        // Verify date getter
        assertEquals(date, match.getDate());
    }

    @Test
    public void testSetDate() {
        // Modify and verify the date
        Date newDate = new Date(date.getTime() + 86400000); // Add 1 day
        match.setDate(newDate);
        assertEquals(newDate, match.getDate());
    }

    @Test
    public void testGetLocation() {
        // Verify location getter
        assertEquals("Staples Center", match.getLocation());
    }

    @Test
    public void testSetLocation() {
        // Modify and verify the location
        match.setLocation("Madison Square Garden");
        assertEquals("Madison Square Garden", match.getLocation());
    }

    @Test
    public void testGetTeamA() {
        // Verify team A getter
        assertEquals(teamA, match.getTeamA());
    }

    @Test
    public void testSetTeamA() {
        // Modify and verify team A
        Equipe newTeamA = new Equipe();
        newTeamA.setId(3L);
        newTeamA.setNom("Clippers");

        match.setTeamA(newTeamA);
        assertEquals(newTeamA, match.getTeamA());
    }

    @Test
    public void testGetTeamB() {
        // Verify team B getter
        assertEquals(teamB, match.getTeamB());
    }

    @Test
    public void testSetTeamB() {
        // Modify and verify team B
        Equipe newTeamB = new Equipe();
        newTeamB.setId(4L);
        newTeamB.setNom("Nets");

        match.setTeamB(newTeamB);
        assertEquals(newTeamB, match.getTeamB());
    }

    @Test
    public void testGetScoreA() {
        // Verify score A getter
        assertEquals(100, match.getScoreA());
    }

    @Test
    public void testSetScoreA() {
        // Modify and verify score A
        match.setScoreA(101);
        assertEquals(101, match.getScoreA());
    }

    @Test
    public void testGetScoreB() {
        // Verify score B getter
        assertEquals(99, match.getScoreB());
    }

    @Test
    public void testSetScoreB() {
        // Modify and verify score B
        match.setScoreB(102);
        assertEquals(102, match.getScoreB());
    }

    @Test
    public void testGetId() {
        // Verify ID getter
        Long id = 1L;
        match.setId(id);
        assertEquals(id, match.getId());
    }

    @Test
    public void testSetId() {
        // Modify and verify ID
        Long newId = 2L;
        match.setId(newId);
        assertEquals(newId, match.getId());
    }
}
