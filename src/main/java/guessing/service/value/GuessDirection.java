package guessing.service.value;

public enum GuessDirection {
    CORRECT(null),
    BIGGER("더 높게!"),
    LOWER("더 낮게!");

    private final String description;

    GuessDirection(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
