package guessing.service;

import guessing.domain.GameManager;
import guessing.io.Input;
import guessing.io.Output;

public class Game {
    private static final int MAX_CHANCE = 7;

    private GameManager gameManager;

    private Input input;
    private Output output;

    public Game(GameManager gameManager, Input input, Output output) {
        this.gameManager = gameManager;
        this.input = input;
        this.output = output;
    }

    public void play() {
        while (true) {
            gameManager.generate();

            // 플레이어 수
            int player = setPlayerNumber();

            //플레이어당 기회
            gameManager.setting(player);

            for (int j = 0; j < MAX_CHANCE; j++) {
                boolean result = guessing(player);
                if (result) {
                    break;
                }
            }

            String retry;
            while (true) {
                try {
                    System.out.println("한판 더 하시겠습니까?");
                    retry = input.getInput();
                    if (retry == null || retry.isBlank()) {
                        throw new IllegalArgumentException("잘못된 입력을 하셨습니다. 다시 입력해주세요.");
                    }
                    if (!retry.equalsIgnoreCase("y") && !retry.equalsIgnoreCase("n")) {
                        throw new IllegalArgumentException("잘못된 입력을 하셨습니다. 다시 입력해주세요.");
                    }
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("잘못된 입력을 하셨습니다. 다시 입력해주세요.");
                }
            }
            if (retry.equalsIgnoreCase("N")) {
                break;
            }

        }
    }

    private boolean guessing(int player) {
        for (int i = 1; i <= player; i++) {
            try {
                System.out.print("player " + i + "님 수를 입력해주세요: ");
                //각각의 플레이어가 정답을 맞춥니다.
                int answer = gameManager.heardAnswer(input.getInput());
                gameManager.exhaust(i);
                String s = gameManager.isSuccessThenGetString(i, answer);
                if (s != null) {
                    System.out.println(s);
                    return true;
                }

                s = gameManager.notCorrect(i, answer);
                System.out.println(s);

            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력을 하셨습니다. 다시 입력해주세요.");

            }

        }
    }

    private int setPlayerNumber() {
        int player = 0;
        while (true) {
            try {
                System.out.print("플레이어의 수를 입력해주세요: ");
                String playerNum = input.getInput();

                if (gameManager.setPlayerNumber(playerNum)) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력을 하셨습니다. 다시 입력해주세요.");
            }
        }
        return player;
    }
}
