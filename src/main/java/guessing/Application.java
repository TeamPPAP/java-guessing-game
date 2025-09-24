package guessing;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();

        boolean isGameOver = false;
        do {
            app.runNumberGuessing();
            if(!app.askPlayAgain()){
                System.out.println("Game Over❗");
                break;
            }

        } while (!isGameOver);
    }

    private boolean askPlayAgain(){
        boolean result = false;
        System.out.println("\n한판 더 하시겠습니까❓ [Y/N]");
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();

        if(answer.equals("Y"))
            result = true;

        return result;
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

    private int reduceChance(int chance) {
        return --chance;
    }

    private int promptNumber() {
        System.out.print("숫자를 입력하세요:");
        Scanner sc = new Scanner(System.in);
        int input =  sc.nextInt();
        return input;
    }

    private void runNumberGuessing() {
        Application app = new Application();
        int answerNumber = app.getAnswerNumber(100); // 정답 숫자
        System.out.println(answerNumber + "임의");

        int chance = 7;
        int maxChance = chance;

        System.out.println("1부터 100까지 사이의 숫자를 맞혀보세요❗ (남은 기회: " + chance + "번)");

        boolean flag = false;
        while (!flag) {
            int inputNum = promptNumber();

            flag = app.compareToAnswer(answerNumber, inputNum);
            chance = app.reduceChance(chance);

            if (!flag) {
                System.out.println("(남은 기회: " + chance + "번)\n");
                continue;
            }

            System.out.println((maxChance - chance)+"번 만에 맞췄습니다.");

        }
    }
}
