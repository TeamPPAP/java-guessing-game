package guessing;

public class Player {

    private String name;
    private int winCount;
    private int playCount;

    public Player(String name) {
        this.name = name;
        this.winCount = 0;
        this.playCount = 0;
    }

    public void playerWon() {
        this.winCount += 1;
        this.playCount += 1;
    }

    public void playerLose() {
        this.playCount += 1;
    }

    public double getPlayerRatio() {
        return (double) winCount / (double) playCount;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " [Win: " + winCount + " / Total: " + playCount + "]";
    }
}
