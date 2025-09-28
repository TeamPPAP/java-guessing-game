package guessing.domain;

import static guessing.domain.Announce.INPUT_NUMBER_RANGE_ERROR;

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
            throw new IllegalArgumentException(INPUT_NUMBER_RANGE_ERROR.getMessage());
        }
    }

    public int getValue() {
        return value;
    }
}
