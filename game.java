import java.util.Random;
import java.util.Scanner;

public class game {

    public static void main(String[] args) {
        // Step 1: Game Initialization
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int guess = 0;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        // Display introductory message
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("Try to guess it!");

        // Step 2: User Input and Guess Validation
        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            try {
                guess = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
                continue;
            }
            
            // Increment attempt counter
            attempts++;
            
            // Step 3: Guess Validation
            if (guess < lowerBound || guess > upperBound) {
                System.out.println("Please guess a number between " + lowerBound + " and " + upperBound + ".");
            } else if (guess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                // Step 4: Winning Condition
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You've guessed the number.");
                System.out.println("It took you " + attempts + " attempts.");
            }
        }

        // Close the scanner
        scanner.close();
    }
}
