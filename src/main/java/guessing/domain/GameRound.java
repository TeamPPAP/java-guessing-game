package guessing.domain;

public class GameRound {
    private static final int MIN_COUNT = 0;
    private static final int MAX_COUNT = 7;
    private final int randomNumber;
    private Announce hint;
    private int remainingCount;
    private int tryCount;

    public GameRound(final int randomNumber) {
        this.randomNumber = randomNumber;
        this.remainingCount = MAX_COUNT;
        this.tryCount = MIN_COUNT;
    }

    public GameStatus guess(final Num input) {
        tryCount++;
        remainingCount--;

        if (randomNumber == input.value()) {
            return GameStatus.WIN;
        }

        if (remainingCount <= MIN_COUNT) {
            return GameStatus.LOSE;
        }

        hint = getHint(input);
        return GameStatus.ONGOING;
    }

    private Announce getHint(final Num input) {
        return randomNumber < input.value() ? Announce.LOWER_MESSAGE : Announce.HIGHER_MESSAGE;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public int getRemainingCount() {
        return remainingCount;
    }

    public int getTryCount() {
        return tryCount;
    }

    public Announce getHint() {
        return hint;
    }
}
