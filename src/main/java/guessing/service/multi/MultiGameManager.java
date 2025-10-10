package guessing.service.multi;

import guessing.computer.Computer;
import guessing.service.dto.GuessResult;
import guessing.service.value.GuessDirection;
import guessing.player.Player;
import guessing.player.repository.PlayerMap;
import guessing.service.GameManager;

import static guessing.service.value.GuessDirection.CORRECT;

public class MultiGameManager extends GameManager implements MultiGameManagingFlow {
    private final PlayerMap playerMap;

    public MultiGameManager(Computer computer) {
        super(computer);
        this.playerMap = new PlayerMap();
    }

    public void startNewGame(int totalPlayers) {
        computer.makeRandomNumber();
        playerMap.savePlayers(totalPlayers);
    }

    @Override
    public GuessResult submitGuess(int id, int answer, int max) {
        Player player = findById(id);
        player.exhaust();
        GuessDirection direction = computer.direction(answer);

        if (direction == CORRECT) {
            return GuessResult.success(player.name(), player.getAttempts());
        }
        return GuessResult.failure(direction, player.getAttemptsLeft(max));
    }

    protected Player findById(int id) {
        return playerMap.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
