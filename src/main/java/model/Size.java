package model;

import java.util.HashMap;
import java.util.Map;

public enum Size {
    FORTY_TWO(42),
    FORTY_FOUR(44),
    FORTY_SIX(46),
    FORTY_EIGHT(48),
    FIFTY(50),
    FIFTY_TWO(52),
    FIFTY_FOUR(54);

    private int sizeValue;

    private static Map<Integer, Size> map = new HashMap<>();

    static {
        for (Size sizeEnum : Size.values()) {
            map.put(sizeEnum.sizeValue, sizeEnum);
        }
    }

    Size(int sizeValue) {
        this.sizeValue = sizeValue;
    }

    public int getSizeValue() {
        return sizeValue;
    }

    public static Size valueOf(int sizeValue) {
        return map.get(sizeValue);
    }
}
