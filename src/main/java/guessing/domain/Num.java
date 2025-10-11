package guessing.domain;

import static guessing.domain.Announce.INPUT_NUMBER_RANGE_ERROR;

public record Num(int value) {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;

    public Num {
        if (value < MIN_RANGE || MAX_RANGE < value) {
            throw new IllegalArgumentException(INPUT_NUMBER_RANGE_ERROR.getMessage());
        }
    }
}
