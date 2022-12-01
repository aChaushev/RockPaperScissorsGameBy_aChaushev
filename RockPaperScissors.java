import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String Rock = "Rock";
        String Paper = "Paper";
        String Scissors = "Scissors";

        System.out.print("Choose [r]ock, [p]aper or [s]cissors: ");
        String playerMove = scanner.nextLine();

        if (playerMove.equals("r") || playerMove.equals("rock")){
            playerMove = Rock;
        } else if (playerMove.equals("p") || playerMove.equals("paper")) {
            playerMove = Paper;
        } else if (playerMove.equals("s") || playerMove.equals("scissors")) {
            playerMove = Scissors;
        } else {
            System.out.println("Invalid Input. Try Again...");
        }

        Random random = new Random();
        int computerRandomNumber = random.nextInt(4);
        String computerMove = switch (computerRandomNumber) {
            case 1 -> Rock;
            case 2 -> Paper;
            case 3 -> Scissors;
            default -> "Lightsaber";
        };
        System.out.printf("The computer chose %s.%n",computerMove);

        if ((playerMove.equals(Rock) && computerMove.equals(Scissors)) ||
                (playerMove.equals(Paper) && computerMove.equals(Rock)) ||
                (playerMove.equals(Scissors) && computerMove.equals(Paper))){
            System.out.println("You win.");
        } else if ((playerMove.equals(Rock) && computerMove.equals(Paper)) ||
                (playerMove.equals(Paper) && computerMove.equals(Scissors)) ||
                (playerMove.equals(Scissors) && computerMove.equals(Rock))) {
            System.out.println("You lose.");
        } else if ((playerMove.equals(Rock) && computerMove.equals(Rock)) ||
                (playerMove.equals(Paper) && computerMove.equals(Paper)) ||
                (playerMove.equals(Scissors) && computerMove.equals(Scissors))) {
            System.out.println("This game was a draw.");
        } else {
            System.out.println("The lightsaber always wins.");
        }

    }
}