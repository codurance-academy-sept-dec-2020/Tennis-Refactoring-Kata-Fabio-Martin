
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
    StringBuilder result = new StringBuilder();
    int tempScore = 0;
    if (isADraw(scorePlayerOne, scorePlayerTwo)) {
      switch (scorePlayerOne) {
        case 0:
          result = new StringBuilder("Love-All");
          break;
        case 1:
          result = new StringBuilder("Fifteen-All");
          break;
        case 2:
          result = new StringBuilder("Thirty-All");
          break;
        default:
          result = new StringBuilder("Deuce");
          break;

      }
    } else if (hasAnyPlayerScoredForty()) {
      int minusResult = scorePlayerOne - scorePlayerTwo;
      if (isADraw(minusResult, 1)) {
        result = new StringBuilder("Advantage " + playerOne);
      } else if (isADraw(minusResult, -1)) {
        result = new StringBuilder("Advantage " + playerTwo);//fix me string duplication
      } else if (minusResult >= 2) {
        result = new StringBuilder("Win for " + playerOne);
      } else {
        result = new StringBuilder("Win for " + playerTwo);
      }
    } else {
      for (int i = 1; i < 3; i++) {
        if (isADraw(i, 1)) {
          tempScore = scorePlayerOne;
        } else {
          result.append("-");
          tempScore = scorePlayerTwo;
        }
        switch (tempScore) {
          case 0:
            result.append("Love");
            break;
          case 1:
            result.append("Fifteen");
            break;
          case 2:
            result.append("Thirty");
            break;
          case 3:
            result.append("Forty");
            break;
        }
      }
    }
    return result.toString();
  }

  private boolean isADraw(int scorePlayerOne, int scorePlayerTwo) {
    return scorePlayerOne == scorePlayerTwo;
  }

  private boolean hasAnyPlayerScoredForty() {
    return scorePlayerOne >= 4 || scorePlayerTwo >= 4;
  }
}
