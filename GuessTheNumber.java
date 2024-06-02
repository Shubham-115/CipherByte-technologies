import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rounds = 3; // Number of rounds
        int maxAttempts = 5; // Maximum number of attempts per round
        int totalScore = 0;

        System.out.println("Welcome to the Guess the Number Game!");

        for (int round = 1; round <= rounds; round++) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessed = false;

            System.out.println("Round " + round + ":");
            while (attempts < maxAttempts && !guessed) {
                System.out.print("Enter your guess (1-100): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    guessed = true;
                    int points = maxAttempts - attempts + 1;
                    totalScore += points;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts. You earn " + points + " points.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessed) {
                System.out.println("Sorry! You've used all attempts. The number was " + numberToGuess + ".");
            }

            System.out.println();
        }

        System.out.println("Game Over! Your total score is: " + totalScore);
        scanner.close();
    }
}
