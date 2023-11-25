import java.util.Random;
public class Main {
    public static void main(String[] args) {
        //defining range
        int min = 1;
        int max = 100;

        //creating an instance of random class
        Random random = new Random();
        int randomNumber = random.nextInt(max - min + 1) + min;

        //printing the generated random number.
        System.out.println("Random number:" +randomNumber);
    }
}