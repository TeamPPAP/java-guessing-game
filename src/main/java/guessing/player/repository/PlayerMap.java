package guessing.player.repository;

import guessing.player.Chance;
import guessing.player.Player;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class PlayerMap {
    private final Set<Player> playerMap;

    public PlayerMap() {
        this.playerMap = new HashSet<>();
    }

    public void savePlayers(int playerNumber) {
        playerMap.clear();
        for (int i = 1; i <= playerNumber; i++) {
            playerMap.add(new Player(i, "Player " + i, new Chance()));
        }
    }

    public Optional<Player> findById(int id) {
        return playerMap.stream().filter(player -> player.id() == id).findFirst();
    }

}
