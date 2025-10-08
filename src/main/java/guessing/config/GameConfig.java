package guessing.config;

import guessing.domain.Computer;
import guessing.domain.MultiGameManager;
import guessing.domain.NumberGenerator;
import guessing.exception.ExceptionHandler;
import guessing.io.Input;
import guessing.service.Game;

public class GameConfig {

    private final ExceptionHandler exceptionHandler = new ExceptionHandler();

    public ExceptionHandler exceptionHandler() {
        return exceptionHandler;
    }

    public NumberGenerator numberGenerator() {
        return new NumberGenerator();
    }

    public Computer computer() {
        return new Computer(numberGenerator());
    }

    public MultiGameManager gameManager() {
        return new MultiGameManager(computer());
    }

    public Input input() {
        return new Input(exceptionHandler());
    }

    public Game game() {
        return new Game(gameManager(), input(), exceptionHandler());
    }

}
