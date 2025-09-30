package guessing.domain;

public class ChanceEntity {
    private Player player;
    private Chance chance;

    public ChanceEntity(Player player, Chance chance) {
        this.player = player;
        this.chance = chance;
    }

    public void increaseChance() {
        chance.plus();
    }

    public String returnSuccess() {
        return player.getName() + "님이 " + chance.getChance() + "번 만에 맞혔습니다!";
    }

    public String getBigger(int max) {
        return "더 높게! (남은 기회: " + (max - chance.getChance()) + "번)";
    }

    public String getLower(int max) {
        return "더 낮게! (남은 기회: " + (max - chance.getChance()) + "번)";
    }
}
