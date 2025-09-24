package guessing;

import java.util.Scanner;

public class Application {
    private static final int MAX_CHANCE = 7;

    public static void main(String[] args) {

        //컴퓨터가 숫자 난수 생성
        while (true) {
            int randomNum = (int) (Math.random() * (100 - 1) + 1);

            //입력하기 위해 scanner 정의
            Scanner scanner = new Scanner(System.in);

            // 플레이어 수
            int player = 0;
            while (true) {
                try {
                    System.out.print("플레이어의 수를 입력해주세요: ");
                    String playerNum = scanner.nextLine();

                    //잘못된 플래이어 입력 시 exception 발생
                    player = Integer.parseInt(playerNum);

                    //최대 플래이어 수: 4
                    if (player < 1 || player > 4) {
                        throw new IllegalArgumentException("잘못된 입력을 하셨습니다. 다시 입력해주세요.");
                    }
                    break;//입력에 문제가 없을 경우 break
                } catch (IllegalArgumentException e) {
                    System.out.println("잘못된 입력을 하셨습니다. 다시 입력해주세요.");
                }

            }

            //플레이어당 기회
            int[] chances = new int[player + 1];
            CHANCE:
            for (int j = 0; j < MAX_CHANCE; j++) {
                for (int i = 1; i <= player; i++) {
                    try {
                        System.out.print("player " + i + "님 수를 입력해주세요: ");
                        String answer = scanner.nextLine(); //각각의 플레이어가 정답을 맞춥니다.

                        //잘못된 입력일 경우 NumberFormatException 발생
                        int number = Integer.parseInt(answer);

                        //맞춰야하는 숫자는 1 ~ 100 사이
                        if (number < 1 || number > 100) {
                            throw new IllegalArgumentException("잘못된 입력을 하셨습니다. 다시 입력해주세요.");
                        }

                        //숫자 비교
                        chances[i]++;
                        if (number == randomNum) {
                            System.out.println("Player " + i + "님이" + chances[i] + "번 만에 맞혔습니다!");
                            break CHANCE;
                        } else if (number < randomNum) {
                            System.out.println("더 높게! (남은 기회: " + (7 - chances[i]) + "번)");
                        } else {
                            System.out.println("더 낮게! (남은 기회: " + (7 - chances[i]) + "번)");
                        }

                    } catch (IllegalArgumentException e) {
                        System.out.println("잘못된 입력을 하셨습니다. 다시 입력해주세요.");

                    }

                }
            }

            String retry;
            while (true) {
                try {
                    System.out.println("한판 더 하시겠습니까?");
                    retry = scanner.nextLine();
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
}
