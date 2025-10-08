package guessing;

import guessing.config.GameConfig;
import guessing.service.Game;

public class Application {

    public static void main(String[] args) {
        GameConfig gameConfig = new GameConfig();
        Game game = gameConfig.game();
        game.play();
    }
}
