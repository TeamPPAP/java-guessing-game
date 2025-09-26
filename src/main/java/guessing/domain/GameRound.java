package guessing.domain;

import java.util.concurrent.ThreadLocalRandom;

public class GameRound {
    private final int randomNumber;
    private int count = 7;
    private int tryCount = 1;

    public GameRound() {
        this.randomNumber = ThreadLocalRandom.current().nextInt(1, 101);
    }

    public Announce inGameAnnounce(int input) {
        count--;

        if (randomNumber == input) {
            return Announce.WINNING_MESSAGE;
        } else if (randomNumber < input) {
            tryCount++;
            return Announce.LOWER_MESSAGE;
        } else {
            tryCount++;
            return Announce.HIGHER_MESSAGE;
        }
    }

    public boolean isOver() {
        return count <= 0;
    }

    public int getCount() {
        return count;
    }

    public int getTryCount() {
        return tryCount;
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
