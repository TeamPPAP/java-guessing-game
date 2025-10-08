package guessing.service;

import guessing.domain.MultiGameManager;
import guessing.exception.ExceptionHandler;
import guessing.io.Input;

public class Game {
    private static final int MAX_CHANCE = 7;

    private final ExceptionHandler exceptionHandler;
    private final MultiGameManager gameManager;

    private final Input input;

    public Game(MultiGameManager gameManager, Input input, ExceptionHandler exceptionHandler) {
        this.gameManager = gameManager;
        this.input = input;
        this.exceptionHandler = exceptionHandler;
    }

    public void play() {
        while (true) {
            gameManager.generate();
            int player = setPlayerNumber();
            guessNumber(player);
            String answer = retry();

            if (answer.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    private String retry() {
        return exceptionHandler.executeWithRetry(() -> {
            System.out.println("한판 더 하시겠습니까?");
            String retry = input.getOptionalInput().orElseThrow(IllegalArgumentException::new);
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
        String answer = input.getOptionalInput().orElseThrow(IllegalArgumentException::new);
        int guessingNumber = input.getGuessingNumber(answer);

        gameManager.exhaust(playerId);
        String s = gameManager.isSuccessThenGetString(playerId, guessingNumber);

        if (s != null) {
            System.out.println(s);
            return true;
        }

        System.out.println(gameManager.notCorrect(playerId, guessingNumber, MAX_CHANCE));
        return false;
    }

    private int setPlayerNumber() {
        return exceptionHandler.executeWithRetry(() -> {
            System.out.print("플레이어의 수를 입력해주세요: ");
            String playerNum = input.getInput();

            int p = input.getPlayerNumber(playerNum);

            gameManager.setting(p);
            return p;
        });
    }
}
