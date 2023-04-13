/**
 * we first build a PlayerRecord class to model each entry (playerName, position, teamName, gamePlayed, goalsScored,
 * assists, penaltyMinutes, shotOnGoal, winningGoals) and then use this to build NHLStats class.
 */
package Assignment;

import java.util.Objects;

public class PlayerRecord {
    private String playerName;
    private String position;
    private String teamName;
    private int gamePlayed;
    private int goalsScored;
    private int assists;
    private int penaltyMinutes;
    private int shotOnGoal;
    private int winningGoals;

//    Constructors
    public PlayerRecord(String playerName, String position, String teamName, int gamePlayed, int goalsScored,
                        int assists, int penaltyMinutes, int shotOnGoal, int winningGoals) {
        this.playerName = playerName;
        this.position = position;
        this.teamName = teamName;
        this.gamePlayed = gamePlayed;
        this.goalsScored = goalsScored;
        this.assists = assists;
        this.penaltyMinutes = penaltyMinutes;
        this.shotOnGoal = shotOnGoal;
        this.winningGoals = winningGoals;
    }

//    Getters
public String getPlayerName() {
    return playerName;
}

    public String getPosition() {
        return position;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getGamePlayed() {
        return gamePlayed;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getAssists() {
        return assists;
    }

    public int getPenaltyMinutes() {
        return penaltyMinutes;
    }

    public int getShotOnGoal() {
        return shotOnGoal;
    }

    public int getWinningGoals() {
        return winningGoals;
    }

//    toString
@Override
public String toString() {
    return "PlayerRecord{" +
            "playerName='" + playerName + '\'' +
            ", position='" + position + '\'' +
            ", teamName='" + teamName + '\'' +
            ", gamePlayed=" + gamePlayed +
            ", goalsScored=" + goalsScored +
            ", assists=" + assists +
            ", penaltyMinutes=" + penaltyMinutes +
            ", shotOnGoal=" + shotOnGoal +
            ", winningGoals=" + winningGoals +
            '}';
}

//  equals
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof PlayerRecord)) return false;
    PlayerRecord that = (PlayerRecord) o;
    return getGamePlayed() == that.getGamePlayed()
            && getGoalsScored() == that.getGoalsScored()
            && getAssists() == that.getAssists()
            && getPenaltyMinutes() == that.getPenaltyMinutes()
            && getShotOnGoal() == that.getShotOnGoal()
            && getWinningGoals() == that.getWinningGoals()
            && Objects.equals(getPlayerName(), that.getPlayerName())
            && Objects.equals(getPosition(), that.getPosition())
            && Objects.equals(getTeamName(), that.getTeamName());
}

}
