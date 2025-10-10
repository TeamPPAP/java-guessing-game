package guessing.player;

public class Chance {
    private int chance;

    public Chance() {
        this.chance = 0;
    }

    public int getAttempts() {
        return chance;
    }

    public void increase() {
        chance++;
    }
}
