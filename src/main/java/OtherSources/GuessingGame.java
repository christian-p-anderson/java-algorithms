package OtherSources;

import java.util.Scanner;

public class GuessingGame {

    /**
     * Create a class that utilizes recursion to answer
     */

    public static void main(String[] args) {
        greeting();
        int number = 1 + (int) (10 * Math.random());
        System.out.println(number);
        guessTheNumber(number);
    }

    public static void greeting() {
        System.out.println(
                "I am thinking of a number between 1 and 10" +
                        "\nTry to guess it in as few attempts as possible." +
                        "\nGuess the number."
        );
    }

    public static void guessTheNumber(int number) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int guess = scanner.nextInt();

            if (guess == number) {
                System.out.println("You guessed correctly!!!");
                break;
            } else if (guess > number) {
                System.out.println("Your guess is too high. Please guess again.");
                guessTheNumber(number);
                break;
            } else {
                System.out.println("Your guess is too low. Please guess again.");
                guessTheNumber(number);
                break;
            }
        }
    }
}
