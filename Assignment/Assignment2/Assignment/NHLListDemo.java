/**
 * @author Ahmed Rajgoli Shoaib Shakeel - B00878695
 **/
package Assignment;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class NHLListDemo {
    public static void main(String [] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);

//        add the source of the file
        System.out.println("Enter the name of the text file: ");
        String filename = keyboard.nextLine();

        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

//        Note: When you read data from the file, each line is read as a String. Use a StringTokenizer to parse the line’s
//        components. Also take note that the input file has rows in which the items are delimited by tabs, not spaces.
//        Try the following when setting your delimiter:
//        token = new StringTokenizer(line, "\t");
        StringTokenizer token;

        NHLStats nhlStats = new NHLStats();

        PlayerRecord playerRecord;

        String playerName, playerPosition, teamName, gamesPlayed, goalScored, assists, penaltyMinutes, shotOnGoal, gameWinningGoals;

        while (inputFile.hasNext()){
            String line = inputFile.nextLine();
            token = new StringTokenizer(line, "\t");
            playerName = token.nextToken();
            playerPosition = token.nextToken();
            teamName = token.nextToken();

            gamesPlayed = token.nextToken();
            goalScored =  token.nextToken();
            assists =  token.nextToken();
            penaltyMinutes =  token.nextToken();
            shotOnGoal =  token.nextToken();
            gameWinningGoals =  token.nextToken();

            Integer playedGames = Integer.valueOf (gamesPlayed);
            Integer goalsScored = Integer.valueOf(goalScored);
            Integer assistsInteger = Integer.valueOf(assists);
            Integer penaltyMinutesInteger = Integer.valueOf( penaltyMinutes );
            Integer shotOnGoalInteger = Integer.valueOf(shotOnGoal);
            Integer gameWinningGoalsInteger = Integer.valueOf(gameWinningGoals);

            playerRecord = new PlayerRecord(playerName,playerPosition,teamName,playedGames,goalsScored,assistsInteger,
                    penaltyMinutesInteger,shotOnGoalInteger,gameWinningGoalsInteger);

            nhlStats.add(playerRecord);
        }
        inputFile.close();


        System.out.println("\nNHL Results Summary\n");

//        players with highest points
        nhlStats.mostPoints();

//        most aggressive players
        nhlStats.mostAggressive();

//        MVPs
        nhlStats.playerMVP();

//        most promising player
        nhlStats.mostPromising();

//        most penalty by teams
        nhlStats.mostPenaltyMins();

//        most game winnings by teams
        nhlStats.MostWinningGoals();

    }// main
}// class
