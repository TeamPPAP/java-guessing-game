package guessing;

import java.util.Scanner;

/**
 * Abstract base class for all guessing games.
 * This class defines the common structure and behavior for all games
 * 모든 추측 게임의 추상 기본 클래스로 공통 구조와 동작을 정의함
 */
public abstract class Game {
    protected Player player;
    protected Scanner scanner;
    protected boolean isGameOver;
    protected boolean isPlayerWon;

    /**
     * Constructor initializes the game with a player and scanner
     * 플레이어와 스캐너로 게임을 초기화하는 생성자
     */
    public Game(Player player, Scanner scanner) {
        this.player = player;
        this.scanner = scanner;
    }

    /**
     * Abstract method to start the game
     * Each game implementation will define how to start
     * 게임을 시작하는 추상 메서드
     */
    public abstract void startGame();

    /**
     * Abstract method to play a single turn
     * Each game implementation will define turn logic
     * 한 번의 턴을 진행하는 추상 메서드
     */
    public abstract void playTurn();

    /**
     * Abstract method to display current game state
     * Each game implementation will define how to show progress
     * 현재 게임 상태를 표시하는 추상 메서드
     */
    public abstract void displayGameState();

    /**
     * Abstract method to check if the game is won
     * Each game implementation will define win conditions
     * 게임 승리 여부를 확인하는 추상 메서드
     */
    public abstract boolean checkWinCondition();

    /**
     * Abstract method to check if the game is lost
     * Each game implementation will define lose conditions
     * 게임 패배 여부를 확인하는 추상 메서드
     */
    public abstract boolean checkLoseCondition();

    /**
     * Main game loop - common for all games
     * 모든 게임에 공통인 메인 게임 루프
     */
    public void playGame() {
        startGame();
        while (!isGameOver) {
            displayGameState();
            playTurn();
            if (checkWinCondition()) {
                isPlayerWon = true;
                isGameOver = true;
            }
            if (checkLoseCondition()) {
                isPlayerWon = false;
                isGameOver = true;
            }
        }
        finishGame();
        displayEndGameMessage();
    }

    /**
     * Abstract method to finish the game
     * Each game implementation will define how to finish
     * 게임을 종료하는 추상 메서드
     */
    public abstract void finishGame();

    /**
     * Display end game message based on win/lose status
     * 승패 상태에 따른 게임 종료 메시지를 표시
     */
    public void displayEndGameMessage() {
        System.out.println("Your rank is: " + GameMessages.getPerformanceRating((int) (player.getPlayerRatio() * 100)));
        System.out.println(player.toString());
    }

    /**
     * Get the game name
     * 게임 이름을 반환하는 추상 메서드
     */
    public abstract String getGameName();

}