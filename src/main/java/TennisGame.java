/**
 * Created by marsalisqualls on 7/10/17.
 */
public class TennisGame {

    private int playerOneScore;
    private int playerTwoScore;


    public void setScore(int playerOneScore, int playerTwoScore) {
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
    }

    public void playerOneScore() {
        this.playerOneScore++;
    }

    public void playerTwoScore() {
        this.playerTwoScore++;
    }

    public String getGameScore() {
        StringBuilder sb = new StringBuilder();

        if(isScoreTied()){
            if (isScoreGreaterThanOrEqualTo3(playerOneScore)){
                sb.append("Deuce");
            } else {
                sb.append(TennisScore.values()[playerOneScore]);
                sb.append(" - All");
            }
        } else {
            if(isScoreGreaterThan3(playerOneScore) || isScoreGreaterThan3(playerTwoScore)){
                sb.append(getAdvantageOrWinner());
                sb.append(" ");
                sb.append(playerWithHigherScore());
            } else {
                sb.append(TennisScore.values()[playerOneScore]);
                sb.append(" - ");
                sb.append(TennisScore.values()[playerTwoScore]);
            }
        }

        return sb.toString();
    }

    private String playerWithHigherScore() {
        if (playerOneScore > playerTwoScore)
            return "Player1";
        return "Player2";
    }

    private String getAdvantageOrWinner(){
     if (Math.abs(playerOneScore - playerTwoScore) == 1)
         return "Advantage";
     return "Winner";
    }

    private boolean isScoreTied(){
        return this.playerOneScore == this.playerTwoScore;
    }

    private boolean isScoreGreaterThanOrEqualTo3(int score){
        return score >= 3;
    }

    private boolean isScoreGreaterThan3(int score){
        return score > 3;
    }
}
