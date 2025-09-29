package guessing.domain;

import static guessing.domain.Announce.RETRY_COMMAND_ERROR;

import java.util.Arrays;

public enum RetryCommand {
    YES("Y"),
    NO("N");

    private final String value;

    RetryCommand(final String value) {
        this.value = value;
    }

    public static RetryCommand from(final String input) {
        return Arrays.stream(values())
                .filter(command -> command.value.equalsIgnoreCase(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(RETRY_COMMAND_ERROR.getMessage()));
    }

    public boolean isRetry() {
        return this == YES;
    }
}
