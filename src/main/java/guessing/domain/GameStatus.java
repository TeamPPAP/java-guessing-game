package guessing.domain;

import guessing.view.OutputView;

public enum GameStatus {
    ONGOING{
        @Override
        public void execute(OutputView outputView, GameRound round) {
            outputView.printHint(round.getHint(), round.getRemainingCount());
        }
    },
    WIN{
        @Override
        public void execute(OutputView outputView, GameRound round) {
            outputView.printWin(round.getTryCount());
        }
    },
    LOSE{
        @Override
        public void execute(OutputView outputView, GameRound round) {
            outputView.printGameOver(round.getRandomNumber());
        }
    };

    public boolean isOngoing() {
        return this == ONGOING;
    }

    public abstract void execute(OutputView outputView, GameRound round);
}
