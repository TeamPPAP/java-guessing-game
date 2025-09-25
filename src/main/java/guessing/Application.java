package guessing;

import guessing.domain.Computer;
import guessing.domain.NumberGenerator;
import guessing.io.Input;
import guessing.io.Output;
import guessing.service.Game;
import guessing.domain.GameManager;

public class Application {

    public static void main(String[] args) {
        Game game = new Game(new GameManager(new Computer(new NumberGenerator())), new Input(), new Output());

        game.play();

    }
}
