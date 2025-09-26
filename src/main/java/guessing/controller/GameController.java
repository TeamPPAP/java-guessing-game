package guessing.controller;

import guessing.domain.Announce;
import guessing.domain.GameRound;
import guessing.domain.Num;
import guessing.view.InputView;

public class GameController {
    InputView inputView = new InputView();

    public boolean play(GameRound gameRound) {
        System.out.println(gameRound.getRandomNumber());

        Announce.START_MESSAGE.print();
        Announce.REMAINING_COUNT_MESSAGE.print(gameRound.getCount());

        while (true) {
            Num num;
            try {
                int value = inputView.readNumber();
                num = new Num(value);
            } catch (IllegalArgumentException e) {
                Announce.INPUT_ERROR.print();
                continue;
            }

            Announce result = gameRound.inGameAnnounce(num.getValue());

            result.print();

            if (result.equals(Announce.HIGHER_MESSAGE)) {
                Announce.REMAINING_COUNT_MESSAGE.print(gameRound.getCount());
            }

            if (result.equals(Announce.LOWER_MESSAGE)) {
                Announce.REMAINING_COUNT_MESSAGE.print(gameRound.getCount());
            }

            if (result == Announce.WINNING_MESSAGE) {
                Announce.TRY_COUNT_MESSAGE.print(gameRound.getTryCount());
                return inputView.reTry();
            }

            if (gameRound.isOver()) {
                Announce.GAME_OVER_MESSAGE.print();
                Announce.RANDOM_NUMBER_RELEASE.print(gameRound.getRandomNumber());
                return inputView.reTry();
            }
        }
    }
}
