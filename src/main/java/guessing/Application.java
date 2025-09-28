package guessing;

import guessing.controller.GameController;
import guessing.domain.generator.NumberGenerator;
import guessing.domain.generator.RandomNumberGenerator;
import guessing.view.InputView;
import guessing.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        GameController game = new GameController(inputView, outputView, numberGenerator);
        game.run();
    }
}
