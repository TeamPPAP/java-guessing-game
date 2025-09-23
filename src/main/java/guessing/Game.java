package guessing;

import java.util.Scanner;

/**
 * Abstract base class for all word guessing games.
 * This class defines the common structure and behavior for all games
 */
public abstract class Game {
    protected Player player;
    protected Scanner scanner;
    protected boolean isGameOver;
    protected boolean isPlayerWon;

    /**
     * Constructor initializes the game with a player and scanner
     */
    public Game(Player player, Scanner scanner) {
        // TODO
    }

    /**
     * Abstract method to start the game
     * Each game implementation will define how to start
     */
    public abstract void startGame();

    /**
     * Abstract method to play a single turn
     * Each game implementation will define turn logic
     */
    public abstract void playTurn();

    /**
     * Abstract method to display current game state
     * Each game implementation will define how to show progress
     */
    public abstract void displayGameState();

    /**
     * Abstract method to check if the game is won
     * Each game implementation will define win conditions
     */
    public abstract boolean checkWinCondition();

    /**
     * Abstract method to check if the game is lost
     * Each game implementation will define lose conditions
     */
    public abstract boolean checkLoseCondition();

    /**
     * Main game loop - common for all games
     */
    public void playGame() {
        startGame();

        while (!isGameOver) {
            displayGameState();
            playTurn();

            if (checkWinCondition()) {
                isPlayerWon = true;
                isGameOver = true;
            } else if (checkLoseCondition()) {
                isPlayerWon = false;
                isGameOver = true;
            }
        }

        displayEndGameMessage();
    }

    /**
     * Display end game message based on win/lose status
     */
    protected void displayEndGameMessage() {
        // TODO
        // print different strings depends on game result (win or lose)
        // shows up total statistics
    }

    /**
     * Get the game name
     */
    public abstract String getGameName();
}