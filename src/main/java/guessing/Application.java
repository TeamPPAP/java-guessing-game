package guessing;

import guessing.config.GameConfig;
import guessing.service.multi.MultiGame;

public class Application {

    public static void main(String[] args) {
        GameConfig gameConfig = new GameConfig();
        MultiGame game = gameConfig.game();
        game.play();
    }
}
