package guessing.io;

import guessing.exception.ExceptionHandler;

import java.util.Optional;
import java.util.Scanner;

public class Input {
    private final Scanner scanner;
    private final ExceptionHandler handler;

    public Input(ExceptionHandler handler) {
        this.scanner = new Scanner(System.in);
        this.handler = handler;
    }

    public String getInput() {
        return scanner.nextLine();
    }

    public Optional<String> getOptionalInput() {
        return Optional.ofNullable(scanner.nextLine());
    }

    public int getGuessingNumber(String input) {
        //잘못된 입력일 경우 NumberFormatException 발생
        int number = Integer.parseInt(input);

        //맞춰야하는 숫자는 1 ~ 100 사이
        handler.cause(number < 1 || number > 100, "1부터 100 사이로 입력해주세요");

        return number;
    }

    public int getPlayerNumber(String playerNum) {
        int player = 0;

        //잘못된 플래이어 입력 시 exception 발생
        player = Integer.parseInt(playerNum);
        handler.cause((player < 1 || player > 4), "최대 플레이어 수는 4명입니다.");

        return player;
    }

}
