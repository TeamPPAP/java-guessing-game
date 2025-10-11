package guessing.controller;

import guessing.domain.GameRound;
import guessing.domain.GameStatus;
import guessing.domain.Num;
import guessing.domain.RetryCommand;
import guessing.domain.generator.NumberGenerator;
import guessing.view.InputView;
import guessing.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public GameController(final InputView inputView,
                          final OutputView outputView,
                          final NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        do {
            playGame();
        } while (askForRestart());
    }

    private void playGame() {
        int randomNumber = numberGenerator.generate();
        GameRound round = new GameRound(randomNumber);

        outputView.printGameStart(round.getRemainingCount());

        while (true) {
            Num guess = readValidNumber();
            GameStatus result = round.guess(guess);
            result.execute(outputView, round);

            if(!result.isOngoing()){
                break;
            }
        }
    }

    private Num readValidNumber() {
        while (true) {
            try {
                int number = inputView.readNumber();
                return new Num(number);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private boolean askForRestart() {
        while (true) {
            try {
                return processRetryInput();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private boolean processRetryInput() {
        String input = inputView.readRetry();
        RetryCommand command = RetryCommand.from(input);
        if (command.isRetry()) {
            outputView.printNewGameStart();
        }
        return command.isRetry();
    }
}
