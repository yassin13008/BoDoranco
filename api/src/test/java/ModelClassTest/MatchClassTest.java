package ModelClassTest;

import com.example.api.repository.model.Equipe;
import com.example.api.repository.model.Joueur;
import com.example.api.repository.model.Match;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class MatchClassTest {
    @Test
    public void testMatchConstructorAndGetters() {
        // Arrange
        Date date = new Date();
        String location = "Marseille";
        Equipe teamA = new Equipe("PSG","Paris","psg.jpeg");
        Equipe teamB = new Equipe("Om","Marseille","om.jpeg");
        int scoreA = 0;
        int scoreB = 3;

        // Act
        Match newMatch = new Match(date, location, teamA,teamB,scoreA,scoreB);

        // Assert
        Assertions.assertEquals(date, newMatch.getDate());
        Assertions.assertEquals(location, newMatch.getLocation());
        Assertions.assertEquals(teamA, newMatch.getTeamA());
        Assertions.assertEquals(teamB, newMatch.getTeamB());
        Assertions.assertEquals(scoreA, newMatch.getScoreA());
        Assertions.assertEquals(scoreA, newMatch.getScoreB());
    }
}
