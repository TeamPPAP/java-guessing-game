package core;

public enum GameStatus {
    READY("준비"),
    PLAYING("진행중"),
    WIN("우승"),
    LOSE("패배");

    private final String displayName;

    GameStatus(String displayName) {
        this.displayName = displayName;
    }

}
