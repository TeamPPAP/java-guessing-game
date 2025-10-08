package guessing;

import java.util.Random;
import java.util.Scanner;

/**
 * Number guessing game implementation
 * 숫자 맞추기 게임 구현 클래스
 */
public class GuessingNumber extends Game {

    private final int MIN = 1;
    private final int MAX = 100;
    private final int MAX_CHANCE = 7;
    private int answer;
    private int chance;
    private int input = Integer.MIN_VALUE;
    private boolean continueGame = false;

    /**
     * Constructor for number guessing game
     * 숫자 맞추기 게임 생성자
     */
    public GuessingNumber(Player player, Scanner scanner) {
        super(player, scanner);
        this.answer = 0;
        this.chance = 0;
    }

    /**
     * Start a new number guessing game
     * 새로운 숫자 맞추기 게임을 시작
     */
    @Override
    public void startGame() {
        answer = new Random().nextInt(MAX) + 1;
        chance = MAX_CHANCE;
        input = Integer.MIN_VALUE;
        continueGame = false;
        isPlayerWon = false;
        isGameOver = false;
        System.out.println(GameMessages.createHeader(getGameName(), 40));
        System.out.println("1부터 100사이의 숫자를 맞춰보세요! (남은 기회: " + chance + "번)");
    }

    /**
     * Play one turn of the guessing game
     * 추측 게임의 한 턴을 진행
     */
    @Override
    public void playTurn() {
        input = InputUtils.getIntegerInputWithRange(scanner, "숫자를 입력하세요", MIN, MAX);
        chance -= 1;
        if (input == answer) {
            System.out.println((MAX_CHANCE - chance) + "번 만에 맞혔습니다!");
        }
        if (input != answer && chance == 0) {
            System.out.println("추측 실패! (정답: " + answer + ")");
        }
        if (chance != 0 && input > answer) {
            System.out.println("더 낮게! (남은기회: " + chance + "번)");
        }
        if (chance != 0 && input < answer) {
            System.out.println("더 높게! (남은기회: " + chance + "번)");
        }
        System.out.println(GameMessages.createSeparator(40));
    }

    /**
     * Display current game state (empty implementation)
     * 현재 게임 상태 표시 (빈 구현)
     */
    @Override
    public void displayGameState() {
    }

    /**
     * Check if the player has won the game
     * 플레이어가 게임에서 승리했는지 확인
     */
    @Override
    public boolean checkWinCondition() {
        return input == answer;
    }

    /**
     * Check if the player has lost the game
     * 플레이어가 게임에서 패배했는지 확인
     */
    @Override
    public boolean checkLoseCondition() {
        return chance == 0;
    }

    /**
     * Finish the game and record results
     * 게임을 종료하고 결과를 기록
     */
    @Override
    public void finishGame() {
        if (isPlayerWon) {
            System.out.println(GameMessages.getRandomWinMessage());
            player.recordWin();
            askToContinue();
            return;
        }
        System.out.println(GameMessages.getRandomLoseMessage());
        player.recordLoss();
        askToContinue();
    }

    /**
     * Ask player if they want to continue playing
     * 플레이어에게 게임 계속 여부를 묻는 메서드
     */
    private void askToContinue() {
        continueGame = InputUtils.getYesNoConfirmation(scanner, "한 판 더 하시겠습니까?");
    }

    /**
     * Get the name of this game
     * 이 게임의 이름을 반환
     */
    @Override
    public String getGameName() {
        return "Guessing Number";
    }

    /**
     * Check if the player wants to continue the game
     * 플레이어가 게임을 계속하고 싶은지 확인
     */
    public boolean isContinueGame() {
        return continueGame;
    }
}
