package guessing.domain;

public class MultiGameManager implements GameManager {
    private final Computer computer;
    private final PlayerMap playerMap;

    public MultiGameManager(Computer computer) {
        this.computer = computer;
        this.playerMap = new PlayerMap();
    }

    public void generate() {
        computer.makeRandomNumber();
    }

    public void setting(int player) {
        playerMap.setPlayer(player);
    }

    public void exhaust(int id) {
        playerMap.exhaust(id);// 기회 소모
    }

    public String isSuccessThenGetString(final int id, final int answer) {
        //숫자 비교
        if (computer.isCorrect(answer)) {
            return playerMap.getSuccess(id);
        }
        return null;
    }

    public String notCorrect(int id, int answer, int max) {
        if (computer.isBiggerThenAnswer(answer)) {
            return playerMap.getBigger(id, max);
        }
        return playerMap.getLower(id, max);
    }

}
