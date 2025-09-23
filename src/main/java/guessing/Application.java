package guessing;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Player player = new Player("tabacco");
        Scanner scanner = new Scanner(System.in);
        GuessingNumber GN = new GuessingNumber(player, scanner);
    }

}
