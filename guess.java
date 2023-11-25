import java.util.Random;
import java.util.Scanner;
public class guess {
    public static void main(String[] args) {
        //Define range
        int min = 1;
        int max = 100;
        //Create a random instance
        Random random = new Random();
        int randomNumber = random.nextInt(max-min+1)+min;
        //Prompt the user to enter their guess
        Scanner scanner = new Scanner(System.in);
        int userGuess = scanner.nextInt();

        if (userGuess == randomNumber){
            System.out.println("Congratulations! your guess is correct");
        }
        else {
            System.out.println("Sorry! the correct number was:" +randomNumber);
        }
        //close the scanner to avoid resource leaks.
        scanner.close();
    }
}
