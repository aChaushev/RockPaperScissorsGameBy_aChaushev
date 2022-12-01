import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String Rock = "Rock";
        String Paper = "Paper";
        String Scissors = "Scissors";

        int playerScore = 0;
        int computerScore = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.println("-> Game " + i);
            System.out.print("Choose [r]ock, [p]aper or [s]cissors: ");
            String playerMove = scanner.nextLine();

            if (playerMove.equals("r") || playerMove.equals("rock")) {
                playerMove = Rock;
            } else if (playerMove.equals("p") || playerMove.equals("paper")) {
                playerMove = Paper;
            } else if (playerMove.equals("s") || playerMove.equals("scissors")) {
                playerMove = Scissors;
            } else {
                System.out.println("Invalid Input. Try Again...");
                i--;
                continue;
            }

            Random random = new Random();
            int computerRandomNumber = random.nextInt(4);
            String computerMove = switch (computerRandomNumber) {
                case 1 -> Rock;
                case 2 -> Paper;
                case 3 -> Scissors;
                default -> "Lightsaber";
            };
            System.out.printf("The computer chose %s.%n", computerMove);

            if ((playerMove.equals(Rock) && computerMove.equals(Scissors)) ||
                    (playerMove.equals(Paper) && computerMove.equals(Rock)) ||
                    (playerMove.equals(Scissors) && computerMove.equals(Paper))) {
                System.out.println("You win.");
                playerScore++;
            } else if ((playerMove.equals(Rock) && computerMove.equals(Paper)) ||
                    (playerMove.equals(Paper) && computerMove.equals(Scissors)) ||
                    (playerMove.equals(Scissors) && computerMove.equals(Rock))) {
                System.out.println("You lose.");
                computerScore++;
            } else if ((playerMove.equals(Rock) && computerMove.equals(Rock)) ||
                    (playerMove.equals(Paper) && computerMove.equals(Paper)) ||
                    (playerMove.equals(Scissors) && computerMove.equals(Scissors))) {
                System.out.println("This game was a draw.");
            } else {
                System.out.println("May the Force be with you");
            }
        }
        System.out.printf("%nYour score is: %d%n", playerScore);
        System.out.printf("Computer score is: %d%n", computerScore);
        if (playerScore > computerScore){
            System.out.println("Congratulations, you win the season!");
        } else if (computerScore > playerScore){
            System.out.println("Уou lost the season!");
        } else {
            System.out.println("Equal result, try again.");
        }
    }
}