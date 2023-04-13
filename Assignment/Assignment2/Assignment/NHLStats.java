/**
 * This class creates an unordered playerRecords list. Includes methods to calculates the
 * 1. most points
 * 2. most aggressive player
 * 3. most valuable player
 * 4. most promising
 * 5. most Penalty wins by teams
 * 6. the most winning goals by teams
 */

package Assignment;

import java.util.ArrayList;

public class NHLStats {
    private List<PlayerRecord> unorderedPlayerRecord;

//    constructor
    public NHLStats() {
        unorderedPlayerRecord = new List<PlayerRecord>();
    }

    public void add(PlayerRecord player){
        unorderedPlayerRecord.add(player);
    }

    public boolean isEmpty(){
        return unorderedPlayerRecord.isEmpty();
    }

    public boolean contains (PlayerRecord player){
        return unorderedPlayerRecord.contains(player);
    }

    public PlayerRecord first(){
        return unorderedPlayerRecord.first();
    }

    public PlayerRecord next(){
        return unorderedPlayerRecord.next();
    }

    public void enumerate(){
        unorderedPlayerRecord.enumerate();
    }


    /**
     * This methods scans every row of the NHLStats and finds the max points (assists + goalsScored) and
     * displays the name and the team name of the players based on the most points by the player
     */
    public void mostPoints(){
        if(unorderedPlayerRecord.isEmpty()){return;}

        PlayerRecord record = unorderedPlayerRecord.first ();

        int maxPoints = 0;

        while(record != null) {
            if (record.getAssists() + record.getGoalsScored() > maxPoints) {
                maxPoints = record.getAssists() + record.getGoalsScored ();
            }
            record= unorderedPlayerRecord.next ();
        }
//        initialize to the first element to display the list of player names and team names based on max points
        record = unorderedPlayerRecord.first();

//        displays the name and team name of the player
        System.out.println("Players with highest points: ");
        while(record != null){
            if(record.getAssists() + record.getGoalsScored() == maxPoints){
                System.out.println(record.getPlayerName() + "\t" + record.getTeamName());
            }
            record=unorderedPlayerRecord.next();
        }

    }

    /**
     *  This methods scans every row of the NHLStats and finds the max penalty minutes by the players and
     *  displays the name and the team name and position of the player based on the most penalty minutes by the player
     */

    public void mostAggressive(){
        if( unorderedPlayerRecord.isEmpty() ){return;}

        PlayerRecord record = unorderedPlayerRecord.first();

        int maxMinutes = 0;

        while(record!=null) {
            if (record.getPenaltyMinutes() > maxMinutes) {
                maxMinutes = record.getPenaltyMinutes();
            }
            record = unorderedPlayerRecord.next();
        }

//        initialize to the first element to display the list of player names and team names based on most penalty
        record = unorderedPlayerRecord.first();

//        displays the name and team name of the player
        System.out.println("\nMost aggressive players, their teams and their positions: " );
        while(record != null){
            if(record.getPenaltyMinutes() == maxMinutes){
                System.out.println(record.getPlayerName() + "\t" + record.getTeamName() + " \t" + record.getPosition());
            }
            record = unorderedPlayerRecord.next();
        }
    }

    /**
     * This methods scans every row of the NHLStats and finds the most game winningGoals by the players and
     *  displays the name and the team name of the player based on the most game winningGoals by the player
     */
    public void playerMVP(){
        if(unorderedPlayerRecord.isEmpty()){return;}
        PlayerRecord record = unorderedPlayerRecord.first ();
        int maxGoals = 0;
        while(record!=null) {
            if (record.getWinningGoals() > maxGoals) {
                maxGoals = record.getWinningGoals();
            }
            record= unorderedPlayerRecord.next();
        }
//        initialize to the first element to display the list of player names and team names based on most game winningGoals by the player
        record = unorderedPlayerRecord.first();

//        displays the name and team name of the player
        System.out.println("\nMost valuable players and their teams: " );
        while(record != null){
            if(record.getWinningGoals() == maxGoals){
                System.out.println (record.getPlayerName() + "\t" + record.getTeamName());
            }
            record = unorderedPlayerRecord.next();
        }

    }

    /**
     * This methods scans every row of the NHLStats and finds the most promising player based on shotsOnGoal.
     * First the while loop finds the max shots by a player
     * Second the while loop displays the name and team name based on max shots by the player.
     */
    public void mostPromising(){
        if(unorderedPlayerRecord.isEmpty()){return;}

        PlayerRecord record = unorderedPlayerRecord.first();

        int maxShots = 0;

        while(record != null) {
            if (record.getShotOnGoal() > maxShots) {
                maxShots = record.getShotOnGoal();
            }
            record = unorderedPlayerRecord.next();
        }
//        initialize to the first element to display the list of player names and team names based on shotOnGoal
        record = unorderedPlayerRecord.first();

//        displays the name and team name of the player
        System.out.println("\nMost promising players and their teams: ");
        while(record != null){
            if(record.getShotOnGoal() == maxShots){
                System.out.println (record.getPlayerName() + "\t" + record.getTeamName());
            }
            record = unorderedPlayerRecord.next ();
        }

    }

    /**
     * This methods scans every row of the NHLStats and finds the most penalty by each team
     * 1: Create an arrayList and store each of the teams in the arrayList by going through the list
     * 2: Create an array penalty and store all the penalties of the respective teams. it goes on every list to
     *    check if the lists team name equal to the team name in the arrayList, if it is equal, it adds the lists to 
     *    penalty array else moves forward and goes on until all matches are found
     * 3: find the max of all penalties
     * 4: display all teams with max penalties.
     */

    public void mostPenaltyMins(){
        ArrayList<String> teamsArray = new ArrayList<>();

        PlayerRecord record = unorderedPlayerRecord.first();

//        Create an array list with teams without repetition
        while(record != null){
            if(!teamsArray.contains(record.getTeamName())){
                teamsArray.add(record.getTeamName());
            }
            record = unorderedPlayerRecord.next();
        }

//        add all the penalties to their respective teams
        int [] penalty = new int[teamsArray.size()];

        record = unorderedPlayerRecord.first();

        while(record != null) {
            for (int i = 0; i < teamsArray.size(); i++) {
                if (teamsArray.get(i).equals(record.getTeamName())) {
                    penalty[i] += record.getPenaltyMinutes();
                }
            }
            record = unorderedPlayerRecord.next();
        }

//        search for the max penalty
        int max  = penalty[0];
        for (int j : penalty) {
            if (j > max) {
                max = j;
            }
        }
        
//        display teams with the max penalties
        System.out.println("\nTeams that had the most number of penalty minutes: ");
        for (int j = 0; j < penalty.length; j++) {
            if(penalty[j] == max){
                System.out.println(teamsArray.get(j));
            }
        }
    }

    /**
     *  This Program finds the most penalty by teams
     * 1: Create an arrayList and store each of the teams in the arrayList by going through the list
     * 2: Create an array penalty and store all the penalties of the respective teams. it goes on every list to
     *    check if the lists team name equal to the team name in the arrayList, if it is equal, it adds the lists to 
     *    game winningGoal array else moves forward and goes on until all matches are found
     * 3: find the max of game winning goal
     * 4: displays all teams with max game winning goal.
     */
    public void MostWinningGoals(){
        ArrayList<String> teamsArray = new ArrayList<>();

        PlayerRecord record = unorderedPlayerRecord.first();

//        Create an arrayList with distinct teams
        while(record != null){
            if(!teamsArray.contains(record.getTeamName())){
                teamsArray.add(record.getTeamName());
            }
            record = unorderedPlayerRecord.next();
        }

//        add all the game winnings to their respective teams
        int [] gameWinnings = new int[teamsArray.size()];

        record = unorderedPlayerRecord.first();

        while(record != null) {
            for (int i = 0; i < teamsArray.size(); i++) {
                if (teamsArray.get(i).equals(record.getTeamName())) {
                    gameWinnings[i] += record.getWinningGoals();
                }
            }
            record = unorderedPlayerRecord.next();
        }

//        finds the max game winnings
        int max  = gameWinnings[0];

        for (int j : gameWinnings) {
            if (j > max) {
                max = j;
            }
        }

//        displays the teams with max game winnings
        System.out.println("\nTeams that had the most number of game winning goals: ");
        for (int j = 0; j < gameWinnings.length; j++) {
            if(gameWinnings[j] == max){
                System.out.println(teamsArray.get(j));
            }
        }
    }

}
