package core;

public class ChanceManager {
    private final int CHANCE_MIN_COUNT = 1;
    private final int CHANCE_MAX_COUNT = 7;

    private int chance;

    public ChanceManager() {
        this.chance = CHANCE_MAX_COUNT;
    }

    public int getChance() {
        return chance;
    }

    public int getCHANCE_MAX_COUNT() {
        return CHANCE_MAX_COUNT;
    }

    // TODO: 게임 횟수가 남지 않았을 때 처리 필요
    public void reduceChance() {
        if (!isOverChance()) {
            this.chance = this.chance -1;
        }
    }

    public boolean isOverChance() {
        return !(this.chance >= CHANCE_MIN_COUNT);
    }

    public String createChanceMessage () {
        return "(남은 기회: " + chance + "번)";
    }
}
