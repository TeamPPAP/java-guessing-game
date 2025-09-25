package guessing.io;

public class Output {

    public void printSuccess(String name, int chance) {
        System.out.println(name + "님이" + chance + "번 만에 맞혔습니다!");
    }

    public void printAnswerHigher(int chance) {
        System.out.println("더 높게! (남은 기회: " + chance + "번)");
    }

    public void printAnswerLower(int chance) {
        System.out.println("더 낮게! (남은 기회: " + chance + "번)");
    }
}
