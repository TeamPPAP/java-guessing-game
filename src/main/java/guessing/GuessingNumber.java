package guessing;

import java.util.Scanner;

public class GuessingNumber extends Game {
    private int answer;
    private int chance;
    public GuessingNumber(Player player, Scanner scanner) {
        super(player, scanner);
        this.answer = (int) (Math.random() * 100) + 1;
        this.chance = 7;
    }

    @Override
    public void startGame() {
        /*
        *  컴퓨터가 임의의 숫자 생성
        *  몇번의 기회가 남았는지 초기값 설정
        *  입력을 받기 위한 프롬프트
        *  사용자에게 1부터 100사이 정수를 입력하도록 제시하기
         */

    }

    @Override
    public void playTurn() {
        /*
        * 사용자가 숫자를 입력하도록 프롬프트 생성
        * 사용자에게 입력받기
        * 맞았는지 틀렸는지 확인
        * 틀린 경우에는 높은지 낮은지 확인
        * 남은 기회 카운트
         */
    }

    @Override
    public void displayGameState() {

    }

    @Override
    public boolean checkWinCondition() {
        /*
        * 사용자가 입력한 값이랑 컴퓨터가 생성한 값이 같은지 확인
        * 남은 횟수가 0보다 크거나 같은지 확인
         */
        return false;
    }

    @Override
    public boolean checkLoseCondition() {
        /*
        * 남은횟수가 0이면 진다
         */
        return false;
    }

    @Override
    public String getGameName() {
        return "";
    }

    // answer - variable, set on construction
    // turn - how many attempts available by player

    // this game has turns





}
