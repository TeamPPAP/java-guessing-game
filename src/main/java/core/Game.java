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

    /**
     * 숫자 맞히기 한 판을 실행한다.
     *
     * <p>반환값 규약:
     * <p>- 정답을 맞히면: 시도 횟수(양수)
     * <p>- 모든 기회를 소진하면: -1
     */
    public int run () {
        // 플레이어마다 새 기회 세트 부여
        this.chanceManager = new ChanceManager();

        System.out.println("1부터 100까지 사이의 숫자를 맞혀보세요❗" + chanceManager.createChanceMessage());

        while (true) {
            // 1) 입력값을 받고 유효성 검증(프롬프트 내부에서 처리)
            int inputNum = promptNumber();

            // 2) 정답 비교: 맞히면 즉시 종료(성공 케이스 우선 반환)
            boolean isCorrect = compareToAnswer(inputNum);
            if (isCorrect) {
                return getAttemptsTaken();
            }

            // 3) 오답이면 기회 차감 후 사용자에게 남은 기회 안내
            chanceManager.reduceChance();
            System.out.println(chanceManager.createChanceMessage());

            // 4) 더 이상 기회가 없으면 루프 종료(실패 케이스)
            if (chanceManager.isOverChance()) {
                break;
            }
        }
        // 모든 기회를 소진한 경우
        return -1;
    }

    // TODO 사용자가 몇번 만에 맞췄는지에 반환
    public int getAttemptsTaken() {
        //최대 기회 수 - 현재 기회 = 0 + 1 (1회만에 맞춤)
        return chanceManager.getCHANCE_MAX_COUNT() - chanceManager.getChance()+1; //+1로 수정해서 1번만에 맞췄을때 정상으로 노출
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
