package core;

import java.util.Arrays;
import java.util.Scanner;

public class GameManager {
    Game game;

    public void run () {

        boolean shouldShutdown = false;
        do {
            this.game = new Game();
            game.run();

            // TODO OR 연산의 특징에 따른 소스 개선 필요 - isGameOver가 true면 askPlayAgain를 아예 실행하지 않는다.
            shouldShutdown = game.isGameOver() || !askPlayAgain();
            if (shouldShutdown) {
                System.out.println("Game Over❗ (정답 : "+game.getAnswerNumber()+")");
            }
        } while (!shouldShutdown);

    }

    public boolean askPlayAgain(){
        boolean result = false;
        System.out.println("\n한판 더 하시겠습니까❓ [Y/N]");
        Scanner sc = new Scanner(System.in);

        try {
            String answer = sc.nextLine().toUpperCase();

            result = answer.equals("Y");

            if(Arrays.asList("Y", "N").contains(result))
                throw new IllegalArgumentException("[Y/N] 이 아닌 다른 값을 입력하였습니다.");
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            return result;
        }

    }



}
