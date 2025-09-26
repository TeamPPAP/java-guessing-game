package guessing;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = GameUtils.getStringInput(scanner, "플레이어의 이름을 입력하세요: ");
        Player player = new Player(name);
        GuessingNumber game = new GuessingNumber(player, scanner);
        do {
            game.playGame();
        } while(game.isContinueGame());

        System.out.println("Bye!");
    }

}
