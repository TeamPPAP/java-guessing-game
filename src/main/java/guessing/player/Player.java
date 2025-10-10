package guessing.player;

public record Player(int id, String name, Chance chance) {

    public void exhaust() {
        chance.increase();
    }

    public int getAttempts() {
        return chance.getAttempts();
    }

    public int getAttemptsLeft(int maxAttempts) {
        return maxAttempts - this.chance.getAttempts();
    }

}
