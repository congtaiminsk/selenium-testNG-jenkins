package common;

import java.util.Arrays;

public enum ActionType {

    OPEN("open"),
    CLICK("click"),
    INPUT("input");

    private String value;

    ActionType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ActionType get(final String value) throws Exception {
        return Arrays.stream(ActionType.values())
                .filter(act -> act.value.equals(value))
                .findFirst().orElseThrow(() -> new Exception("sample"));
    }
}
