package guessing.service;

import guessing.exception.ExceptionHandler;
import guessing.io.Input;

public abstract class Game {
    protected static final int MAX_CHANCE = 7;

    protected final ExceptionHandler exceptionHandler;
    protected final GameManager gameManager;

    protected final Input input;

    public Game(GameManager gameManager, Input input, ExceptionHandler exceptionHandler) {
        this.gameManager = gameManager;
        this.input = input;
        this.exceptionHandler = exceptionHandler;
    }

    abstract public void play();

    abstract protected String retry();
}
