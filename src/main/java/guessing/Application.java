package guessing;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 7;
        int tryCount = 1;

        int randomNumber = (int) (Math.random() * 100) + 1;
        Retry:
        while (true) {
            System.out.printf("1부터 100까지의 숫자를 맞춰보세요! (남은 기회 : %d)\n", count);

            Game:
            while (true) {
                System.out.println("숫자를 입력하세요.");

                int input = Integer.parseInt(sc.nextLine());

                if (count < 0) {
                    System.out.println("게임 오버!");
                    System.out.printf("정답은 %d 였습니다.\n", randomNumber);
                    System.out.println("한판 더 하시겠습니까?");

                    String retry = sc.nextLine().toUpperCase();

                    if (retry.equals("Y")) {
                        break Game;
                    } else if (retry.equals("N")) {
                        break Retry;
                    }
                }

                if (randomNumber == input) {
                    System.out.println("정답입니다.");
                    System.out.println(tryCount + "번 만에 맞추셨습니다!");

                    break Retry;
                    //TODO : if문 메서드 분리 -> 지윤
                } else if (randomNumber < input) {
                    count--;
                    tryCount++;
                    System.out.printf("더 낮게! (남은 기회 : %d)\n", count);
                } else {
                    count--;
                    tryCount++;
                    System.out.printf("더 높게! (남은 기회 : %d)\n", count);
                }
            }
        }
    }
}
