package guessing.domain;

public class ChanceEntity {
    private Player player;
    private Chance chance;

    public ChanceEntity(Player player, Chance chance) {
        this.player = player;
        this.chance = chance;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void increaseChance() {
        chance.plus();
    }

    public void setChance(Chance chance) {
        this.chance = chance;
    }

    public String returnSuccess() {
        return player.getName() + "님이" + chance.getChance() + "번 만에 맞혔습니다!";
    }

    public String getBigger(){
        return "더 높게! (남은 기회: " + chance.getChance() + "번)";
    }

    public String getLower() {
        return "더 낮게! (남은 기회: " + chance.getChance() + "번)";
    }
}
