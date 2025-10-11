package guessing.view;

import static guessing.domain.Announce.GAME_OVER_MESSAGE;
import static guessing.domain.Announce.NEW_GAME_START_MESSAGE;
import static guessing.domain.Announce.RANDOM_NUMBER_RELEASE;
import static guessing.domain.Announce.REMAINING_COUNT_MESSAGE;
import static guessing.domain.Announce.START_MESSAGE;
import static guessing.domain.Announce.TRY_COUNT_MESSAGE;
import static guessing.domain.Announce.WINNING_MESSAGE;

import guessing.domain.Announce;

public class OutputView {
    public void printGameStart(final int remainingCount) {
        System.out.print(START_MESSAGE.getMessage());
        System.out.printf(REMAINING_COUNT_MESSAGE.getMessage(), remainingCount);
        System.out.println();
    }

    public void printHint(final Announce hint, final int remainingCount) {
        System.out.print(hint.getMessage());
        System.out.printf(REMAINING_COUNT_MESSAGE.getMessage(), remainingCount);
        System.out.println();
        System.out.println();
    }

    public void printWin(final int tryCount) {
        System.out.println(WINNING_MESSAGE.getMessage());
        System.out.printf(TRY_COUNT_MESSAGE.getMessage(), tryCount);
        System.out.println();
    }

    public void printGameOver(final int randomNumber) {
        System.out.println(GAME_OVER_MESSAGE.getMessage());
        System.out.printf(RANDOM_NUMBER_RELEASE.getMessage(), randomNumber);
        System.out.println();
    }

    public void printNewGameStart() {
        System.out.println();
        System.out.println(NEW_GAME_START_MESSAGE.getMessage());
    }

    public void printErrorMessage(final String message) {
        System.out.println(message);
    }
}
