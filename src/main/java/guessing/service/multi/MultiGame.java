package guessing.service.multi;

import guessing.exception.ExceptionHandler;
import guessing.io.Input;
import guessing.service.Game;
import guessing.service.dto.GuessResult;

public class MultiGame extends Game {

    private final MultiGameManager multiGameManager;

    public MultiGame(MultiGameManager gameManager, Input input, ExceptionHandler exceptionHandler) {
        super(gameManager, input, exceptionHandler);

        this.multiGameManager = gameManager;
    }

    @Override
    public void play() {
        while (true) {
            int player = setPlayerNumber();
            multiGameManager.startNewGame(player);
            guessNumber(player);
            String answer = retry();

            if (answer.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    @Override
    protected String retry() {
        return exceptionHandler.executeWithRetry(() -> {
            System.out.println("한판 더 하시겠습니까?");
            String retry = getInput();
            exceptionHandler.cause(retry.isBlank(), "빈칸 또는 공백 값은 입력하실 수 없습니다.");
            exceptionHandler.cause(!isAnswerYorN(retry), "Y 또는 N만 가능합니다.");
            return retry;
        });
    }

    private boolean isAnswerYorN(String answer) {
        return answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n");
    }

    private void guessNumber(int player) {
        for (int j = 1; j <= MAX_CHANCE; j++) {
            boolean result = guessing(player);
            if (result) {
                break;
            }
        }
    }

    private boolean guessing(int player) {
        for (int i = 1; i <= player; i++) {
            if (executeTurnWithRetry(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean executeTurnWithRetry(int playerId) {
        return exceptionHandler.executeWithRetry(() -> processPlayerTurn(playerId));
    }

    private boolean processPlayerTurn(int playerId) throws IllegalArgumentException {
        System.out.print("player " + playerId + "님 수를 입력해주세요: ");
        int guessingNumber = input.getGuessingNumber(getInput());

        GuessResult result = multiGameManager.submitGuess(playerId, guessingNumber, MAX_CHANCE);
        System.out.println(result.message());

        if (result.success()) {
            return true;
        }

        return false;
    }

    private int setPlayerNumber() {
        return exceptionHandler.executeWithRetry(() -> {
            System.out.print("플레이어의 수를 입력해주세요: ");
            String playerNum = input.getInput();

            return input.getPlayerNumber(playerNum);
        });
    }

    private String getInput() {
        return input.getOptionalInput().orElseThrow(IllegalArgumentException::new);
    }
}
