package guessing;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 실행 코드 작성

        int randomNum= (int) (Math.random() * (100 - 1) + 1);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try{
                System.out.print("플레이어의 수를 입력해주세요: ");
                String playerNum = scanner.nextLine();

                if (playerNum == null || playerNum.isBlank()) {
                    throw new IllegalArgumentException("잘못된 입력을 하셨습니다. 다시 입력해주세요.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }


        }


    }
}
