package guessing;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    int answerNumber = 0;
    int chance = 7;
    public static void main(String[] args) {
        Application app = new Application();

        boolean isGameOver = false;
        do {
            app.answerNumber = app.getAnswerNumber(100); // 정답 숫자
            System.out.println(app.answerNumber + "임의");

            app.runNumberGuessing();
            if(app.chance == 0 || !app.askPlayAgain()){
                System.out.println("Game Over❗ (정답 : "+app.answerNumber+")");
                break;
            }

        } while (!isGameOver);
    }

    private boolean askPlayAgain(){
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

    // TODO : Math.random에 대해 공부 필요
    private int getAnswerNumber(int num) {
        return (int) Math.floor(Math.random()*(num+1));
    }

    private boolean compareToAnswer(int answerNumber, int inputNum) {
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

    private int reduceChance() {
        return --chance;
    }


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

    private void runNumberGuessing() {
        Application app = new Application();

        app.chance = 7;
        int maxChance = chance;

        System.out.println("1부터 100까지 사이의 숫자를 맞혀보세요❗ (남은 기회: " + chance + "번)");

        boolean flag = false;
        while (!flag) {
            int inputNum = promptNumber();

            if(inputNum != 0)
                flag = app.compareToAnswer(answerNumber, inputNum);

            chance = app.reduceChance();

            if(chance <= 0)
                break;

            if (!flag) {
                System.out.println("(남은 기회: " + chance + "번)\n");
                continue;
            }

            System.out.println((maxChance - chance)+"번 만에 맞췄습니다.");

        }
    }
}
