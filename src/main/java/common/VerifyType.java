package common;

import java.util.Arrays;

public enum VerifyType {

    VERIFY_TITLE("verifyTitle");

    private String value;

    VerifyType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static VerifyType get(final String value) throws Exception {
        return Arrays.stream(VerifyType.values())
                .filter(verifyType -> verifyType.value.equals(value))
                .findFirst().orElseThrow(() -> new Exception("sample"));
    }
}
