package guessing.domain;

public class Chance {
    private int chance;

    public Chance() {
        this.chance = 0;
    }

    public int getChance() {
        return chance;
    }

    public boolean isMeet(int n) {
        return chance == n;
    }

    public void plus() {
        chance++;
    }
}
