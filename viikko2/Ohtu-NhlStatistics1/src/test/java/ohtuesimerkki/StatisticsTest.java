/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author svanteha
 */
public class StatisticsTest {

    Statistics statistics;
    List<Player> lista;
    Reader readerStub = new Reader() {
        @Override
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    @Before
    public void setUp() {
        statistics = new Statistics(readerStub);
        lista = readerStub.getPlayers();
    }

    @Test
    public void searchFindsPlayer() {

        Player player1 = lista.get(0);
        Player player2 = statistics.search("Semenko");
        
        assertEquals(player1, player2);

    }
    
    @Test
    public void searchReturnsNullIfNotFound() {
        
        assertEquals(null, statistics.search("svante"));
        
    }
    
    @Test
    public void searchTeamReturnsRight() {
        ArrayList<Player> tiimi = new ArrayList<Player>();
        tiimi.add(lista.get(1));
        
        assertTrue(tiimi.equals(statistics.team("PIT")));
        
    }
    
    @Test
    public void rightTopScorers() {
        ArrayList<Player> score = new ArrayList<Player>();
        score.add(lista.get(4));
        score.add(lista.get(1));
        
        
        assertEquals(score, statistics.topScorers(2));
    }
}
