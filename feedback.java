import java.util.Random;
import java.util.Scanner;
public class feedback {
    public static void main(String[] args) {
        //Define range
        int min = 1;
        int max = 100;
        //Create a random instance
        Random random = new Random();
        int randomNumber = random.nextInt(max-min+1)+min;
        //Create an instance to scan
        Scanner scanner = new Scanner(System.in);
        //prompt the user to guess the number
        System.out.println("Guess the number between"+min+" and "+max+":");
        int userGuess = scanner.nextInt();

        if (userGuess == randomNumber){
            System.out.println("Congratulations! your guess is correct");
        }
        else if (userGuess < randomNumber){
            System.out.println("Sorry! your guess is less than the generated number.\nThe generated number is " +randomNumber);
        }
        else {
            System.out.println("Sorry! your guess is more than the generated number.\nThe generated number is " +randomNumber);
        }
        //close the scanner to avoid resource leaks.
        scanner.close();
    }
}

