package guessing.view;

import static guessing.domain.Announce.INPUT_NUMBER_ERROR;
import static guessing.domain.Announce.INPUT_NUMBER_MESSAGE;
import static guessing.domain.Announce.RETRY_MESSAGE;

import java.util.Scanner;

public class InputView {
    private final Scanner sc = new Scanner(System.in);

    public int readNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE.getMessage());
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NUMBER_ERROR.getMessage());
        }
    }

    public String readRetry() {
        System.out.println();
        System.out.print(RETRY_MESSAGE.getMessage());
        return sc.nextLine().toUpperCase();
    }
}
