package guessing.domain;

public enum Announce {
    START_MESSAGE("1부터 100 사이의 숫자를 맞춰보세요. "),
    INPUT_NUMBER_MESSAGE("숫자를 입력하세요 : "),
    HIGHER_MESSAGE("더 높게! "),
    LOWER_MESSAGE("더 낮게! "),
    REMAINING_COUNT_MESSAGE("(남은 기회 : %d번)\n"),
    WINNING_MESSAGE("정답입니다!\n"),
    TRY_COUNT_MESSAGE("%d 번 만에 맞추셨습니다.\n"),
    GAME_OVER_MESSAGE("게임 오버!\n"),
    RANDOM_NUMBER_RELEASE("정답은 %d 였습니다.\n"),
    RETRY_MESSAGE("한 판 더 하시겠습니까? (Y/N)\n"),
    INPUT_ERROR("숫자만 입력해 주세요.\n");

    private final String message;

    Announce(String message) {
        this.message = message;
    }

    public void print(Object... num) {
        System.out.printf(this.message, num);
    }

    @Override
    public String toString() {
        return this.message;
    }
}
