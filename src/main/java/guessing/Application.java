package guessing;

import java.util.Scanner;

/**
 * Main application class for the guessing number game
 * 숫자 맞추기 게임의 메인 애플리케이션 클래스
 */
public class Application {
    /**
     * Main method to start the guessing number game
     * 숫자 맞추기 게임을 시작하는 메인 메서드
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = InputUtils.getStringInput(scanner, "플레이어의 이름을 입력하세요: ");
        Player player = new Player(name);
        GuessingNumber game = new GuessingNumber(player, scanner);

        do {
            game.playGame();
        } while (game.isContinueGame());

        scanner.close();
        System.out.println("Bye!");
    }

}
