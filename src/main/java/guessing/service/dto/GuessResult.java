package guessing.service.dto;

import guessing.service.value.GuessDirection;

public record GuessResult(String message, boolean success) {

    public static GuessResult success(String name, int attempts) {
        return new GuessResult(name + "님이 " + attempts + "번 만에 맞혔습니다!", true);
    }

    public static GuessResult failure(GuessDirection direction, int attemptsLeft) {
        return new GuessResult(direction.getDescription() + "(남은 기회: " + attemptsLeft + "번)", false);
    }
}
