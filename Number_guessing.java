/**
 * @author Chirayu Patel
 * @version 1.0
 * 2024-05-24
 * Number Guessing Game.
 */


import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Number_guessing {

    public static void main(String[] args) {

        /// Create a random object to generate random numbers
        Random random = new Random();

        // Create a scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Minimum number
        int min = 1;

        // Maximum number
        int max = 100;

        //  if the user wants to play again
        boolean playAgain;

        // Main loop to play the game multiple times
        do {
            // Create a random number between min and max
            int numberToGuess = random.nextInt(max - min + 1) + min;

            // Counter for the number of guesses
            int numberOfGuesses = 0;

            //  check if the user has guessed correctly
            boolean hasGuessedCorrectly = false;

            System.out.println("Welcome to the Guess the Number Game!");
            System.out.println("I have selected a number between " + min + " and " + max + ".");
            System.out.println("Try to guess it!");

            // Loop until the user guesses the correct number
            while (!hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                try {
                    int userGuess = scanner.nextInt();
                    numberOfGuesses++;

                    // Check if the guess is too low, too high, or correct
                    if (userGuess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else if (userGuess > numberToGuess) {
                        System.out.println("Too high! Try again.");
                    } else {
                        // Set flag to true if the number guess is correct
                        System.out.println("Congratulations! You guessed the number in " + numberOfGuesses + " tries.");
                        hasGuessedCorrectly = true;
                    }
                } catch (InputMismatchException e) {

                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                }
            }
            System.out.print("Would you like to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");


            scanner.nextLine();
        } while (playAgain);

        System.out.println("Thank you for playing! Goodbye.");

        scanner.close();
    }
}