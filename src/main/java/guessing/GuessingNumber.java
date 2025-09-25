package guessing;

import java.util.Random;
import java.util.Scanner;

public class GuessingNumber extends Game {

    // Field
    private int answer;
    private int chance;
    private final int MAX_CHANCE = 7;
    private boolean continueGame = false;


    public GuessingNumber(Player player, Scanner scanner) {
        super(player, scanner);
        this.answer = 0;
        this.chance = 0;
        /*
         * 필요한 객체와 멤버변수들을 초기화하는 과정
         */
    }

    @Override
    public void startGame() {
        /* 게임이 시작되며 최초로 1회만 호출되는 state
         *
         * 컴퓨터가 1-100 사이의 임의의 정수 생성 및 할당
         * 정답을 맞출 기회 수를 할당
         * 최초 입력을 받기 위한 프롬프트 출력
         * 사용자에게 1부터 100사이 정수를 입력하도록 제시하기 ?
         * 값이 작은지 큰지 판단하여 결과 및 남은 횟수 제시 ?
         */
        this.answer = new Random().nextInt(100) + 1;
        this.chance = MAX_CHANCE;
        int input = getIntegerInput(this.scanner,"1부터 100 사이의 숫자를 맞춰보세요! (남은기회: " + chance + "번)");
        if(input == this.answer) {
            System.out.println(getRandomWinMessage());
        } else if(input > this.answer) {
            chance--;
            System.out.println("더 낮게! (남은기회: " + chance + "번)");
        } else if(input < this.answer){
            chance--;
            System.out.println("더 높게! (남은기회: " + chance + "번)");
        }
    }

    @Override
    public void playTurn() {
        /*
         * 사용자가 숫자를 입력하도록 화면에 프롬프트 출력
         * 사용자에게 입력받기
         * 맞았는지 틀렸는지 확인
         * 맞은 경우 -> ?
         * 틀린 경우 -> 높은지 낮은지 확인하여 추가 힌트 부여
         *         -> 남은 기회 카운트
         */
        int input = getIntegerInput(this.scanner,"숫자를 입력하세요!");
        if(input == this.answer) {
            System.out.println(getRandomWinMessage());
        } else if(input > this.answer) {
            chance--;
            System.out.println("더 낮게! (남은기회: " + chance + "번)");
        } else if(input < this.answer){
            chance--;
            System.out.println("더 높게! (남은기회: " + chance + "번)");
    }

    @Override
    public void displayGameState() {
        /*
         * 매 턴마다 출력해야 하는 프롬프트를 일괄 출력
         */
    }

    @Override
    public boolean checkWinCondition() {
        /*
         * 사용자가 입력한 값이랑 컴퓨터가 생성한 값이 같은지 확인
         * 남은 횟수가 0보다 크거나 같은지 확인
         */
            return input == this.answer;

    }

    @Override
    public boolean checkLoseCondition() {
        /* 플레이어가 지는 경우를 판단하는 함수
         *
         * 남은횟수가 0이면 진다
         */
        return this.chance == 0;

    }

    @Override
    public void finishGame() {
        /*
         * 한번 더 플레이할지 묻는 프롬프트 출력
         * 사용자에게 Y/N 로 응답받아 저장하기
         *  -> GuessingNumber 객체를 호출한 main() 에서 게임을 재시작할지 여부를 판단하는 플래그로 사용할것
         * 게임의 결과를 플레이어 객체에 저장
         */
        this.continueGame = getYesNoConfirmation(this.scanner,"한 판 더 하시겠습니까?");

    }

    @Override
    public String getGameName() {
        return "";
    }

}

    public boolean isContinueGame() {
        return continueGame;
    }
