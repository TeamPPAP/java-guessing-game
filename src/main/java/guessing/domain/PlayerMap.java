package guessing.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class PlayerMap {
    private final Map<Integer, ChanceEntity> playerMap;

    public PlayerMap() {
        this.playerMap = new LinkedHashMap<>();
    }

    public void setPlayer(int playerNumber) {
        for (int i = 1; i <= playerNumber; i++) {
            playerMap.put(i, new ChanceEntity(new Player("Player " + i), new Chance()));
        }
    }

    public void exhaust(int id) {
        ChanceEntity chanceEntity = playerMap.get(id);
        chanceEntity.increaseChance();
        playerMap.put(id, chanceEntity);
    }

    public String getSuccess(int id) {
        return playerMap.get(id).returnSuccess();
    }

    public String getBigger(int id, int max) {
        return playerMap.get(id).getBigger(max);
    }

    public String getLower(int id, int max) {
        return playerMap.get(id).getLower(max);
    }
}
