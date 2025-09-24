package guessing;

import static guessing.Announce.INPUT_NUMBER_MESSAGE;

import java.util.Scanner;

public class InputView {

    private final Scanner sc = new Scanner(System.in);

    public int readNumber() {
        INPUT_NUMBER_MESSAGE.print();
        return Integer.parseInt(sc.nextLine());
    }
}
