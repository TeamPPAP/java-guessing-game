package guessing.domain;

public record ChanceEntity(Player player, Chance chance) {

    public void increaseChance() {
        chance.plus();
    }

    public String returnSuccess() {
        return player.name() + "님이 " + chance.getChance() + "번 만에 맞혔습니다!";
    }

    public String getBigger(int max) {
        return "더 높게! (남은 기회: " + (max - chance.getChance()) + "번)";
    }

    public String getLower(int max) {
        return "더 낮게! (남은 기회: " + (max - chance.getChance()) + "번)";
    }
}
