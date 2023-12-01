import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private static final String ROCK = "Rock";
    private static final String PAPER = "Paper";
    private static final String SCISSORS = "Scissors";

    static int playerScore = 0;
    static int computerScore = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;

        while (playAgain) {
            for (int i = 1; i <= 10; i++) {
                System.out.println("-> Game " + i);
                String playerMove = getPlayerMove(scanner);

                String computerMove = getComputerMove();

                System.out.printf("The computer chose %s.%n", computerMove);

                determineWinner(playerMove, computerMove);
            }

            printFinalResult(playerScore, computerScore);

            System.out.print("Do you want to play again? (y/n): ");
            String playAgainInput = scanner.nextLine().toLowerCase();
            playAgain = playAgainInput.equals("y") || playAgainInput.equals("yes");
        }
    }

    private static String getPlayerMove(Scanner scanner) {
        System.out.print("Choose [r]ock, [p]aper, or [s]cissors: ");
        String playerMove = scanner.nextLine().toLowerCase();

        switch (playerMove) {
            case "r":
            case "rock":
                return ROCK;
            case "p":
            case "paper":
                return PAPER;
            case "s":
            case "scissors":
                return SCISSORS;
            default:
                System.out.println("Invalid Input. Try Again...");
                return getPlayerMove(scanner);
        }
    }

    private static String getComputerMove() {
        Random random = new Random();
        int computerRandomNumber = random.nextInt(4);

        return switch (computerRandomNumber) {
            case 1 -> ROCK;
            case 2 -> PAPER;
            case 3 -> SCISSORS;
            default -> "Lightsaber";
        };
    }

    private static void determineWinner(String playerMove, String computerMove) {
        if ((playerMove.equals(ROCK) && computerMove.equals(SCISSORS)) ||
                (playerMove.equals(PAPER) && computerMove.equals(ROCK)) ||
                (playerMove.equals(SCISSORS) && computerMove.equals(PAPER))) {
            System.out.println("You win.");
            playerScore++;
        } else if ((playerMove.equals(ROCK) && computerMove.equals(PAPER)) ||
                (playerMove.equals(PAPER) && computerMove.equals(SCISSORS)) ||
                (playerMove.equals(SCISSORS) && computerMove.equals(ROCK))) {
            System.out.println("You lose.");
            computerScore++;
        } else if ((playerMove.equals(ROCK) && computerMove.equals(ROCK)) ||
                (playerMove.equals(PAPER) && computerMove.equals(PAPER)) ||
                (playerMove.equals(SCISSORS) && computerMove.equals(SCISSORS))) {
            System.out.println("This game was a draw.");
        } else {
            System.out.println("May the Force be with you");
        }
    }

    private static void printFinalResult(int playerScore, int computerScore) {
        System.out.printf("%nYour score is: %d%n", playerScore);
        System.out.printf("Computer score is: %d%n", computerScore);

        if (playerScore > computerScore) {
            System.out.println("Congratulations, you win the season!");
        } else if (computerScore > playerScore) {
            System.out.println("You lost the season!");
        } else {
            System.out.println("Equal result, try again.");
        }
    }
}
