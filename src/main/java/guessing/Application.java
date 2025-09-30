package guessing;

import guessing.domain.Computer;
import guessing.domain.NumberGenerator;
import guessing.io.Input;
import guessing.service.Game;
import guessing.domain.MultiGameManager;

public class Application {

    public static void main(String[] args) {
        Game game = new Game(new MultiGameManager(new Computer(new NumberGenerator())), new Input());

        game.play();

    }
}
