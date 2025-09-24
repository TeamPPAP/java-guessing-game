package guessing;

import static guessing.Announce.START_MESSAGE;

public class Application {
    public static void main(String[] args) {
        START_MESSAGE.print();
        InputView inputView = new InputView();
        Num num;

        while (true) {
            try {
                int value = inputView.readNumber();
                num = new Num(value);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("숫자만 입력해 주세요.");
            }
        }

        int count = 7;
        int tryCount = 1;

        int randomNumber = (int) (Math.random() * 100) + 1;
        Retry:
        while (true) {
            while (true) {
                if (count < 0) {
                    System.out.println("게임 오버!");
                    System.out.printf("정답은 %d 였습니다.\n", randomNumber);
                    System.out.println("한판 더 하시겠습니까?");

//                    String retry = sc.nextLine().toUpperCase();
//
//                    if (retry.equals("Y")) {
//                        break Game;
//                    } else if (retry.equals("N")) {
//                        break Retry;
//                    }
                }

                if (randomNumber == num.getValue()) {
                    System.out.println("정답입니다.");
                    System.out.println(tryCount + "번 만에 맞추셨습니다!");
                    break Retry;
                } else if (randomNumber < num.getValue()) {
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
