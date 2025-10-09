package core;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    int answerNumber = 0;
    final int ANSWER_MAX_NUM = 100;
    ChanceManager chanceManager;
    private static final Scanner sc = new Scanner(System.in);

    public Game() {
        this.setAnswerNumber();
    }

    public int getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber() {
        this.answerNumber = (int)(Math.random()*ANSWER_MAX_NUM)+1;
    }

    public int run () {
        this.chanceManager = new ChanceManager(); //플레이어마다 새 기회를 부여받음

        System.out.println("1부터 100까지 사이의 숫자를 맞혀보세요❗" + chanceManager.createChanceMessage());

        boolean flag = false;
        while (!flag) {
            int inputNum = promptNumber();
            if(inputNum != 0)
                flag = compareToAnswer(inputNum); //true면 정답

            System.out.println("🔥inputNum" + inputNum);
            chanceManager.reduceChance();

            if (chanceManager.isOverChance()) break;

            if (!flag) {
                System.out.println(chanceManager.createChanceMessage());
                continue;
            }

            return getAttemptsTaken();
        }
        return -1;
    }

    // TODO 사용자가 몇번 만에 맞췄는지에 반환
    public int getAttemptsTaken() {
        return chanceManager.getCHANCE_MAX_COUNT() - chanceManager.getChance();
    }

    /**
     * 숫자 입력 받기 및 검증
     * @return 정상 입력 값
     */
    private int promptNumber() {
        while (true) {
            System.out.println("숫자를 입력하세요");

            if (!sc.hasNextInt()) {
                System.out.println("숫자가 아닙니다.");
                sc.next();
                continue;
            }
            int input = sc.nextInt();

            if (1 > input || input > 100) {
                System.out.println("입력 가능 범위가 아닙니다.");
                continue;
            }
            return input;
        }
    }

    /**
     * compareToAnswer
     * 숫자 판정
     * @param inputNum
     * @return
     */
    private boolean compareToAnswer(int inputNum) {
        if (answerNumber < inputNum) {
            System.out.print("더 낮게❗ ");
            return false;
        }

        if (answerNumber > inputNum) {
            System.out.print("더 높게❗ ");
            return false;
        }
        return true;
    }

    public boolean isGameOver() {
        return chanceManager.isOverChance();
    }

}
