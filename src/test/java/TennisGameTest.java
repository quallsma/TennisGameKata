import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by marsalisqualls on 7/10/17.
 */
public class TennisGameTest {
    private TennisGame tg;

    @Before
    public void setup(){
        tg = new TennisGame();
    }

    @Test
    public void tennisGame_StartOfGameReturnsLoveAll(){
        Assert.assertEquals("Love - All", tg.getGameScore());
    }

    @Test
    public void tennisGame_playerScoreMethodsAddPointsToScore(){
        tg.playerOneScore();

        Assert.assertEquals("Fifteen - Love", tg.getGameScore());

        tg.playerTwoScore();

        Assert.assertEquals("Fifteen - All", tg.getGameScore());
    }

    @Test
    public void tennisGame_ShouldSetTheScoreOfGame(){
        tg.setScore(2, 2);

        Assert.assertEquals("Thirty - All", tg.getGameScore());

        tg.setScore(1,2);

        Assert.assertEquals("Fifteen - Thirty", tg.getGameScore());
    }

    @Test
    public void tennisGame_getGameScoreWhenThereIsDeuce(){
        tg.setScore(3, 3);

        Assert.assertEquals("Deuce", tg.getGameScore());
    }

    @Test
    public void tennisGame_getGameScoreWhenThereIsAdvantage(){
        tg.setScore(4, 3);

        Assert.assertEquals("Advantage Player1", tg.getGameScore());
    }

    @Test
    public void tennisGame_getGameScoreWhenThereIsWinner(){
        tg.setScore(4, 6);

        Assert.assertEquals("Winner Player2", tg.getGameScore());
    }
}
