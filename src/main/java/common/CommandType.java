package common;

import java.util.Arrays;

public enum CommandType {
    ACTION("Action"),
    VERIFY("Verify");
    private String value;

    CommandType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CommandType get(final String value) throws Exception {
        return Arrays.stream(CommandType.values())
                .filter(act -> act.value.equals(value))
                .findFirst().orElseThrow(() -> new Exception("sample"));
    }
}
