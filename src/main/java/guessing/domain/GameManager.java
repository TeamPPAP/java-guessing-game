package guessing.domain;

public class GameManager {
    private Computer computer;
    private PlayerMap playerMap;

    public GameManager(Computer computer) {
        this.computer = computer;
        this.playerMap = new PlayerMap();
    }

    public void generate() {
        computer.makeRandomNumber();
    }

    public boolean setPlayerNumber(String playerNum) {
        int player = 0;

        //잘못된 플래이어 입력 시 exception 발생
        player = Integer.parseInt(playerNum);
        validatePlayerNumber(player);

        return true;
    }

    public void setting(int player) {
        playerMap.setPlayer(player);
    }

    public int heardAnswer(String answer) {
        //잘못된 입력일 경우 NumberFormatException 발생
        int number = Integer.parseInt(answer);

        //맞춰야하는 숫자는 1 ~ 100 사이
        if (number < 1 || number > 100) {
            throw new IllegalArgumentException("잘못된 입력을 하셨습니다. 다시 입력해주세요.");
        }

        return number;
    }

    public void exhaust(int id) {
        playerMap.exhaust(id);// 기회 소모
    }


    /**
     * 1. 기회 소모 -> playerMap(GameManager 소유 )
     * 2. 맞았는지 비교
     * - 맞았을 경우
     * - true, playerName, chance
     * - String/null
     * - 틀렸을 경우
     *
     *
     *
     *
     *
     */
    public String isSuccessThenGetString(int id, int answer) {
        //숫자 비교
        if (computer.isCorrect(answer)) {
            return playerMap.getSuccess(id);
        }
        return null;
    }

    public String notCorrect(int id, int answer) {
        if (computer.isBiggerThenAnswer(answer)) {
            return playerMap.getBigger(id);
        }

        return playerMap.getLower(id);
    }

    /**
     * 최대 플래이어 수: 4
     *
     * @param playerNum
     */
    private void validatePlayerNumber(int playerNum) {
        if (playerNum < 1 || playerNum > 4) {
            throw new IllegalArgumentException("잘못된 입력을 하셨습니다. 다시 입력해주세요.");
        }
    }
}
