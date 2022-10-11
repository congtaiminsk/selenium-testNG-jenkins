package common;

import java.util.Arrays;

public enum ColumnSeq {
    TC_ID(1),
    STEP_ID(2),
    STEP_DESC(3),
    SCREEN_ID(4),
    SCREEN_NAME(5),
    OBJ_ID(6),
    OBJ_NAME(7),
    LOCATOR_TYPE(8),
    LOCATOR_VALUE(9),
    CMD_TYPE(10),
    CMD_KW(11),
    ARG_VALUE(12);

    private Integer value;

    ColumnSeq(final Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public ColumnSeq get(final Integer value) throws Exception {
        return Arrays.stream(ColumnSeq.values())
                .filter(col -> col.value.equals(value))
                .findFirst().orElseThrow(() -> new Exception("sample"));
    }
}
