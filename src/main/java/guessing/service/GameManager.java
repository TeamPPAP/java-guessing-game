package guessing.service;

import guessing.computer.Computer;

public abstract class GameManager {
    protected final Computer computer;

    public GameManager(Computer computer) {
        this.computer = computer;
    }

}
