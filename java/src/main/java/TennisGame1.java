
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
      if (playerName.equals("player1")) {
          scorePlayerOne += 1;
      } else {
          scorePlayerTwo += 1;
      }
  }

  public String getScore() {
    String score = "";
    int tempScore = 0;
    if (scorePlayerOne == scorePlayerTwo) {
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
    } else if (scorePlayerOne >= 4 || scorePlayerTwo >= 4) {
      int minusResult = scorePlayerOne - scorePlayerTwo;
        if (minusResult == 1) {
            score = "Advantage player1";
        } else if (minusResult == -1) {
            score = "Advantage player2";
        } else if (minusResult >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
    } else {
      for (int i = 1; i < 3; i++) {
          if (i == 1) {
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
}
