package guessing.service;

import guessing.domain.MultiGameManager;
import guessing.exception.ExceptionHandler;
import guessing.io.Input;

public class Game {
    private static final int MAX_CHANCE = 7;
    private final ExceptionHandler exceptionHandler = new ExceptionHandler();
    private MultiGameManager gameManager;

    private Input input;

    public Game(MultiGameManager gameManager, Input input) {
        this.gameManager = gameManager;
        this.input = input;
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
            String retry = input.getInput();
            exceptionHandler.cause(retry == null || retry.isBlank());
            exceptionHandler.cause(!isAnswerYorN(retry));
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
        while (true) {
            try {
                return processPlayerTurn(playerId);
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력을 하셨습니다. 다시 입력해주세요.");
            }
        }
    }

    private boolean processPlayerTurn(int playerId) throws IllegalArgumentException {
        System.out.print("player " + playerId + "님 수를 입력해주세요: ");
        int answer = gameManager.heardAnswer(input.getInput());

        gameManager.exhaust(playerId);
        String s = gameManager.isSuccessThenGetString(playerId, answer);

        if (s != null) {
            System.out.println(s);
            return true;
        }

        System.out.println(gameManager.notCorrect(playerId, answer, MAX_CHANCE));
        return false;
    }

    private int setPlayerNumber() {
        return exceptionHandler.executeWithRetry(() -> {
            System.out.print("플레이어의 수를 입력해주세요: ");
            String playerNum = input.getInput();

            int p = gameManager.setPlayerNumber(playerNum);
            if (p == 0) {
                throw new IllegalArgumentException("플레이어 수는 1 이상이어야 합니다.");
            }

            gameManager.setting(p);
            return p;
        });
    }
}
