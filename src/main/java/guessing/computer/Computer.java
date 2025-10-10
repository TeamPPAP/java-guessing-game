package guessing.computer;

import guessing.service.value.GuessDirection;

public class Computer {
    private final NumberGenerator numberGenerator;
    private int randomNumber;

    public Computer(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void makeRandomNumber() {
        this.randomNumber = numberGenerator.generate(1, 100);
    }

    public GuessDirection direction(int num) {
        return switch (Integer.compare(randomNumber, num)) {
            case 0 -> GuessDirection.CORRECT;
            case 1 -> GuessDirection.BIGGER;
            case -1 -> GuessDirection.LOWER;
            default -> throw new IllegalStateException("비교 로직 오류");
        };
    }

}
