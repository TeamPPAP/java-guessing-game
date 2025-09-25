package guessing;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        /*
         * 새 플레이어, 스캐너, 게임 객체 생성
         * 게임 객체의 .playGame() 실행
         *  -> 게임이 종료될때까지 .playGame() 내부에 있음
         *  -> 함수 실행 완료 후 "여기"로 돌아옴
         * 플레이어가 다시 하길 원한다면?
         *  -> .playGame() 다시 호출
         * 원하지 않는다면?
         *  -> 그대로 loop 탈출 후 종료
         */

        Player player1 = new Player();
        Scanner scanner = new Scanner(System.in);
        GuessingNumber game1 = new GuessingNumber();
        do {
            game1.playGame();
            game1.isContinueGame();

        } while( game1.isContinueGame())

        System.out.println("사요나라!");
    }

}
