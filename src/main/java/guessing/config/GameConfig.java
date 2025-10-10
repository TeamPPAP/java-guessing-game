package guessing.config;

import guessing.computer.Computer;
import guessing.computer.NumberGenerator;
import guessing.exception.ExceptionHandler;
import guessing.io.Input;
import guessing.service.multi.MultiGame;
import guessing.service.multi.MultiGameManager;

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

    public MultiGame game() {
        return new MultiGame(gameManager(), input(), exceptionHandler());
    }

}
