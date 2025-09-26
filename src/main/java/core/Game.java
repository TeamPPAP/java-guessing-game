package core;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    int answerNumber = 0;
    final int ANSWER_MAX_NUM = 100;
    ChanceManager chanceManager;

    public Game() {
        this.chanceManager = new ChanceManager();
        this.setAnswerNumber();
    }

    public int getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber() {
        this.answerNumber = (int) Math.floor(Math.random()*(ANSWER_MAX_NUM+1));
    }

    public void run () {
        System.out.println(answerNumber + "임의");
        System.out.println("1부터 100까지 사이의 숫자를 맞혀보세요❗" + chanceManager.createChanceMessage());

        boolean flag = false;
        while (!flag) {
            int inputNum = promptNumber();
            if(inputNum != 0)
                flag = compareToAnswer(inputNum);

            chanceManager.reduceChance();

            if (chanceManager.isOverChance()) break; //1회가 남았는데 여기서 나가 버림


            if (!flag) {
                System.out.println(chanceManager.createChanceMessage());
                continue;
            }


            System.out.println((chanceManager.getCHANCE_MAX_COUNT() - chanceManager.getChance())+"번 만에 맞췄습니다.");
        }

    }
    // 숫자 입력받기
    private int promptNumber() {
        System.out.print("숫자를 입력하세요:");
        Scanner sc = new Scanner(System.in);
        int input = 0;
        try {
            input = sc.nextInt();

            if( 1 > input || input > 100)
                throw new IllegalArgumentException("입력가능 범위를 초과하였습니다.");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } catch (InputMismatchException ex) {
            System.out.println("InputMismatchException : 숫자가 아닙니다.");
        }
        return input;
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
