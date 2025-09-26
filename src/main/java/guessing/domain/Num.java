package guessing.domain;

public class Num {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;

    private final int value;

    public Num(final int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(final int value) {
        if (value < MIN_RANGE || MAX_RANGE < value) {
            throw new IllegalArgumentException("1부터 100 사이의 숫자를 입력해 주세요.");
        }
    }

    public int getValue() {
        return value;
    }
}
