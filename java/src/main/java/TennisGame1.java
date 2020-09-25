
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
        StringBuilder result;
        if (isADraw(scorePlayerOne, scorePlayerTwo)) {
            result = calculateDrawScore();
        } else if (hasAnyPlayerScoredForty()) {
            result = calculateScoreWhenSomePlayerReachedForty();
        } else {
            result = calculateScore();
        }
        return result.toString();
    }

    private StringBuilder calculateScore() {
        StringBuilder result = new StringBuilder();
        int tempScore;
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
        return result;
    }

    private StringBuilder calculateScoreWhenSomePlayerReachedForty() {
        int scoreDifference = scorePlayerOne - scorePlayerTwo;
        if (isPlayerOneInAdvantage(scoreDifference)) {
            return new StringBuilder("Advantage " + playerOne);
        }
        if (isPlayerTwoInAdvantage(scoreDifference)) {
            return new StringBuilder("Advantage " + playerTwo);//fix me string duplication
        }
        if (hasPlayerOneWonTheGame(scoreDifference)) {
            return new StringBuilder("Win for " + playerOne);
        }
        return new StringBuilder("Win for " + playerTwo);
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

    private StringBuilder calculateDrawScore() {
        StringBuilder result;
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
        return result;
    }

    private boolean isADraw(int scorePlayerOne, int scorePlayerTwo) {
        return scorePlayerOne == scorePlayerTwo;
    }

    private boolean hasAnyPlayerScoredForty() {
        return scorePlayerOne >= 4 || scorePlayerTwo >= 4;
    }
}
