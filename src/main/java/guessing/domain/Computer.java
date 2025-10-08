package guessing.domain;

public class Computer {
    private final NumberGenerator numberGenerator;
    private int randomNumber;

    public Computer(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void makeRandomNumber() {
        this.randomNumber = numberGenerator.generate(1, 100);
    }

    public boolean isCorrect(int num) {
        return randomNumber == num;
    }

    public boolean isBiggerThenAnswer(int num) {
        return randomNumber > num;
    }
}
