/**
 * Author: Chirayu Patel
 * Date: 05 July 2024
 * Description: This program implements a scoring system for a bowling game for two players.
 */

import java.util.Scanner;
public class BowlingGame {
    static Scanner scanner = new Scanner(System.in);
    static final int Max_Frames = 10;

    public static void main(String[] args) {
        do {
            // Enter two players name.
            String player1Name = getPlayerName(1);
            String player2Name = getPlayerName(2);

            // Enter game points.
            int[][] player1Scores = new int[Max_Frames][2];
            int[][] player2Scores = new int[Max_Frames][2];

            // Take point round wise.
            for (int Round = 0; Round < Max_Frames; Round++) {
                System.out.println("Round " + (Round + 1));
                player1Scores[Round] = getFrameScores(player1Name, Round);
                player2Scores[Round] = getFrameScores(player2Name, Round);
            }

            // Display the result.
            displayGameResults(player1Name, player2Name, player1Scores, player2Scores);
        } while (playAnotherGame());
    }


    private static String getPlayerName(int playerNumber) {
        System.out.print("Enter player " + playerNumber + " name: ");
        return scanner.nextLine();
    }

    private static int getRollScore(String playerName, String rollDescription) {
        int score;
        do {
            System.out.print(playerName + ", Enter score for " + rollDescription + " : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid score. Please enter a score between 0 to 10.");
                scanner.next(); // consume the invalid input
            }
            score = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over
            if (score < 0 || score > 10) {
                System.out.println("Invalid score. Please enter a score between 0 to 10.");
            }
        } while (score < 0 || score > 10);
        return score;
    }

    // Method to get the scores for a frame
    private static int[] getFrameScores(String playerName, int Round) {
        int[] rolls = new int[2];
        rolls[0] = getRollScore(playerName, "first");

        if (rolls[0] == 10) {
            System.out.println("Strike!");
            if (Round == Max_Frames - 1) { // 10th frame
                rolls[1] = getRollScore(playerName, "first extra");
                int secondExtraRoll = getRollScore(playerName, "second extra");
                System.out.println("Second extra roll: " + secondExtraRoll);
            } else {
                rolls[1] = 0;
            }
        } else {
            rolls[1] = getRollScore(playerName, "second");
            if (rolls[0] + rolls[1] == 10) {

                if (Round == Max_Frames - 1) { // 10th frame
                    int extraRoll = getRollScore(playerName, "extra");
                    System.out.println("Extra roll: " + extraRoll);
                }
            }
        }
        return rolls;
    }

    // Method to display game results
    private static void displayGameResults(String player1Name, String player2Name, int[][] player1Scores, int[][] player2Scores) {
        int player1Total = 0;
        int player2Total = 0;
        System.out.println("Game Results:");


        for (int Round = 0; Round < Max_Frames; Round++) {
            player1Total += calculateFrameScore(player1Scores, Round);
            player2Total += calculateFrameScore(player2Scores, Round);

        }


        if (player1Total > player2Total) {
            System.out.println(player1Name + " wining the game!");
        } else if (player2Total > player1Total) {
            System.out.println(player2Name + " wining the game!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    // Method to calculate the score for a frame
    private static int calculateFrameScore(int[][] playerScores, int Round) {
        int frameScore = playerScores[Round][0] + playerScores[Round][1];

        if (playerScores[Round][0] == 10) {
            frameScore += getNextTwoRollsScore(playerScores, Round);
        } else if (frameScore == 10) {
            frameScore += getNextRollScore(playerScores, Round);
        }
        return frameScore;
    }

    // Method to get the score of the next two rolls after a strike
    private static int getNextTwoRollsScore(int[][] playerScores, int frame) {
        if (frame < Max_Frames - 1) {
            if (playerScores[frame + 1][0] == 10 && frame < Max_Frames - 2) {
                return playerScores[frame + 1][0] + playerScores[frame + 2][0];
            } else {
                return playerScores[frame + 1][0] + playerScores[frame + 1][1];
            }
        }
        return 0;
    }

    // Method to get the score of the next roll after a spare
    private static int getNextRollScore(int[][] playerScores, int frame) {
        if (frame < Max_Frames - 1) {
            return playerScores[frame + 1][0];
        }
        return 0;
    }

    // Method to ask if the players want to play another game
    private static boolean playAnotherGame() {
        System.out.print("Do you want to play another game!? (yes/no): ");
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("yes");
    }
}
