package guessing.domain;

import guessing.dto.RoundResult;

public class GameRound {
    private static final int MIN_COUNT = 0;
    private static final int MAX_COUNT = 7;

    private final int randomNumber;
    private int remainingCount;
    private int tryCount;

    public GameRound(final int randomNumber) {
        this.randomNumber = randomNumber;
        this.remainingCount = MAX_COUNT;
        this.tryCount = MIN_COUNT;
    }

    public RoundResult guess(final Num input) {
        tryCount++;
        remainingCount--;

        if (randomNumber == input.getValue()) {
            return new RoundResult(GameStatus.WIN, Announce.WINNING_MESSAGE);
        }

        if (remainingCount <= MIN_COUNT) {
            return new RoundResult(GameStatus.LOSE, Announce.GAME_OVER_MESSAGE);
        }

        Announce hint = getHint(input);
        return new RoundResult(GameStatus.ONGOING, hint);
    }

    private Announce getHint(final Num input) {
        Announce hint;
        if (randomNumber < input.getValue()) {
            hint = Announce.LOWER_MESSAGE;
        } else {
            hint = Announce.HIGHER_MESSAGE;
        }
        return hint;
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
}
