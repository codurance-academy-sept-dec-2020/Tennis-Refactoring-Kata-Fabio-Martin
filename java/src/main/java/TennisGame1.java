import java.util.Map;

public class TennisGame1 implements TennisGame {

  private int scorePlayerOne = 0;
  private int scorePlayerTwo = 0;
  private final String playerOne;
  private final String playerTwo;

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
    if (isADraw(scorePlayerOne, scorePlayerTwo)) {
      return calculateDrawScore();
    }
    if (hasAnyPlayerScoredForty()) {
      return calculateScoreWhenSomePlayerReachedForty();
    }
    return calculateScore();
  }

  private String calculateScore() {
    StringBuilder result = new StringBuilder();
    int tempScore;
    for (int i = 1; i < 3; i++) {
      if (isADraw(i, 1)) {
        tempScore = scorePlayerOne;
      } else {
        result.append("-");
        tempScore = scorePlayerTwo;
      }
      result.append(mapScoreNames(tempScore));
    }
    return result.toString();
  }

  private String mapScoreNames(int score) {
    String[] scoreNames = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
    return scoreNames[score];
  }

  private String calculateScoreWhenSomePlayerReachedForty() {
    int scoreDifference = scorePlayerOne - scorePlayerTwo;
    if (isPlayerOneInAdvantage(scoreDifference)) {
      return "Advantage " + playerOne;
    }
    if (isPlayerTwoInAdvantage(scoreDifference)) {
      return "Advantage " + playerTwo;
    }
    if (hasPlayerOneWonTheGame(scoreDifference)) {
      return "Win for " + playerOne;
    }
    return "Win for " + playerTwo;
  }

  private boolean hasPlayerOneWonTheGame(int scoreDifference) {
    return scoreDifference >= 2;
  }

  private boolean isPlayerTwoInAdvantage(int scoreDifference) {
    return isADraw(scoreDifference, -1);
  }

  private boolean isPlayerOneInAdvantage(int scoreDifference) {
    return isADraw(scoreDifference, 1);
  }

  private String calculateDrawScore() {
    Map<Integer, String> scoreDrawNames = Map
        .of(0, "Love-All", 1, "Fifteen-All", 2, "Thirty-All", 3, "Deuce");
    return scoreDrawNames.getOrDefault(scorePlayerOne, scoreDrawNames.get(3));
  }

  private boolean isADraw(int scorePlayerOne, int scorePlayerTwo) {
    return scorePlayerOne == scorePlayerTwo;
  }

  private boolean hasAnyPlayerScoredForty() {
    return scorePlayerOne >= 4 || scorePlayerTwo >= 4;
  }
}
