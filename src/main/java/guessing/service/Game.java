package guessing.service;

import guessing.controller.GameController;
import guessing.domain.GameRound;

public class Game {
    GameController gameController = new GameController();

    public void run() {
        while (gameController.play(new GameRound()));
    }
}
