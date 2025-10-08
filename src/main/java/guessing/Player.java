package guessing;

/**
 * Player class to manage player information and game statistics
 * 플레이어 정보와 게임 통계를 관리하는 클래스
 */
public class Player {

    private String name;
    private int winCount;
    private int playCount;

    /**
     * Constructor to create a player with given name
     * 주어진 이름으로 플레이어를 생성하는 생성자
     */
    public Player(String name) {
        this.name = name;
        this.winCount = 0;
        this.playCount = 0;
    }

    /**
     * Record a win for this player
     * 이 플레이어의 승리를 기록
     */
    public void recordWin() {
        this.winCount += 1;
        this.playCount += 1;
    }

    /**
     * Record a loss for this player
     * 이 플레이어의 패배를 기록
     */
    public void recordLoss() {
        this.playCount += 1;
    }

    /**
     * Get the win ratio of this player
     * 이 플레이어의 승률을 반환
     */
    public double getPlayerRatio() {
        if (playCount == 0) return 0.0;
        return (double) winCount / (double) playCount;
    }

    /**
     * Get the name of this player
     * 이 플레이어의 이름을 반환
     */
    public String getName() {
        return name;
    }

    /**
     * Return string representation of player with statistics
     * 플레이어의 통계를 포함한 문자열 표현을 반환
     */
    @Override
    public String toString() {
        return name + " [Win: " + winCount + " / Total: " + playCount + "]";
    }
}
