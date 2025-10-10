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
        if (!isOutOfChances()) {
            this.chance = this.chance -1;
        }
    }

    /**
     * 사용 가능한 기회를 모두 소진했는지 여부를 반환한다.
     * @return 남은 기회가 없으면 true, 1회 이상 남아 있으면 flase
     */
    public boolean isOutOfChances() {
        // chance < 최소치면 더 이상 시도 불가
        return this.chance < CHANCE_MIN_COUNT;
    }


    public String createChanceMessage () {
        return "(남은 기회: " + chance + "번)";
    }
}
