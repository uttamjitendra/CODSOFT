//The below code consists of fully loaded features required for the number game.

import java.util.Random;
import java.util.Scanner;

public class numbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 2;
        int maxAttempts = 5;
        int score = 0;

        boolean playAgain = true;

        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean correctGuess = false;

            System.out.println("Welcome to the Guessing Game!");
            System.out.println("Try to guess the number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts && !correctGuess) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! Your guess is correct.");
                    correctGuess = true;
                    score += maxAttempts - attempts + 1; // Update the score based on attempts
                } else if (userGuess < randomNumber) {
                    System.out.println("Sorry, your guess is too low. Attempts left: " + (maxAttempts - attempts));
                } else {
                    System.out.println("Sorry, your guess is too high. Attempts left: " + (maxAttempts - attempts));
                }
            }

            if (!correctGuess) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + randomNumber);
            }

            System.out.println("Your current score: " + score);

            // Ask the user if they want to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();

            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing! Your final score: " + score);
        scanner.close();
    }
}

