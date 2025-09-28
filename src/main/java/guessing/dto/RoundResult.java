package guessing.dto;

import guessing.domain.Announce;
import guessing.domain.GameStatus;

public final class RoundResult {
    private final GameStatus gameStatus;
    private final Announce hint;

    public RoundResult(final GameStatus gameStatus, final Announce hint) {
        this.gameStatus = gameStatus;
        this.hint = hint;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Announce getHint() {
        return hint;
    }
}
