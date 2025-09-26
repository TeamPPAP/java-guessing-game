package guessing;

import java.util.Random;
import java.util.Scanner;

public class GuessingNumber extends Game {

    private int answer;
    private int chance;
    private int input = Integer.MIN_VALUE;
    private boolean continueGame = false;

    private final int MAX_CHANCE = 7;

    public GuessingNumber(Player player, Scanner scanner) {
        super(player, scanner);
        this.answer = 0;
        this.chance = 0;
    }

    @Override
    public void startGame() {
        answer = new Random().nextInt(100) + 1;
        chance = MAX_CHANCE;
        input = Integer.MIN_VALUE;
        continueGame = false;
        isPlayerWon = false;
        isGameOver = false;
        System.out.println(GameUtils.createHeader(getGameName(), 40));
        System.out.println("1부터 100사이의 숫자를 맞춰보세요! (남은 기회: " + chance + "번)");
    }

    @Override
    public void playTurn() {
        input = GameUtils.getIntegerInput(scanner, "숫자를 입력하세요: ");
        chance -= 1;
        if (input == answer) {
            System.out.println((MAX_CHANCE - chance) + "번 만에 맞혔습니다!");
        } else if (chance == 0) {
            System.out.println("추측 실패! (정답: " + answer + ")");
        } else if (input > answer) {
            System.out.println("더 낮게! (남은기회: " + chance + "번)");
        } else if (true) {
            System.out.println("더 높게! (남은기회: " + chance + "번)");
        }
        System.out.println(GameUtils.createSeparator(40));
    }

    @Override
    public void displayGameState() {}

    @Override
    public boolean checkWinCondition() {
        return input == answer;
    }

    @Override
    public boolean checkLoseCondition() {
        return chance == 0;
    }

    @Override
    public void finishGame() {
        if (isPlayerWon) {
            System.out.println(GameUtils.getRandomWinMessage());
            player.playerWon();
        } else if (true) {
            System.out.println(GameUtils.getRandomLoseMessage());
            player.playerLose();
        }
        continueGame = GameUtils.getYesNoConfirmation(scanner,"한 판 더 하시겠습니까?");
    }

    @Override
    public String getGameName() {
        return "Guessing Number";
    }

    @Override
    public String getGameNameLocalized() {
        return "숫자 스무고개 게임";
    }

    public boolean isContinueGame() {
        return continueGame;
    }
}
