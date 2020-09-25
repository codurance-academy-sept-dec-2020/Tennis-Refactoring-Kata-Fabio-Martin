
public class TennisGame1 implements TennisGame {

  private int scorePlayerOne = 0;
  private int scorePlayerTwo = 0;
  private String playerOne;
  private String playerTwo;

  public TennisGame1(String playerOne, String playerTwo) {
    this.playerOne = playerOne;
    this.playerTwo = playerTwo;
  }

  public void wonPoint(String playerName) {
    if (playerName.equals(playerOne)) {
      scorePlayerOne += 1;
    } else {
      scorePlayerTwo += 1;
    }
  }

  public String getScore() {
    String score = "";
    int tempScore = 0;
    if (isADraw(scorePlayerOne, scorePlayerTwo)) {
      switch (scorePlayerOne) {
        case 0:
          score = "Love-All";
          break;
        case 1:
          score = "Fifteen-All";
          break;
        case 2:
          score = "Thirty-All";
          break;
        default:
          score = "Deuce";
          break;

      }
    } else if (hasAnyPlayerScoredForty()) {
      int minusResult = scorePlayerOne - scorePlayerTwo;
      if (isADraw(minusResult, 1)) {
        score = "Advantage " + playerOne;
      } else if (isADraw(minusResult, -1)) {
        score = "Advantage " + playerTwo;
      } else if (minusResult >= 2) {
        score = "Win for " + playerOne;
      } else {
        score = "Win for " + playerTwo;
      }
    } else {
      for (int i = 1; i < 3; i++) {
        if (isADraw(i, 1)) {
          tempScore = scorePlayerOne;
        } else {
          score += "-";
          tempScore = scorePlayerTwo;
        }
        switch (tempScore) {
          case 0:
            score += "Love";
            break;
          case 1:
            score += "Fifteen";
            break;
          case 2:
            score += "Thirty";
            break;
          case 3:
            score += "Forty";
            break;
        }
      }
    }
    return score;
  }

  private boolean isADraw(int scorePlayerOne, int scorePlayerTwo) {
    return scorePlayerOne == scorePlayerTwo;
  }

  private boolean hasAnyPlayerScoredForty() {
    return scorePlayerOne >= 4 || scorePlayerTwo >= 4;
  }
}
