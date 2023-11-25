import java.util.Random;
import java.util.Scanner;

public class repeatsteps {
    public static void main(String[] args) {
        // Define the range
        int min = 1;
        int max = 100;

        // Create an instance of the Random class
        Random random = new Random();

        // Generate a random number within the specified range
        int randomNumber = random.nextInt(max - min + 1) + min;

        // Create an instance of the Scanner class for user input
        Scanner scanner = new Scanner(System.in);

        // Variable to track whether the guess is correct
        boolean correctGuess = false;

        // Loop until the user guesses the correct number
        while (!correctGuess) {
            // Prompt the user to enter their guess
            System.out.print("Guess the number between " + min + " and " + max + ": ");
            int userGuess = scanner.nextInt();

            // Compare the user's guess with the generated number and provide feedback
            if (userGuess == randomNumber) {
                System.out.println("Congratulations! Your guess is correct.");
                correctGuess = true; // Set the flag to exit the loop
            } else if (userGuess < randomNumber) {
                System.out.println("Sorry, your guess is too low. Try again.");
            } else {
                System.out.println("Sorry, your guess is too high. Try again.");
            }
        }

        // Close the Scanner to avoid resource leaks
        scanner.close();
    }
}
